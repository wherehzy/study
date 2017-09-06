package ThreadLocal;

/**
 * Created by huangzy on 2017/9/6.
 */
public class ClassicThreadLocal {

    //hibernate获取session经典 ThreadLocal

    private static ThreadLocal sessionMap = new ThreadLocal();

    public static Object getSession(){
        Object obj = sessionMap.get();
        if(obj == null){
            obj = new Object();
            sessionMap.set(obj);

        }
        return obj;
    }
}
