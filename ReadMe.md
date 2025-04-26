# Cmd Paint

An ANTLR + Java project which aims to create an application for drawing stuff with the use of commands typed in the command line.

# Commands:
There are many possible commands, many of them require to provide the name of a shape. When providing shape remember to use quotation marks ```"shape_name"```. Some commands have optional arguments, which in examples have been marked with a *.

Shapes can be **selected** with mouseclick and modified through provided window editor.
## Draw
Syntax: ```draw <name> <shape> <position> <color color_value>* <stroke (int value)>* <hollow>* <layer (int value)>*```

This command is the most essential for drawing shapes. It consists of ```draw``` keyword, 2 required arguments, position argument and 4 optional arguments.
- name - name of the drawn shape. If shape with this name exists, overwrite prompt will ensue.
- shape - one of 5 possible basic shapes. Each shapes require different arguments:
    - square - requires position given as ```(<int>, <int>)*``` and size, defined with ```size <int>```. Position is optional because defining position with mouseclick can be used.
    - rect - requires position given as ```(<int>, <int>)*```, width and height, defined with ```width <int> height <int>```.  Position is optional because defining position with mouseclick can be used.
    - circle - requires position given as ```(<int>, <int>)*``` and size, defined with ```radius <int>```.  Position is optional because defining position with mouseclick can be used.
    - line - requires position given as ```(<int>, <int>, <int>, <int>)*``` or length ```length <int>*```.  Position is optional but when it is not present length has to be specified. When position is absent, line of provided length is drawn with one end at selected (x, y) and the other at (x + length, y)
    - polygon - requires position given as ```(<int>, <int>, <int>...) (<int>, <int>, <int>...)``` where first defines x points and the second y points. Position is required and number of x and y points has to be equal.
- color - definition of color, can be either a rgb value ```color (<int>, <int>, <int>)``` or string, for example ```color green```. Notice that for colors quotation marks are not required. Default color is black.
- stroke - definition of stroke ```stroke <int>```, which defines the thickness of outline. Only works on lines and hollow shapes.
- hollow - hollow modifier, describes if shape should be just outline. If not present, shapes are filled.
- layer - describes layer ```layer <int>```. Shapes with higher layer are drawn at the end, so they "hide" shapes on a lower layer.

## Color
Syntax ```color <shape_names>* <color_value>```

Changes the color of one or multiple shapes. Shape name does not need to be provided if a shape has been selected.

## Rotate
Syntax: ```rotate <shape_names>* <int value>```

Rotates one or more shapes by a given number of degrees. Rotation is around the shape's center. If no shape names are given, selected shapes are rotated.

## Move
Syntax: ```move <shape_names>* <int value, int value>*```

Moves one or more shapes to a specified position. If no position is provided, mouse click is used as destination. If no shape names are provided, selected shapes are moved.

## Save
Syntax: ```save image``` or ```save script```

Saves the canvas. 
- save image saves the drawing as an image file.
- save script saves the series of commands to a script file.

## Delete
Syntax: ```delete <shape_names>*``` or ```delete all```

Deletes one or more shapes. If no shape names are given, selected shapes are deleted. ```delete all``` deletes everything from the canvas.

## Background
Syntax: ```background <color color_value>```

Changes the background color of the canvas. Color can be a named color or RGB.

## Rename
Syntax: ```rename <old_name> <new_name>```

Renames a shape.

## Names
Syntax: ```names```

Toggles showing or hiding names of shapes on the canvas.

## Hollow / Fill
Syntax: ```hollow <shape_names>*``` or ```fill <shape_names>*```

Changes a shape to hollow (only outline) or filled (solid color). If no names are provided, selected shapes are modified.

## Stroke
Syntax: ```stroke <shape_names>* <stroke_width>```

Changes the stroke width (outline thickness) of shapes. If no names are provided, selected shapes are modified.

## Define
Syntax: ```define <color_name> <color>```

Defines a custom color name for later use. Quotation marks are *not required* for color name

## Layer
Syntax: ```layer <shape_names>* <layer_number>``` or ```move <shape_names>* up/down```

Changes the drawing layer of shapes. Higher layers are drawn later and appear above lower layers. Move up/down changes layer by +/-1.

## Clone
Syntax: ```clone <shape_name>* <position>*```

Clones a shape. If no position is provided, clone appears close to original.

## Serialize / Load
Syntax: ```serialize <file_name> <shape_names>*``` or ```load <file_name>```

Saves groups of shapes to a file (serialize) or loads them (load).

## Group / Degroup
Syntax: ```group <group_name> <shape_names>``` or ```degroup <group_name>*```

Groups multiple shapes together or separates them.

## Scale
Syntax: ```scale <shape_names>* <float value>```

Scales the size of one or more shapes by a given factor.

## Grid
Syntax: ```grid```

Toggles a grid display on the canvas.

