package Interrupt;

/**
 * Created by huangzy on 2017/9/4.
 */
public class InterrupThread implements Runnable {
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("i am running");
        }
        System.out.println("i was interrpted by isInterrupted");
    }
}
