// Statement_List ::= Statement ; Statement_List | epsilon
class StatementListAST {
 private StatementAST stmt;
 private StatementListAST rest;

 public StatementListAST(StatementAST stmt, StatementListAST rest) {
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
   return "StatementListAST { rest = " + this.rest + ", stmt = " + this.stmt + " }";
 }
}