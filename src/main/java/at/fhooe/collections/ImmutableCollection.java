package at.fhooe.collections;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface ImmutableCollection<T> extends Collection<T> {

    ImmutableCollection<T> concat(T other);

    ImmutableCollection<T> concat(ImmutableCollection<T> others);

    Optional<T> head();

    ImmutableCollection<T> tail();

    ImmutableCollection<T> filter(Predicate<T> predicate);

    default boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    default boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    default void clear() {
        throw new UnsupportedOperationException();
    }

    default boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    default boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    default boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    default boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

}
