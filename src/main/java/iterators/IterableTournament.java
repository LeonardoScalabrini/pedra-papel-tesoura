package main.java.iterators;

import main.java.Player;
import main.java.exceptions.WrongNumberOfPlayersError;

import java.util.List;
import java.util.Optional;

public interface IterableTournament {

    void createIterator(List<Player> players);

    boolean hasNext();

    void next() throws WrongNumberOfPlayersError;

    Optional<Player> winner();
}