package main.java.iterators.impl;

import java.util.*;
import main.java.Match;
import main.java.Player;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.iterators.IterableTournament;

public class TournamentIterator implements IterableTournament {

  private static final int GROUP_NUMBER_PLAYERS = 2;
  private int totalIterations = 0;
  private int iterations = 0;
  private Player winnerPlayer;
  private List<Player> players = Collections.emptyList();

  @Override
  public void createIterator(List<Player> players) {
    Objects.requireNonNull(players);
    this.totalIterations = players.size() / GROUP_NUMBER_PLAYERS;
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
        winnerPlayer = Match.winner(group);
        winnerPlays.add(winnerPlayer);
        group.clear();
      }
    }
    winnerPlays.addAll(group);
    iterations++;
    players = winnerPlays;
  }

  @Override
  public Optional<Player> winner() {
    return Optional.ofNullable(winnerPlayer);
  }
}
