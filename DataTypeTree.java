// Data_Type ::= int | boolean
abstract class DataTypeTree {}

class IntTypeTree extends DataTypeTree {
  private String spelling;

  public IntTypeTree() {
    this.spelling = "int";
  }

  public String spelling() {
    return this.spelling;
  }
}

class BooleanTypeTree extends DataTypeTree {
  private String spelling;

  public BooleanTypeTree() {
    this.spelling = "boolean";
  }

  public String spelling() {
    return this.spelling;
  }
}