package strategys.impl;

import strategys.BeatsStrategy;
import strategys.StrategyType;

public class PaperBeatsStrategy implements BeatsStrategy {

  private static final PaperBeatsStrategy instance = new PaperBeatsStrategy();

  private PaperBeatsStrategy() {}

  public static PaperBeatsStrategy getInstance() {
    return instance;
  }

  @Override
  public boolean beats(StrategyType strategyType) {
    return StrategyType.R.equals(strategyType);
  }
}
