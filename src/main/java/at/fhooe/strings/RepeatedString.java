package at.fhooe.strings;

public class RepeatedString {
    private final String original;
    private final int repeat;

    public RepeatedString(String original, int repeat) {
        this.original = original;
        this.repeat = repeat;
    }

    @Override
    public String toString() {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            repeated = repeated.append(original);
        }
        return repeated.toString();
    }
}
