package at.fhooe.eventbus;

import at.fhooe.collections.ImmutableCollection;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class MutableEventBus<T> implements EventBus<T> {
    private ImmutableCollection<Subscriber<T>> subscribers;

    @Override
    public EventBus<T> register(Subscriber<T> subscriber) {
        requireNonNull(subscriber);
        if(!subscribers.contains(subscriber)) {
            subscribers = subscribers.concat(subscriber);
        }
        return this;
    }

    @Override
    public EventBus<T> unregister(Subscriber<T> subscriber) {
        requireNonNull(subscriber);
        subscribers = subscribers.filter(s -> Objects.equals(subscriber, s));
        return this;
    }

    @Override
    public void post(T arg) {
        for (Subscriber<T> subscriber : subscribers) {
            if(subscriber.isResponsible(arg)) {
                subscriber.handle(arg);
            }
        }
    }
}
