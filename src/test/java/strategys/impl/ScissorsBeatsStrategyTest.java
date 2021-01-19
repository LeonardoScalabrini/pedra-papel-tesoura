package test.java.strategys.impl;

import main.java.strategys.StrategyType;
import main.java.strategys.impl.ScissorsBeatsStrategy;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScissorsBeatsStrategyTest {

    private ScissorsBeatsStrategy beatsStrategy = new ScissorsBeatsStrategy();

    @Test
    public void shouldBeats() {
        assertTrue(beatsStrategy.beats(StrategyType.P));
    }

    @Test
    public void notShouldBeatsIfR() {
        assertFalse(beatsStrategy.beats(StrategyType.R));
    }

    @Test
    public void notShouldBeatsIfS() {
        assertFalse(beatsStrategy.beats(StrategyType.S));
    }

    @Test
    public void notShouldBeatsIfNull() {
        assertFalse(beatsStrategy.beats(null));
    }
}
