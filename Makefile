JAVACC := javac
JAVAFLAGS := -Xlint
CLASSES := ProgramTree.java StatementListTree.java StatementTree.java ExpressionTree.java Identifier.java DataTypeTree.java \
					 Operator.java TokenType.java Token.java Lexer.java LexerException.java ScannerException.java \
					 Main.java

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