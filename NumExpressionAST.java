public class NumExpressionAST extends ExpressionAST {
  private int number;

  public NumExpressionAST(int number) {
    this.number = number;
  }

  public int number() {
    return this.number;
  }

  @Override
  public String toString() {
    return "NumExpressionAST { number = " + this.number + " }";
  }
}
