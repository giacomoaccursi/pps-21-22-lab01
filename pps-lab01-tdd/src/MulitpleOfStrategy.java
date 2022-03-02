import lab01.tdd.SelectStrategy;

public class MulitpleOfStrategy implements SelectStrategy {

    private final int given;
    public MulitpleOfStrategy(int given) {
        this.given = given;
    }

    @Override
    public boolean apply(int element) {
        return element % this.given == 0;
    }
}
