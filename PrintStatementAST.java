/// Print_Statement ::= println Identifier
public class PrintStatementAST extends StatementAST {
  private Identifier id;

  public PrintStatementAST(Identifier id) {
    this.id = id;
  }

  public Identifier id() {
    return this.id;
  }

  @Override
  public String toString() {
    return "PrintStatementAST { id = " + this.id + " }";
  }
}
