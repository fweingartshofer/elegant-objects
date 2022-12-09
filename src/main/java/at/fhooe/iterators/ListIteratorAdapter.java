package at.fhooe.iterators;

import java.util.ListIterator;

import static java.util.Objects.requireNonNull;

public final class ListIteratorAdapter<T> implements ListIterator<T> {

    private ImmutableListIterator<T> iterator;

    public ListIteratorAdapter(ImmutableListIterator<T> iterator) {
        requireNonNull(iterator);
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public T next() {
        T current = iterator.get();
        iterator = iterator.next();
        return current;
    }

    @Override
    public boolean hasPrevious() {
        return iterator.hasPrevious();
    }

    @Override
    public T previous() {
        T current = iterator.get();
        iterator = iterator.previous();
        return current;
    }

    @Override
    public int nextIndex() {
        return iterator.nextIndex();
    }

    @Override
    public int previousIndex() {
        return iterator.previousIndex();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(T t) {
        throw new UnsupportedOperationException();
    }
}
