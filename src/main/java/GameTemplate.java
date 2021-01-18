package main.java;

import main.java.exceptions.RPSException;
import main.java.factorys.ChainOfValidationFactory;
import main.java.validates.BaseValidate;

import java.util.List;

public class GameTemplate {

    private static final int PLAYER_ONE = 0;
    private static final int PLAYER_TWO = 1;
    private final ChainOfValidationFactory chainOfValidationFactory;

    public GameTemplate(ChainOfValidationFactory chainOfValidationFactory) {
        this.chainOfValidationFactory = chainOfValidationFactory;
    }

    public Play gameWinner(List<Play> plays) throws RPSException {

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
