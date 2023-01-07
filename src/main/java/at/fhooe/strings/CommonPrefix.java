package at.fhooe.strings;

public class CommonPrefix {
    private final String a;
    private final String b;

    public CommonPrefix(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i); i++) {
            prefix = prefix.append(a.charAt(i));
        }
        return prefix.toString();
    }
}
