package fixtures;

import domains.Player;
import domains.Tournament;
import java.util.List;

public class TournamentFixture {

  private TournamentFixture() {}

  public static Tournament of(List<Player> players) {
    return Tournament.newTournament(players);
  }
}
