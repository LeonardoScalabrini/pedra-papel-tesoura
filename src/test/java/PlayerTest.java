import fixtures.PlayerFixture;
import main.java.Player;
import main.java.exceptions.NoSuchStrategyError;
import main.java.strategys.StrategyType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
class PlayerTest {

    @ParameterizedTest
    @MethodSource("fixtures.PlayerMethodSource#equals")
    void equals(Player one, Player two, boolean expected) {
        assertEquals(expected, one.equals(two));
        assertEquals(expected, one.hashCode() == two.hashCode());
    }

    @Test
    void shouldThrowWithNullStrategy() {
        assertThrows(NoSuchStrategyError.class, () -> PlayerFixture.of("name", null));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowWithNullName(String name) {
        assertThrows(NullPointerException.class, () -> PlayerFixture.of(name, StrategyType.S));
    }
}