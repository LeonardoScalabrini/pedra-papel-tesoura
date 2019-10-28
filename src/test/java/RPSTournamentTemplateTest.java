package test.java;

import main.java.Play;
import main.java.RPSGameTemplate;
import main.java.RPSTournamentTemplate;
import main.java.StrategyType;
import main.java.exceptions.RPSException;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.factorys.ChainOfValidationFactory;
import main.java.iterators.impl.TournamentIterator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RPSTournamentTemplateTest {

    private RPSTournamentTemplate rpsTournamentTemplate = new RPSTournamentTemplate(new RPSGameTemplate(new ChainOfValidationFactory()), new TournamentIterator());

    @Test
    public void shouldWinnerTournament() throws RPSException {
        List<List<List<Play>>> tournament = new ArrayList<>();
        List<List<Play>> groupA = new ArrayList<>();
        groupA.add(Arrays.asList(new Play("Armando", StrategyType.P), new Play("Dave", StrategyType.S)));
        groupA.add(Arrays.asList(new Play("Richard", StrategyType.R), new Play("Michael", StrategyType.S)));

        List<List<Play>> groupB = new ArrayList<>();
        groupB.add(Arrays.asList(new Play("Allen", StrategyType.S), new Play("Omer", StrategyType.P)));
        groupB.add(Arrays.asList(new Play("David E.", StrategyType.R), new Play("Richard X.", StrategyType.P)));

        tournament.add(groupA);
        tournament.add(groupB);

        assertEquals(new Play("Richard", StrategyType.R), rpsTournamentTemplate.rps_tournament_winner(tournament));
    }

    @Test
    public void shouldWinnerTournamentWith1Group() throws RPSException {
        List<List<List<Play>>> tournament = new ArrayList<>();
        List<List<Play>> groupA = new ArrayList<>();
        groupA.add(Arrays.asList(new Play("Armando", StrategyType.P), new Play("Dave", StrategyType.S)));
        groupA.add(Arrays.asList(new Play("Richard", StrategyType.R), new Play("Michael", StrategyType.S)));

        tournament.add(groupA);

        assertEquals(new Play("Richard", StrategyType.R), rpsTournamentTemplate.rps_tournament_winner(tournament));
    }

    @Test
    public void shouldWinnerTournamentWith3Groups() throws RPSException {
        List<List<List<Play>>> tournament = new ArrayList<>();
        List<List<Play>> groupA = new ArrayList<>();
        groupA.add(Arrays.asList(new Play("Armando", StrategyType.P), new Play("Dave", StrategyType.S)));
        groupA.add(Arrays.asList(new Play("Richard", StrategyType.R), new Play("Michael", StrategyType.S)));

        List<List<Play>> groupB = new ArrayList<>();
        groupB.add(Arrays.asList(new Play("Allen", StrategyType.S), new Play("Omer", StrategyType.P)));
        groupB.add(Arrays.asList(new Play("David E.", StrategyType.R), new Play("Richard X.", StrategyType.P)));

        tournament.add(groupA);
        tournament.add(groupB);
        tournament.add(groupA);

        assertEquals(new Play("Richard", StrategyType.R), rpsTournamentTemplate.rps_tournament_winner(tournament));
    }

    @Test
    public void shouldWinnerTournamentWith4Groups() throws RPSException {
        List<List<List<Play>>> tournament = new ArrayList<>();
        List<List<Play>> groupA = new ArrayList<>();
        groupA.add(Arrays.asList(new Play("Armando", StrategyType.P), new Play("Dave", StrategyType.S)));
        groupA.add(Arrays.asList(new Play("Richard", StrategyType.R), new Play("Michael", StrategyType.S)));

        List<List<Play>> groupB = new ArrayList<>();
        groupB.add(Arrays.asList(new Play("Allen", StrategyType.S), new Play("Omer", StrategyType.P)));
        groupB.add(Arrays.asList(new Play("David E.", StrategyType.R), new Play("Richard X.", StrategyType.P)));

        tournament.add(groupA);
        tournament.add(groupB);
        tournament.add(groupA);
        tournament.add(groupB);

        assertEquals(new Play("Richard", StrategyType.R), rpsTournamentTemplate.rps_tournament_winner(tournament));
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsNull() throws RPSException {
        rpsTournamentTemplate.rps_tournament_winner(null);
    }
}