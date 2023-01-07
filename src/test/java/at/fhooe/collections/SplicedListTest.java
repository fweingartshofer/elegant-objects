package at.fhooe.collections;

import at.fhooe.ranges.IntegerRange;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SplicedListTest {
    @Test
    void arrayListSplice_returnsCorrectPortion() {
        assertThat(
                new SplicedList<>(
                        new ArrayList<>(1, 2, 3, 4, 5, 6, 7, 8, 9))
                        .splice(new IntegerRange(2, 6)),
                contains(3, 4, 5, 6)
        );
    }

    @Test
    void arrayListSplice_throwsIndexOutBoundsException() {
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> new SplicedList<>(
                        new ArrayList<>(1, 2, 3, 4, 5, 6, 7, 8, 9))
                        .splice(new IntegerRange(2, 11))
        );
    }

    @Test
    void arrayListSplice_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                new SplicedList<>(
                        new ArrayList<>(1, 2, 3, 4, 5, 6, 7, 8, 9))
                        .splice(null)
        );
    }
}