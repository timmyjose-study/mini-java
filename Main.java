import java.util.List;

public class Main {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("Usage: mj <FILE>");
      System.exit(1);
    }

    Parser parser = new Parser(args[0]);
    ProgramAST program = parser.parse();
    System.out.println(program);
  }
}