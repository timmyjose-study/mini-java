// Expression ::= Identifier | Numeral | ( Expression Operator Expression )
abstract class ExpressionAST {}

class IdExpressionAST extends ExpressionAST {
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

class NumExpressionAST extends ExpressionAST {
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

class BinExpressionAST extends ExpressionAST {
  private ExpressionAST left;
  private Operator op;
  private ExpressionAST right;

  public BinExpressionAST(ExpressionAST left, Operator op, ExpressionAST right) {
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
    return "BinExpressionAST { left = " + this.left + ", op = " + this.op + ", right = " + this.right + " }";
  }
}