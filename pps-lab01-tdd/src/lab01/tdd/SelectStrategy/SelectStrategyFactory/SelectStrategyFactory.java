package lab01.tdd.SelectStrategy.SelectStrategyFactory;

import lab01.tdd.SelectStrategy.SelectStrategy;

public interface SelectStrategyFactory {
    SelectStrategy createEvenStrategy();

    SelectStrategy createMultipleOfStrategy(int given);

    SelectStrategy createEqualsStrategy(int given);
}
