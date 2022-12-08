package at.fhooe.ranges;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerRangeTest {

    @Test
    void testIteratingWithoutStepSize() {
        // given
        var it = new IntegerRange(5);
        // when
        var res = it.collect();

        // then
        var expected = List.of(0, 1, 2, 3, 4);
        assertEquals(expected, res);
    }

    @Test
    void testIteratingWithStepSize() {
        // given
        var it = new IntegerRange(0, 5, 2);
        // when
        var res = it.collect();

        // then
        var expected = List.of(0, 2, 4);
        assertEquals(expected, res);
    }

    @Test
    void testIteratingWithOddStepSizeOverEvenRange() {
        // given
        var it = new IntegerRange(0, 11, 3);
        // when
        var res = it.collect();

        // then
        var expected = List.of(0, 3, 6, 9);
        assertEquals(expected, res);
    }

    @Test
    void testIteratorWithNegativeTests() {
        // given
        var it = new IntegerRange(5, 0, -1);
        // when
        var res = it.collect();

        // then
        var expected = List.of(5, 4, 3, 2, 1);
        assertEquals(expected, res);
    }

}