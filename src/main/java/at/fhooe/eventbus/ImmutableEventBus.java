package at.fhooe.eventbus;

import at.fhooe.collections.ArrayList;
import at.fhooe.collections.ImmutableCollection;
import at.fhooe.collections.ImmutableList;

import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

public final class ImmutableEventBus<T> implements EventBus<T> {
    private final ImmutableList<Subscriber<T>> subscribers;

    public ImmutableEventBus(ImmutableCollection<Subscriber<T>> subscribers) {
        this.subscribers = new ArrayList<>(subscribers);
    }

    @Override
    public ImmutableEventBus<T> register(Subscriber<T> subscriber) {
        requireNonNull(subscriber);
        return new ImmutableEventBus<>(subscribers.concat(subscriber));
    }

    @Override
    public ImmutableEventBus<T> unregister(Subscriber<T> subscriber) {
        requireNonNull(subscriber);
        return new ImmutableEventBus<>(subscribers.filter(Predicate.not(subscriber::equals)));
    }

    @Override
    public void post(T arg) {
        for (Subscriber<T> subscriber : subscribers) {
            subscriber.handle(arg);
        }
    }
}
