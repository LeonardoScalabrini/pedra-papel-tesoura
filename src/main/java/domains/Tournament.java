package domains;

import exceptions.WrongNumberOfPlayersError;
import iterators.impl.TournamentIterator;
import java.util.List;
import java.util.Objects;

public class Tournament {
  private final TournamentIterator tournamentIterator;

  public Tournament(TournamentIterator tournamentIterator) {
    this.tournamentIterator = tournamentIterator;
  }

  public Player tournamentWinner(List<Player> players) throws WrongNumberOfPlayersError {
    Objects.requireNonNull(players);

    tournamentIterator.createIterator(players);
    while (tournamentIterator.hasNext()) {
      tournamentIterator.next();
    }
    return tournamentIterator.winner().orElseThrow();
  }
}
