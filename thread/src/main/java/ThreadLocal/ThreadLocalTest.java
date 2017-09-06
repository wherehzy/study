package ThreadLocal;

/**
 * Created by huangzy on 2017/9/6.
 */
public class ThreadLocalTest implements Runnable{

    public ThreadLocal<Integer> num = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };


    @Override
    public void run() {
        int i=0;
        while(i < 3){
            System.out.println("thread:" + Thread.currentThread().getName() + "  -> num :" + num.get());
            num.set(num.get().intValue()  + 1) ;
            i++;
        }
    }

    public static void main(String[] args) {
        int num  = 0;

        Thread test1 = new Thread(new ThreadLocalTest());
        Thread test2 = new Thread(new ThreadLocalTest());
        Thread test3 = new Thread(new ThreadLocalTest());

        test1.start();
        test2.start();
        test3.start();

    }
}
