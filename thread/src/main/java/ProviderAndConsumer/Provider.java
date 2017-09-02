package ProviderAndConsumer;

/**
 * Created by huangzy on 2017/9/2.
 */
public class Provider implements  Runnable{

    private Object lockObject;

    public Provider(Object lockObject) {
        this.lockObject = lockObject;
    }

    @Override
    public void run() {
        int i = 1;
        while(i< 10){
            synchronized (lockObject) {
                lockObject.notify();
                System.out.println("我生产了第" + i + "件产品");
                i++;
                try {
                    lockObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}