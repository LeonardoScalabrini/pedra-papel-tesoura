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
import org.junit.jupiter.params.provider.NullAndEmptySource;

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
        Duration.ofMillis(timeOut), () -> TournamentFixture.of(players).tournamentWinner().orElseThrow());
  }

  @ParameterizedTest
  @NullAndEmptySource
  @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
  void shouldReturnErrorIfPlayersIsNull(List<Player> players) {
    assertThrows(Exception.class, () -> TournamentFixture.of(players).tournamentWinner().orElseThrow());
  }

  @Test
  @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
  void shouldReturnWithEmptyOrNullElement() {
    assertTrue(TournamentFixture.of(Collections.emptyList()).tournamentWinner().isEmpty());
    assertTrue(TournamentFixture.of(Collections.singletonList(null)).tournamentWinner().isEmpty());
  }
}
