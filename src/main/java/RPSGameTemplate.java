package main.java;

import main.java.exceptions.RPSException;
import main.java.factorys.ChainOfValidationFactory;
import main.java.validates.BaseValidate;

import java.util.List;

public class RPSGameTemplate {

    private static final int PLAYER_ONE = 0;
    private static final int PLAYER_TWO = 1;
    private final ChainOfValidationFactory chainOfValidationFactory;

    public RPSGameTemplate(ChainOfValidationFactory chainOfValidationFactory) {
        this.chainOfValidationFactory = chainOfValidationFactory;
    }

    public Play rps_game_winner(List<Play> plays) throws RPSException {

        BaseValidate baseValidate = chainOfValidationFactory.create();

        baseValidate.valid(plays);

        Play playerOne = plays.get(PLAYER_ONE);
        Play playerTwo = plays.get(PLAYER_TWO);

        if (playerOne.strategy.equals(playerTwo.strategy))
            return playerOne;

        if (playerOne.strategy.beats(playerTwo.strategy))
            return playerOne;

        return playerTwo;
    }
}
