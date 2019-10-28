package test.java.strategys.impl;

import main.java.StrategyType;
import main.java.strategys.impl.PaperBeatsStrategy;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PaperBeatsStrategyTest {

    private PaperBeatsStrategy beatsStrategy = new PaperBeatsStrategy();

    @Test
    public void shouldBeats() {
        assertTrue(beatsStrategy.beats(StrategyType.R));
    }

    @Test
    public void notShouldBeatsIfS() {
        assertFalse(beatsStrategy.beats(StrategyType.S));
    }

    @Test
    public void notShouldBeatsIfP() {
        assertFalse(beatsStrategy.beats(StrategyType.P));
    }

    @Test
    public void notShouldBeatsIfNull() {
        assertFalse(beatsStrategy.beats(null));
    }
}
