package at.fhooe.strings;

public class NullToEmptyString {

    private final NullOrEmpty string;

    public NullToEmptyString(String original) {
        this.string = new NullOrEmptyString(original);
    }

    @Override
    public String toString() {
        return string.isNullOrEmpty() ? "" : string.toString();
    }
}
