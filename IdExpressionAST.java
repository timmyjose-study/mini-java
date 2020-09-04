public class IdExpressionAST extends ExpressionAST {
  private Identifier id;

  public IdExpressionAST(Identifier id) {
    this.id = id;
  }

  public Identifier id() {
    return this.id;
  }

  @Override
  public String toString() {
    return "IdExpressionAST { id = " + this.id + " }";
  }
}
