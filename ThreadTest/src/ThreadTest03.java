public class ThreadTest03 {


    public  static  void main(String[] agrs){

        Thread t1 = new Thread(new Processor());
        t1.setName("t1线程");
        t1.setPriority(1);
        t1.start();

        Thread t2 = new Thread(new Processor());
        t2.setName("t2线程");

        // 设置线程优先级 最高
        t2.setPriority(10);
        t2.start();
    }



}
class Processor implements  Runnable{

    @Override
    public void run() {
        String name =   Thread.currentThread().getName();

        for(int i = 0 ; i<100; i++){
            System.out.println(name + "开始执行" + i);
        }

    }
}