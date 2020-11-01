package com.github.antoniodvr;

public class TimeMachinePool extends ObjectPool<TimeMachine> {

    @Override
    protected TimeMachine create() {
        return new TimeMachine();
    }

}