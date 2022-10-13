package main.java;

import java.util.List;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.iterators.impl.TournamentIterator;

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
