// Program ::= { Statement_List }
public class ProgramAST {
  private StatementListAST stmtList;

  public ProgramAST(StatementListAST stmtList) {
    this.stmtList = stmtList;
  }

  public StatementListAST stmtList() {
    return this.stmtList;
  }

  @Override
  public String toString() {
    return "ProgramAST { stmtList = " + this.stmtList + " }";
  }
}