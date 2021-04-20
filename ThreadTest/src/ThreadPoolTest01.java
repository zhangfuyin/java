import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadPoolTest01 {

    public  static void main(String agrs[]) throws  Exception{


        Long start = System.currentTimeMillis();

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<100000; i++){
            Thread thread = new Thread(new MyTask1(list));
            thread.start();
            thread.join();
        }
        System.out.println("时间：" + (System.currentTimeMillis() - start));
        System.out.println("list size = " + list.size());

    }


}
class MyTask1 implements Runnable {

    List<Integer> list;

    MyTask1(List<Integer> list){
        this.list = list;
    }

    Random random = new Random();
    @Override
    public void run() {
        list.add(random.nextInt());
    }
}