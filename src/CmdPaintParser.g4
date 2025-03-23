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
    : SQUARE position SIZE INT ('color' COLOR)?
    | CIRCLE position RADIUS INT ('color' COLOR)?
    | RECTANGLE position WIDTH INT HEIGHT INT ('color' COLOR)?
    | LINE line_pos ('color' COLOR)?
    ;

position
    : LPAREN INT COMMA INT RPAREN
    ;

line_pos
    : LPAREN INT COMMA INT COMMA INT COMMA INT RPAREN
    ;