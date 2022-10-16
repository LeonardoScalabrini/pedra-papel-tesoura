package iterators.impl;

import static org.junit.jupiter.api.Assertions.*;

import domains.Player;
import fixtures.SingleMatchStrategyFixture;
import fixtures.TournamentIteratorFixture;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class TournamentIteratorTest {

  @ParameterizedTest
  @MethodSource("fixtures.TournamentIteratorMethodSource#next")
  void next(
      List<Player> players,
      int numberOfIterations,
      boolean expectedNext,
      boolean expectedWinner,
      Player winner) {
    TournamentIterator iterator = TournamentIteratorFixture.of(players);
    IntStream.range(0, numberOfIterations).forEach((i) -> iterator.next());
    assertEquals(expectedNext, iterator.hasNext());
    assertEquals(expectedWinner, iterator.winner().isPresent());
    if (expectedWinner) assertEquals(winner, iterator.winner().orElseThrow());
  }

  @ParameterizedTest
  @NullSource
  @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
  void shouldReturnErrorIfPlayersIsNull(List<Player> players) {
    assertThrows(Exception.class, () -> TournamentIteratorFixture.of(players));
  }
}
