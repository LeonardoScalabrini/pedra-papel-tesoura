package main.java.validates;

import main.java.Player;
import main.java.exceptions.RPSException;

import java.util.List;

public interface Validate {

    void valid(List<Player> players) throws RPSException;

    void next(Validate next);
}
