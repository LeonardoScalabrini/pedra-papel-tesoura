package fixtures;

import domains.Player;
import exceptions.NoSuchStrategyError;
import strategys.StrategyType;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Collections;
import java.util.stream.Stream;

import static fixtures.PlayerFixture.of;
import static java.util.Arrays.asList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PlayerMethodSource {

  private static final Player scissorsPlayer;
  private static final Player rockPlayer;
  private static final Player paperPlayer;

  static {
    try {
      scissorsPlayer = of("scissorsPlayer", StrategyType.S);
      rockPlayer = of("rockPlayer", StrategyType.R);
      paperPlayer = of("paperPlayer", StrategyType.P);
    } catch (NoSuchStrategyError e) {
      throw new RuntimeException(e);
    }
  }

  private static Stream<Arguments> equals() {
    try {
      return Stream.of(
          arguments(of("name", StrategyType.S), null, false),
          arguments(of("name", StrategyType.S), of("diff", StrategyType.S), false),
          arguments(of("name", StrategyType.R), of("name", StrategyType.S), false),
          arguments(of("name", StrategyType.S), of("name", StrategyType.S), true));
    } catch (Exception e) {
      return Stream.empty();
    }
  }

  private static Stream<Arguments> winner() {
    try {
      return Stream.of(
          arguments(asList(rockPlayer, scissorsPlayer), rockPlayer),
          arguments(asList(scissorsPlayer, paperPlayer), scissorsPlayer),
          arguments(asList(paperPlayer, rockPlayer), paperPlayer),
          arguments(asList(paperPlayer, scissorsPlayer), scissorsPlayer),
          arguments(asList(scissorsPlayer, scissorsPlayer), scissorsPlayer));
    } catch (Exception e) {
      return Stream.empty();
    }
  }

  private static Stream<Arguments> wrongNumberOfPlayers() {
    try {
      return Stream.of(
          arguments(Collections.singletonList(of())), arguments(asList(of(), of(), of())));
    } catch (Exception e) {
      return Stream.empty();
    }
  }

  private static Stream<Arguments> tournament() {
    try {
      return Stream.of(
          arguments(asList(rockPlayer, scissorsPlayer), rockPlayer),
          arguments(asList(scissorsPlayer, paperPlayer, paperPlayer), scissorsPlayer),
          arguments(asList(paperPlayer, rockPlayer, rockPlayer, rockPlayer), paperPlayer),
          arguments(
              asList(rockPlayer, scissorsPlayer, paperPlayer, scissorsPlayer, scissorsPlayer),
              rockPlayer),
          arguments(
              asList(
                  scissorsPlayer,
                  paperPlayer,
                  rockPlayer,
                  paperPlayer,
                  paperPlayer,
                  scissorsPlayer),
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
    } catch (Exception e) {
      return Stream.empty();
    }
  }

  private static Stream<Arguments> massive() {
    return Stream.of(
        arguments(10, of(10)),
        arguments(10, of(100)),
        arguments(10, of(1000)),
        arguments(100, of(10000)));
  }
}
