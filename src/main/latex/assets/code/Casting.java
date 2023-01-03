class Casting() {
public static void main(String... args) {
List<String> list = new ArrayList<String>(); // Down cast
ArrayList<String> arrayList = (ArrayList<String>) list; // Up cast
}
}