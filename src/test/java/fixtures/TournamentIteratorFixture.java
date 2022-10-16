package fixtures;

import domains.Player;
import iterators.impl.TournamentIterator;
import java.util.List;

public class TournamentIteratorFixture {
  public static TournamentIterator of(List<Player> players) {
    return TournamentIterator.newIterator(players, SingleMatchStrategyFixture.of());
  }
}
