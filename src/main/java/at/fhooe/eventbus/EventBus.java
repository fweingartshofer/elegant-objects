package at.fhooe.eventbus;

public interface EventBus<T> {
    EventBus<T> register(Subscriber<T> subscriber);

    EventBus<T> unregister(Subscriber<T> subscriber);

    void post(T arg);
}
