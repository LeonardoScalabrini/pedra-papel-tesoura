package main.java.validates;

import main.java.Player;
import main.java.exceptions.RPSException;

import java.util.List;

public abstract class BaseValidate implements Validate {

    private Validate next;

    @Override
    public void valid(List<Player> players) throws RPSException {
        if (next == null)
            return;

        next.valid(players);
    }

    @Override
    public void next(Validate next) {
        this.next = next;
    }
}
