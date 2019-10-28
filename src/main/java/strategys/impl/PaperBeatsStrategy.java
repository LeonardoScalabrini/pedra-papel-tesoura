package main.java.strategys.impl;

import main.java.StrategyType;
import main.java.strategys.BeatsStrategy;

public class PaperBeatsStrategy implements BeatsStrategy {
    @Override
    public boolean beats(StrategyType strategyType) {
        return StrategyType.R.equals(strategyType);
    }
}
