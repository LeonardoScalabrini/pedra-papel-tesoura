package strategys.impl;

import domains.StrategyType;
import strategys.BeatsStrategy;

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
