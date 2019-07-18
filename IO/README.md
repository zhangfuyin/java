## 基本概念
  * 根据流的方向  可以分为输入流和输出流、输入和输出是相对于内存而言的、输入叫InputStream 输出OutputStream 输入还叫"读"read 输出还叫"写" write
  * 根据流的读取方式 分为字节流、字符流、字节流一个一个字节读取、字符流一个字符一个字符读（一次读两个字节）
    * 字节流 都是stream结尾 比较适合读取 声音、图片、影像、等二进制文件
    * 字符流 reader或writer结尾  比较适合读取纯文本文件
## 需要掌握的16个流
  * 基本输入、输出
    * FileInputStream
    * FileOutputStream
    * FileReader
    * FileWriter
  * 缓冲流
    * BufferedInputStream
    * BufferedOutputStream
    * BufferedReader
    * BufferedWriter
  * 数据流
    * DataInputStream
    * DataOutputStream
  * 对象流 : 专门读取java对象
    * ObjectInputStream
    * ObjectOutputStream
  * 转换流 : 字节流转字符流
    * InputStreamReader
    * OutputStream
  * 打印流
    * PrintWriter
    * PrintStream
    
## IO流的继承结构图
  * input、output
    [](https://github.com/zhangfuyin/java/raw/master/IO/images/input_output_img.png)  
  
    
