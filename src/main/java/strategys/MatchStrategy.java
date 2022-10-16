package strategys;

import domains.Player;
import java.util.List;
import java.util.Optional;

public interface MatchStrategy {
  Optional<Player> winner(List<Player> players);
}
