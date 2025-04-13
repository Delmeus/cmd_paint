parser grammar CmdPaintParser;

options { tokenVocab=CmdPaintLexer; }

program: command+ EOF;

command
    : DRAW NAME shape #drawOp
    | COLORC NAME colors #colorOp
    | ROTATE NAME INT #rotateOp
    | MOVE NAME position #moveOp
    | SAVE #saveOp
    | DELETE NAME #deleteOp
    | BACKGROUND colorDefinition #backgroundOp
    | RENAME NAME NAME #renameOp
    | SHOW_NAMES #showNamesOp
    | HOLLOW NAME #hollowOp
    | FILL NAME #hollowOp
    | DEFINE NAME colors #defineOp
    | LAYER NAME INT #layerOp
    | MOVE NAME (DOWN | UP) #layerOp
    ;

shape
    : SQUARE position SIZE INT colorDefinition? HOLLOW? layerDefinition?
    | CIRCLE position RADIUS INT colorDefinition? HOLLOW? layerDefinition?
    | RECTANGLE position WIDTH INT HEIGHT INT colorDefinition? HOLLOW? layerDefinition?
    | LINE line_pos colorDefinition? HOLLOW? layerDefinition?
    | POLYGON poly_pos poly_pos colorDefinition? HOLLOW? layerDefinition?
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