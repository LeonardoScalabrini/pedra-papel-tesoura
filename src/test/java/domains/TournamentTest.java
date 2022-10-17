package domains;

import static org.junit.jupiter.api.Assertions.*;

import fixtures.TournamentFixture;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TournamentTest {

  @ParameterizedTest
  @MethodSource("fixtures.PlayerMethodSource#tournament")
  @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
  void tournament(List<Player> players, Player winner) {
    assertEquals(winner, TournamentFixture.of(players).tournamentWinner().orElseThrow());
  }

  @ParameterizedTest
  @MethodSource("fixtures.PlayerMethodSource#massive")
  void massive(int timeOut, List<Player> players) {
    assertTimeout(
        Duration.ofMillis(timeOut),
        () -> TournamentFixture.of(players).tournamentWinner().orElseThrow());
  }

  @Test
  @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
  void shouldReturnWithEmptyOrNullElement() {
    assertThrows(NullPointerException.class, () -> TournamentFixture.of(null));
    assertTrue(TournamentFixture.of(Collections.emptyList()).tournamentWinner().isEmpty());
    assertThrows(
        NullPointerException.class,
        () -> TournamentFixture.of(Collections.singletonList(null)).tournamentWinner());
  }

  @ParameterizedTest
  @MethodSource("fixtures.TournamentMethodSource#winner")
  void winner(List<Player> players, boolean expectedWinner, Player winner) {
    Tournament tournament = TournamentFixture.of(players);
    assertEquals(expectedWinner, tournament.tournamentWinner().isPresent());
    if (expectedWinner) assertEquals(winner, tournament.tournamentWinner().orElseThrow());
  }
}
