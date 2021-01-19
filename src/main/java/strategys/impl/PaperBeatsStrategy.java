package main.java.strategys.impl;

import main.java.strategys.BeatsStrategy;
import main.java.strategys.StrategyType;

public class PaperBeatsStrategy implements BeatsStrategy {
    @Override
    public boolean beats(StrategyType strategyType) {
        return StrategyType.R.equals(strategyType);
    }
}
