package main.java;

import java.util.Objects;

public class Play {

    public final String name;

    public final StrategyType strategy;

    public Play(String name, StrategyType strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Play play = (Play) o;
        return Objects.equals(name, play.name) &&
                Objects.equals(strategy, play.strategy);
    }
}
