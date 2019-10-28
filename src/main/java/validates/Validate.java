package main.java.validates;

import main.java.Play;
import main.java.exceptions.RPSException;

import java.util.List;

public interface Validate {

    void valid(List<Play> plays) throws RPSException;

    void next(Validate next);
}
