import main.java.Player;
import main.java.strategys.StrategyType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PlayerTest {

    @Test
    public void shouldEquals() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player("name", StrategyType.S);
        assertEquals(one, two);
    }

    @Test
    public void notShouldEqualsWithDiffName() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player("diff", StrategyType.S);
        assertNotEquals(one, two);
    }

    @Test
    public void notShouldEqualsWithDiffStategy() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player("name", StrategyType.P);
        assertNotEquals(one, two);
    }

    @Test
    public void notShouldEqualsWithDiffNameAndStategy() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player("diff", StrategyType.P);
        assertNotEquals(one, two);
    }

    @Test
    public void notShouldEqualsWithNullName() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player(null, StrategyType.S);
        assertNotEquals(one, two);
    }

    @Test
    public void notShouldEqualsWithNullStategy() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player("name", null);
        assertNotEquals(one, two);
    }

    @Test
    public void notShouldEqualsWithNullNameAndStategy() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player(null, null);
        assertNotEquals(one, two);
    }

    @Test
    public void shouldHash() {
        Player one = new Player("name", StrategyType.S);
        Player two = new Player("name", StrategyType.S);
        assertEquals(one.hashCode(), two.hashCode());
    }
}