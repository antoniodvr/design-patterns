package com.github.antoniodvr;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public abstract class ObjectPool<T extends Poolable> {

    private final Set<T> idle = new HashSet<>();
    private final Set<T> active = new HashSet<>();

    protected abstract T create();

    public synchronized T acquire() {
        long acquiringStart = System.currentTimeMillis();
        if (idle.isEmpty()) {
            idle.add(create());
        }
        T instance = idle.iterator().next();
        idle.remove(instance);
        active.add(instance);
        long acquiringTime = System.currentTimeMillis() - acquiringStart;
        log.debug("Acquired poolable object {} in {}ms", instance.getId(), acquiringTime);
        return instance;
    }

    public synchronized void release(T instance) {
        active.remove(instance);
        idle.add(instance);
        log.debug("Released poolable object " + instance.getId());
    }

    @Override
    public synchronized String toString() {
        return String.format("Pool[idle=%d, active=%d]", idle.size(), active.size());
    }

}