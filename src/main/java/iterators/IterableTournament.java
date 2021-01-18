package main.java.iterators;

import main.java.GameTemplate;
import main.java.Play;
import main.java.exceptions.RPSException;

import java.util.List;

public interface IterableTournament {

    void createIterator(GameTemplate gameTemplate, List<List<List<Play>>> tournament);

    boolean hasNext();

    void next() throws RPSException;

    Play previousPlay();
}