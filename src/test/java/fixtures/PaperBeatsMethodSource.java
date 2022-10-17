package fixtures;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import domains.StrategyType;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import strategys.impl.PaperBeatsStrategy;

public class PaperBeatsMethodSource {
  private static Stream<Arguments> beats() {
    return Stream.of(
        arguments(PaperBeatsStrategy.getInstance(), StrategyType.S, false),
        arguments(PaperBeatsStrategy.getInstance(), StrategyType.R, true),
        arguments(PaperBeatsStrategy.getInstance(), StrategyType.P, false),
        arguments(PaperBeatsStrategy.getInstance(), null, false));
  }
}
