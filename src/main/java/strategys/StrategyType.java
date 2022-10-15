package strategys;

import strategys.impl.PaperBeatsStrategy;
import strategys.impl.RockBeatsStrategy;
import strategys.impl.ScissorsBeatsStrategy;

public enum StrategyType {
  R(RockBeatsStrategy.getInstance()),
  P(PaperBeatsStrategy.getInstance()),
  S(ScissorsBeatsStrategy.getInstance());

  private final BeatsStrategy beatsStrategy;

  StrategyType(BeatsStrategy beatsStrategy) {
    this.beatsStrategy = beatsStrategy;
  }

  public boolean beats(StrategyType strategyType) {
    return beatsStrategy.beats(strategyType);
  }
}
