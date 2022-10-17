package strategys.impl;

import domains.StrategyType;
import strategys.BeatsStrategy;

public class ScissorsBeatsStrategy implements BeatsStrategy {

  private static final ScissorsBeatsStrategy instance = new ScissorsBeatsStrategy();

  private ScissorsBeatsStrategy() {}

  public static ScissorsBeatsStrategy getInstance() {
    return instance;
  }

  @Override
  public boolean beats(StrategyType strategyType) {
    return StrategyType.P.equals(strategyType);
  }
}
