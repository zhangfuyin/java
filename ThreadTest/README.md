## 线程创建方式 
   
   *  继承Thread 通过start()方法启动线程
   
   ```
       package com.zhangfuyin;
       
       public class ThreadTest01 extends  Thread {
       
           @Override
           public void run() {
       
               for(int i = 0 ; i <=100; i++){
                   System.out.println("子线程开始执行了, i + " + i);
               }
       
           }
       
           public static void main(String agrs[]){
               Thread thread = new ThreadTest01();
               thread.start();
       
               for(int i = 0 ; i < 300; i++){
                   System.out.println("主线程开始执行了, i + " + i);
               }
           }
       }

        
   ```
   
   
   * 实现Runnable接口 
   
    ```
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
    ```
   
   ## 线程生命周期
   
   ![生命周期](https://github.com/zhangfuyin/java/blob/master/ThreadTest/img/QQ20210419-224002%402x.png)
   
   
   ## 线程的调度和控制
   
   * 线程的优先级(setPriority(1)) 让线程获取cpu的时间片的时间相对较长
     
     ```
        public class ThreadTest03 {
        
        
            public  static  void main(String[] agrs){
        
                Thread t1 = new Thread(new Processor());
                t1.setName("t1线程");
                // 设置线程优先级 最低
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
     ```
   
   * 线程阻塞--sleep 目的：为了阻塞当前线程让出cpu时间片给其他线程执行 可以通过*interrupt()*打断线程的休眠 让其继续执行
     
     ```
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
     ```
      
   
    
   
   
   * 线程让位yield让 *同优先级* 的线程有执行的机会
   
   
   * 线程合并join t1.join() 会阻塞当前线程, 等t1线程执行结束 当前线程继续执行
   
   
## 线程池
  
  * 不推荐使用Executors工具创建线程池
  
  * 自定义线程池
      ```
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

        
        输出结果：
        
        /Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=62902:/Applications/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/tools.jar:/Users/zhangfuyin/IdeaProjects/java/Thead-Test/production/Test ThreadPoolTest03
        pool-1-thread-1-----1
        pool-1-thread-4-----4
        pool-1-thread-2-----2
        pool-1-thread-3-----3
        pool-1-thread-6-----6
        pool-1-thread-5-----5
        pool-1-thread-7-----7
        pool-1-thread-8-----8
        pool-1-thread-9-----9
        pool-1-thread-10-----10
        pool-1-thread-11-----21
        pool-1-thread-12-----22
        pool-1-thread-13-----23
        pool-1-thread-14-----24
        pool-1-thread-15-----25
        pool-1-thread-16-----26
        pool-1-thread-17-----27
        pool-1-thread-18-----28
        pool-1-thread-19-----29
        pool-1-thread-20-----30
        Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task MyTask03@49476842 rejected from java.util.concurrent.ThreadPoolExecutor@78308db1[Running, pool size = 20, active threads = 20, queued tasks = 10, completed tasks = 0]
        	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
        	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
        	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
        	at ThreadPoolTest03.main(ThreadPoolTest03.java:13)
        pool-1-thread-6-----11
        pool-1-thread-1-----12
        pool-1-thread-7-----13
        pool-1-thread-5-----14
        pool-1-thread-3-----17
        pool-1-thread-4-----16
        pool-1-thread-8-----15
        pool-1-thread-2-----18
        pool-1-thread-11-----19
        pool-1-thread-12-----20
        
        Process finished with exit code 130 (interrupted by signal 2: SIGINT)

        
      ```
      
      1、问题思考 我for循环1～100向线程池提交任务  为什么21～30的任务 比 11 ～ 20的任务先执行呢？
      
        这里是因为线程池【提交优先级】和 【执行优先级】决定的 
        提交优先级：先把1～10的任务提交到核心线程池 在把11～20任务放到队列，线程发现队列已满、21～30放到线程池 
        执行顺序：  核心线程池 -> 线程池 -> 队列
        
      
      
   
  * 线程池的处理流程
    
    ![生命周期](https://github.com/zhangfuyin/java/blob/master/ThreadTest/img/WX20210421-002126@2x.png)
      
   