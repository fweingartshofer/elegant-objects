package at.fhooe.strings;

public class LeftPaddedString {
    private final String original;
    private final RepeatedString leftPad;

    public LeftPaddedString(String original, String pad, int repeat) {
        this.original = original;
        this.leftPad = new RepeatedString(pad, repeat);
    }

    @Override
    public String toString() {
        return leftPad + original;
    }
}
