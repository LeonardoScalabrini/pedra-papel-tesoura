package domains;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exceptions.RPSException;
import exceptions.WrongNumberOfPlayersError;
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
  void shouldReturnWinner(List<Player> players, Player winner) throws RPSException {
    assertEquals(winner, Match.winner(players));
  }

  @ParameterizedTest
  @NullAndEmptySource
  @MethodSource("fixtures.PlayerMethodSource#wrongNumberOfPlayers")
  void shouldReturnWrongNumberOfPlayersError(List<Player> players) {
    assertThrows(WrongNumberOfPlayersError.class, () -> Match.winner(players));
  }
}
