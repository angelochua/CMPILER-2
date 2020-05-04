grammar B;

source
    : block EOF
    ;
/*
mainDeclaration
    : MAIN LBRACE statement* RBRACE
    ;
*/
block
    : ( statement | functionDecl )* ( RETURN expression SCOLON)?
    ;

statement
    : assignment SCOLON
    | constantAssignment SCOLON
    | functionCall SCOLON
    | ifStatement
    | forStatement
    | whileStatement
    | doWhileStatement
    | tryCatchNullStatement
    | tryCatchIndexOutOfBoundsStatement
    | tryCatchDivideByZeroStatement
    ;

assignment
    : VAR IDENTIFIER indexes? '=' expression
    ;

constantAssignment
    : CONST IDENTIFIER indexes? '=' expression
    ;

ifStatement
    : ifStat elseIfStat* elseStat?
    ;

ifStat
    : IF expression LBRACE block RBRACE
    ;

elseIfStat
    : ELSE IF expression LBRACE block RBRACE
    ;

elseStat
    : ELSE LBRACE block RBRACE
    ;

functionDecl
    : FUNC IDENTIFIER '(' idList? ')' LBRACE block RBRACE
    | missingLBraceFuncDecl
    | missingRBraceFuncDecl
    ;

missingLBraceFuncDecl
    : FUNC IDENTIFIER '(' idList? ')' block RBRACE
    ;

missingRBraceFuncDecl
    : FUNC IDENTIFIER '(' idList? ')' LBRACE block
    ;

forStatement
    : FOR IDENTIFIER '=' expression TO expression LBRACE block RBRACE
    | missingLBraceForLoop
    | missingRBraceForLoop
    ;

missingLBraceForLoop
    : FOR IDENTIFIER '=' expression TO expression block RBRACE
    ;

missingRBraceForLoop
    : FOR IDENTIFIER '=' expression TO expression LBRACE block
    ;

whileStatement
    : WHILE expression LBRACE block RBRACE
    | missingLBraceWhileLoop
    | missingRBraceWhileLoop
    ;

missingLBraceWhileLoop
    : WHILE expression block RBRACE
    ;

missingRBraceWhileLoop
    : WHILE expression LBRACE block
    ;

doWhileStatement
    : DO LBRACE block RBRACE WHILE expression SCOLON
    | missingLBraceDoWhileLoop
    | missingRBraceDoWhileLoop
    ;

missingLBraceDoWhileLoop
    : DO block RBRACE WHILE expression SCOLON
    ;

missingRBraceDoWhileLoop
    : DO LBRACE block WHILE expression SCOLON
    ;

tryCatchNullStatement
    : TRY LBRACE statement* RBRACE CATCH '(' 'NullException' ')' LBRACE statement* RBRACE FINALLY LBRACE statement* RBRACE
    ;

tryCatchIndexOutOfBoundsStatement
    : TRY LBRACE statement* RBRACE CATCH '(' 'IndexOutOfBounds' ')' LBRACE statement* RBRACE FINALLY LBRACE statement* RBRACE
    ;

tryCatchDivideByZeroStatement
    : TRY LBRACE statement* RBRACE CATCH '(' 'DivideByZero' ')' LBRACE statement* RBRACE FINALLY LBRACE statement* RBRACE
    ;

functionCall
    : IDENTIFIER '(' exprList? ')' #identifierFunctionCall
    | PRINTLN '(' expression? ')'  #printlnFunctionCall
    | PRINT '(' expression ')'     #printFunctionCall
    | PRINT exprList? ')'          #missingLParenPrintStatement
    | PRINT '(' exprList?          #missingRParenStatement
    ;

idList
    : IDENTIFIER ( ',' IDENTIFIER )*
    ;

exprList
    : expression ( ',' expression )*
    ;

expression
    : '-' expression                                          #unaryMinusExpression
    | '!' expression                                          #notExpression
    | <assoc=right> expression '^' expression                 #powerExpression
    | expression op=( '*' | '/' | '%' ) expression            #multExpression
    | expression op=( '+' | '-' ) expression                  #ADDExpression
    | expression ( '++' | '--' | '**' | '//' '%%') expression #excessOperationExpression
    | expression op=( '>=' | '<=' | '>' | '<' ) expression    #compExpression
    | expression op=( '==' | '!=' ) expression                #eqExpression
    | expression '&&' expression                              #andExpression
    | expression '||' expression                              #orExpression
    | expression '?' expression ':' expression                #ternaryExpression
    | expression IN expression                                #inExpression
    | NUMBER                                                  #numberExpression
    | BOOL                                                    #boolExpression
    | NULL                                                    #nullExpression
    | functionCall indexes?                                   #functionCallExpression
    | list indexes?                                           #listExpression
    | IDENTIFIER indexes?                                     #identifierExpression
    | STRING indexes?                                         #stringExpression
    | '(' expression ')' indexes?                             #expressionExpression
    | expression ')'                                          #missingLParenExpression
    | '(' expression                                          #missingRParenExpression
    | INPUT '(' STRING? ')'                                   #inputExpression
    ;

indexes
    : ( '[' expression ']' )+
    ;

list
    : '[' exprList? ']'
    ;

// Keywords
MAIN     : 'bain';
PRINTLN  : 'brint';
PRINT    : 'print';
INPUT    : 'bnput';
FUNC     : 'bunc';
CONST    : 'bonst';
IF       : 'bf';
ELSE     : 'blse';
RETURN   : 'beturn';
FOR      : 'bor';
WHILE    : 'bhile';
TO       : 'bto';
DO       : 'bdo';
END      : 'bnd';
IN       : 'bn';
NULL     : 'bull';
VAR      : 'bar';
TRY      : 'bry';
CATCH    : 'batch';
FINALLY  : 'binally';

AND      : '&&';
OR       : '||';
EQUALS   : '==';
NEQUALS  : '!=';
GTEQUALS : '>=';
LTEQUALS : '<=';
POW      : '^';
BANG     : '!';
GT       : '>';
LT       : '<';
MUL      : '*';
DIV      : '/';
ADD      : '+';
SUB      : '-';
MOD      : '%';
RPAREN   : ')';
LPAREN   : '(';
LBRACE   : '{';
RBRACE   : '}';
LBRACKET : '[';
RBRACKET : ']';
SCOLON   : ';';
ASSIGN   : '=';
COMMA    : ',';
QMARK    : '?';

BOOL
    : 'butete' // true
    | 'palaka' // false
    ;

NUMBER
    : Int ( '.' Digit* )?
    ;

IDENTIFIER
    : [a-zA-Z_] [a-zA-Z_0-9]*
    ;

STRING
    : ["] ( ~["\r\n\\] | '\\' ~[\r\n] )* ["]
    | ['] ( ~['\r\n\\] | '\\' ~[\r\n] )* [']
    ;

COMMENT
    : ( '//' ~[\r\n]* | '/*' .*? '*/' ) -> skip
    ;

SPACE
    : [ \t\r\n\u000C] -> skip
    ;

fragment Int
    : [1-9] Digit*
    | '0'
    ;

fragment Digit
    : [0-9]
    ;

fragment Letter
    : [a-zA-Z$_] // these are the "java letters" below 0x7F
    | ~[\u0000-\u007F\uD800-\uDBFF] // covers all characters above 0x7F which are not a surrogate
    | [\uD800-\uDBFF] [\uDC00-\uDFFF] // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
    ;