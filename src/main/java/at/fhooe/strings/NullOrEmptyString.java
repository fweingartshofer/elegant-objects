package at.fhooe.strings;

public class NullOrEmptyString implements NullOrEmpty {

    private final String string;

    public NullOrEmptyString(String string) {
        this.string = string;
    }

    @Override
    public boolean isNullOrEmpty() {
        return string == null || string.isEmpty();
    }

    @Override
    public String toString() {
        return string;
    }
}
