package blockQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by huangzy on 2017/9/14.
 */
public class BlockQueueTest {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(1);
        Thread t1 = new Thread(new Provider(arrayBlockingQueue));
        Thread t2 = new Thread(new Consumer(arrayBlockingQueue));
        t1.start();
        t2.start();
    }

}
