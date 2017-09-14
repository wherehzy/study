package blockQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by huangzy on 2017/9/14.
 */
public class Consumer implements Runnable {
    private ArrayBlockingQueue<Integer> arrayBlockingQueue ;

    @Override
    public void run() {
        Integer i;
        try {
            while ((i = arrayBlockingQueue.take()) != null){//如果发现队列不为空
                System.out.println("消费第" + i + "个产品");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Consumer(ArrayBlockingQueue<Integer> queue) {
        arrayBlockingQueue = queue;
    }
}
