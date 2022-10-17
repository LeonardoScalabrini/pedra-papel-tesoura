package fixtures;

import static fixtures.PlayerMethodSource.*;
import static java.util.Arrays.asList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Collections;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class TournamentMethodSource {
  private static Stream<Arguments> winner() {
    return Stream.of(
            arguments(Collections.emptyList(), false, rockPlayer),
        arguments(asList(rockPlayer), true, rockPlayer),
        arguments(asList(rockPlayer, scissorsPlayer), true, rockPlayer),
        arguments(asList(scissorsPlayer, paperPlayer, paperPlayer), true, scissorsPlayer),
        arguments(
            asList(paperPlayer, rockPlayer, scissorsPlayer, paperPlayer),
            true,
            scissorsPlayer),
        arguments(
            asList(paperPlayer, rockPlayer, scissorsPlayer, paperPlayer, rockPlayer),
            true,
            rockPlayer),
        arguments(
            asList(
                paperPlayer, rockPlayer, scissorsPlayer, paperPlayer, rockPlayer, scissorsPlayer),
            true,
            rockPlayer));
  }
}
