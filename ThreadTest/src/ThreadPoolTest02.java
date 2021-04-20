import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest02 {

    public  static void main(String agrs[]) throws  Exception{

        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();


        Long start =  System.currentTimeMillis();

        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for(int i = 0 ; i < 100000; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("时间：" + (System.currentTimeMillis() - start));
        System.out.println("list size = " + list.size());

    }


}

