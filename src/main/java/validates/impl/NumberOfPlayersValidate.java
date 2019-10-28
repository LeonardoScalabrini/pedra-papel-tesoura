package main.java.validates.impl;

import main.java.Play;
import main.java.exceptions.RPSException;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.validates.BaseValidate;

import java.util.List;
import java.util.Optional;

public class NumberOfPlayersValidate extends BaseValidate {

    private static final int NUMBER_OF_PLAYER = 2;

    @Override
    public void valid(List<Play> plays) throws RPSException {

        Optional.ofNullable(plays).orElseThrow(WrongNumberOfPlayersError::new);

        if (plays.size() != NUMBER_OF_PLAYER)
            throw new WrongNumberOfPlayersError();

        super.valid(plays);
    }
}
