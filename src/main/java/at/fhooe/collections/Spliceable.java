package at.fhooe.collections;

import at.fhooe.ranges.IntegerRange;

public interface Spliceable<T> {
    ImmutableCollection<T> splice(IntegerRange integerRange);
}
