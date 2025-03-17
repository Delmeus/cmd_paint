parser grammar CmdPaintParser;

options { tokenVocab=CmdPaintLexer; }

program: command+ EOF;

command
    : DRAW NAME shape ('color' COLOR)?
    | COLORC NAME COLOR
    | ROTATE NAME INT
    | MOVE NAME position
    ;

shape
    : SQUARE position SIZE INT
    | CIRCLE position RADIUS INT
    | RECTANGLE position WIDTH INT HEIGHT INT
    | LINE position
    ;

position
    : LPAREN INT COMMA INT RPAREN
    ;