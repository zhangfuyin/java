public class ThreadTest02 implements  Runnable{


    @Override
    public void run() {
        for(int i = 0 ; i <=100; i++){
            System.out.println("子线程开始执行了, i + " + i);
        }
    }


    public  static  void main(String[] agrs){
        Thread thread = new Thread(new ThreadTest02());
        thread.start();


        for(int i = 0 ; i < 300; i++){
            System.out.println("主线程开始执行了, i + " + i);
        }
    }
}
