package at.fhooe.collections;

import at.fhooe.ranges.IntegerRange;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayListTest {
    @Test
    void newArrayList_isEmpty() {
        assertThat(new ArrayList<>(), is(empty()));
    }

    @Test
    void newArrayList_hasSizeOfZero() {
        assertThat(new ArrayList<>().size(), equalTo(0));
    }

    @Test
    void newInitializedArrayList_notEmpty() {
        assertThat(new ArrayList<Integer>(1, 2, 3), is(not(empty())));
    }

    @Test
    void newArrayList_hasCorrectSize() {
        assertThat(new ArrayList<>(1, 2, 3), hasSize(3));
    }

    @Test
    void arrayList_containsElement() {
        assertThat(new ArrayList<>(1, 2, 3), hasItem(3));
    }

    @Test
    void arrayList_doesNotContainElement() {
        assertThat(new ArrayList<>(1, 2, 3), not(hasItem(5)));
    }

    @Test
    void arrayListIterator_iteratesCorrectlyForward() {
        assertThat(new ArrayList<>(1, 2, 3), IsIterableContainingInOrder.contains(1, 2, 3));
    }

    @Test
    void arrayListToArray_returnsEmptyArray() {
        assertThat(new ArrayList<>().toArray(), emptyArray());
    }

    @Test
    void notEmptyArrayListToArray_returnsArrayInCorrectOrder() {
        assertThat(new ArrayList<>(1, 2, 3).toArray(), arrayContaining(1, 2, 3));
    }

    @Test
    void arrayList_containsAllElements() {
        assertThat(new ArrayList<>(1, 2, 3), hasItems(1, 2, 3, 3));
    }

    @Test
    void arrayList_doesNotContainAllElements() {
        assertThat(new ArrayList<>(1, 2, 3), not(hasItems(1, 5)));
    }

    @Test
    void arrayListConcat_addsNewElement() {
        assertThat(new ArrayList<>(1, 2, 3).concat(2), contains(1, 2, 3, 2));
    }

    @Test
    void arrayListConcat_newLengthCorrect() {
        assertThat(new ArrayList<>(1, 2, 3).concat(2), hasSize(4));
    }

    @Test
    void arrayListConcat_addsNewElements() {
        assertThat(
                new ArrayList<>(1, 2, 3)
                        .concat(new ArrayList<>(4, 5, 6)),
                contains(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void arrayListConcat_addMultipleElementsNewLengthCorrect() {
        assertThat(
                new ArrayList<>(1, 2, 3)
                        .concat(new ArrayList<>(4, 5, 6)),
                hasSize(6)
        );
    }

    @Test
    void emptyArrayListHead_returnsEmptyOptional() {
        assertTrue(new ArrayList<>().head().isEmpty());
    }

    @Test
    void arrayListHead_returnsFirstElementInList() {
        assertThat(new ArrayList<>(1, 2, 3).head().get(), is(1));
    }

    @Test
    void emptyArrayListTail_returnsEmptyArrayList() {
        assertThat(new ArrayList<>().tail(), empty());
    }

    @Test
    void arrayListTail_returnCorrectArrayList() {
        assertThat(new ArrayList<>(1, 2, 3).tail(), contains(2, 3));
    }

    @Test
    void arrayListGet_throwsOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> new ArrayList<>(1, 2, 3).get(10));
    }

    @Test
    void arrayListGet_returnsCorrectElement() {
        assertThat(new ArrayList<>(1, 2, 3).get(1), is(2));
    }

    @Test
    void arrayListIndexOf_returnsCorrectIndex() {
        assertThat(new ArrayList<>(1, 2, 2, 3).indexOf(2), is(1));
    }

    @Test
    void arrayListIndexOfForMissing_returnsNegativeOne() {
        assertThat(new ArrayList<>(1, 2, 2, 3).indexOf(4), is(-1));
    }

    @Test
    void arrayListLastIndexOf_returnsCorrectIndex() {
        assertThat(new ArrayList<>(1, 2, 2, 3).lastIndexOf(2), is(2));
    }

    @Test
    void arrayListLastIndexOf_returnsNegativeOne() {
        assertThat(new ArrayList<>(1, 2, 2, 3).lastIndexOf(4), is(-1));
    }

    @Test
    void arrayListListIteratorNext_returnsFirstElement() {
        assertThat(new ArrayList<>(1, 2, 3).listIterator().next(), is(1));
    }

    @Test
    void arrayListListIteratorPrevious_returnsFirstElement() {
        assertThat(new ArrayList<>(1, 2, 3).listIterator().previous(), is(1));
    }

    @Test
    void arrayListListIteratorHasNext_returnsTrue() {
        assertTrue(new ArrayList<>(1, 2, 3).listIterator().hasNext());
    }

    @Test
    void arrayListListIteratorHasPrevious_returnsTrue() {
        assertTrue(new ArrayList<>(1, 2, 3).listIterator().hasPrevious());
    }

    @Test
    void arrayListListIterator_throws() {
        assertThrows(IndexOutOfBoundsException.class, () -> new ArrayList<>().listIterator(0));
    }

    @Test
    void arrayListListIteratorAtIndex_returnsCorrectElement() {
        assertThat(new ArrayList<>(1, 2, 3).listIterator(2).next(), is(3));
    }

    @Test
    void arrayListSubList_returnsCorrectPortion() {
        assertThat(new ArrayList<>(1, 2, 3, 4, 5, 6, 7, 8, 9).subList(2, 6), contains(3, 4, 5, 6));
    }

    @Test
    void arrayListSubList_throws() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> new ArrayList<>(1, 2, 3, 4, 5, 6, 7, 8, 9).subList(2, 11));
    }

    @Test
    void arrayListSplice_returnsCorrectPortion() {
        assertThat(
                new ArrayList<>(1, 2, 3, 4, 5, 6, 7, 8, 9)
                        .splice(new IntegerRange(2, 6)),
                contains(3, 4, 5, 6)
        );
    }

    @Test
    void arrayListSplice_throws() {
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> new ArrayList<>(1, 2, 3, 4, 5, 6, 7, 8, 9)
                        .splice(new IntegerRange(2, 11))
        );
    }
}