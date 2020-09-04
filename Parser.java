import java.util.List;
import java.util.ArrayList;
import java.text.MessageFormat;

public class Parser {
  private Lexer lexer;
  private Token currentToken;

  public Parser(String filename) {
    this.lexer = new Lexer(filename);
  }

  private void accept(TokenType tt) {
    if (currentToken.kind != tt) {
      throw new ParserException(MessageFormat.format("Expected token of kind {0}, found kind {1} at line {2}, column {3}",
            tt,
            currentToken.kind,
            currentToken.line,
            currentToken.column));
    }

    if (currentToken.kind == TokenType.EOT) return;

    currentToken = lexer.nextToken();
  }

  private void acceptIt() {
    currentToken = lexer.nextToken();
  }

  public ProgramAST parse() {
    currentToken = lexer.nextToken();
    ProgramAST ast = parseProgram();
    accept(TokenType.EOT);
    return ast;
  }

  // Program := { Statement_List }
  private ProgramAST parseProgram() {
    ProgramAST ast = null;

    switch (currentToken.kind) {
      case LEFT_BRACE: 
        acceptIt();
        StatementListAST stmtList = parseStatementList();
        accept(TokenType.RIGHT_BRACE);
        ast = new ProgramAST(stmtList);
        break;

      default: 
        throw new ParserException(MessageFormat.format("Unexpected token of kind {0} at line {1}, column {2}", 
              currentToken.kind,
              currentToken.line,
              currentToken.column));
    }

    return ast;
  }

  // Statement_List ::= statement ()
  private StatementListAST parseStatementList() {
    StatementListAST stmtList = null;

    while (currentToken.kind != TokenType.RIGHT_BRACE) {
      StatementAST stmt = parseStatement();
      stmtList = new StatementListAST(stmt, stmtList);
    }

    return stmtList;
  }

  // Statement ::= DeclarationStatement | AssignStatement | PrintStatement | WhileStatement
  private StatementAST parseStatement() {
    StatementAST stmt = null;

    switch (currentToken.kind) {
      case IDENTIFIER: 
        {
          if (currentToken.spelling.equalsIgnoreCase("int") || 
              currentToken.spelling.equalsIgnoreCase("boolean")) {
            DataTypeAST dataType = parseDataType();
            Identifier id = parseIdentifier();

            stmt = new DeclarationStatementAST(dataType, id);
          } else {
            Identifier id = parseIdentifier();
            accept(TokenType.BECOMES);
            ExpressionAST expr = parseExpression();

            stmt = new AssignmentStatementAST(id, expr);
          }
        }
        break;

      case PRINTLN:
        acceptIt();
        Identifier id = parseIdentifier();

        stmt = new PrintStatementAST(id);
        break;

      case WHILE:
        acceptIt();
        ExpressionAST expr = parseExpression();
        accept(TokenType.LEFT_BRACE);
        StatementListAST stmtList = parseStatementList();
        accept(TokenType.RIGHT_BRACE);

        stmt = new WhileStatementAST(expr, stmtList);
        break;

      default: 
        throw new ParserException(MessageFormat.format("Unexpected token of kind {0} at line {1}, column {2}",
            currentToken.kind,
            currentToken.line,
            currentToken.column));
    }
            
    accept(TokenType.SEMICOLON);

    return stmt;
  }

  // Data_Type ::= int | boolean
  private DataTypeAST parseDataType() {
    DataTypeAST dataType = null;

    if (currentToken.spelling.equalsIgnoreCase("int")) {
      dataType = new IntTypeAST();
    } else if (currentToken.spelling.equalsIgnoreCase("boolean")) {
      dataType = new BooleanTypeAST();
    } else {
      throw new ParserException(MessageFormat.format("Unknown data type {0} at line {1}, column {2}",
            currentToken.spelling,
            currentToken.line,
            currentToken.column));
    }

    acceptIt();

    return dataType;
  }

  // Identifier ::= Letter (Letter)*
  private Identifier parseIdentifier() {
    if (currentToken.kind != TokenType.IDENTIFIER) {
      throw new ParserException(MessageFormat.format("Expected token of kind {0}, found token of kind {1} at line {2}, column {3}",
            TokenType.IDENTIFIER,
            currentToken.kind,
            currentToken.line,
            currentToken.column));
    }

    Identifier id = new Identifier(currentToken.spelling);
    acceptIt();

    return id;
  }

  // Expression ::= IdExpression | NumExpression | BinaryExpression
  private ExpressionAST parseExpression() {
    ExpressionAST expr = null;

    switch (currentToken.kind) {
      case IDENTIFIER:
        Identifier id = parseIdentifier();
        return new IdExpressionAST(id);

      case NUMBER:
        int number = parseNumber();
        return new NumExpressionAST(number);

      case LEFT_PAREN:
        acceptIt();
        ExpressionAST left = parseExpression();
        Operator op = parseOperator();
        ExpressionAST right = parseExpression();
        accept(TokenType.RIGHT_PAREN);

        return new BinaryExpressionAST(left, op, right);

      default:
        throw new ParserException(MessageFormat.format("Unexpected token kind {0} and line {1}, column {2}",
              currentToken.kind,
              currentToken.line,
              currentToken.column));
    }
  }

  // Operator ::= + | ==
  private Operator parseOperator() {
    if (currentToken.kind != TokenType.OPERATOR) {
      throw new ParserException(MessageFormat.format("Expected token of kind {0}, found token of kind {1} at line {2}, column {3}",
            TokenType.OPERATOR,
            currentToken.kind,
            currentToken.line,
            currentToken.column));
    }

    Operator op = new Operator(currentToken.spelling);
    acceptIt();

    return op;
  }

  // Number ::= digit (digit)*
  private int parseNumber() {
    int number = Integer.parseInt(currentToken.spelling);
    acceptIt();

    return number;
  }
}
