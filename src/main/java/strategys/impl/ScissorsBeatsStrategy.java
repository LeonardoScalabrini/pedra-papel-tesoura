package main.java.strategys.impl;

import main.java.strategys.BeatsStrategy;
import main.java.strategys.StrategyType;

public class ScissorsBeatsStrategy implements BeatsStrategy {
    @Override
    public boolean beats(StrategyType strategyType) {
        return StrategyType.P.equals(strategyType);
    }
}
