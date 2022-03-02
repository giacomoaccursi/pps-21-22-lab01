package lab01.tdd.SelectStrategy;

public class MulitpleOfStrategy implements SelectStrategy {

    private final int givenValue;
    public MulitpleOfStrategy(int givenValue) {
        this.givenValue = givenValue;
    }

    @Override
    public boolean apply(int element) {
        return element % this.givenValue == 0;
    }
}
