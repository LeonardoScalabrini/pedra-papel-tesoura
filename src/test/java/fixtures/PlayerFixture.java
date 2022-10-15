package fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import domains.Player;
import exceptions.NoSuchStrategyError;
import java.util.ArrayList;
import java.util.List;
import strategys.StrategyType;

public class PlayerFixture {

  static {
    Fixture.of(Player.class)
        .addTemplate(
            "random",
            new Rule() {
              {
                add("name", random("One", "Two", "Three"));
                add("strategy", random(StrategyType.P, StrategyType.R, StrategyType.S));
              }
            });
  }

  private PlayerFixture() {}

  public static Player of() {
    return Fixture.from(Player.class).gimme("random");
  }

  public static List<Player> of(int quantity) {
    List<Player> players = new ArrayList<>();
    for (int i = 0; i < quantity; i++) {
      players.add(of());
    }
    return players;
  }

  public static Player of(String name, StrategyType strategyType) throws NoSuchStrategyError {
    return new Player(name, strategyType);
  }
}
