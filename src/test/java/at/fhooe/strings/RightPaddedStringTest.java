package at.fhooe.strings;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class RightPaddedStringTest {
    @Test
    void testToStringWithPostfix_returnsPostfixedString() {
        assertThat(
                new RightPaddedString("repeat", "abc", 3).toString(),
                equalTo("repeatabcabcabc")
        );
    }

    @Test
    void testToStringWithNullOriginal_doesNotThrow() {
        assertDoesNotThrow(
                () -> new RightPaddedString(null, "abc", 3).toString()
        );
    }

    @Test
    void testToStringWithNullPadding_doesNotThrow() {
        assertDoesNotThrow(
                () -> new RightPaddedString("abc", null, 3).toString()
        );
    }

    @Test
    void testToStringWithNoRepeats_returnsOriginal() {
        assertThat(
                new RightPaddedString("repeat", "abc", 0).toString(),
                equalTo("repeat")
        );
    }
}