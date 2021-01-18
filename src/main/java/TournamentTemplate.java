package main.java;

import main.java.exceptions.RPSException;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.iterators.impl.TournamentIterator;

import java.util.List;
import static java.util.Optional.ofNullable;

public class RPSTournamentTemplate {

    private final RPSGameTemplate gameTemplate;
    private final TournamentIterator tournamentIterator;

    public RPSTournamentTemplate(RPSGameTemplate gameTemplate, TournamentIterator tournamentIterator) {
        this.gameTemplate = gameTemplate;
        this.tournamentIterator = tournamentIterator;
    }

    public Play tournamentWinner(List<List<List<Play>>> tournament) throws RPSException {
        if (!ofNullable(tournament).isPresent()) {
            throw new WrongNumberOfPlayersError();
        }
        tournamentIterator.createIterator(gameTemplate, tournament);
        while (tournamentIterator.hasNext()) {
            tournamentIterator.next();
        }
        return tournamentIterator.previousPlay();
    }
}
