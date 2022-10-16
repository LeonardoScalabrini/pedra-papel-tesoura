package strategys.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import domains.Player;
import strategys.MatchStrategy;

public class SingleMatchStrategy implements MatchStrategy {

  private static final SingleMatchStrategy instance = new SingleMatchStrategy();

  private SingleMatchStrategy() {}

  public static SingleMatchStrategy getInstance() {
    return instance;
  }

  public Optional<Player> winner(List<Player> players) {
    Objects.requireNonNull(players);

    Iterator<Player> iterable = players.stream().iterator();

    if (!iterable.hasNext()) return Optional.empty();

    Player playerOne = iterable.next();

    if (!iterable.hasNext()) return Optional.empty();

    Player playerTwo = iterable.next();

    if (playerTwo.strategy.beats(playerOne.strategy)) return Optional.ofNullable(playerTwo);

    return Optional.ofNullable(playerOne);
  }
}
