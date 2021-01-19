package main.java.iterators;

import main.java.Match;
import main.java.Player;
import main.java.exceptions.RPSException;

import java.util.List;

public interface IterableTournament {

    void createIterator(Match match, List<List<List<Player>>> tournament);

    boolean hasNext();

    void next() throws RPSException;

    Player winner();
}