lexer grammar CmdPaintLexer;

NAME  : '"' [a-zA-Z_][a-zA-Z0-9_]* '"';
COLOR : 'red' | 'green' | 'blue' | 'yellow' | 'black' | 'white';
INT   : '-'?[0-9]+;
WS    : [ \t\r\n]+ -> skip;

DRAW   : 'draw' | 'd';
COLORC : 'color';
ROTATE : 'rotate' | 'rot' | 'rt';
MOVE   : 'move' | 'mv';
DELETE : 'delete' | 'del' | 'rm' | 'remove';
BACKGROUND : 'background' | 'back' | 'b';
SHOW_NAMES : 'names';
RENAME : 'rename' | 'name';
FILL : 'fill';

SQUARE    : 'square' | 'sq';
CIRCLE    : 'circle' | 'circ';
RECTANGLE : 'rectangle' | 'rect';
POLYGON : 'polygon' | 'poly';
LINE : 'line';

SIZE   : 'size' | 's';
RADIUS : 'radius' | 'r';
WIDTH  : 'width' | 'w';
HEIGHT : 'height' | 'h';
HOLLOW : 'hollow';
SAVE   : 'save';

LPAREN : '(';
RPAREN : ')';
COMMA  : ',';