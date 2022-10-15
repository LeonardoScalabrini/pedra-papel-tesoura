package domains;

import exceptions.NoSuchStrategyError;
import strategys.StrategyType;

import java.util.Objects;

public class Player {

  public final String name;

  public final StrategyType strategy;

  public Player(String name, StrategyType strategy) throws NoSuchStrategyError {
    Objects.requireNonNull(name);

    if (name.isBlank()) throw new NullPointerException();

    if (Objects.isNull(strategy)) {
      throw new NoSuchStrategyError();
    }
    this.name = name;
    this.strategy = strategy;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, strategy);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return name.equals(player.name) && strategy.equals(player.strategy);
  }
}