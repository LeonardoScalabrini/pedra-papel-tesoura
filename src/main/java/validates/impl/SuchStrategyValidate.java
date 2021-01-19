package main.java.validates.impl;

import main.java.Player;
import main.java.exceptions.NoSuchStrategyError;
import main.java.exceptions.RPSException;
import main.java.validates.BaseValidate;

import java.util.List;

import static java.util.Optional.ofNullable;

public class SuchStrategyValidate extends BaseValidate {
    @Override
    public void valid(List<Player> players) throws RPSException {
        if (!ofNullable(players).isPresent()) {
            throw new NoSuchStrategyError();
        }
        for (Player player : players) {
            if (!ofNullable(player.strategy).isPresent()) {
                throw new NoSuchStrategyError();
            }
        }
        super.valid(players);
    }
}
