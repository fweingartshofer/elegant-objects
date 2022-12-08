package at.fhooe.collections;

import java.util.*;

public interface ImmutableList<T> extends ImmutableCollection<T>, List<T> {
    @Override
    ImmutableCollection<T> concat(T other);

    @Override
     ImmutableCollection<T> concat(ImmutableCollection<T> others);

    @Override
    Optional<T> head();

    @Override
    ImmutableCollection<T> tail();

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

    @Override
    int indexOf(Object o);

    @Override
    int lastIndexOf(Object o);

    @Override
    ListIterator<T> listIterator();

    @Override
    ListIterator<T> listIterator(int index);

    @Override
    List<T> subList(int fromIndex, int toIndex);

    @Override
    int size();

    @Override
    boolean isEmpty();

    @Override
    boolean contains(Object o);

    @Override
    Iterator<T> iterator();

    @Override
    Object[] toArray();

    @Override
    <T1> T1[] toArray(T1[] a);

    @Override
    boolean containsAll(Collection<?> c);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
}
