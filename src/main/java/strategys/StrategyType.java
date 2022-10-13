package main.java.strategys;

import main.java.strategys.impl.PaperBeatsStrategy;
import main.java.strategys.impl.RockBeatsStrategy;
import main.java.strategys.impl.ScissorsBeatsStrategy;

public enum StrategyType {
    R(RockBeatsStrategy.getInstance()), P(PaperBeatsStrategy.getInstance()), S(ScissorsBeatsStrategy.getInstance());

    private final BeatsStrategy beatsStrategy;

    StrategyType(BeatsStrategy beatsStrategy) {
        this.beatsStrategy = beatsStrategy;
    }

    public boolean beats(StrategyType strategyType) {
        return beatsStrategy.beats(strategyType);
    }
}
