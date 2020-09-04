// Assign_Statement ::= Identifier = Expression
public class AssignmentStatementAST extends StatementAST {
  private Identifier id;
  private ExpressionAST expr;

  public AssignmentStatementAST(Identifier id, ExpressionAST expr) {
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
