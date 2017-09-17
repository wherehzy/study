package ThreadPoolManage;

import java.util.concurrent.*;

/**
 * Created by huangzy on 2017/9/17.
 */
public class MyThreadPoolExecutor {

    private static int CORE_POOL_SIZE = 10;

    private static int MAX_POOL_SIZE = 15;



    private static ThreadPoolExecutor threadPool ;

    public static ThreadPoolExecutor getInstance(){
        if(threadPool == null){
            synchronized (threadPool){
                if(threadPool == null){
                    threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10), new ThreadFactory() {
                        @Override
                        public Thread newThread(Runnable r) {
                            return new Thread();//简单线程工厂
                        }
                    },new RejectedExecutionHandler(){
                        @Override
                        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                            //当提交任务数超过maxmumPoolSize+workQueue之和时，任务会交给RejectedExecutionHandler来处理
                        }
                    });
                }
            }
        }
        return threadPool;
    }


    public void removeJob(Runnable job){
        MyThreadPoolExecutor.getInstance().remove(job);
    }

    public void submitJob(Runnable job){
        MyThreadPoolExecutor.getInstance().submit(job);
    }
}
