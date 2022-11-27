package at.fhooe.collections;

import java.util.Optional;

public interface ImmutableCollection<T> {
    ImmutableCollection<T> concat(ImmutableCollection<T> other);

    Optional<T> head();

    ImmutableCollection<T> tail();
}
