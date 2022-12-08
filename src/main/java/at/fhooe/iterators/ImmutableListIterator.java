package at.fhooe.iterators;

public interface ImmutableListIterator<T> extends ImmutableIterator<T> {
    @Override
    ImmutableListIterator<T> next();

    boolean hasPrevious();

    ImmutableListIterator<T> previous();

    int nextIndex();

    int previousIndex();

    @Override
    default ListIteratorAdapter<T> iterator() {
        return new ListIteratorAdapter<>(this);
    }
}
