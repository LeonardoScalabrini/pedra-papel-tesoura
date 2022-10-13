package strategys.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;
import main.java.strategys.StrategyType;
import main.java.strategys.impl.ScissorsBeatsStrategy;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
class ScissorsBeatsStrategyTest {

  @ParameterizedTest
  @MethodSource("fixtures.ScissorsBeatsMethodSource#beats")
  void shouldBeats(ScissorsBeatsStrategy scissors, StrategyType strategyType, boolean expected) {
    assertEquals(expected, scissors.beats(strategyType));
  }
}
