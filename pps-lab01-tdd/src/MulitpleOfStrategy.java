import lab01.tdd.SelectStrategy;

public class MulitpleOfStrategy implements SelectStrategy {

    private final int toCompare;
    public MulitpleOfStrategy(int toCompare) {
        this.toCompare = toCompare;
    }

    @Override
    public boolean apply(int element) {
        return element % this.toCompare == 0;
    }
}
