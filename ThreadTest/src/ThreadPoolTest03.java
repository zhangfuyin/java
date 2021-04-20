import java.util.concurrent.*;

public class ThreadPoolTest03 {

    public static void main(String[] agrs){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                20,
                0L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));

        for(int i = 1; i <= 100; i++){
            threadPoolExecutor.execute(new MyTask03(i));
        }

        threadPoolExecutor.shutdown();

    }


}

class MyTask03  implements  Runnable{
    MyTask03(int i ){
        this.i = i;
    }
    private int i;

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "-----"+ i);

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
