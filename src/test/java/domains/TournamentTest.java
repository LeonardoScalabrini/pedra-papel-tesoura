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
    var test = tournament.tournamentWinner().test();
    test.awaitTerminalEvent(10, TimeUnit.MILLISECONDS);
    test.assertValue(Optional.of(winner))
        .assertComplete()
        .assertNoErrors()
        .assertNoTimeout()
        .assertSubscribed()
        .dispose();
  }

  @ParameterizedTest
  @MethodSource("fixtures.PlayerMethodSource#massive")
  void massive(int timeOut, List<Player> players) {
    Tournament tournament = TournamentFixture.of(players);
    var test = tournament.tournamentWinner().test();
    test.awaitTerminalEvent(10, TimeUnit.MILLISECONDS);
    test.assertValueCount(1)
        .assertComplete()
        .assertNoErrors()
        .assertNoTimeout()
        .assertSubscribed()
        .dispose();
  }

  @Test
  void shouldReturnWithEmptyOrNullElement() {
    assertThrows(NullPointerException.class, () -> TournamentFixture.of(null));

    List<Player> players = new ArrayList<>();
    Tournament tournament = TournamentFixture.of(players);
    var test = tournament.tournamentWinner().test();
    test.awaitTerminalEvent(10, TimeUnit.MILLISECONDS);
    test.assertComplete()
        .assertNoErrors()
        .assertValue(Optional.empty())
        .assertNoTimeout()
        .assertSubscribed()
        .dispose();

    players.add(null);
    final Tournament tournamentThrows = TournamentFixture.of(players);
    var testThrows = tournamentThrows.tournamentWinner().test();
    testThrows.awaitTerminalEvent(10, TimeUnit.MILLISECONDS);
    testThrows
        .assertComplete()
        .assertValue(Optional.empty())
        .assertNoTimeout()
        .assertSubscribed()
        .dispose();
  }

  @ParameterizedTest
  @MethodSource("fixtures.TournamentMethodSource#winner")
  void winner(List<Player> players, boolean expectedWinner, Player winner) {
    Tournament tournament = TournamentFixture.of(players);
    Optional<Player> expected = expectedWinner ? Optional.of(winner) : Optional.empty();
    var test = tournament.tournamentWinner().test();
    test.awaitTerminalEvent(10, TimeUnit.MILLISECONDS);
    test.assertValue(expected)
        .assertComplete()
        .assertNoErrors()
        .assertNoTimeout()
        .assertSubscribed()
        .dispose();
  }
}
