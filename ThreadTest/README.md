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
   
