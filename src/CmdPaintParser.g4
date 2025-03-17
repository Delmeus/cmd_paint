parser grammar CmdPaintParser;

options { tokenVocab=CmdPaintLexer; }

program: command+ EOF;

command
    : DRAW NAME shape
    | COLORC NAME COLOR
    | ROTATE NAME INT
    | MOVE NAME position
    | SAVE NAME
    ;

shape
    : SQUARE position SIZE INT ('color' COLOR)?
    | CIRCLE position RADIUS INT ('color' COLOR)?
    | RECTANGLE position WIDTH INT HEIGHT INT ('color' COLOR)?
    | LINE position ('color' COLOR)?
    ;

position
    : LPAREN INT COMMA INT RPAREN
    ;