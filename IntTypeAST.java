public class IntTypeAST extends DataTypeAST {
  private String spelling;

  public IntTypeAST() {
    this.spelling = "int";
  }

  public String spelling() {
    return this.spelling;
  }

  @Override
  public String toString() {
    return "IntTypeAST { spelling = " + this.spelling + " }";
  }
}
