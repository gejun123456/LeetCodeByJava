package learn_java_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author bruce.ge
 * @Date 2017/3/19
 * @Description
 */
public class MujusculeABC {
    private Lock lock;

    private Condition waitA;

    private Condition waitB;

    private Condition waitC;

    private char lastPrintChar;

    public MujusculeABC(){
        this.lock = new ReentrantLock();
        this.waitA = lock.newCondition();
        this.waitB = lock.newCondition();
        this.waitC = lock.newCondition();
    }


    public char getLastPrintChar() {
        return lastPrintChar;
    }

    public void setLastPrintChar(char lastPrintChar) {
        this.lastPrintChar = lastPrintChar;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Condition getWaitA() {
        return waitA;
    }

    public void setWaitA(Condition waitA) {
        this.waitA = waitA;
    }

    public Condition getWaitB() {
        return waitB;
    }

    public void setWaitB(Condition waitB) {
        this.waitB = waitB;
    }

    public Condition getWaitC() {
        return waitC;
    }

    public void setWaitC(Condition waitC) {
        this.waitC = waitC;
    }
}
