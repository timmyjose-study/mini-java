// Expression ::= Identifier | Numeral | ( Expression Operator Expression )
abstract class ExpressionTree {}

class IdExpressionTree extends ExpressionTree {
  private Identifier id;

  public IdExpressionTree(Identifier id) {
    this.id = id;
  }

  public Identifier id() {
    return this.id;
  }
}

class NumExpressionTree extends ExpressionTree {
  private int number;

  public NumExpressionTree(int number) {
    this.number = number;
  }

  public int number() {
    return this.number;
  }
}

class BinExpressionTree extends ExpressionTree {
  private ExpressionTree left;
  private Operator op;
  private ExpressionTree right;

  public BinExpressionTree(ExpressionTree left, Operator op, ExpressionTree right) {
    this.left = left;
    this.op = op;
    this.right = right;
  }

  public ExpressionTree left() {
    return this.left;
  }

  public Operator op() {
    return this.op;
  }

  public ExpressionTree right() {
    return this.right;
  }
}