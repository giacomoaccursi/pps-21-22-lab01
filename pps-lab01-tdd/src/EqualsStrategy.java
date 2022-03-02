import lab01.tdd.SelectStrategy;

public class EqualsStrategy implements SelectStrategy {
    private final int given;

    public EqualsStrategy(int given) {
        this.given = given;
    }

    @Override
    public boolean apply(int element) {
        return given == element;
    }
}
