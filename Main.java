import java.util.List;

public class Main {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("Usage: mj <FILE>");
      System.exit(1);
    }

    Lexer lexer = new Lexer(args[0]);
    lexer.scan();
    while (lexer.hasMoreTokens()) {
      System.out.println(lexer.nextToken());
    }
  }
}