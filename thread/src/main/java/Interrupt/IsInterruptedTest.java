package Interrupt;

/**
 * Created by huangzy on 2017/9/4.
 */
public class IsInterruptedTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterrupThread());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}
