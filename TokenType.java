public enum TokenType {
  EOT("<eot>"),
  IDENTIFIER("<identifier>"),
  LEFT_BRACE("<left-brace>"),
  LEFT_PAREN("<left-paren>"),
  NUMBER("<number>"),
  OPERATOR("<operator>"),
  PRINTLN("<println>"),
  RIGHT_BRACE("<right-brace>"),
  RIGHT_PAREN("<right-paren>"),
  SEMICOLON("<semi-colon>"),
  WHILE("<while>");

  private String description;

  private TokenType(String description) {
    this.description = description;
  }

  public String description() {
    return this.description;
  }
}
