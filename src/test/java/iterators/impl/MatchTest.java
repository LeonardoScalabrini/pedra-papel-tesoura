package iterators.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import domains.Player;
import fixtures.SingleMatchStrategyFixture;
import strategys.impl.SingleMatchStrategy;

@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class MatchTest {

  private SingleMatchStrategy singleMatchStrategy = SingleMatchStrategyFixture.of();

  @ParameterizedTest
  @MethodSource("fixtures.PlayerMethodSource#winner")
  void shouldReturnWinner(List<Player> players, Player winner) {
    assertEquals(winner, singleMatchStrategy.winner(players).orElseThrow());
  }

  @ParameterizedTest
  @NullSource
  void shouldReturnNullPointerError(List<Player> players) {
    assertThrows(NullPointerException.class, () -> singleMatchStrategy.winner(players));
  }

  @Test
  void shouldReturnWithEmptyOrNullElement() {
    assertTrue(singleMatchStrategy.winner(Collections.singletonList(null)).isEmpty());
    assertTrue(singleMatchStrategy.winner(Collections.emptyList()).isEmpty());
  }

  @ParameterizedTest
  @MethodSource("fixtures.PlayerMethodSource#fewPlayers")
  void shouldReturnWinner(List<Player> players) {
    assertTrue(singleMatchStrategy.winner(players).isEmpty());
  }
}
