lexer grammar CmdPaintLexer;

NAME  : '"' [a-zA-Z_][a-zA-Z0-9_]* '"';
COLOR : 'red' | 'green' | 'blue' | 'yellow' | 'black' | 'white';
INT   : '-'?[0-9]+;
WS    : [ \t\r\n]+ -> skip;

DRAW   : 'draw';
COLORC : 'color';
ROTATE : 'rotate';
MOVE   : 'move';
DELETE : 'delete';
RENAME : 'rename';


SQUARE    : 'square';
CIRCLE    : 'circle';
RECTANGLE : 'rectangle';
POLYGON : 'polygon';
LINE : 'line';

SIZE   : 'size';
RADIUS : 'radius';
WIDTH  : 'width';
HEIGHT : 'height';
HOLLOW : 'hollow';
SAVE   : 'save';

LPAREN : '(';
RPAREN : ')';
COMMA  : ',';