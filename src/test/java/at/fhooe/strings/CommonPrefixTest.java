package at.fhooe.strings;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.IsEmptyString.emptyString;

class CommonPrefixTest {

    @Test
    void commonPrefixOfEqualString_returnsWholeString() {
        assertThat(new CommonPrefix("abc", "abc").toString(), equalTo("abc"));
    }

    @Test
    void commonPrefixWithSimilarPrefix_returnsPrefix() {
        assertThat(
                new CommonPrefix("Hello World!", "Hello Earth!").toString(),
                equalTo("Hello ")
        );
    }

    @Test
    void commonPrefixWithDifferentStrings_returnsEmptyString() {
        assertThat(
                new CommonPrefix("Hello World!", "Goodbye.").toString(),
                is(emptyString())
        );
    }
}