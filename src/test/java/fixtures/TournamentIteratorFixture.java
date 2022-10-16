package fixtures;

import java.util.List;

import domains.Player;
import iterators.impl.TournamentIterator;

public class TournamentIteratorFixture {
    public static TournamentIterator of(List<Player> players) {
        return TournamentIterator.newIterator(players, SingleMatchStrategyFixture.of());
      }
}
