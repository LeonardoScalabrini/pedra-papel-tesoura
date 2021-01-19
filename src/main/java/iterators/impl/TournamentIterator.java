package main.java.iterators.impl;

import main.java.Match;
import main.java.Player;
import main.java.exceptions.RPSException;
import main.java.iterators.IterableTournament;

import java.util.ArrayList;
import java.util.List;

public class TournamentIterator implements IterableTournament {

    private static final int N_PLAYERS = 2;
    private Integer totalIterations = 0;
    private Integer iterations = 0;
    private Player playerWinner;
    private Match match;
    private List<Player> players = new ArrayList<>();

    @Override
    public void createIterator(Match match, List<List<List<Player>>> tournament) {
        this.totalIterations = tournament.size() + 1;
        this.match = match;
        tournament.forEach(lists -> lists.forEach(p -> this.players.addAll(p)));
    }

    @Override
    public boolean hasNext() {
        return totalIterations > iterations;
    }

    @Override
    public void next() throws RPSException {
        List<Player> playsWinner = new ArrayList<>();
        List<Player> group = new ArrayList<>();
        for (Player player : players) {
            group.add(player);
            if (group.size() == N_PLAYERS) {
                playerWinner = match.winner(group);
                playsWinner.add(playerWinner);
                group.clear();
            }
        }
        playsWinner.addAll(group);

        iterations++;
        players = playsWinner;
    }

    @Override
    public Player winner() {
        return playerWinner;
    }
}
