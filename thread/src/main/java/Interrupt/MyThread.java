package Interrupt;

/**
 * Created by huangzy on 2017/9/4.
 */
public class MyThread implements Runnable{
    @Override
    public void run() {

        try {


            while (true) {
                System.out.println("i am running");
                Thread.sleep(300);
            }
        }catch (InterruptedException e){
            System.out.println("i am interrupted by exception");
        }
    }
}
