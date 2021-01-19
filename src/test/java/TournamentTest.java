import main.java.Match;
import main.java.Player;
import main.java.Tournament;
import main.java.exceptions.RPSException;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.factorys.ChainOfValidationFactory;
import main.java.iterators.impl.TournamentIterator;
import main.java.strategys.StrategyType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TournamentTest {

    private static final String ARMANDO = "Armando";
    private static final String RICHARD = "Richard";
    private static final String MICHAEL = "Michael";
    private static final String ALLEN = "Allen";
    private static final String DAVID_E = "David E.";
    private static final String RICHARD_X = "Richard X.";
    private Tournament tournament = new Tournament(new Match(new ChainOfValidationFactory()), new TournamentIterator());

    @Test
    public void shouldWinnerTournament() throws RPSException {
        List<List<List<Player>>> groups = new ArrayList<>();
        List<List<Player>> groupA = new ArrayList<>();
        groupA.add(Arrays.asList(new Player(ARMANDO, StrategyType.P), new Player("Dave", StrategyType.S)));
        groupA.add(Arrays.asList(new Player(RICHARD, StrategyType.R), new Player(MICHAEL, StrategyType.S)));

        List<List<Player>> groupB = new ArrayList<>();
        groupB.add(Arrays.asList(new Player(ALLEN, StrategyType.S), new Player("Omer", StrategyType.P)));
        groupB.add(Arrays.asList(new Player(DAVID_E, StrategyType.R), new Player(RICHARD_X, StrategyType.P)));

        groups.add(groupA);
        groups.add(groupB);

        assertEquals(new Player(RICHARD, StrategyType.R), this.tournament.tournamentWinner(groups));
    }

    @Test
    public void shouldWinnerTournamentWith1Group() throws RPSException {
        List<List<List<Player>>> groups = new ArrayList<>();
        List<List<Player>> groupA = new ArrayList<>();
        groupA.add(Arrays.asList(new Player(ARMANDO, StrategyType.P), new Player("Dave", StrategyType.S)));
        groupA.add(Arrays.asList(new Player(RICHARD, StrategyType.R), new Player(MICHAEL, StrategyType.S)));

        groups.add(groupA);

        assertEquals(new Player(RICHARD, StrategyType.R), this.tournament.tournamentWinner(groups));
    }

    @Test
    public void shouldWinnerTournamentWith3Groups() throws RPSException {
        List<List<List<Player>>> groups = new ArrayList<>();
        List<List<Player>> groupA = new ArrayList<>();
        groupA.add(Arrays.asList(new Player(ARMANDO, StrategyType.P), new Player("Dave", StrategyType.S)));
        groupA.add(Arrays.asList(new Player(RICHARD, StrategyType.R), new Player(MICHAEL, StrategyType.S)));

        List<List<Player>> groupB = new ArrayList<>();
        groupB.add(Arrays.asList(new Player(ALLEN, StrategyType.S), new Player("Omer", StrategyType.P)));
        groupB.add(Arrays.asList(new Player(DAVID_E, StrategyType.R), new Player(RICHARD_X, StrategyType.P)));

        groups.add(groupA);
        groups.add(groupB);
        groups.add(groupA);

        assertEquals(new Player(RICHARD, StrategyType.R), this.tournament.tournamentWinner(groups));
    }

    @Test
    public void shouldWinnerTournamentWith4Groups() throws RPSException {
        List<List<List<Player>>> groups = new ArrayList<>();
        List<List<Player>> groupA = new ArrayList<>();
        groupA.add(Arrays.asList(new Player(ARMANDO, StrategyType.P), new Player("Dave", StrategyType.S)));
        groupA.add(Arrays.asList(new Player(RICHARD, StrategyType.R), new Player(MICHAEL, StrategyType.S)));

        List<List<Player>> groupB = new ArrayList<>();
        groupB.add(Arrays.asList(new Player(ALLEN, StrategyType.S), new Player("Omer", StrategyType.P)));
        groupB.add(Arrays.asList(new Player(DAVID_E, StrategyType.R), new Player(RICHARD_X, StrategyType.P)));

        groups.add(groupA);
        groups.add(groupB);
        groups.add(groupA);
        groups.add(groupB);

        assertEquals(new Player(RICHARD, StrategyType.R), this.tournament.tournamentWinner(groups));
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsNull() throws RPSException {
        tournament.tournamentWinner(null);
    }
}