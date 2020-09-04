import java.util.Map;
import java.util.HashMap;

public class Token {
  TokenType kind;
  String spelling;
  int line;
  int column;
  private static final Map<String, TokenType> keywords;

  static {
    keywords = new HashMap<>();
    
    keywords.put("=", TokenType.BECOMES);
    keywords.put(";", TokenType.SEMICOLON);
    keywords.put("println", TokenType.PRINTLN);
    keywords.put("while", TokenType.WHILE);
    keywords.put("{", TokenType.LEFT_BRACE);
    keywords.put("}", TokenType.RIGHT_BRACE);
    keywords.put("(", TokenType.LEFT_PAREN);
    keywords.put(")", TokenType.RIGHT_PAREN);
  }

  public Token(TokenType kind, String spelling, int line, int column) {
    this.kind = kind;

    if (keywords.containsKey(spelling)) {
      this.kind = keywords.get(spelling);
    }
    this.spelling = spelling;
    this.line = line;
    this.column = column;
  }

  @Override
  public String toString() {
    return "<" + this.kind.description() + ", " + this.spelling + ">";
  }
}
