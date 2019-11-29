package thread;

import java.util.concurrent.Callable;

/**
 * @program: Hello
 * @author: hejiacun
 * @create: 2019-01-21 11:35
 **/
public class MyCallable implements Callable<String> {
    private long waitTime;
    public MyCallable(int timeInMillis){
        this.waitTime=timeInMillis;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }

}
