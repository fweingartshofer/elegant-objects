package at.fhooe.strings;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

class NullToEmptyStringTest {

    @Test
    void testToStringOfNonNull_returnsString() {
        assertThat(new NullToEmptyString("abc").toString(), equalTo("abc"));
    }

    @Test
    void testToStringOfNull_returnsEmptyString() {
        assertThat(new NullToEmptyString(null).toString(), equalTo(""));
    }

    @Test
    void testToStringOfEmpty_returnsEmptyString() {
        assertThat(new NullToEmptyString("").toString(), equalTo(""));
    }
}