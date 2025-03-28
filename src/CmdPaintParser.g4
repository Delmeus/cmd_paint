parser grammar CmdPaintParser;

options { tokenVocab=CmdPaintLexer; }

program: command+ EOF;

command
    : DRAW NAME shape
    | COLORC NAME colors
    | ROTATE NAME INT
    | MOVE NAME position
    | SAVE NAME
    | DELETE NAME
    | BACKGROUND colorDefinition
    | RENAME NAME NAME
    | SHOW_NAMES
    | HOLLOW NAME
    | FILL NAME
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