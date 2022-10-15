package iterators.impl;

import static org.junit.jupiter.api.Assertions.*;

import domains.Player;
import exceptions.WrongNumberOfPlayersError;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class TournamentIteratorTest {

  @ParameterizedTest
  @MethodSource("fixtures.TournamentIteratorMethodSource#next")
  void next(
      List<Player> players,
      int numberOfIterations,
      boolean expectedNext,
      boolean expectedWinner,
      Player winner)
      throws WrongNumberOfPlayersError {
    TournamentIterator iterator = new TournamentIterator();
    iterator.createIterator(players);
    for (int i = 0; i < numberOfIterations; i++) {
      iterator.next();
    }
    assertEquals(expectedNext, iterator.hasNext());
    assertEquals(expectedWinner, iterator.winner().isPresent());
    if (expectedWinner) assertEquals(winner, iterator.winner().get());
  }
}
