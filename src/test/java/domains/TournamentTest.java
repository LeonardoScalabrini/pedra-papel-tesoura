package domains;

import static org.junit.jupiter.api.Assertions.*;

import fixtures.TournamentFixture;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TournamentTest {

  @ParameterizedTest
  @MethodSource("fixtures.PlayerMethodSource#tournament")
  void tournament(List<Player> players, Player winner) {
    Tournament tournament = TournamentFixture.of(players);
    Player result =
        assertTimeout(Duration.ofMillis(300), () -> tournament.tournamentWinner().orElseThrow());
    assertEquals(winner, result);
  }

  @ParameterizedTest
  @MethodSource("fixtures.PlayerMethodSource#massive")
  void massive(int timeOut, List<Player> players) {
    Tournament tournament = TournamentFixture.of(players);
    assertTimeout(Duration.ofMillis(timeOut), () -> tournament.tournamentWinner().orElseThrow());
  }

  @Test
  @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
  void shouldReturnWithEmptyOrNullElement() {
    assertThrows(NullPointerException.class, () -> TournamentFixture.of(null));

    List<Player> players = new ArrayList<>();
    Tournament tournament = TournamentFixture.of(players);
    assertTrue(tournament.tournamentWinner().isEmpty());

    players.add(null);
    final Tournament tournamentThrows = TournamentFixture.of(players);
    assertThrows(NullPointerException.class, () -> tournamentThrows.tournamentWinner());
  }

  @ParameterizedTest
  @MethodSource("fixtures.TournamentMethodSource#winner")
  void winner(List<Player> players, boolean expectedWinner, Player winner) {
    Tournament tournament = TournamentFixture.of(players);
    assertEquals(expectedWinner, tournament.tournamentWinner().isPresent());
    if (expectedWinner) assertEquals(winner, tournament.tournamentWinner().orElseThrow());
  }
}
