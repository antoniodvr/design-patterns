package com.github.antoniodvr;

import java.util.UUID;

public class TimeMachine implements Poolable {

    private final UUID id;

    public TimeMachine() {
        this.id = UUID.randomUUID();
        try {
            Thread.sleep(3000); // Really expensive :)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getId() {
        return id.toString();
    }

    @Override
    public String toString() {
        return String.format("TimeMachine id=%s", id);
    }

}