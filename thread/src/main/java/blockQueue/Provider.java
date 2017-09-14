package blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by huangzy on 2017/9/14.
 */
public class Provider implements Runnable{

    ArrayBlockingQueue<Integer> blockingQueue;

    public Provider(ArrayBlockingQueue<Integer> queue) {

        blockingQueue = queue;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while(i<10){
                i++;
                blockingQueue.put(i);
                System.out.println("生产了第" + i + "个产品");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
