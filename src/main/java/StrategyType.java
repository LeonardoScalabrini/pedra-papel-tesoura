package main.java;

import main.java.strategys.BeatsStrategy;
import main.java.strategys.impl.PaperBeatsStrategy;
import main.java.strategys.impl.RockBeatsStrategy;
import main.java.strategys.impl.ScissorsBeatsStrategy;

public enum StrategyType {
    R(new RockBeatsStrategy()), P(new PaperBeatsStrategy()), S(new ScissorsBeatsStrategy());

    private final BeatsStrategy beatsStrategy;

    StrategyType(BeatsStrategy beatsStrategy) {
        this.beatsStrategy = beatsStrategy;
    }

    public boolean beats(StrategyType strategyType) {
        return beatsStrategy.beats(strategyType);
    }
}
