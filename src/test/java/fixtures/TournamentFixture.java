package fixtures;

import main.java.Tournament;
import main.java.iterators.impl.TournamentIterator;

public class TournamentFixture {

    private TournamentFixture() {
    }

    public static Tournament of() {
        return new Tournament(new TournamentIterator());
    }
}
