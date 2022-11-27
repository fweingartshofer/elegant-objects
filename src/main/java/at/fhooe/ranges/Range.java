package at.fhooe.ranges;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface Range<T> extends Iterable<T> {
    default Collection<T> collect() {
        return StreamSupport
                .stream(this.spliterator(), false)
                .collect(Collectors.toList());
    }
}
