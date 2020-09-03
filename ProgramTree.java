// Program ::= { Statement_List }
public class ProgramTree {
  private StatementListTree stmtList;

  public ProgramTree(StatementListTree stmtList) {
    this.stmtList = stmtList;
  }

  public StatementListTree stmtList() {
    return this.stmtList;
  }
}