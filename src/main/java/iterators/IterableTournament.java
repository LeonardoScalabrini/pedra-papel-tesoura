package iterators;

import domains.Player;
import java.util.Optional;

public interface IterableTournament {

  boolean hasNext();

  void next();

  Optional<Player> winner();
}
