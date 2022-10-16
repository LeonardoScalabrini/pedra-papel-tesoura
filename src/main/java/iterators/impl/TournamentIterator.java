package iterators.impl;

import domains.Player;
import iterators.IterableTournament;
import java.util.*;
import strategys.MatchStrategy;

public class TournamentIterator implements IterableTournament {

  private final MatchStrategy matchStrategy;
  private List<Player> players;

  public static TournamentIterator newIterator(List<Player> players, MatchStrategy matchStrategy){
    return new TournamentIterator(players, matchStrategy);
  }

  private TournamentIterator(List<Player> players, MatchStrategy matchStrategy) {
    Objects.requireNonNull(players);
    Objects.requireNonNull(matchStrategy);
    this.players = players;
    this.matchStrategy = matchStrategy;
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
