package fixtures;

import domains.Player;
import domains.StrategyType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PlayerFixture {

  private PlayerFixture() {}

  public static Player of() {
    return of("name", StrategyType.S);
  }

  public static List<Player> of(int quantity) {
    List<Player> players = new ArrayList<>();
    IntStream.range(1, quantity).forEach((i) -> players.add(of()));
    return players;
  }

  public static Player of(String name, StrategyType strategyType) {
    return Player.newPlayer(name, strategyType);
  }
}
