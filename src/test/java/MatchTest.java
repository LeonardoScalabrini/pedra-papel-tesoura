package test.java;

import main.java.Match;
import main.java.Player;
import main.java.exceptions.NoSuchStrategyError;
import main.java.exceptions.RPSException;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.factorys.ChainOfValidationFactory;
import main.java.strategys.StrategyType;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class MatchTest {

    private static final String ARMANDO = "Armando";
    private Match match = new Match(new ChainOfValidationFactory());

    @Test
    public void shouldReturnWinnerR() throws RPSException {
        assertEquals(new Player(ARMANDO, StrategyType.R), match.winner(Arrays.asList(new Player(ARMANDO, StrategyType.R), new Player("Dave", StrategyType.S))));
    }

    @Test
    public void shouldReturnWinnerS() throws RPSException {
        assertEquals(new Player(ARMANDO, StrategyType.S), match.winner(Arrays.asList(new Player(ARMANDO, StrategyType.S), new Player("Dave", StrategyType.P))));
    }

    @Test
    public void shouldReturnWinnerP() throws RPSException {
        assertEquals(new Player(ARMANDO, StrategyType.P), match.winner(Arrays.asList(new Player(ARMANDO, StrategyType.P), new Player("Dave", StrategyType.R))));
    }

    @Test
    public void shouldReturnWinnerSecondPlayer() throws RPSException {
        assertEquals(new Player("Dave", StrategyType.S), match.winner(Arrays.asList(new Player(ARMANDO, StrategyType.P), new Player("Dave", StrategyType.S))));
    }

    @Test
    public void shouldReturnWinnerWithDraw() throws RPSException {
        assertEquals(new Player(ARMANDO, StrategyType.S), match.winner(Arrays.asList(new Player(ARMANDO, StrategyType.S), new Player("Dave", StrategyType.S))));
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsLessThanTwo() throws RPSException {
        match.winner(Collections.singletonList(new Player(ARMANDO, StrategyType.P)));
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsGreaterThanTwo() throws RPSException {
        match.winner(Arrays.asList(new Player(ARMANDO, StrategyType.P), new Player("Dave", StrategyType.S), new Player("Mike", StrategyType.R)));
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsNull() throws RPSException {
        match.winner(null);
    }

    @Test(expected = NoSuchStrategyError.class)
    public void shouldReturnErrorIfPlayersStrategyIsSomethingOtherThanRPS() throws RPSException {
        match.winner(Arrays.asList(new Player(ARMANDO, null), new Player("Dave", null)));
    }
}
