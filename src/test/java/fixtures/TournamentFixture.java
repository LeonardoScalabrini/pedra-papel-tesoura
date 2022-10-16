package fixtures;

import java.util.List;

import domains.Player;
import domains.Tournament;
import iterators.impl.TournamentIterator;

public class TournamentFixture {

  private TournamentFixture() {}

  public static Tournament of(List<Player> players) {
    return Tournament.newTournament(TournamentIterator.newIterator(players, SingleMatchStrategyFixture.of()));
  }
}
