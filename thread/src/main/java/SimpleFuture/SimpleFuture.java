package SimpleFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import java.util.concurrent.FutureTask;

/**
 * Created by huangzy on 2017/9/5.
 */
public class SimpleFuture {

    public void callableTest() {

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "CallResult";
            }
        };

        FutureTask<String> future = new FutureTask<String>(callable);
        new Thread(future).start();

        try {
            Thread.sleep(3000); //
            future.get(); //最后执行结果在这里得到
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
