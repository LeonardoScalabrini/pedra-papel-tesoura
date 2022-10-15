import exceptions.WrongNumberOfPlayersError;
import iterators.impl.TournamentIterator;
import java.util.List;

public class Tournament {
  private final TournamentIterator tournamentIterator;

  public Tournament(TournamentIterator tournamentIterator) {
    this.tournamentIterator = tournamentIterator;
  }

  public Player tournamentWinner(List<Player> players) throws WrongNumberOfPlayersError {
    if (players == null || players.isEmpty()) {
      throw new WrongNumberOfPlayersError();
    }
    tournamentIterator.createIterator(players);
    while (tournamentIterator.hasNext()) {
      tournamentIterator.next();
    }
    return tournamentIterator.winner().orElseThrow();
  }
}
