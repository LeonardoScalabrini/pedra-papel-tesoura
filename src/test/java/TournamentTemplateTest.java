package test.java;

import main.java.GameTemplate;
import main.java.Play;
import main.java.StrategyType;
import main.java.TournamentTemplate;
import main.java.exceptions.RPSException;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.factorys.ChainOfValidationFactory;
import main.java.iterators.impl.TournamentIterator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TournamentTemplateTest {

    private static final String ARMANDO = "Armando";
    private static final String RICHARD = "Richard";
    private static final String MICHAEL = "Michael";
    private static final String ALLEN = "Allen";
    private static final String DAVID_E = "David E.";
    private static final String RICHARD_X = "Richard X.";
    private TournamentTemplate tournamentTemplate = new TournamentTemplate(new GameTemplate(new ChainOfValidationFactory()), new TournamentIterator());

    @Test
    public void shouldWinnerTournament() throws RPSException {
        List<List<List<Play>>> tournament = new ArrayList<>();
        List<List<Play>> groupA = new ArrayList<>();
        groupA.add(Arrays.asList(new Play(ARMANDO, StrategyType.P), new Play("Dave", StrategyType.S)));
        groupA.add(Arrays.asList(new Play(RICHARD, StrategyType.R), new Play(MICHAEL, StrategyType.S)));

        List<List<Play>> groupB = new ArrayList<>();
        groupB.add(Arrays.asList(new Play(ALLEN, StrategyType.S), new Play("Omer", StrategyType.P)));
        groupB.add(Arrays.asList(new Play(DAVID_E, StrategyType.R), new Play(RICHARD_X, StrategyType.P)));

        tournament.add(groupA);
        tournament.add(groupB);

        assertEquals(new Play(RICHARD, StrategyType.R), tournamentTemplate.tournamentWinner(tournament));
    }

    @Test
    public void shouldWinnerTournamentWith1Group() throws RPSException {
        List<List<List<Play>>> tournament = new ArrayList<>();
        List<List<Play>> groupA = new ArrayList<>();
        groupA.add(Arrays.asList(new Play(ARMANDO, StrategyType.P), new Play("Dave", StrategyType.S)));
        groupA.add(Arrays.asList(new Play(RICHARD, StrategyType.R), new Play(MICHAEL, StrategyType.S)));

        tournament.add(groupA);

        assertEquals(new Play(RICHARD, StrategyType.R), tournamentTemplate.tournamentWinner(tournament));
    }

    @Test
    public void shouldWinnerTournamentWith3Groups() throws RPSException {
        List<List<List<Play>>> tournament = new ArrayList<>();
        List<List<Play>> groupA = new ArrayList<>();
        groupA.add(Arrays.asList(new Play(ARMANDO, StrategyType.P), new Play("Dave", StrategyType.S)));
        groupA.add(Arrays.asList(new Play(RICHARD, StrategyType.R), new Play(MICHAEL, StrategyType.S)));

        List<List<Play>> groupB = new ArrayList<>();
        groupB.add(Arrays.asList(new Play(ALLEN, StrategyType.S), new Play("Omer", StrategyType.P)));
        groupB.add(Arrays.asList(new Play(DAVID_E, StrategyType.R), new Play(RICHARD_X, StrategyType.P)));

        tournament.add(groupA);
        tournament.add(groupB);
        tournament.add(groupA);

        assertEquals(new Play(RICHARD, StrategyType.R), tournamentTemplate.tournamentWinner(tournament));
    }

    @Test
    public void shouldWinnerTournamentWith4Groups() throws RPSException {
        List<List<List<Play>>> tournament = new ArrayList<>();
        List<List<Play>> groupA = new ArrayList<>();
        groupA.add(Arrays.asList(new Play(ARMANDO, StrategyType.P), new Play("Dave", StrategyType.S)));
        groupA.add(Arrays.asList(new Play(RICHARD, StrategyType.R), new Play(MICHAEL, StrategyType.S)));

        List<List<Play>> groupB = new ArrayList<>();
        groupB.add(Arrays.asList(new Play(ALLEN, StrategyType.S), new Play("Omer", StrategyType.P)));
        groupB.add(Arrays.asList(new Play(DAVID_E, StrategyType.R), new Play(RICHARD_X, StrategyType.P)));

        tournament.add(groupA);
        tournament.add(groupB);
        tournament.add(groupA);
        tournament.add(groupB);

        assertEquals(new Play(RICHARD, StrategyType.R), tournamentTemplate.tournamentWinner(tournament));
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsNull() throws RPSException {
        tournamentTemplate.tournamentWinner(null);
    }
}