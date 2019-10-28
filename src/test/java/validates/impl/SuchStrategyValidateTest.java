package test.java.validates.impl;

import main.java.Play;
import main.java.StrategyType;
import main.java.exceptions.NoSuchStrategyError;
import main.java.exceptions.RPSException;
import main.java.validates.impl.SuchStrategyValidate;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class SuchStrategyValidateTest {

    private SuchStrategyValidate suchStrategyValidate = new SuchStrategyValidate();

    @Test(expected = NoSuchStrategyError.class)
    public void shouldReturnErroIfNotIsStrategy() throws RPSException {
        suchStrategyValidate.valid(Arrays.asList(new Play("", null)));
    }

    @Test
    public void notShouldReturnErroIfEmpty() throws RPSException {
        suchStrategyValidate.valid(Collections.emptyList());
    }

    @Test(expected = NoSuchStrategyError.class)
    public void shouldReturnErroIfNull() throws RPSException {
        suchStrategyValidate.valid(null);
    }

    @Test
    public void notShouldReturnErroIfIsStrategy() throws RPSException {
        suchStrategyValidate.valid(Arrays.asList(new Play("", StrategyType.P)));
    }
}
