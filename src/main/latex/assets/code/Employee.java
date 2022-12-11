public class Employee {
    public static final Employee EMPTY =
            new Employee() {
                @Override
                public String name() {
                    return "empty";
                }
                @Override
                public void transfer(Department dep) {
                    throw new EmptyObjectException();
                }
            };
    private final String name;

    public String name() {
        return name;
    }
    public void transfer(Department dep) {
        // Implementation
    }
}