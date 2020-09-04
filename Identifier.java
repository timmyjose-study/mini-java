class Identifier {
  String spelling;

  public Identifier(String spelling) {
    this.spelling = spelling;
  }

  @Override
  public String toString() {
    return "Identifier { spelling = " + this.spelling + " }";
  }
}