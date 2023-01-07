package at.fhooe.strings;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

class EmptyToNullStringTest {
    @Test
    void testToStringOfNonEmpty_returnsString() {
        assertThat(new EmptyToNullString("abc").toString(), equalTo("abc"));
    }

    @Test
    void testToStringOfNull_returnsNull() {
        assertThat(new EmptyToNullString(null).toString(), equalTo(null));
    }

    @Test
    void testToStringOfEmpty_returnsNull() {
        assertThat(new EmptyToNullString("").toString(), equalTo(null));
    }
}