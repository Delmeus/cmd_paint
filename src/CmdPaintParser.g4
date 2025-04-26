parser grammar CmdPaintParser;

options { tokenVocab=CmdPaintLexer; }

program: command+ EOF;

command
    : DRAW NAME shape #drawOp
    | COLORC NAME* colors #colorOp
    | ROTATE NAME* INT #rotateOp
    | MOVE NAME* position? #moveOp
    | SAVE savePossibility #saveOp
    | DELETE NAME* ALL? #deleteOp
    | BACKGROUND colorDefinition #backgroundOp
    | RENAME NAME NAME? #renameOp
    | SHOW_NAMES #showNamesOp
    | HOLLOW NAME* #hollowOp
    | FILL NAME* #hollowOp
    | STROKE NAME* INT #hollowOp
    | DEFINE NAME colors #defineOp
    | LAYER NAME* INT #layerOp
    | MOVE NAME* (DOWN | UP) #layerOp
    | CLONE NAME? position? #cloneOp
    | SERIALIZE NAME NAME* #serializeOp
    | GROUP NAME NAME+ #groupOp
    | DEGROUP NAME? #groupOp
    | LOAD NAME #serializeOp
    | SCALE NAME* (FLOAT | INT) #scaleOp
    | GRID #gridOp
    ;

shape
    : SQUARE position? SIZE INT shapeAttributes*
    | CIRCLE position? RADIUS INT shapeAttributes*
    | RECTANGLE position? WIDTH INT HEIGHT INT shapeAttributes*
    | LINE (line_pos | (LENGTH INT)) shapeAttributes*
    | POLYGON poly_pos poly_pos shapeAttributes*
    ;

position
    : LPAREN INT COMMA INT RPAREN
    ;

poly_pos
    : LPAREN (INT COMMA)+ INT RPAREN
    ;

line_pos
    : LPAREN INT COMMA INT COMMA INT COMMA INT RPAREN
    ;

rgb_color
    : (LPAREN INT COMMA INT COMMA INT RPAREN) | (INT INT INT)
    ;

colors
    : (COLOR | rgb_color)
    ;

colorDefinition
    : 'color' colors
    ;

layerDefinition
    : LAYER INT
    ;

strokeDefinition
    : STROKE INT
    ;

shapeAttributes
    : colorDefinition
    | HOLLOW
    | layerDefinition
    | strokeDefinition
    ;

savePossibility
    : IMAGE | SCRIPT
    ;