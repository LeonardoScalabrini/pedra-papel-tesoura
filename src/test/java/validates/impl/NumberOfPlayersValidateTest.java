package test.java.validates.impl;

import main.java.Play;
import main.java.StrategyType;
import main.java.exceptions.RPSException;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.validates.impl.NumberOfPlayersValidate;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class NumberOfPlayersValidateTest {

    private NumberOfPlayersValidate numberOfPlayersValidate = new NumberOfPlayersValidate();

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErroIfEmpty() throws RPSException {
        numberOfPlayersValidate.valid(Collections.emptyList());
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErroIfNull() throws RPSException {
        numberOfPlayersValidate.valid(null);
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsGreaterThanTwo() throws RPSException {
        numberOfPlayersValidate.valid(Arrays.asList(new Play("", StrategyType.P), new Play("", StrategyType.P), new Play("", StrategyType.P)));
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void shouldReturnErrorIfPlayersIsLessThanTwo() throws RPSException {
        numberOfPlayersValidate.valid(Arrays.asList(new Play("", StrategyType.P)));
    }

    @Test
    public void notShouldReturnErrorIfPlayersIsTwo() throws RPSException {
        numberOfPlayersValidate.valid(Arrays.asList(new Play("", StrategyType.P), new Play("", StrategyType.P)));
    }
}
