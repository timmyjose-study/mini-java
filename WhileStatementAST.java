// While_Statement ::= while Expression { Statement_List }
public class WhileStatementAST extends StatementAST {
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




