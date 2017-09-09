package Atom;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by huangzy on 2017/9/9.
 */
public class SimpleAtomInteger implements Runnable{

    private AtomicInteger num;

    @Override
    public void run() {
        System.out.println("num:" +getNumIncrement());
    }

    public SimpleAtomInteger(AtomicInteger num) {
        this.num = num;
    }

    public int getNumIncrement(){
        return num.incrementAndGet();
    }

    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger();
        a.addAndGet(0);
        SimpleAtomInteger SimpleAtomInteger = new SimpleAtomInteger(a);
        SimpleAtomInteger simpleAtomInteger1 = new SimpleAtomInteger(a);
        SimpleAtomInteger simpleAtomInteger2 = new SimpleAtomInteger(a);
        Thread t1 = new Thread(SimpleAtomInteger);
        Thread t2 = new Thread(simpleAtomInteger1);
        Thread t3 = new Thread(simpleAtomInteger2);
        t1.start();t2.start();t3.start();
    }
}
