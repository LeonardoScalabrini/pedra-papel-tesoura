package main.java.validates.impl;

import main.java.Player;
import main.java.exceptions.RPSException;
import main.java.exceptions.WrongNumberOfPlayersError;
import main.java.validates.BaseValidate;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

public class NumberOfPlayersValidate extends BaseValidate {

    private static final int NUMBER_OF_PLAYER = 2;

    @Override
    public void valid(List<Player> players) throws RPSException {
        if (ofNullable(players).orElse(emptyList()).size() != NUMBER_OF_PLAYER)
            throw new WrongNumberOfPlayersError();

        super.valid(players);
    }
}
