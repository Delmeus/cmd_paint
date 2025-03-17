lexer grammar CmdPaintLexer;

NAME  : '"' [a-zA-Z_][a-zA-Z0-9_]* '"';
COLOR : 'red' | 'green' | 'blue' | 'yellow' | 'black' | 'white';
INT   : [0-9]+;
WS    : [ \t\r\n]+ -> skip;

DRAW   : 'draw';
COLORC : 'color';
ROTATE : 'rotate';
MOVE   : 'move';

SQUARE    : 'square';
CIRCLE    : 'circle';
RECTANGLE : 'rectangle';
LINE : 'line';

SIZE   : 'size';
RADIUS : 'radius';
WIDTH  : 'width';
HEIGHT : 'height';
SAVE   : 'save';

LPAREN : '(';
RPAREN : ')';
COMMA  : ',';