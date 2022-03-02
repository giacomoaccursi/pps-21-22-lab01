package lab01.tdd.SelectStrategy;

public class EqualsStrategy implements SelectStrategy {
    private final int givenValue;

    public EqualsStrategy(int givenValue) {
        this.givenValue = givenValue;
    }

    @Override
    public boolean apply(int element) {
        return givenValue == element;
    }
}
