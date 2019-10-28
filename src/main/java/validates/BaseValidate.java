package main.java.validates;

import main.java.Play;
import main.java.exceptions.RPSException;

import java.util.List;

public abstract class BaseValidate implements Validate {

    private Validate next;

    @Override
    public void valid(List<Play> plays) throws RPSException {
        if (next == null)
            return;

        next.valid(plays);
    }

    @Override
    public void next(Validate next) {
        this.next = next;
    }
}
