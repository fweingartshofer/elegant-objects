package at.fhooe.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/***
 * It is not possible to stay true to eop, since an iterator has to be mutable.
 * If the iterator was immutable, it would be not possible to update the current value.
 * Therefore, this adapter can be used, so the <code>ImmutableIterator</code> can be used.
 */
final class IteratorAdapter<T> implements Iterator<T> {
    private ImmutableIterator<T> immutableIterator;

    public IteratorAdapter(ImmutableIterator<T> immutableIterator) {
        this.immutableIterator = immutableIterator;
    }

    @Override
    public boolean hasNext() {
        return immutableIterator.hasNext();
    }

    @Override
    public T next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        T current = immutableIterator.get();
        immutableIterator = immutableIterator.next();
        return current;
    }
}
