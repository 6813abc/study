package com.cyg.study.concurrent.aqs;

/**
 * @author cyg
 * @date 2021/5/12 10:18
 **/
public class LeeLock {

    private Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }
}
