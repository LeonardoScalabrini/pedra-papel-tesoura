package domains;

import static java.util.Objects.requireNonNull;
import static java.util.Objects.hash;

public class Player {

  private final String name;

  public final StrategyType strategy;

  public static Player newPlayer(String name, StrategyType strategy) {
    return new Player(name, strategy);
  }

  private Player(String name, StrategyType strategy) {
    if (requireNonNull(name).isBlank()) throw new IllegalArgumentException();

    this.name = name;
    this.strategy = requireNonNull(strategy);
  }

  @Override
  public int hashCode() {
    return hash(name, strategy);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return name.equals(player.name) && strategy.equals(player.strategy);
  }
}
