package main.java.validates.impl;

import main.java.Play;
import main.java.exceptions.NoSuchStrategyError;
import main.java.exceptions.RPSException;
import main.java.validates.BaseValidate;

import java.util.List;
import java.util.Optional;

public class SuchStrategyValidate extends BaseValidate {
    @Override
    public void valid(List<Play> plays) throws RPSException {
        Optional.ofNullable(plays).orElseThrow(NoSuchStrategyError::new);
        for (Play play : plays)
            Optional.ofNullable(play.strategy).orElseThrow(NoSuchStrategyError::new);

        super.valid(plays);
    }
}
