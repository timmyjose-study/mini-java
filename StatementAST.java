// Statement ::= Decl_Statement | Assign_Statement | Print_Statement | While_Statement
abstract class StatementAST {
}

// Decl_Statement ::= Data_Type Identifier
class DeclStatementAST extends StatementAST {
  private DataTypeAST dataType;
  private Identifier id;

  public DeclStatementAST(DataTypeAST dataType, Identifier id) {
    this.dataType = dataType;
    this.id = id;
  }

  public DataTypeAST dataType() {
    return this.dataType;
  }

  public Identifier id() {
    return this.id;
  }

  @Override
  public String toString() {
    return "DeclStatementAST { dataType = " + this.dataType + ", id = " + this.id + " }";
  }
}

// Assign_Statement ::= Identifier = Expression
class AssignStatementAST extends StatementAST {
  private Identifier id;
  private ExpressionAST expr;

  public AssignStatementAST(Identifier id, ExpressionAST expr) {
    this.id = id;
    this.expr = expr;
  }

  public Identifier id() {
    return this.id;
  }

  public ExpressionAST expr() {
    return this.expr;
  }

  @Override
  public String toString() {
    return "AssignStatementAST { id = " + this.id + ". expr = " + this.expr + " }";
  }
}

/// Print_Statement ::= println Identifier
class PrintStatementAST extends StatementAST {
  private Identifier id;

  public PrintStatementAST(Identifier id) {
    this.id = id;
  }

  public Identifier id() {
    return this.id;
  }

  @Override
  public String toString() {
    return "PrintStatementAST { id = " + this.id + " }";
  }
}

// While_Statement ::= while Expression { Statement_List }
class WhileStatementAST extends StatementAST {
  private ExpressionAST expr;
  private StatementListAST stmtList;

  public WhileStatementAST(ExpressionAST expr, StatementListAST stmtList) {
    this.expr = expr;
    this.stmtList = stmtList;
  }

  public ExpressionAST expr() {
    return this.expr;
  }

  public StatementListAST stmtList() {
    return this.stmtList;
  }

  @Override
  public String toString() {
    return "WhileStatementAST { expr = " + this.expr + ", stmtList = " + this.stmtList + " }";
  }
}