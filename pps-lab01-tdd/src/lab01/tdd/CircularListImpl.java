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
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (list.size() == 0) {
            return Optional.empty();
        }
        current = current + 1 > list.size() - 1 ? 0 : current + 1;
        return Optional.of(list.get(current));
    }

    @Override
    public Optional<Integer> previous() {
        return current - 1 > 0  ? Optional.empty() : Optional.of(list.get(++current));
    }

    @Override
    public void reset() {

    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }


}
