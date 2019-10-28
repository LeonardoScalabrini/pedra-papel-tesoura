package main.java.factorys;

import main.java.validates.BaseValidate;
import main.java.validates.impl.NumberOfPlayersValidate;
import main.java.validates.impl.SuchStrategyValidate;

public class ChainOfValidationFactory {

    public BaseValidate create() {
        NumberOfPlayersValidate numberOfPlayersValidate = new NumberOfPlayersValidate();
        SuchStrategyValidate suchStrategyValidate = new SuchStrategyValidate();

        numberOfPlayersValidate.next(suchStrategyValidate);

        return numberOfPlayersValidate;
    }
}
