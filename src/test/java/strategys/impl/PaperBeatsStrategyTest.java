package strategys.impl;

import main.java.strategys.StrategyType;
import main.java.strategys.impl.PaperBeatsStrategy;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
public class PaperBeatsStrategyTest {

    @ParameterizedTest
    @MethodSource("fixtures.PaperBeatsMethodSource#beats")
    public void shouldBeats(PaperBeatsStrategy paper, StrategyType strategyType, boolean expected) {
        assertEquals(expected, paper.beats(strategyType));
    }
}
