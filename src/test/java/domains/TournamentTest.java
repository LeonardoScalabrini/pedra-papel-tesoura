package domains;

import static org.junit.jupiter.api.Assertions.*;

import fixtures.TournamentFixture;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class TournamentTest {
  private final Tournament tournament = TournamentFixture.of();

  @ParameterizedTest
  @MethodSource("fixtures.PlayerMethodSource#tournament")
  @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
  void tournament(List<Player> players, Player winner) {
    assertEquals(winner, tournament.tournamentWinner(players).orElseThrow());
  }

  @ParameterizedTest
  @MethodSource("fixtures.PlayerMethodSource#massive")
  void massive(int timeOut, List<Player> players) {
    assertTimeout(
        Duration.ofMillis(timeOut), () -> tournament.tournamentWinner(players).orElseThrow());
  }

  @ParameterizedTest
  @NullAndEmptySource
  @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
  void shouldReturnErrorIfPlayersIsNull(List<Player> playerList) {
    assertThrows(Exception.class, () -> tournament.tournamentWinner(playerList).orElseThrow());
  }
}
