package fixtures;

import static fixtures.PlayerFixture.of;
import static java.util.Arrays.asList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import domains.Player;
import domains.StrategyType;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class PlayerMethodSource {

  public static final Player scissorsPlayer;
  public static final Player rockPlayer;
  public static final Player paperPlayer;

  static {
    scissorsPlayer = of("scissorsPlayer", StrategyType.S);
    rockPlayer = of("rockPlayer", StrategyType.R);
    paperPlayer = of("paperPlayer", StrategyType.P);
  }

  private static Stream<Arguments> tournament() {
    return Stream.of(
        arguments(asList(rockPlayer, scissorsPlayer), rockPlayer),
        arguments(asList(scissorsPlayer, paperPlayer, paperPlayer), scissorsPlayer),
        arguments(asList(paperPlayer, rockPlayer, rockPlayer, rockPlayer), paperPlayer),
        arguments(
            asList(rockPlayer, scissorsPlayer, paperPlayer, scissorsPlayer, scissorsPlayer),
            rockPlayer),
        arguments(
            asList(
                scissorsPlayer, paperPlayer, rockPlayer, paperPlayer, paperPlayer, scissorsPlayer),
            scissorsPlayer),
        arguments(
            asList(
                paperPlayer,
                rockPlayer,
                rockPlayer,
                scissorsPlayer,
                rockPlayer,
                scissorsPlayer,
                rockPlayer),
            paperPlayer));
  }

  private static Stream<Arguments> massive() {
    return Stream.of(
        arguments(10, of(10)),
        arguments(10, of(100)),
        arguments(10, of(1000)),
        arguments(30, of(10000)));
  }
}
