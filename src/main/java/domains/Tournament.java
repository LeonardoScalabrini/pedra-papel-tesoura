package domains;

import iterators.impl.TournamentIterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Tournament {
  private final TournamentIterator tournamentIterator;

  public Tournament(TournamentIterator tournamentIterator) {
    Objects.requireNonNull(tournamentIterator);
    this.tournamentIterator = tournamentIterator;
  }

  public Optional<Player> tournamentWinner(List<Player> players) {
    Objects.requireNonNull(players);

    tournamentIterator.createIterator(players);
    while (tournamentIterator.hasNext()) {
      tournamentIterator.next();
    }
    
    return tournamentIterator.winner();
  }
}
