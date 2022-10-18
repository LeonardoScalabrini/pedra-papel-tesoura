package domains;

import static org.junit.jupiter.api.Assertions.*;

import fixtures.TournamentFixture;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TournamentTest {

  @ParameterizedTest
  @MethodSource("fixtures.PlayerMethodSource#tournament")
  void tournament(List<Player> players, Player winner) {
    Tournament tournament = TournamentFixture.of(players);
    var results =
        tournament
            .tournamentWinner()
            .timeout(10, TimeUnit.MILLISECONDS)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertNoTimeout()
            .assertSubscribed()
            .values();
    assertEquals(winner, results.get(results.size() - 1).orElseThrow());
  }

  @ParameterizedTest
  @MethodSource("fixtures.PlayerMethodSource#massive")
  void massive(int timeOut, List<Player> players) {
    Tournament tournament = TournamentFixture.of(players);
    var results =
        tournament
            .tournamentWinner()
            .timeout(timeOut, TimeUnit.MILLISECONDS)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertNoTimeout()
            .assertSubscribed()
            .values();
    assertTrue(results.get(results.size() - 1).isPresent());
  }

  @Test
  void shouldReturnWithEmptyOrNullElement() {
    assertThrows(NullPointerException.class, () -> TournamentFixture.of(null));

    List<Player> players = new ArrayList<>();
    Tournament tournament = TournamentFixture.of(players);
    tournament
        .tournamentWinner()
        .timeout(10, TimeUnit.MILLISECONDS)
        .test()
        .assertComplete()
        .assertNoErrors()
        .assertValue(Optional.empty())
        .assertNoTimeout()
        .assertSubscribed();

    players.add(null);
    final Tournament tournamentThrows = TournamentFixture.of(players);
    tournamentThrows
        .tournamentWinner()
        .timeout(10, TimeUnit.MILLISECONDS)
        .test()
        .assertComplete()
        .assertValue(Optional.empty())
        .assertNoTimeout()
        .assertSubscribed();
  }

  @ParameterizedTest
  @MethodSource("fixtures.TournamentMethodSource#winner")
  void winner(List<Player> players, boolean expectedWinner, Player winner) {
    Tournament tournament = TournamentFixture.of(players);
    final Optional<Player> valueExpected = expectedWinner ? Optional.of(winner) : Optional.empty();
    var results =
        tournament
            .tournamentWinner()
            .timeout(10, TimeUnit.MILLISECONDS)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertNoTimeout()
            .assertSubscribed()
            .values();
    assertEquals(valueExpected, results.get(results.size() - 1));
  }
}
