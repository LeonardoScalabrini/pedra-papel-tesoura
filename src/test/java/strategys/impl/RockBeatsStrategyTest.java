package strategys.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import domains.StrategyType;

@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
class RockBeatsStrategyTest {

  @ParameterizedTest
  @MethodSource("fixtures.RockBeatsMethodSource#beats")
  void shouldBeats(RockBeatsStrategy rock, StrategyType strategyType, boolean expected) {
    assertEquals(expected, rock.beats(strategyType));
  }
}
