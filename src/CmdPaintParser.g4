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
    ;

shape
    : SQUARE position SIZE INT colorDefinition? HOLLOW?
    | CIRCLE position RADIUS INT colorDefinition? HOLLOW?
    | RECTANGLE position WIDTH INT HEIGHT INT colorDefinition? HOLLOW?
    | LINE line_pos colorDefinition? HOLLOW?
    | POLYGON poly_pos poly_pos colorDefinition? HOLLOW?
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