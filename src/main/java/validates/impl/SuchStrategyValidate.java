package main.java.validates.impl;

import main.java.Play;
import main.java.exceptions.NoSuchStrategyError;
import main.java.exceptions.RPSException;
import main.java.validates.BaseValidate;

import java.util.List;

import static java.util.Optional.ofNullable;

public class SuchStrategyValidate extends BaseValidate {
    @Override
    public void valid(List<Play> plays) throws RPSException {
        if (!ofNullable(plays).isPresent()) {
            throw new NoSuchStrategyError();
        }
        for (Play play : plays) {
            if (!ofNullable(play.strategy).isPresent()) {
                throw new NoSuchStrategyError();
            }
        }
        super.valid(plays);
    }
}
