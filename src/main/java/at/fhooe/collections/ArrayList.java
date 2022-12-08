package at.fhooe.collections;

import at.fhooe.iterators.ImmutableListIterator;
import at.fhooe.ranges.IntegerRange;

import java.util.*;

public class ArrayList<T> implements ImmutableList<T>, Spliceable {
    private final Object[] data;

    public ArrayList() {
        this.data = new Object[0];
    }

    /***
     * No code in constructors
     * @param data array to start with
     */
    public ArrayList(Object... data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return data.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, data.length);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < data.length) {
            return (T1[]) Arrays.copyOf(data, data.length, a.getClass());
        }
        System.arraycopy(data, 0, a, 0, data.length);
        if (a.length > data.length) {
            a[data.length] = null;
        }
        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object other : c) {
            for (Object item : data) {
                if (!item.equals(other)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public ArrayList<T> concat(T other) {
        Object[] newData = Arrays.copyOf(data, data.length + 1);
        newData[newData.length - 1] = other;
        return new ArrayList<>(newData);
    }

    @Override
    public ArrayList<T> concat(ImmutableCollection<T> others) {
        Object[] newData = Arrays.copyOf(data, data.length + others.size());
        Object[] othersArray = others.toArray();
        for(int i : new IntegerRange(data.length, data.length + others.size())) {
            newData[i] = othersArray[i - data.length];
        }
        return new ArrayList<>(newData);
    }

    @Override
    public Optional<T> head() {
        if (isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(elementAt(0));
    }

    @Override
    public ImmutableCollection<T> tail() {
        if(isEmpty()) {
            return new ArrayList<>();
        }
        Object[] other = new Object[data.length - 1];
        System.arraycopy(data, 1, other, 0, data.length - 1);
        return new ArrayList<>(other);
    }

    @Override
    public T get(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return elementAt(index);
    }

    @Override
    public int indexOf(Object o) {
        for (int i : new IntegerRange(0, size())) {
            if (o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i : new IntegerRange(size() - 1, -1, -1)) {
            if (o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return new ArrayListIterator(index).iterator();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return splice(new IntegerRange(fromIndex, toIndex));
    }

    @Override
    public ArrayList<T> splice(IntegerRange integerRange) {
        ArrayList<T> list = new ArrayList<>();
        for (Integer i : integerRange) {
            list = list.concat(elementAt(i));
        }
        return list;
    }

    private T elementAt(int index) {
        return (T) data[index];
    }

    private final class ArrayListIterator implements ImmutableListIterator<T> {

        private final int index;

        private ArrayListIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return data.length > index;
        }

        @Override
        public ArrayListIterator next() {
            return new ArrayListIterator(index + 1);
        }

        @Override
        public T get() {
            return elementAt(index);
        }

        @Override
        public boolean hasPrevious() {
            return index >= 0;
        }

        @Override
        public ArrayListIterator previous() {
            return new ArrayListIterator(index - 1);
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index == 0 ? -1 : index - 1;
        }
    }
}
