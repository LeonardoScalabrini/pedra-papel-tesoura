package main.java;

import java.util.Objects;
import main.java.exceptions.NoSuchStrategyError;
import main.java.strategys.StrategyType;

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
