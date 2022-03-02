package lab01.tdd;

import lab01.tdd.CircularList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class CircularListImpl implements CircularList {

    List<Integer> list = new ArrayList<>();
    int current;

    public CircularListImpl() {
        this.current = -1;
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
        if (this.list.size() == 0) {
            return Optional.empty();
        }
        this.current = this.current + 1 > this.list.size() - 1 ? 0 : this.current + 1;
        return Optional.of(this.list.get(this.current));
    }

    @Override
    public Optional<Integer> previous() {
        if (this.list.size() == 0) {
            return Optional.empty();
        }
        this.current = this.current - 1 < 0 ? this.list.size() - 1 : this.current - 1;
        return Optional.of(this.list.get(this.current));
    }

    @Override
    public void reset() {
        this.current = -1;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }


}
