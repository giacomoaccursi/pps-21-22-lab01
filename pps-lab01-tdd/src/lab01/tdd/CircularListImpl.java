package lab01.tdd;

import lab01.tdd.SelectStrategy.SelectStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private static final int CURRENT_START = -1;

    List<Integer> list = new ArrayList<>();
    int current;

    public CircularListImpl() {
        this.current = CURRENT_START;
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return this.isEmpty() ? Optional.empty() : Optional.of(this.list.get(calculateNext()));
    }

    @Override
    public Optional<Integer> previous() {
        return this.isEmpty() ? Optional.empty()  : Optional.of(this.list.get(calculatePrevious()));
    }

    @Override
    public void reset() {
        this.current = CURRENT_START;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        Optional<Integer> element;
        do {
            element = this.next();
            if(strategy.apply(element.orElseThrow())){
                return element;
            }
        }
        while (!isCurrentAtTheEndOfList());
        return Optional.empty();
    }

    private boolean isCurrentAtTheEndOfList(){
        return this.current == this.size() - 1;
    }

    private int calculatePrevious(){
        this.current = this.current - 1 <  0 ? this.list.size() - 1 : this.current - 1;
        return this.current;
    }

    private int calculateNext(){
        this.current = (this.current + 1) % this.size() ;
        return this.current;
    }


}
