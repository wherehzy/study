package Lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by huangzy on 2017/9/10.
 */
public class ReentranLockTest {

    public static int i = 0;

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public synchronized int getI() {
        System.out.println("get i");
        return i;
    }

    public synchronized void setI(){
        i++;
        System.out.println("set i");
    }

    public int getRI(){
        lock.readLock().lock();
        try {
            System.out.println("getR i");
            return i;
        }finally {
            lock.readLock().unlock();
        }
    }


    public void setRI(){
        lock.writeLock().lock();
        try{
            i++;
            System.out.println("set i");
        }finally {
            lock.writeLock().unlock();
        }
    }

    public void interruptLock(){
        try {
            lock.readLock().lockInterruptibly();//可中断
        } catch (InterruptedException e) {
            e.printStackTrace();//中断
        }
    }
}
