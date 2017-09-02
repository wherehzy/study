package ProviderAndConsumer;

/**
 * Created by huangzy on 2017/9/2.
 */
public class Test {

    public static void main(String[] args) {
        Object lock = new Object();
        Provider provider = new Provider(lock);
        Consumer consumer = new Consumer(lock);
        Thread Pthread = new Thread(provider);
        Thread Cthread = new Thread(consumer);
        Pthread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Cthread.start();

    }
}
