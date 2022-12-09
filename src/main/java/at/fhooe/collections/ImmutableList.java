package at.fhooe.collections;

import java.util.Collection;
import java.util.List;

public interface ImmutableList<T> extends ImmutableCollection<T>, List<T> {
    @Override
    default boolean addAll(Collection<? extends T> c) {
        return ImmutableCollection.super.addAll(c);
    }

    @Override
    default boolean removeAll(Collection<?> c) {
        return ImmutableCollection.super.removeAll(c);
    }

    @Override
    default void clear() {
        ImmutableCollection.super.clear();
    }

    @Override
    default boolean addAll(int index, Collection<? extends T> c) {
        return ImmutableCollection.super.addAll(index, c);
    }

    @Override
    default boolean retainAll(Collection<?> c) {
        return ImmutableCollection.super.retainAll(c);
    }

    @Override
    default boolean add(T t) {
        return ImmutableCollection.super.add(t);
    }

    @Override
    default boolean remove(Object o) {
        return ImmutableCollection.super.remove(o);
    }

    @Override
    T get(int index);

    @Override
    default T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    default void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    default T remove(int index) {
        throw new UnsupportedOperationException();
    }
}
