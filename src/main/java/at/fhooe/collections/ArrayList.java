package at.fhooe.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

public class ArrayList<T> implements Collection<T>, ImmutableCollection<T> {
    private final Object[] data;

    public ArrayList() {
        this.data = new Object[0];
    }

    /***
     * No code in constructors
     * @param data array to start with
     */
    public ArrayList(T... data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, data.length);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ImmutableCollection<T> concat(ImmutableCollection<T> other) {
        return null;
    }

    @Override
    public Optional<T> head() {
        if (data.length == 0) {
            return Optional.empty();
        }
        return Optional.ofNullable(elementAt(0));
    }

    @Override
    public ImmutableCollection<T> tail() {
        Object[] other = new Object[data.length - 1];
        System.arraycopy(data, 1, other, 0, data.length - 1);
        return new ArrayList<>((T[])other);
    }

    private T elementAt(int index) {
        return (T) data[index];
    }
}
