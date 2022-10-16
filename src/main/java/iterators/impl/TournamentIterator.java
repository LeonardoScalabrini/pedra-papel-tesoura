package iterators.impl;

import domains.Player;
import iterators.IterableTournament;
import strategys.MatchStrategy;

import java.util.*;

public class TournamentIterator implements IterableTournament {

  private MatchStrategy matchStrategy;
  private List<Player> players = Collections.emptyList();

  public TournamentIterator(MatchStrategy matchStrategy) {
    Objects.requireNonNull(matchStrategy);
    this.matchStrategy = matchStrategy;
  }

  @Override
  public void createIterator(List<Player> players) {
    Objects.requireNonNull(players);
    this.players = players;
  }

  @Override
  public boolean hasNext() {
    return players.size() > 1;
  }

  @Override
  public void next() {
    List<Player> winnerPlayers = new ArrayList<>();
    List<Player> group = new ArrayList<>();
    players.stream()
        .forEach(
            p -> {
              if (Objects.isNull(p)) return;

              group.add(p);
              Optional<Player> mayWinner = matchStrategy.winner(group);
              mayWinner.ifPresent(
                  (w) -> {
                    winnerPlayers.add(w);
                    group.clear();
                  });
            });
    winnerPlayers.addAll(group);
    players = winnerPlayers;
  }

  @Override
  public Optional<Player> winner() {
    return players.stream().filter(i -> Objects.nonNull(i)).findFirst();
  }
}
