// Statement_List ::= Statement ; Statement_List | epsilon
abstract class StatementListAST {
}

class StatementListAST1 extends StatementListAST {
 private StatementAST stmt;
 private StatementListAST rest;

 public StatementListAST1(StatementAST stmt, StatementListAST rest) {
   this.stmt = stmt;
   this.rest = rest;
 }

 public StatementAST StatementAST() {
   return this.stmt;
 }

 public StatementListAST rest() {
   return this.rest;
 }

 @Override
 public String toString() {
   return "StatementListAST1 { stmt = " + this.stmt + ", rest = " + this.rest + " }";
 }
}

class StatementListAST2 extends StatementListAST {
  public StatementListAST2() {}

  @Override
  public String toString() {
    return "StatementListAST2 {}";
  }
}