package at.fhooe.strings;

public class RightPaddedString {
    private final String original;
    private final RepeatedString rightPad;

    public RightPaddedString(String original, String pad, int repeat) {
        this.original = original;
        this.rightPad = new RepeatedString(pad, repeat);
    }

    @Override
    public String toString() {
        return original + rightPad;
    }
}
