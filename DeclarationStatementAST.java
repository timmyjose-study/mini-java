// Decl_Statement ::= Data_Type Identifier
public class DeclarationStatementAST extends StatementAST {
  private DataTypeAST dataType;
  private Identifier id;

  public DeclarationStatementAST(DataTypeAST dataType, Identifier id) {
    this.dataType = dataType;
    this.id = id;
  }

  public DataTypeAST dataType() {
    return this.dataType;
  }

  public Identifier id() {
    return this.id;
  }

  @Override
  public String toString() {
    return "DeclStatementAST { dataType = " + this.dataType + ", id = " + this.id + " }";
  }
}


