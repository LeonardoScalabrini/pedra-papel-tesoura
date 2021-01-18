package test.java;

import main.java.GameTemplate;
import main.java.Play;
import main.java.StrategyType;
import main.java.exceptions.NoSuchStrategyError;
import main.java.exceptions.RPSException;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.factorys.ChainOfValidationFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class GameTemplateTest {

    private static final String ARMANDO = "Armando";
    private GameTemplate gameTemplate = new GameTemplate(new ChainOfValidationFactory());

    @Test
    public void shouldReturnWinnerR() throws RPSException {
        assertEquals(new Play(ARMANDO, StrategyType.R), gameTemplate.gameWinner(Arrays.asList(new Play(ARMANDO, StrategyType.R), new Play("Dave", StrategyType.S))));
    }

    @Test
    public void shouldReturnWinnerS() throws RPSException {
        assertEquals(new Play(ARMANDO, StrategyType.S), gameTemplate.gameWinner(Arrays.asList(new Play(ARMANDO, StrategyType.S), new Play("Dave", StrategyType.P))));
    }

    @Test
    public void shouldReturnWinnerP() throws RPSException {
        assertEquals(new Play(ARMANDO, StrategyType.P), gameTemplate.gameWinner(Arrays.asList(new Play(ARMANDO, StrategyType.P), new Play("Dave", StrategyType.R))));
    }

    @Test
    public void shouldReturnWinnerSecondPlayer() throws RPSException {
        assertEquals(new Play("Dave", StrategyType.S), gameTemplate.gameWinner(Arrays.asList(new Play(ARMANDO, StrategyType.P), new Play("Dave", StrategyType.S))));
    }

    @Test
    public void shouldReturnWinnerWithDraw() throws RPSException {
        assertEquals(new Play(ARMANDO, StrategyType.S), gameTemplate.gameWinner(Arrays.asList(new Play(ARMANDO, StrategyType.S), new Play("Dave", StrategyType.S))));
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsLessThanTwo() throws RPSException {
        gameTemplate.gameWinner(Collections.singletonList(new Play(ARMANDO, StrategyType.P)));
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsGreaterThanTwo() throws RPSException {
        gameTemplate.gameWinner(Arrays.asList(new Play(ARMANDO, StrategyType.P), new Play("Dave", StrategyType.S), new Play("Mike", StrategyType.R)));
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsNull() throws RPSException {
        gameTemplate.gameWinner(null);
    }

    @Test(expected = NoSuchStrategyError.class)
    public void shouldReturnErrorIfPlayersStrategyIsSomethingOtherThanRPS() throws RPSException {
        gameTemplate.gameWinner(Arrays.asList(new Play(ARMANDO, null), new Play("Dave", null)));
    }
}
