package test.java;

import main.java.Player;
import main.java.strategys.StrategyType;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void shouldEquals() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player("name", StrategyType.S);
        assertTrue(one.equals(two));
    }

    @Test
    public void notShouldEqualsWithDiffName() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player("diff", StrategyType.S);
        assertFalse(one.equals(two));
    }

    @Test
    public void notShouldEqualsWithDiffStategy() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player("name", StrategyType.P);
        assertFalse(one.equals(two));
    }

    @Test
    public void notShouldEqualsWithDiffNameAndStategy() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player("diff", StrategyType.P);
        assertFalse(one.equals(two));
    }

    @Test
    public void notShouldEqualsWithNullName() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player(null, StrategyType.S);
        assertFalse(one.equals(two));
    }

    @Test
    public void notShouldEqualsWithNullStategy() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player("name", null);
        assertFalse(one.equals(two));
    }

    @Test
    public void notShouldEqualsWithNullNameAndStategy() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player(null, null);
        assertFalse(one.equals(two));
    }

    @Test
    public void shouldHash() {
        Player one = new Player("name", StrategyType.S);
        assertEquals(1915661092, one.hashCode());
    }
}