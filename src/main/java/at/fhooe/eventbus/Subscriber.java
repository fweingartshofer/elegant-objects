package at.fhooe.eventbus;

@FunctionalInterface
public interface Subscriber<T> {
    void handle(T arg);

    default boolean isResponsible(T arg) {
        return true;
    }
}
