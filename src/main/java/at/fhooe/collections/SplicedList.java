package at.fhooe.collections;

import at.fhooe.ranges.IntegerRange;

import static java.util.Objects.requireNonNull;

public class SplicedList<T> implements Spliceable<T>{
    private final ImmutableList<T> immutableList;

    public SplicedList(ImmutableList<T> immutableList) {
        this.immutableList = immutableList;
    }

    @Override
    public ImmutableList<T> splice(IntegerRange integerRange) {
        ArrayList<T> list = new ArrayList<>();
        for (Integer i : integerRange) {
            list = list.concat(immutableList.get(i));
        }
        return list;
    }
}
