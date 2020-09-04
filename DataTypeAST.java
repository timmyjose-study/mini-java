// Data_Type ::= int | boolean
abstract class DataTypeAST {}

class IntTypeAST extends DataTypeAST {
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

class BooleanTypeAST extends DataTypeAST {
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