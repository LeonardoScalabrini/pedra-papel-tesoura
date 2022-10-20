package domains;

import static java.util.Objects.requireNonNull;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
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

  public Observable<Optional<Player>> tournamentWinner() {
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

    Consumer<int[]> consumer =
        intList -> {
          int indexOne = intList[0];
          int indexTwo = intList[1];
          Player playerOne = requireNonNull(players.get(indexOne));
          Player playerTwo = requireNonNull(players.get(indexTwo));
          int indexToRemove = indexOne;
          if (playerOne.strategy.beats(playerTwo.strategy)) {
            indexToRemove = indexTwo;
          }
          players.remove(indexToRemove);
          size.decrementAndGet();
          currentIndex.decrementAndGet();
        };

    return Observable.defer(
        () ->
            stream
                .subscribeOn(Schedulers.computation())
                .doOnNext(consumer)
                .last(new int[] {})
                .flatMapObservable(t -> Observable.just(players.stream().findAny()))
                .onErrorReturn(e -> Optional.empty()));
  }
}
