package test.java.strategys.impl;

import main.java.strategys.StrategyType;
import main.java.strategys.impl.RockBeatsStrategy;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RockBeatsStrategyTest {

    private RockBeatsStrategy beatsStrategy = new RockBeatsStrategy();

    @Test
    public void shouldBeats() {
        assertTrue(beatsStrategy.beats(StrategyType.S));
    }

    @Test
    public void notShouldBeatsIfR() {
        assertFalse(beatsStrategy.beats(StrategyType.R));
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
