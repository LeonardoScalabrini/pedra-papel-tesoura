package main.java.iterators;

import main.java.Play;
import main.java.RPSGameTemplate;
import main.java.exceptions.RPSException;

import java.util.List;

public interface IterableTournament {

    void createIterator(RPSGameTemplate gameTemplate, List<List<List<Play>>> tournament);

    boolean hasNext();

    List<Play> next() throws RPSException;

    Play previousPlay();
}