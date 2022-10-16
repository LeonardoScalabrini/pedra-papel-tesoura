package domains;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class MatchTest {

  @ParameterizedTest
  @MethodSource("fixtures.PlayerMethodSource#winner")
  void shouldReturnWinner(List<Player> players, Player winner) {
    assertEquals(winner, Match.winner(players).orElseThrow());
  }

  @ParameterizedTest
  @NullAndEmptySource
  @MethodSource("fixtures.PlayerMethodSource#wrongNumberOfPlayers")
  void shouldReturnWrongNumberOfPlayersError(List<Player> players) {
    assertThrows(Exception.class, () -> Match.winner(players));
  }
}
