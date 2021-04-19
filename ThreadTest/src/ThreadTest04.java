public class ThreadTest04 {


    public  static  void main(String[] agrs) throws Exception{

        Thread t1 = new Thread(new Processor1());
        t1.setName("t1线程");
        t1.start();

        Thread.sleep(2000);

        // 打断线程的休眠状态 让其继续执行
        t1.interrupt();
    }



}

class Processor1 implements  Runnable{

    @Override
    public void run() {
        String name =   Thread.currentThread().getName();

        try {
            // 线程休眠5秒钟
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0 ; i<100; i++){
            System.out.println(name + "开始执行" + i);
        }

    }
}