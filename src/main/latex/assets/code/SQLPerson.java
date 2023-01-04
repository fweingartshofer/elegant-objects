final class SQLPerson implements Person {
  private final Source database;
  private final int id;

  public String name() {
    return new JdbcSession(this.database)
      .sql("SELECT title FROM post WHERE id = ?")
      .set(this.id)
      .select(new SingleOutcome<String>(String.class));
  }
}
