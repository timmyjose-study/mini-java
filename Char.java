public class Char {
  char c;
  int line;
  int column;

  public Char(char c, int line, int column) {
    this.c = c;
    this.line = line;
    this.column = column;
  }

  @Override
  public String toString() {
    return "Char { \"" + this.c + "\", " + this.line + ", " + this.column + " }";
  }
}

