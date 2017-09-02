package ProviderAndConsumer;

/**
 * Created by huangzy on 2017/9/2.
 */
public class Consumer implements Runnable {

    private Object lockObject;

    public Consumer(Object lockObject) {
        this.lockObject = lockObject;
    }

    @Override
    public void run() {
        int i = 1;
        while (i < 10){
            synchronized (lockObject) {
                System.out.println("我消费了第" + i + "件产品");
                i++;
                lockObject.notify();
                try {
                    lockObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
