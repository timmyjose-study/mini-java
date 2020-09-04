public class BinaryExpressionAST extends ExpressionAST {
  private ExpressionAST left;
  private Operator op;
  private ExpressionAST right;

  public BinaryExpressionAST(ExpressionAST left, Operator op, ExpressionAST right) {
    this.left = left;
    this.op = op;
    this.right = right;
  }

  public ExpressionAST left() {
    return this.left;
  }

  public Operator op() {
    return this.op;
  }

  public ExpressionAST right() {
    return this.right;
  }

  @Override
  public String toString() {
    return "BinaryExpressionAST { left = " + this.left + ", op = " + this.op + ", right = " + this.right + " }";
  }
}



