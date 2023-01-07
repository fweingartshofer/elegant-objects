package at.fhooe.strings;

public class EmptyToNullString {

    private final NullOrEmpty string;

    public EmptyToNullString(String original) {
        this.string = new NullOrEmptyString(original);
    }

    @Override
    public String toString() {
        return string.isNullOrEmpty() ? null : string.toString();
    }
}
