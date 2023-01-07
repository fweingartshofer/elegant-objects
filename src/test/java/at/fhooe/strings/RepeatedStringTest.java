package at.fhooe.strings;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RepeatedStringTest {

    @Test
    void testToString() {
        assertThat(new RepeatedString("abc", 3).toString(), equalTo("abcabcabc"));
    }

    @Test
    void testToStringOfNull_throws() {
        assertDoesNotThrow(() -> new RepeatedString(null, 3).toString());
    }

    @Test
    void testToStringRepeatedZeroTimes_returnEmpty() {
        assertThat(new RepeatedString("abc", 0).toString(), is(emptyString()));
    }

    @Test
    void testToStringEmptyString_returnEmpty() {
        assertThat(new RepeatedString("", 3).toString(), is(emptyString()));
    }
}