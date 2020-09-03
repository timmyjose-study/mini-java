```
Program ::= { StatementList }
StatementList ::= [[ Statement ;]]*
Statement ::= Data_Type Identifier
            | Identifier = Expression
            | println Expression
            | while Expression { StatementList }
Data_Type ::= int | boolean
Expression ::= Identifier | Numeral | ( Expression Operator Expression)

Identifier ::= Letter [[ Letter ]]*
Numeral ::= Digit [[ Digit ]]*
Operator ::= + | ==
Letter ::=  A | B | ... | Z
Numeral ::= 0 | 1 | 2 | ... | 9
```