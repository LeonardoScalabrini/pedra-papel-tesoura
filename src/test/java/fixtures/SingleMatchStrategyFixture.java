package fixtures;

import strategys.impl.SingleMatchStrategy;

public class SingleMatchStrategyFixture {
    
    private SingleMatchStrategyFixture() {}

    public static SingleMatchStrategy of() {
        return SingleMatchStrategy.getInstance();
    }
}
