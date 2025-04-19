import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.List;

public class Painter extends CmdPaintParserBaseVisitor<Boolean> {
    private final String error_name = "CHANGE THIS NAME";
    private final Map<String, Shape> shapes;// = new HashMap<>();
    private final Map<String, Color> definedColors = new HashMap<>();
    private final PainterFrame painterFrame; // = new PainterFrame(shapes);

    private final List<String> errorList = new ArrayList<>();
    private boolean errorOccurred = false;

    public Painter(Map<String, Shape> shapes, PainterFrame frame) {
        this.shapes = shapes;
        this.painterFrame = frame;
    }

    boolean namesVisible = false;

    @Override
    public Boolean visitProgram(CmdPaintParser.ProgramContext ctx) {
        boolean result = true;
        for (CmdPaintParser.CommandContext command : ctx.command()) {
            result &= visit(command);
            errorOccurred = false;
        }
        painterFrame.repaint();
        return result;
    }
    @Override
    public Boolean visitDrawOp(CmdPaintParser.DrawOpContext ctx) {
        String name = "";
        if (ctx.NAME() == null)
            name = parseName(name);
        else
            name = parseName(ctx.NAME().getText());
        Shape shape = null;

        CmdPaintParser.ShapeContext shapeCtx = ctx.shape();
        if (shapeCtx.SQUARE() != null) {
            int[] pos = getPosition(shapeCtx);
            int size = Integer.parseInt(shapeCtx.INT().getFirst().getText());
            shape = new Square(name, pos[0], pos[1], size);
        } else if (shapeCtx.RECTANGLE() != null) {
            int[] pos = getPosition(shapeCtx);
            int width = Integer.parseInt(shapeCtx.INT().get(0).getText());
            int height = Integer.parseInt(shapeCtx.INT().get(1).getText());
            shape = new Rectangle(name, pos[0], pos[1], width, height);
        } else if (shapeCtx.CIRCLE() != null) {
            int[] pos = getPosition(shapeCtx);
            int radius = Integer.parseInt(shapeCtx.INT().getFirst().getText());
            shape = new Circle(name, pos[0], pos[1], radius);
        } else if (shapeCtx.LINE() != null) {
            if (shapeCtx.line_pos() != null) {
                int x = Integer.parseInt(shapeCtx.line_pos().INT(0).getText());
                int y = Integer.parseInt(shapeCtx.line_pos().INT(1).getText());
                int x2 = Integer.parseInt(shapeCtx.line_pos().INT(2).getText());
                int y2 = Integer.parseInt(shapeCtx.line_pos().INT(3).getText());
                shape = new Line(name, x, y, x2, y2);
            } else {
                int x = painterFrame.getSelectedX();
                int y = painterFrame.getSelectedY();
                int length = Integer.parseInt(shapeCtx.INT().getFirst().getText());
                shape = new Line(name, x, y, length);
            }
        } else if (shapeCtx.POLYGON() != null) {
            if (shapeCtx.poly_pos(0).getChildCount() == shapeCtx.poly_pos(1).getChildCount()) {
                int size = shapeCtx.poly_pos(0).INT().size();
                int[] x = new int[size];
                int[] y = new int[size];
                for (int i = 0; i < size; i++) {
                    x[i] = Integer.parseInt(shapeCtx.poly_pos(0).INT(i).getText());
                    y[i] = Integer.parseInt(shapeCtx.poly_pos(1).INT(i).getText());
                }
                shape = new Polygon(name, x, y);
            } else {
                errorList.add("X.size = " + shapeCtx.poly_pos(0).INT().size() + " != Y.size = " + shapeCtx.poly_pos(1).INT().size());
            }
        }

        if(shape == null) {
            pushErrorsToWindow("Error when creating shape (shape is null)");
            return false;
        }

        for (CmdPaintParser.ShapeAttributesContext attrCtx : shapeCtx.shapeAttributes()) {
            if (attrCtx.colorDefinition() != null) {
                var colorCtx = attrCtx.colorDefinition().colors();
                if (colorCtx.COLOR() != null) {
                    String color = colorCtx.COLOR().getText();
                    if (definedColors.containsKey(color)) {
                        shape.setColor(definedColors.get(color));
                    } else {
                        shape.setColor(color);
                    }
                } else if (colorCtx.rgb_color() != null) {
                    shape.setColor(parseRgb(attrCtx));
                }
            } else if (attrCtx.HOLLOW() != null) {
                shape.hollow();
            } else if (attrCtx.layerDefinition() != null) {
                shape.setLayer(Integer.parseInt(attrCtx.layerDefinition().INT().getText()));
            } else if (attrCtx.strokeDefinition() != null) {
                shape.setStroke(Integer.parseInt(attrCtx.strokeDefinition().INT().getText()));
            }
        }

        shapes.put(shape.name, shape);
        painterFrame.repaint();
        return true;
    }

    @Override
    public Boolean visitColorOp(CmdPaintParser.ColorOpContext ctx) {
        List<String> names = new ArrayList<>();
        if (ctx.NAME().isEmpty())
            if (painterFrame.hasShapesSelected()) {
                names = getSelectedNames(painterFrame.getSelectedShapes());
            }
            else
                names.add(parseName(""));
        else
            for(int i = 0; i < ctx.NAME().size(); i++)
                names.add(parseName(ctx.NAME(i).getText()));
        for (String name : names) {
            try {
                if (ctx.colors().COLOR() != null)
                    if (definedColors.containsKey(ctx.colors().COLOR().getText())) {
                        shapes.get(name).setColor(definedColors.get(ctx.colors().COLOR().getText()));
                    } else
                        shapes.get(name).setColor(ctx.colors().COLOR().getText());
                else if (ctx.colors().rgb_color() != null)
                    shapes.get(name).setColor(parseRgb(ctx.colors()));
            } catch (Exception e) {
                errorList.add(e.getMessage());
                errorOccurred = true;
            }
        }
        painterFrame.repaint();

        if(errorOccurred){
            pushErrorsToWindow("Error when visit color op");
            return false;
        }
        return true;
    }

    @Override
    public Boolean visitRotateOp(CmdPaintParser.RotateOpContext ctx) {
        List<String> names = new ArrayList<>();
        if (ctx.NAME().isEmpty())
            if(painterFrame.hasShapesSelected())
                names = getSelectedNames(painterFrame.getSelectedShapes());
            else
                names.add(parseName(""));
        else
            for(int i = 0; i < ctx.NAME().size(); i++)
                names.add(parseName(ctx.NAME(i).getText()));
        for (String name : names) {
            int rotationAngle;
            try {
                rotationAngle = Integer.parseInt(ctx.INT().getText());
                shapes.get(name).rotate(rotationAngle);
            } catch (Exception e) {
                errorList.add(e.getMessage());
                errorOccurred = true;
            }
        }

        if(errorOccurred){
            pushErrorsToWindow("Error in rotate");
            return false;
        }

        return true;
    }

    @Override
    public Boolean visitMoveOp(CmdPaintParser.MoveOpContext ctx) {
        List<String> names = new ArrayList<>();
        if (ctx.NAME().isEmpty())
            if(painterFrame.hasShapesSelected())
                names = getSelectedNames(painterFrame.getSelectedShapes());
            else
                names.add(parseName(""));
        else
            for(int i = 0; i < ctx.NAME().size(); i++)
                names.add(parseName(ctx.NAME(i).getText()));
        int[] pos = getPosition(ctx);
        for (String name : names) {
            try {
                shapes.get(name).move(pos[0], pos[1]);
            }catch (Exception e){
                errorList.add(e.getMessage());
            }
        }
        painterFrame.repaint();

        if(errorOccurred){
            pushErrorsToWindow("Error in move");
            return false;
        }

        return true;
    }

    @Override
    public Boolean visitSaveOp(CmdPaintParser.SaveOpContext ctx) {
        if(ctx.savePossibility().IMAGE() != null)
            errorOccurred = !painterFrame.saveAsImage();
        else if (ctx.savePossibility().SCRIPT() != null) {
            try {
                FileWriter fw = new FileWriter("script.txt");
                for (Shape shape : shapes.values()) {
                    List<String> lines = shape.getScript();
                    for(String line : lines)
                        fw.write(line + "\n");
                }
                fw.close();
                return true;
            }
            catch (IOException e) {
                errorList.add(e.getMessage());
                errorOccurred = true;
            }
        }

        if(errorOccurred)
            pushErrorsToWindow("Error in saving file");

        return false;
    }

    @Override
    public Boolean visitDeleteOp(CmdPaintParser.DeleteOpContext ctx) {
        if (ctx.ALL() != null){
            shapes.clear();
            return true;
        }
        List<String> names = new ArrayList<>();
        if (ctx.NAME().isEmpty())
            if(painterFrame.hasShapesSelected())
                names = getSelectedNames(painterFrame.getSelectedShapes());
            else
                names.add(parseName(""));
        else
            for(int i = 0; i < ctx.NAME().size(); i++)
                names.add(parseName(ctx.NAME(i).getText()));
        for (String name : names) {
            shapes.remove(name);
        }
        painterFrame.repaint();
        return true;
    }

    @Override
    public Boolean visitBackgroundOp(CmdPaintParser.BackgroundOpContext ctx) {
        if(ctx.colorDefinition().colors().COLOR() != null)
            if(definedColors.containsKey(ctx.colorDefinition().colors().COLOR().getText()))
                painterFrame.setBackgroundColor(definedColors.get(ctx.colorDefinition().colors().COLOR().getText()));
            else
                painterFrame.setBackgroundColor(ctx.colorDefinition().colors().COLOR().getText());
        else if(ctx.colorDefinition().colors().rgb_color() != null)
            painterFrame.setBackgroundColor(parseRgb(ctx.colorDefinition().colors()));
        return true;
    }

    @Override
    public Boolean visitRenameOp(CmdPaintParser.RenameOpContext ctx) {
        String oldName = ctx.NAME(0).getText().replace("\"", "");
        if (!shapes.containsKey(oldName)){
            painterFrame.pushMessage("There is no shape with name: " + oldName);
            return false;
        }
        String newName = ctx.NAME(1).getText().replace("\"", "");

        shapes.put(newName, shapes.remove(oldName));
        return true;
    }

    @Override
    public Boolean visitShowNamesOp(CmdPaintParser.ShowNamesOpContext ctx) {
        if(!namesVisible){
            printShapes();
            for(Shape s : shapes.values()){
                s.showName();
            }
            namesVisible = true;
        } else {
            for (Shape s : shapes.values())
                s.hideName();
            namesVisible = false;
        }
        return true;
    }

    @Override
    public Boolean visitHollowOp(CmdPaintParser.HollowOpContext ctx) {
        List<String> names = new ArrayList<>();
        if (ctx.NAME().isEmpty())
            if(painterFrame.hasShapesSelected())
                names = getSelectedNames(painterFrame.getSelectedShapes());
            else
                names.add(parseName(""));
        else
            for(int i = 0; i < ctx.NAME().size(); i++)
                names.add(parseName(ctx.NAME(i).getText()));
        for (String name : names) {
            try {
                if (ctx.HOLLOW() != null)
                    shapes.get(name).hollow();
                else if (ctx.FILL() != null)
                    shapes.get(name).fill();
                else if (ctx.STROKE() != null)
                    shapes.get(name).setStroke(Integer.parseInt(ctx.INT().getText()));
            } catch (Exception e) {
                errorList.add(e.getMessage());
                errorOccurred = true;
            }
        }

        if(errorOccurred){
            pushErrorsToWindow("Error in Hollow/Fill");
            return false;
        }

        return true;
    }

    @Override
    public Boolean visitDefineOp(CmdPaintParser.DefineOpContext ctx) {
        String name = "";
        if (ctx.NAME() == null)
            return false;
        else
            name = parseName(ctx.NAME().getText());
        Color color = parseRgb(ctx.colors());
        definedColors.put(name, color);
        return true;
    }

    @Override
    public Boolean visitLayerOp(CmdPaintParser.LayerOpContext ctx) {
        List<String> names = new ArrayList<>();
        if (ctx.NAME().isEmpty())
            if(painterFrame.hasShapesSelected())
                names = getSelectedNames(painterFrame.getSelectedShapes());
            else
                names.add(parseName(""));
        else
            for(int i = 0; i < ctx.NAME().size(); i++)
                names.add(parseName(ctx.NAME(i).getText()));

        for(String name : names) {
            try {
                if (ctx.INT() != null)
                    shapes.get(name).setLayer(Math.max(0, Integer.parseInt(ctx.INT().getText())));
                else if (ctx.DOWN() != null)
                    shapes.get(name).moveDown();
                else if (ctx.UP() != null)
                    shapes.get(name).moveUp();
                else
                    return false;
            } catch (Exception e) {
                errorList.add(e.getMessage());
                errorOccurred = true;
            }
        }

        if(errorOccurred){
            pushErrorsToWindow("Error in Layer");
            return false;
        }

        return true;
    }

    @Override
    public Boolean visitSerializeOp(CmdPaintParser.SerializeOpContext ctx) {
        if(ctx.SERIALIZE() != null){
            if(ctx.NAME() == null)
                return false;
            Map<String, Shape> toBeSerialized = new HashMap<>();
            if (ctx.NAME().size() == 1){
                Set<Shape> shapes = painterFrame.getSelectedShapes();
                if(shapes == null)
                    return false;
                for(Shape shape : shapes)
                    toBeSerialized.put(shape.name, shape);
            } else {
                for (int i = 0; i < ctx.NAME().size(); i++) {
                    String name = parseName(ctx.NAME(i).getText());
                    if (shapes.containsKey(name))
                        toBeSerialized.put(name, shapes.get(name));
                }
            }
            String filename = parseName(ctx.NAME(0).getText());
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialized/" + filename + ".ser"))) {
                oos.writeObject(toBeSerialized);
                painterFrame.pushMessage("Saved shapes to file: serialized/" + filename + ".ser");
                return true;
            } catch (IOException e) {
                errorList.add(e.getMessage());
                errorOccurred = true;
            }
        } else if (ctx.LOAD() != null) {
            String path = "serialized/" + parseName(ctx.NAME().getFirst().getText()) + ".ser";
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
                Map<String, Shape> loadedShapes = (Map<String, Shape>) ois.readObject();
                shapes.putAll(loadedShapes);
                painterFrame.repaint();
                return true;
            } catch (IOException | ClassNotFoundException e) {
                errorList.add(e.getMessage());
                errorOccurred = true;
            }
        }

        if(errorOccurred){
            pushErrorsToWindow("Error in Saving/Loading serialized shapes");
            return false;
        }

        return true;
    }

    @Override
    public Boolean visitCloneOp(CmdPaintParser.CloneOpContext ctx) {
        int[] pos = getPosition(ctx);
        String name = "";
        if (ctx.NAME() == null)
            if(painterFrame.hasShapesSelected() && painterFrame.getSelectedShapes().size() == 1)
                name = painterFrame.getSelectedShapes().iterator().next().name;
            else
                painterFrame.pushMessage("Exactly one object has to be provided for clone. " +
                        "To clone multiple shapes try grouping them first.");
        else
            name = parseName(ctx.NAME().getText());
        if(!shapes.containsKey(name))
            return false;
        Shape shape = shapes.get(name).clone(pos[0], pos[1]);
        shapes.put(shape.name, shape);
        return true;
    }

    @Override
    public Boolean visitGroupOp(CmdPaintParser.GroupOpContext ctx) {
        if (ctx.NAME().size() == 0)
            return false;
        String name = parseName(ctx.NAME(0).getText());
        List<Shape> groupedShapes = new ArrayList<>();
        for (int i = 1; i < ctx.NAME().size(); i++) {
            String shapeName = parseName(ctx.NAME(i).getText());
            Shape shape = shapes.get(shapeName);
            if (shape != null) {
                groupedShapes.add(shape);
                shapes.remove(shapeName);
            } else {
                painterFrame.pushMessage("Warning: Shape \"" + shapeName + "\" not found.");
            }
        }

        shapes.put(name, new ShapeGroup(name, groupedShapes));
        return true;
    }
//--------------------------------------------------
//               UTILITY METHODS
//--------------------------------------------------
    private String parseName(String passedName){
        if (passedName.isEmpty()){
            System.err.println("Name not provided, name set to " +
                    error_name + "\n failing to provide proper name will lead do overriding this shape");
            return error_name;
        }
        String name = "";
        try{
            name = passedName.replace("\"", "");
        }catch (Exception e){
            System.err.println("Error in parsing name, name set to " +
                    error_name + "\n failing to provide proper name will lead do overriding this shape");
            name = error_name;
        }
        return name;
    }

    private void printShapes(){
        for (Shape shape : shapes.values()){
            System.out.println(shape.toString());
        }
    }

    private Color parseRgb(CmdPaintParser.ColorsContext ctx){
        int[] rgb = new int[3];

        for (int i = 0; i < 3; i++) {
            rgb[i] = Integer.parseInt(ctx.rgb_color().INT(i).getText());
            rgb[i] = Math.max(0, Math.min(255, rgb[i]));
        }

        return new Color(rgb[0], rgb[1], rgb[2]);
    }

    private Color parseRgb(CmdPaintParser.ShapeAttributesContext ctx){
        int[] rgb = new int[3];
        for(int i = 0; i < 3; i++){
            rgb[i] = Integer.parseInt(ctx.colorDefinition().colors().rgb_color().INT(i).getText());
            if(rgb[i] < 0)
                rgb[i] = 0;
            else if (rgb[i] > 255)
                rgb[i] = 255;
        }
        return new Color(rgb[0], rgb[1], rgb[2]);
    }

    private int[] getPosition(CmdPaintParser.ShapeContext shapeCtx){
        int x, y;
        if (shapeCtx.position() == null){
            x = painterFrame.getSelectedX();
            y = painterFrame.getSelectedY();
        }
        else {
            x = Integer.parseInt(shapeCtx.position().INT(0).getText());
            y = Integer.parseInt(shapeCtx.position().INT(1).getText());
        }
        int[] pos = new int[2];
        pos[0] = x;
        pos[1] = y;
        return pos;
    }

    private int[] getPosition(CmdPaintParser.MoveOpContext ctx){
        int x, y;
        if (ctx.position() == null){
            x = painterFrame.getSelectedX();
            y = painterFrame.getSelectedY();
        }
        else {
            x = Integer.parseInt(ctx.position().INT(0).getText());
            y = Integer.parseInt(ctx.position().INT(1).getText());
        }
        int[] pos = new int[2];
        pos[0] = x;
        pos[1] = y;
        return pos;
    }

    private int[] getPosition(CmdPaintParser.CloneOpContext ctx){
        int x, y;
        if (ctx.position() == null){
            x = painterFrame.getSelectedX();
            y = painterFrame.getSelectedY();
        }
        else {
            x = Integer.parseInt(ctx.position().INT(0).getText());
            y = Integer.parseInt(ctx.position().INT(1).getText());
        }
        int[] pos = new int[2];
        pos[0] = x;
        pos[1] = y;
        return pos;
    }

    private List<String> getSelectedNames(Set<Shape> shapes){
        List<String> names = new ArrayList<>();
        for (Shape shape : shapes) {
            names.add(shape.name);
        }
        return names;
    }

    private void appendError(String error){
        errorList.add(error);
    }

    private void pushErrorsToWindow(String errorPrefix){
        StringBuilder errorMessage = new StringBuilder(errorPrefix + "\nInfo: ");
        if (!errorList.isEmpty()){
            errorMessage.append("-");
        }
        for (String name : errorList) {
            errorMessage.append(name).append("\n");
        }
        painterFrame.pushMessage(errorMessage.toString());
        errorList.clear();
    }
}
