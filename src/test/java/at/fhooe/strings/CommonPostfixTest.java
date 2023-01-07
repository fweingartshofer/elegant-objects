package at.fhooe.strings;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.IsEmptyString.emptyString;

class CommonPostfixTest {

    @Test
    void commonPostfixOfEqualString_returnsWholeString() {
        assertThat(new CommonPostfix("abc", "abc").toString(), equalTo("abc"));
    }

    @Test
    void commonPostfixWithSimilarPostfix_returnsPostfix() {
        assertThat(
                new CommonPostfix("Hello World!", "Goodbye World!").toString(),
                equalTo(" World!")
        );
    }

    @Test
    void commonPostfixWithDifferentStrings_returnsEmptyString() {
        assertThat(
                new CommonPostfix("Hello World!", "Goodbye.").toString(),
                is(emptyString())
        );
    }
}