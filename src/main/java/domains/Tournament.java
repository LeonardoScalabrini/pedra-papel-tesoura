package domains;

import iterators.impl.TournamentIterator;
import java.util.Objects;
import java.util.Optional;

public class Tournament {
  private final TournamentIterator tournamentIterator;

  public static Tournament newTournament(TournamentIterator iterator) {
    return new Tournament(iterator);
  }

  private Tournament(TournamentIterator tournamentIterator) {
    Objects.requireNonNull(tournamentIterator);
    this.tournamentIterator = tournamentIterator;
  }

  public Optional<Player> tournamentWinner() {
    while (tournamentIterator.hasNext()) {
      tournamentIterator.next();
    }

    return tournamentIterator.winner();
  }
}
