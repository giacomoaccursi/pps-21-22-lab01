package lab01.tdd.SelectStrategy.SelectStrategyFactory;

import lab01.tdd.SelectStrategy.EqualsStrategy;
import lab01.tdd.SelectStrategy.EvenStrategy;
import lab01.tdd.SelectStrategy.MulitpleOfStrategy;
import lab01.tdd.SelectStrategy.SelectStrategy;

public class SelectStrategyFactoryImpl implements SelectStrategyFactory {

    @Override
    public SelectStrategy createEvenStrategy() {
        return new EvenStrategy();
    }

    @Override
    public SelectStrategy createMultipleOfStrategy(int givenValue) {
        return new MulitpleOfStrategy(givenValue);
    }

    @Override
    public SelectStrategy createEqualsStrategy(int givenValue) {
        return new EqualsStrategy(givenValue);
    }
}