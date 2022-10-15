package fixtures;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import strategys.StrategyType;
import strategys.impl.ScissorsBeatsStrategy;

public class ScissorsBeatsMethodSource {
  private static Stream<Arguments> beats() {
    return Stream.of(
        arguments(ScissorsBeatsStrategy.getInstance(), StrategyType.S, false),
        arguments(ScissorsBeatsStrategy.getInstance(), StrategyType.R, false),
        arguments(ScissorsBeatsStrategy.getInstance(), StrategyType.P, true),
        arguments(ScissorsBeatsStrategy.getInstance(), null, false));
  }
}
