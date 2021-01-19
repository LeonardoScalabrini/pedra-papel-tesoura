package main.java;

import main.java.exceptions.RPSException;
import main.java.factorys.ChainOfValidationFactory;
import main.java.validates.BaseValidate;

import java.util.List;

public class Match {

    private static final int PLAYER_ONE = 0;
    private static final int PLAYER_TWO = 1;
    private final ChainOfValidationFactory chainOfValidationFactory;

    public Match(ChainOfValidationFactory chainOfValidationFactory) {
        this.chainOfValidationFactory = chainOfValidationFactory;
    }

    public Player winner(List<Player> players) throws RPSException {

        BaseValidate baseValidate = chainOfValidationFactory.create();

        baseValidate.valid(players);

        Player playerOne = players.get(PLAYER_ONE);
        Player playerTwo = players.get(PLAYER_TWO);

        if (playerOne.strategy.equals(playerTwo.strategy))
            return playerOne;

        if (playerOne.strategy.beats(playerTwo.strategy))
            return playerOne;

        return playerTwo;
    }
}
