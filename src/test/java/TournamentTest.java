import fixtures.TournamentFixture;
import main.java.Player;
import main.java.Tournament;
import main.java.exceptions.WrongNumberOfPlayersError;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class TournamentTest {
    private final Tournament tournament = TournamentFixture.of();

    @ParameterizedTest
    @MethodSource("fixtures.PlayerMethodSource#tournament")
    @Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
    public void tournament(List<Player> players, Player winner) throws WrongNumberOfPlayersError {
        assertEquals(winner, tournament.tournamentWinner(players));
    }

    @ParameterizedTest
    @MethodSource("fixtures.PlayerMethodSource#massive")
    public void massive(int timeOut, List<Player> players) {
        assertTimeout(Duration.ofMillis(timeOut), () -> tournament.tournamentWinner(players));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
    public void shouldReturnErrorIfPlayersIsNull(List<Player> playerList) {
        assertThrows(WrongNumberOfPlayersError.class, () -> tournament.tournamentWinner(playerList));
    }
}