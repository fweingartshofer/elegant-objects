package at.fhooe.iterators;

import java.util.Iterator;

public interface ImmutableIterator<T> extends Iterable<T> {
    boolean hasNext();

    ImmutableIterator<T> next();

    T get();

    default Iterator<T> iterator() {
        return new IteratorAdapter<>(this);
    }
}
