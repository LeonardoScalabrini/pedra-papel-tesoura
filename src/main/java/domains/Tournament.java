package domains;

import static java.util.Objects.requireNonNull;

import io.reactivex.Observable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Tournament {

  private final List<Player> players;

  public static Tournament newTournament(List<Player> players) {
    return new Tournament(players);
  }

  private Tournament(List<Player> players) {
    this.players = new ArrayList<>(requireNonNull(players));
  }

  public Optional<Player> tournamentWinner() {
    final AtomicInteger size = new AtomicInteger(players.size());
    final AtomicInteger currentIndex = new AtomicInteger(-1);
    Observable<int[]> stream =
        Observable.create(
            emitter -> {
              while (size.get() > 1) {
                if (currentIndex.get() >= size.get() - 2) {
                  currentIndex.set(-1);
                }
                emitter.onNext(
                    new int[] {currentIndex.incrementAndGet(), currentIndex.incrementAndGet()});
              }
              emitter.onComplete();
        });
        stream
        .subscribe(
            indexList -> {
              int indexOne = indexList[0];
              int indexTwo = indexList[1];
              Player playerOne = requireNonNull(players.get(indexOne));
              Player playerTwo = requireNonNull(players.get(indexTwo));
              int indexToRemove = indexOne;
              if (playerOne.strategy.beats(playerTwo.strategy)) {
                indexToRemove = indexTwo;
              }
              players.remove(indexToRemove);
              size.decrementAndGet();
              currentIndex.decrementAndGet();
            });

    return players.stream().findAny();
  }
}
