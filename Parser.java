import java.util.List;
import java.util.ArrayList;

public class Parser {
  private Lexer lexer;
  private Token currentToken;

  public Parser(String filename) {
    this.lexer = new Lexer(filename);
  }

  public ProgramAST parse() {
    return null;
  }
}
