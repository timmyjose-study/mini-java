public class BooleanTypeAST extends DataTypeAST {
  private String spelling;

  public BooleanTypeAST() {
    this.spelling = "boolean";
  }

  public String spelling() {
    return this.spelling;
  }

  @Override
  public String toString() {
    return "BooleanTypeAST { spelling = " + this.spelling + " }";
  }
}


