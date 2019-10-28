package main.java;

import main.java.exceptions.RPSException;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.iterators.impl.TournamentIterator;

import java.util.List;
import java.util.Optional;

public class RPSTournamentTemplate {

    private final RPSGameTemplate gameTemplate;
    private final TournamentIterator tournamentIterator;

    public RPSTournamentTemplate(RPSGameTemplate gameTemplate, TournamentIterator tournamentIterator) {
        this.gameTemplate = gameTemplate;
        this.tournamentIterator = tournamentIterator;
    }

    public Play rps_tournament_winner(List<List<List<Play>>> tournament) throws RPSException {
        Optional.ofNullable(tournament).orElseThrow(WrongNumberOfPlayersError::new);
        tournamentIterator.createIterator(gameTemplate, tournament);
        while (tournamentIterator.hasNext()) {
            tournamentIterator.next();
        }
        return tournamentIterator.previousPlay();
    }
}
