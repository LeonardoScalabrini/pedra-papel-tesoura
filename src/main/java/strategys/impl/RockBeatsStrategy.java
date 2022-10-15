package strategys.impl;

import strategys.BeatsStrategy;
import strategys.StrategyType;

public class RockBeatsStrategy implements BeatsStrategy {

  private static final RockBeatsStrategy instance = new RockBeatsStrategy();

  private RockBeatsStrategy() {}

  public static RockBeatsStrategy getInstance() {
    return instance;
  }

  @Override
  public boolean beats(StrategyType strategyType) {
    return StrategyType.S.equals(strategyType);
  }
}
