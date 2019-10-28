package main.java.strategys.impl;

import main.java.StrategyType;
import main.java.strategys.BeatsStrategy;

public class RockBeatsStrategy implements BeatsStrategy {
    @Override
    public boolean beats(StrategyType strategyType) {
        return StrategyType.S.equals(strategyType);
    }
}
