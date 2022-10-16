package domains;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Match {

  private Match() {}

  public static Optional<Player> winner(List<Player> players)  {
    Objects.requireNonNull(players);

    Iterator<Player> iterable = players.stream().iterator();

    if(!iterable.hasNext())
      return Optional.empty();
    
      Player playerOne = iterable.next();

    if(!iterable.hasNext())
      return Optional.empty();
      
    Player playerTwo = iterable.next();

    if (playerTwo.strategy.beats(playerOne.strategy)) return Optional.ofNullable(playerTwo);

    return Optional.ofNullable(playerOne);
  }
}
