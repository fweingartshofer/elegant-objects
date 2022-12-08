package at.fhooe.ranges;

import at.fhooe.iterators.ImmutableIterator;

import java.util.Iterator;

public class IntegerRange implements Range<Integer> {

    private final int from;
    private final int to;
    private final int step;

    /***
     * Create an integer range, that can be iterated
     * Utilizing an overflow for ranges is illegal and leads to an IllegalArgumentException at construction time, as it would lead to an illegal state of the rage object.
     * @param from start of the range
     * @param to exclusive end
     * @param step step size
     * @throws IllegalArgumentException if <code>from</code> is lower than <code>to</code> and <code>step</code> is a negative number,
     * <code>from</code> is bigger than <code>to</code> and <code>step</code> is a positive number,
     * or <code>step</code> is zero
     */
    public IntegerRange(int from, int to, int step) {
        if (from > to && step > 0 || from < to && step < 0 || step == 0) {
            throw new IllegalArgumentException();
        }
        this.from = from;
        this.to = to;
        this.step = step;
    }

    /***
     * Create an integer range, that can be iterated
     * @param from start of the range
     * @param to exclusive end
     * @throws IllegalArgumentException if <code>from</code> is lower than <code>to</code>
     */
    public IntegerRange(int from, int to) {
        this(from, to, 1);
    }

    /***
     * Create an integer range, that can be iterated
     * @param to exclusive end
     * @throws IllegalArgumentException if <code>to</code> is a negative number
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
            return step > 0
                    ? get() < to
                    : get() > to;
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
