package fixtures;

import static fixtures.PlayerMethodSource.*;
import static java.util.Arrays.asList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Collections;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class TournamentIteratorMethodSource {
  private static Stream<Arguments> next() {
    return Stream.of(
        arguments(Collections.emptyList(), 0, false, false, rockPlayer),
        arguments(Collections.singletonList(null), 1, false, false, rockPlayer),
        arguments(asList(rockPlayer), 1, false, true, rockPlayer),
        arguments(asList(rockPlayer), 0, false, true, rockPlayer),
        arguments(asList(rockPlayer, scissorsPlayer), 1, false, true, rockPlayer),
        arguments(asList(rockPlayer, scissorsPlayer), 0, true, true, rockPlayer),
        arguments(asList(scissorsPlayer, paperPlayer, paperPlayer), 2, false, true, scissorsPlayer),
        arguments(asList(scissorsPlayer, paperPlayer, paperPlayer), 1, true, true, scissorsPlayer),
        arguments(
            asList(paperPlayer, rockPlayer, scissorsPlayer, paperPlayer),
            2,
            false,
            true,
            scissorsPlayer),
        arguments(
            asList(paperPlayer, rockPlayer, scissorsPlayer, paperPlayer),
            1,
            true,
            true,
            paperPlayer),
        arguments(
            asList(paperPlayer, rockPlayer, scissorsPlayer, paperPlayer, rockPlayer),
            3,
            false,
            true,
            rockPlayer),
        arguments(
            asList(paperPlayer, rockPlayer, scissorsPlayer, paperPlayer, rockPlayer),
            2,
            true,
            true,
            scissorsPlayer),
        arguments(
            asList(
                paperPlayer, rockPlayer, scissorsPlayer, paperPlayer, rockPlayer, scissorsPlayer),
            3,
            false,
            true,
            rockPlayer),
        arguments(
            asList(
                paperPlayer, rockPlayer, scissorsPlayer, paperPlayer, rockPlayer, scissorsPlayer),
            2,
            true,
            true,
            scissorsPlayer));
  }
}
