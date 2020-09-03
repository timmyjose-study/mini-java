// Statement ::= Decl_Statement | Assign_Statement | Print_Statement | While_Statement
abstract class StatementTree {
}

// Decl_Statement ::= Data_Type Identifier
class DeclStatementTree extends StatementTree {
  private DataTypeTree dataType;
  private Identifier id;

  public DeclStatementTree(DataTypeTree dataType, Identifier id) {
    this.dataType = dataType;
    this.id = id;
  }

  public DataTypeTree dataType() {
    return this.dataType;
  }

  public Identifier id() {
    return this.id;
  }
}

// Assign_Statement ::= Identifier = Expression
class AssignStatementTree extends StatementTree {
  private Identifier id;
  private ExpressionTree expr;

  public AssignStatementTree(Identifier id, ExpressionTree expr) {
    this.id = id;
    this.expr = expr;
  }

  public Identifier id() {
    return this.id;
  }

  public ExpressionTree expr() {
    return this.expr;
  }
}

/// Print_Statement ::= println Identifier
class PrintStatementTree extends StatementTree {
  private Identifier id;

  public PrintStatementTree(Identifier id) {
    this.id = id;
  }

  public Identifier id() {
    return this.id;
  }
}

// While_Statement ::= while Expression { Statement_List }
class WhileStatementTree extends StatementTree {
  private ExpressionTree expr;
  private StatementListTree stmtList;

  public WhileStatementTree(ExpressionTree expr, StatementListTree stmtList) {
    this.expr = expr;
    this.stmtList = stmtList;
  }

  public ExpressionTree expr() {
    return this.expr;
  }

  public StatementListTree stmtList() {
    return this.stmtList;
  }
}