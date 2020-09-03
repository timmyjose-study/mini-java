import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.IOException;

public class Scanner {
  private List<Char> characters;
  private int idx;

  public Scanner(String filename) {
    this.characters = new ArrayList<>();
    this.initialise(filename);
    this.idx = 0;
  }

  public void initialise(String filename) {
    try {
      int line = 0;
      int column = 0;

      List<String> lines = Files.readAllLines(Paths.get(filename));
      for (String s : lines) {
        line++;
        for (char c : s.toCharArray()) {
          this.characters.add(new Char(c, line, ++column));
        }
      }
      characters.add(new Char('\u0000', -1, -1));
    } catch (IOException ex) {
      throw new ScannerException(ex.getLocalizedMessage());
    }
  }

  public boolean hasMoreCharacters() {
    return this.idx < this.characters.size();
  }

  public Char nextCharacter() {
    return this.characters.get(idx++);
  }
}
