JAVACC := javac
JAVAFLAGS := -Xlint
CLASSES := \
			AssignmentStatementAST.java \
			BinaryExpressionAST.java \
			BooleanTypeAST.java \
			Char.java \
			DataTypeAST.java \
			DeclarationStatementAST.java \
			ExpressionAST.java \
			IdExpressionAST.java \
			Identifier.java \
			IntTypeAST.java \
			Lexer.java \
			LexerException.java \
			Main.java \
			NumExpressionAST.java \
			Operator.java \
			Parser.java \
			ParserException.java \
			PrintStatementAST.java \
			ProgramAST.java \
			Scanner.java \
			ScannerException.java \
			StatementAST.java \
			StatementListAST.java \
			Token.java \
			TokenType.java \
			WhileStatementAST.java 
 
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