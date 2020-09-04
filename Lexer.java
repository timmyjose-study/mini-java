import java.util.List;
import java.util.ArrayList;
import java.text.MessageFormat;
import java.io.IOException;

public class Lexer {
  private Scanner scanner;
  private List<Token> tokens;
  private int idx;

  private Char currentChar;
  private StringBuffer currentSpelling;
  private int currentLine;
  private int currentColumn;

  public Lexer(String filename) {
    this.scanner = new Scanner(filename);
    this.tokens = new ArrayList<>();
    this.currentChar = scanner.nextCharacter();
    this.scan();
    System.out.println(tokens);
    this.idx = 0;
  }

  private void skipIt() {
    if (scanner.hasMoreCharacters()) currentChar = scanner.nextCharacter();
  }

  private void skip(char c) {
    if (currentChar.c != c) {
      throw new ScannerException(MessageFormat.format("Expected character {0}, found character {1} at line {2} and column {3}", 
            c,
            currentChar.c,
            currentChar.line,
            currentChar.column));
    }

    if (scanner.hasMoreCharacters()) currentChar = scanner.nextCharacter();
  }

  private void acceptIt() {
    currentSpelling.append(currentChar.c);
    if (scanner.hasMoreCharacters()) currentChar = scanner.nextCharacter();
  }

  private void accept(char c) {
    if (currentChar.c != c) {
      throw new ScannerException(MessageFormat.format("Expected to accept character {0}, found character {1} at line {2] and column {3}}",
            c,
            currentChar.c,
            currentChar.line,
            currentChar.column));
    }

    currentSpelling.append(c);
    if (scanner.hasMoreCharacters()) currentChar = scanner.nextCharacter();
  }

  public void scan() {
    while (scanner.hasMoreCharacters()) {
      scanWhitespace();
      currentSpelling = new StringBuffer();
      TokenType tt = scanToken();
      tokens.add(new Token(tt, currentSpelling.toString(), currentLine, currentColumn));
    }

    // for eot
    TokenType tt = scanToken();
    if (tt != TokenType.EOT) {
      throw new LexerException(MessageFormat.format("Expected eot, found {0} at line {1}, column {2}",
            currentChar.c,
            currentChar.line,
            currentChar.column));
    }
    tokens.add(new Token(TokenType.EOT, "<eot>", -1, -1));
  }

  private void scanWhitespace() {
    switch (currentChar.c) {
      case ' ':
      case '\t':
        while (Character.isWhitespace(currentChar.c)) {
          skipIt();
        }
    }
  }

  private TokenType scanToken() {
    currentLine = currentChar.line;
    currentColumn = currentChar.column;

    switch (currentChar.c) {
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9': 
        acceptIt();
        while (Character.isDigit(currentChar.c)) {
          acceptIt();
        }
        return TokenType.NUMBER;

      case 'a':
      case 'b':
      case 'c':
      case 'd':
      case 'e':
      case 'f':
      case 'g':
      case 'h':
      case 'i':
      case 'j':
      case 'k':
      case 'l':
      case 'm':
      case 'n':
      case 'o':
      case 'p':
      case 'q':
      case 'r':
      case 's':
      case 't':
      case 'u':
      case 'v':
      case 'w':
      case 'x':
      case 'y':
      case 'z':
      case 'A':
      case 'B':
      case 'C':
      case 'D':
      case 'E':
      case 'F':
      case 'G':
      case 'H':
      case 'I':
      case 'J':
      case 'K':
      case 'L':
      case 'M':
      case 'N':
      case 'O':
      case 'P':
      case 'Q':
      case 'R':
      case 'S':
      case 'T':
      case 'U':
      case 'V':
      case 'W':
      case 'X':
      case 'Y':
      case 'Z':
        acceptIt();
        while (Character.isLetter(currentChar.c)) {
          acceptIt();
        }
        return TokenType.IDENTIFIER;

      case '(': acceptIt(); return TokenType.LEFT_PAREN;
      case ')': acceptIt(); return TokenType.RIGHT_PAREN;
      case '{': acceptIt(); return TokenType.LEFT_BRACE;
      case '}': acceptIt(); return TokenType.RIGHT_BRACE;
      case ';': acceptIt(); return TokenType.SEMICOLON;
      case '+': acceptIt(); return TokenType.OPERATOR;
      case '=':
                acceptIt();
                if (currentChar.c == '=') {
                  acceptIt();
                  return TokenType.OPERATOR;
                }
               return TokenType.BECOMES;

      case '\u0000': skipIt(); return TokenType.EOT;

      default: throw new ScannerException("something went wrong, unexpected character " + currentChar.c);
    }
  }

  public boolean hasMoreTokens() {
    return idx < tokens.size();
  }

  public Token nextToken() {
    return tokens.get(idx++);
  }
}
