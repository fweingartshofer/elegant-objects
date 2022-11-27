package at.fhooe.ranges;

import at.fhooe.iterators.ImmutableIterator;

import java.util.Iterator;

public class IntegerRange implements Range<Integer> {

    private final int from;
    private final int to;
    private final int step;

    /***
     * Create an integer range, that can be iterated
     * @param from start of the range
     * @param to exclusive end
     * @param step step size
     */
    public IntegerRange(int from, int to, int step) {
        this.from = from;
        this.to = to;
        this.step = step;
    }

    /***
     * Create an integer range, that can be iterated
     * @param from start of the range
     * @param to exclusive end
     */
    public IntegerRange(int from, int to) {
        this(from, to, 1);
    }

    /***
     * Create an integer range, that can be iterated
     * @param to exclusive end
     */
    public IntegerRange(int to) {
        this(0, to, 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntegerRangeIterator(from).iterator();
    }

    private class IntegerRangeIterator implements ImmutableIterator<Integer> {
        private final int current;
        private IntegerRangeIterator(int current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return get() < to;
        }

        @Override
        public IntegerRangeIterator next() {
            return new IntegerRangeIterator(get() + step);
        }

        @Override
        public Integer get() {
            return current;
        }
    }
}
