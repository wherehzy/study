package Interrupt;

/**
 * Created by huangzy on 2017/9/4.
 */
public class ExceptionTest {

    public static void main(String[] args) {
        Thread myThread = new Thread(new MyThread());
        myThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.interrupt();
    }
}
