package main.java.iterators.impl;

import main.java.GameTemplate;
import main.java.Play;
import main.java.exceptions.RPSException;
import main.java.iterators.IterableTournament;

import java.util.ArrayList;
import java.util.List;

public class TournamentIterator implements IterableTournament {

    private static final int N_PLAYERS = 2;
    private Integer totalIterations = 0;
    private Integer iterations = 0;
    private Play previousPlay;
    private GameTemplate gameTemplate;
    private List<Play> plays = new ArrayList<>();

    @Override
    public void createIterator(GameTemplate gameTemplate, List<List<List<Play>>> tournament) {
        this.totalIterations = tournament.size() + 1;
        this.gameTemplate = gameTemplate;
        tournament.forEach(lists -> lists.forEach(p -> this.plays.addAll(p)));
    }

    @Override
    public boolean hasNext() {
        return totalIterations > iterations;
    }

    @Override
    public void next() throws RPSException {
        List<Play> playsWinner = new ArrayList<>();
        List<Play> group = new ArrayList<>();
        for (Play play : plays) {
            group.add(play);
            if (group.size() == N_PLAYERS) {
                previousPlay = gameTemplate.gameWinner(group);
                playsWinner.add(previousPlay);
                group.clear();
            }
        }
        playsWinner.addAll(group);

        iterations++;
        plays = playsWinner;
    }

    @Override
    public Play previousPlay() {
        return previousPlay;
    }
}
