package strategys;

import java.util.List;
import java.util.Optional;

import domains.Player;

public interface MatchStrategy {
    Optional<Player> winner(List<Player> players);
}
