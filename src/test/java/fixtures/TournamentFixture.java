package fixtures;

import domains.Player;
import domains.Tournament;
import iterators.impl.TournamentIterator;
import java.util.List;

public class TournamentFixture {

  private TournamentFixture() {}

  public static Tournament of(List<Player> players) {
    return Tournament.newTournament(
        TournamentIterator.newIterator(players, SingleMatchStrategyFixture.of()));
  }
}
