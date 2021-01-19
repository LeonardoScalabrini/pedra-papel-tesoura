package main.java.strategys.impl;

import main.java.strategys.BeatsStrategy;
import main.java.strategys.StrategyType;

public class RockBeatsStrategy implements BeatsStrategy {
    @Override
    public boolean beats(StrategyType strategyType) {
        return StrategyType.S.equals(strategyType);
    }
}
