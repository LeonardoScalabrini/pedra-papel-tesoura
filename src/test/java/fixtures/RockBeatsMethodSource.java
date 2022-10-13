package fixtures;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import main.java.strategys.StrategyType;
import main.java.strategys.impl.RockBeatsStrategy;
import org.junit.jupiter.params.provider.Arguments;

public class RockBeatsMethodSource {
  private static Stream<Arguments> beats() {
    return Stream.of(
        arguments(RockBeatsStrategy.getInstance(), StrategyType.S, true),
        arguments(RockBeatsStrategy.getInstance(), StrategyType.R, false),
        arguments(RockBeatsStrategy.getInstance(), StrategyType.P, false),
        arguments(RockBeatsStrategy.getInstance(), null, false));
  }
}
