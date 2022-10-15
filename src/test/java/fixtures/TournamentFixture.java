package fixtures;

import domains.Tournament;
import iterators.impl.TournamentIterator;

public class TournamentFixture {

  private TournamentFixture() {}

  public static Tournament of() {
    return new Tournament(new TournamentIterator());
  }
}
