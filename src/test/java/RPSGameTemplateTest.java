package test.java;

import main.java.Play;
import main.java.RPSGameTemplate;
import main.java.StrategyType;
import main.java.exceptions.NoSuchStrategyError;
import main.java.exceptions.RPSException;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.factorys.ChainOfValidationFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class RPSGameTemplateTest {

    private RPSGameTemplate rpsGameTemplate = new RPSGameTemplate(new ChainOfValidationFactory());

    @Test
    public void shouldReturnWinnerR() throws RPSException {
        assertEquals(new Play("Armando", StrategyType.R), rpsGameTemplate.rps_game_winner(Arrays.asList(new Play("Armando", StrategyType.R), new Play("Dave", StrategyType.S))));
    }

    @Test
    public void shouldReturnWinnerS() throws RPSException {
        assertEquals(new Play("Armando", StrategyType.S), rpsGameTemplate.rps_game_winner(Arrays.asList(new Play("Armando", StrategyType.S), new Play("Dave", StrategyType.P))));
    }

    @Test
    public void shouldReturnWinnerP() throws RPSException {
        assertEquals(new Play("Armando", StrategyType.P), rpsGameTemplate.rps_game_winner(Arrays.asList(new Play("Armando", StrategyType.P), new Play("Dave", StrategyType.R))));
    }

    @Test
    public void shouldReturnWinnerSecondPlayer() throws RPSException {
        assertEquals(new Play("Dave", StrategyType.S), rpsGameTemplate.rps_game_winner(Arrays.asList(new Play("Armando", StrategyType.P), new Play("Dave", StrategyType.S))));
    }

    @Test
    public void shouldReturnWinnerWithDraw() throws RPSException {
        assertEquals(new Play("Armando", StrategyType.S), rpsGameTemplate.rps_game_winner(Arrays.asList(new Play("Armando", StrategyType.S), new Play("Dave", StrategyType.S))));
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsLessThanTwo() throws RPSException {
        rpsGameTemplate.rps_game_winner(Collections.singletonList(new Play("Armando", StrategyType.P)));
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsGreaterThanTwo() throws RPSException {
        rpsGameTemplate.rps_game_winner(Arrays.asList(new Play("Armando", StrategyType.P), new Play("Dave", StrategyType.S), new Play("Mike", StrategyType.R)));
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsNull() throws RPSException {
        rpsGameTemplate.rps_game_winner(null);
    }

    @Test(expected = NoSuchStrategyError.class)
    public void shouldReturnErrorIfPlayersStrategyIsSomethingOtherThanRPS() throws RPSException {
        rpsGameTemplate.rps_game_winner(Arrays.asList(new Play("Armando", null), new Play("Dave", null)));
    }
}
