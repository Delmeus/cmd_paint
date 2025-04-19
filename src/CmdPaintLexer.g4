lexer grammar CmdPaintLexer;

NAME  : '"' [a-zA-Z_][a-zA-Z0-9_]* '"';
INT   : '-'?[0-9]+;
WS    : [ \t\r\n]+ -> skip;

DRAW   : 'draw' | 'd';
DEFINE : 'define' | 'def';
COLORC : 'color';
ROTATE : 'rotate' | 'rot' | 'rt';
MOVE   : 'move' | 'mv';
DELETE : 'delete' | 'del' | 'rm' | 'remove';
BACKGROUND : 'background' | 'back' | 'b';
SHOW_NAMES : 'names';
RENAME : 'rename' | 'name';
LAYER : 'layer' | 'l';
FILL : 'fill';
SERIALIZE : 'serialize';
GROUP : 'group';
LOAD : 'load';
CLONE : 'clone';

SQUARE    : 'square' | 'sq';
CIRCLE    : 'circle' | 'circ';
RECTANGLE : 'rectangle' | 'rect';
POLYGON : 'polygon' | 'poly';
LINE : 'line';

SIZE   : 'size' | 's';
LENGTH : 'length';
RADIUS : 'radius' | 'r';
WIDTH  : 'width' | 'w';
HEIGHT : 'height' | 'h';
HOLLOW : 'hollow';
SAVE   : 'save';
DOWN   : 'down';
UP     : 'up';
STROKE : 'stroke' | 'st';
ALL    : 'all';

IMAGE : 'image' | 'img';
SCRIPT : 'script';

LPAREN : '(';
RPAREN : ')';
COMMA  : ',';
COLOR : [a-zA-Z_][a-zA-Z0-9_]*;
