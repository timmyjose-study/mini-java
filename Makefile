JAVACC := javac
JAVAFLAGS := -Xlint
CLASSES := ProgramAST.java StatementListAST.java StatementAST.java ExpressionAST.java Identifier.java DataTypeAST.java \
					 Operator.java TokenType.java Token.java Lexer.java LexerException.java ScannerException.java ParserException.java \
					 Parser.java Main.java

.PHONY: clean run default
.SUFFIXES: .java .class

.java.class:
	$(JAVACC) $(JAVAFLAGS) $*.java

default: classes

classes: $(CLASSES:.java=.class)

run:
	java -cp . Main $(ARGS)

clean:
	rm -f *.class