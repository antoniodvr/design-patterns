package com.github.antoniodvr;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {
        TimeMachinePool pool = new TimeMachinePool();
        log.info(pool.toString());

        // Acquire 3 time machines
        TimeMachine timeMachine1 = pool.acquire();
        log.info(pool.toString());
        TimeMachine timeMachine2 = pool.acquire();
        log.info(pool.toString());
        TimeMachine timeMachine3 = pool.acquire();
        log.info(pool.toString());
        // Release 2 time machines
        pool.release(timeMachine1);
        log.info(pool.toString());
        pool.release(timeMachine2);
        log.info(pool.toString());
        // Acquire 2 time machines
        TimeMachine timeMachine4 = pool.acquire();
        log.info(pool.toString());
        TimeMachine timeMachine5 = pool.acquire();
        log.info(pool.toString());
        // Release 1 time machine
        pool.release(timeMachine5);
        log.info(pool.toString());
    }

}
