package strategys.impl;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import strategys.StrategyType;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
class RockBeatsStrategyTest {

  @ParameterizedTest
  @MethodSource("fixtures.RockBeatsMethodSource#beats")
  void shouldBeats(RockBeatsStrategy rock, StrategyType strategyType, boolean expected) {
    assertEquals(expected, rock.beats(strategyType));
  }
}
