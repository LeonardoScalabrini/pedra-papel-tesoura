package iterators.impl;

import domains.Match;
import domains.Player;
import exceptions.WrongNumberOfPlayersError;
import iterators.IterableTournament;
import java.util.*;

public class TournamentIterator implements IterableTournament {

  private static final int GROUP_NUMBER_PLAYERS = 2;
  private int totalIterations = 0;
  private int iterations = 0;
  private List<Player> players = Collections.emptyList();

  @Override
  public void createIterator(List<Player> players) {
    Objects.requireNonNull(players);
    if (players.isEmpty())
      return;

    this.totalIterations = calculeTotalIterations(players);
    this.players = players;
  }

  @Override
  public boolean hasNext() {
    return totalIterations > iterations;
  }

  @Override
  public void next() throws WrongNumberOfPlayersError {
    List<Player> winnerPlays = new ArrayList<>();
    List<Player> group = new ArrayList<>();
    for (Player player : players) {
      group.add(player);
      if (group.size() == GROUP_NUMBER_PLAYERS) {
        winnerPlays.add(Match.winner(group));
        group.clear();
      }
    }
    winnerPlays.addAll(group);
    iterations++;
    players = winnerPlays;
  }

  @Override
  public Optional<Player> winner() {
    return players.stream().findFirst();
  }

  private int calculeTotalIterations(List<Player> players){
    var total = players.size();
    var result = total / GROUP_NUMBER_PLAYERS;
    var remainder = total % GROUP_NUMBER_PLAYERS;

    if (remainder > 0)
      result++;

    return result;
  }
}
