package at.fhooe.strings;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class LeftPaddedStringTest {

    @Test
    void testToStringWithPrefix_returnsPrefixedString() {
        assertThat(
                new LeftPaddedString("repeat", "abc", 3).toString(),
                equalTo("abcabcabcrepeat")
        );
    }

    @Test
    void testToStringWithNullOriginal_doesNotThrow() {
        assertDoesNotThrow(
                () -> new LeftPaddedString(null, "abc", 3).toString()
        );
    }

    @Test
    void testToStringWithNullPadding_doesNotThrow() {
        assertDoesNotThrow(
                () -> new LeftPaddedString("abc", null, 3).toString()
        );
    }

    @Test
    void testToStringWithNoRepeats_returnsOriginal() {
        assertThat(
                new LeftPaddedString("repeat", "abc", 0).toString(),
                equalTo("repeat")
        );
    }
}