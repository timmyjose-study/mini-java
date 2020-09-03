// Statement_List ::= Statement ; Statement_List | epsilon
abstract class StatementListTree {
}

class StatementList1 extends StatementListTree {
 private StatementTree stmt;
 private StatementListTree rest;

 public StatementList1(StatementTree stmt, StatementListTree rest) {
   this.stmt = stmt;
   this.rest = rest;
 }

 public StatementTree StatementTree() {
   return this.stmt;
 }

 public StatementListTree rest() {
   return this.rest;
 }
}

class StatementList2 extends StatementListTree {
  public StatementList2() {}
}