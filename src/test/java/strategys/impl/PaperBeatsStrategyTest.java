package strategys.impl;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import strategys.StrategyType;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
class PaperBeatsStrategyTest {

  @ParameterizedTest
  @MethodSource("fixtures.PaperBeatsMethodSource#beats")
  void shouldBeats(PaperBeatsStrategy paper, StrategyType strategyType, boolean expected) {
    assertEquals(expected, paper.beats(strategyType));
  }
}
