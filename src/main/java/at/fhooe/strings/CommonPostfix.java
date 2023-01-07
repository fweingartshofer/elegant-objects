package at.fhooe.strings;

public class CommonPostfix {
    private final String a;
    private final String b;

    public CommonPostfix(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        StringBuilder postfix = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0 && a.charAt(i) == b.charAt(j); i--, j--) {
            postfix = postfix.insert(0, a.charAt(i));
        }
        return postfix.toString();
    }
}
