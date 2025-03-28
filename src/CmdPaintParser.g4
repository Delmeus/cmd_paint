parser grammar CmdPaintParser;

options { tokenVocab=CmdPaintLexer; }

program: command+ EOF;

command
    : DRAW NAME shape
    | COLORC NAME COLOR
    | ROTATE NAME INT
    | MOVE NAME position
    | SAVE NAME
    | DELETE NAME
    | RENAME NAME NAME
    ;

shape
    : SQUARE position SIZE INT ('color' COLOR)? HOLLOW?
    | CIRCLE position RADIUS INT ('color' COLOR)? HOLLOW?
    | RECTANGLE position WIDTH INT HEIGHT INT ('color' COLOR)? HOLLOW?
    | LINE line_pos ('color' COLOR)? HOLLOW?
    | POLYGON poly_pos poly_pos ('color' COLOR)? HOLLOW?
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