package at.fhooe.strings;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

class NullOrEmptyStringTest {

    @Test
    void isNullOrEmptyOfNull_returnsTrue() {
        assertThat(new NullOrEmptyString(null).isNullOrEmpty(), is(true));
    }

    @Test
    void isNullOrEmptyOfEmpty_returnsTrue() {
        assertThat(new NullOrEmptyString("").isNullOrEmpty(), is(true));
    }

    @Test
    void isNullOrEmptyOfNoneEmpty_returnsFalse() {
        assertThat(new NullOrEmptyString("abc").isNullOrEmpty(), is(false));
    }

    @Test
    void testToString() {
        assertThat(new NullOrEmptyString("abc").toString(), equalTo("abc"));
    }
}