package main.java;

import main.java.strategys.StrategyType;

import java.util.Objects;

public class Player {

    public final String name;

    public final StrategyType strategy;

    public Player(String name, StrategyType strategy) {
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
        return Objects.equals(name, player.name) &&
                Objects.equals(strategy, player.strategy);
    }
}
