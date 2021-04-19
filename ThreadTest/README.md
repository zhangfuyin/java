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
   
   
   
   
   
   