package domains;

import static java.util.Objects.requireNonNull;

import java.util.*;

public class Tournament {

  private final List<Player> players;

  public static Tournament newTournament(List<Player> players) {
    return new Tournament(players);
  }

  private Tournament(List<Player> players) {
    this.players = new ArrayList<Player>(requireNonNull(players));
  }

  public Optional<Player> tournamentWinner() {
    int size = players.size();
    int currentIndex = -1;
    while (size > 1) {

      if (currentIndex >= size - 2) {
        currentIndex = -1;
      }

      currentIndex++;
      int firstPlayerIndex = currentIndex;
      Player firstPlayer = requireNonNull(players.get(firstPlayerIndex));

      currentIndex++;
      int secondPlayerIndex = currentIndex;
      Player secondPlayer = requireNonNull(players.get(secondPlayerIndex));

      int defeatedPlayerIndex = firstPlayerIndex;
      if (firstPlayer.strategy.beats(secondPlayer.strategy)) defeatedPlayerIndex = secondPlayerIndex;

      players.remove(defeatedPlayerIndex);
      size--;
      currentIndex--;
    }
    return players.stream().findFirst();
  }
}
