package main.java;

import main.java.exceptions.RPSException;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.iterators.impl.TournamentIterator;

import java.util.List;

import static java.util.Optional.ofNullable;

public class Tournament {

    private final Match match;
    private final TournamentIterator tournamentIterator;

    public Tournament(Match match, TournamentIterator tournamentIterator) {
        this.match = match;
        this.tournamentIterator = tournamentIterator;
    }

    public Player tournamentWinner(List<List<List<Player>>> tournament) throws RPSException {
        if (!ofNullable(tournament).isPresent()) {
            throw new WrongNumberOfPlayersError();
        }
        tournamentIterator.createIterator(match, tournament);
        while (tournamentIterator.hasNext()) {
            tournamentIterator.next();
        }
        return tournamentIterator.winner();
    }
}
