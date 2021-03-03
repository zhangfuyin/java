## 1、目录结构和存放文件和存放文件类型
  |命令实例|英文解释|作用|
  |:---|:---|:---|
  |root|root|root用户的主目录|
  |home|home|默认情况下，存放普通用户的个人配置文件|
  |sbin|superuser binary|存放系统管理员的系统管理程序|
  |bin|binary|二进制执行文件目录，常见linux命令、系统所有用户命令目录文件|
  |etc|etcetera|各种配置文件目录，大部分配置属性都放在这里|
  |lib|library|各存放系统动态链接共享库|
  |usr|unix software resource|用户的应用程序和文件存放目录|
  |opt|option|可选目录，第三方软件安装目录|
  |tmp|temporary|存放临时文件的目录|
  |dev|device|设备目录，大部分配置属性均存放在这里|
  |mnt|mount|临时外部设备挂接在此目录|
  |var|variable|变量文件|
  |pro|process|存放系统内存中的信息|
  
## 2、初学者新装Linux通过Xshell连不上Linux
  查看sshd 服务是否启动  可以通过systemctl restart sshd 命令重新启动sshd服务
  
## 3、vim 命令
  1、拷贝当前行的第N行 yy 按下p键进行黏贴  注意：在普通模式上按下yy复制 p黏贴</br>
  2、删除当前行 dd，删除当前行的下5行 5dd</br>
  3、在文件中查找某个单子，在编辑模式下输入 /单词 回车查找 输入n就是查找下一个</br>
  4、设置文件文件行号，取消文件行号 在命令模式下 设置行号：set nu   取消行号：set nonu</br>
  5、在正常模式下 G光标跳到文件最后一行  gg跳到文件首行</br> 
  7、在正常模式 输入行号 然后 shift+g  跳转到指定行数</br>
  
## 4、Linux 关机 重启指令
  1、shutdown -h now 立即关机</br>
  2、shutdown -h 1 一分钟后关机</br>
  3、shutdown -r now 立即重启</br>
  4、reboot 重启</br>
  4、sync 把内存的数据保存到磁盘上、作为一个运行人员 在`任何重启或者关机 养成一个好习惯，先执行sync命令，再执行重启或者关机命令`</br>


## 5、Linux用户管理
  1、创建用户  useradd 用户名 默认创建 和用户名相同的组 并把该用户放到当前组下面 </br>
     当然也可以指定家目录  useradd -d 家目录 用户名 </br>
     当然也可以指定组  useradd -g 组名 用户名
  2、创建密码  passwd 用户名  </br>
  3、删除用户  userdel 用户名（保留家目录） userdel -r 用户名（不保留家目录） 实际开发过程中 一般采用保留家目录的删除方式</br>
  4、查看用户信息 id 用户名</br>
  5、切换用户 su 用户名 </br>
  
## 6、Linux组管理
   1、添加组 groupadd 组名称 </br>
   2、删除组 groupdel 组名称 </br>
   3、修改用户组 usermod -g 组名 用户名</br>
   4、用户和组的配置文件 1、用户配置文件（用户信息）/etc/passwd  2、组配置文件（组信息）/etc/group 3、口令配置文件（密码登陆信息）/etc/shadow</br>
   
## 7、Linux重要命令
* 帮助命令
  * man [命令或者配置文件] 
  * help [命令] 获取shell内置命令的帮助信息
  
* 创建目录 mkdir -p 创建多级目录

* 删除目录
  * 删除空目录 rmdir a 
  * 删除多级目录 rmdir -p a/b/c (只会删除c目录)
  * 删除一个非空目录 rm -rf a  没有文件或者目录删除提示    rm -r a 有文件或者目录删除提示

* 创建空文件
  * touch test.txt 

* 拷贝文件或目录
  * cp  cp a.txt b  只能拷贝单文件或单目录
  * cp -r 递归cp文件
  * 强制不覆盖提示 \cp 

* 移动和重命名文件
  * mv 
  
* 查看文件
  * cat -n | more  查看文件并分页显示
  * 以全屏的方式按页显示文件内容 more /etc/profile
    * 空白键（space）代表向下翻一页
    * Enter键 向下翻一行
    * q 代表立刻离开more，不再显示文件内容
    * control + F 向下滚动一屏
    * control + B 向上滚动一屏
    * = 输出当前行号
    * :f 输出当前文件名和行号
  * less指令 用于查看大文件有更高的效率 less /etc/profile
    * 空白键（space） 代表向下翻一页
    * pagedown 代表向下翻一页
    * pageup   代表向上翻一页
    * /字符串   向下搜索字符串的功能 n:向下查找 N：向上查找
    * ?字符串   向上搜索字符串功能  n:向下查找 N：向上查找
  * head指令 用于显示文件开头部分内容，默认显示文件的前10行 head -n 5 文件
  * tail指定 输出文件尾部内容  tail -n 5 文件  查看文件最后5行  tail -f 实时追踪文件的变化
    
* 输出重定向指令(>) 和 追加指令（ >> ）
  * 输出重定下、会覆盖 ls -l > text.txt 将ls -l 列表的信息写到text.txt (不存在的话会创建)
  * 追加 ls -l >> text.txt 将ls -l 列表信息追加到text.txt 文件中
  * cat test1.txt > text2.txt 将文件1的内容覆盖到文件2中
  * echo “hello world” >> test.txt 将hello world追加到test.txt 
  
* echo 用于输出内容到控制台 一般用于输出当前的环境路径 
  
* 软链接（相当于windows的快捷方式）  ln -s   ln -s a/b linkToB

* history 查看已经执行过的历史指令、也可以执行历史指令 用 ！行号 执行已经执行的指令


## 时间日期类
  1、date</br>
  2、date "+%Y" 只显示年 </br>
  3、date “+%m” </br>
  4、date “+%d” </br>
  5、date “+%Y-%m-%d %H:%M:%S” 显示 年-月-日 时：分：秒 </br>
  6、设置日期 date -s “2019-07-10 22:21:32” </br>
  7、日历 cal 默认显示本月日历  cal 2020  显示2020年日历 </br>

## 搜索查询指令
  * find指令 是将指定的目录向下递归查找子文件 将满足条件的目录或者文件显示在终端
    * find /root -name text.txt 根据文件名称精确查找 find /root -name *.txt 模糊搜索
    * find /root -user root     查询指定用户名文件
    * find /root -size +20M     查找文件大于20M的文件
    
  * locate指令 快速定位文件路径 为了保证查询结果的准确性、管理员必须通过updatedb 定期更新locate数据库</br>
  
  * grep指令和管道（|）指令 | 指的是把前面的结果交给后面的指令执行  
    * cat Hello.java | grep public 在Hello.java文件中  找public字符串
    * cat Hello.java | grep -n public  显示匹配行和行号
    * cat Hello.java | grep -i public  忽略大小写

## 压缩和解压类
  * gzip  文件    压缩文件 功能描述： 只能将将文件压缩*.gz文件(注意 1:只能压缩文件不能是目录、2:压缩之后原始文件会被删除)
  * gunzip *.gz   解压文件 功能描述：解压缩文件(注意： 1:解压之后 *.gz文件会被删除)
  * zip    基本语法： zip [选项] xxx.zip ，将要压缩文件的内容（功能描述：压缩文件和目录的命令）
    * -r 递归压缩   `eg: zip root.zip -r ../root`
  * unzip  基本语法：unzip [选项] XXX.zip 
    * -d<目录> ： 指定解压后文件的存放目录  `eg: unzip root.zip -d ./e `
  * tar 指令 zcvf：压缩，压缩后的文件格式：*.tar.gz   zxvf: 解压 
    * zcvf  `eg: tar -zcvf ./e/mypackage.tar.gz /Home`
    * zxvf  `eg: tar -zxvf ./e/mypackage.tar.gz ./d`
  
## Linux组管理
  * 基本概念：Linux中的每个用户必须属于一个组、不能独立于组外、在Linux中每个文件有所有者、所在组、其他组的概念
  * 查看文件的所有者  ls-ahl 
  * 改变文件的所有者 chown 用户 文件 
  * 修改文件的所在组 chgrp 组名 文件
  * 修改用户的所在组 usermod -g 组名 用户名
  * 综合写法：chown newower:newgroup file 改变文件的所在组和所有者（  -R 如果是目录的话 递归生效）
  
## Linux权限管理
  * 查看文件ls -a 的说明
    * 0位置 表示文件的类型
    * 1～3位置 表示文件所有者的权限
    * 4～6位置 表示文件所在组（同用户组）权限 （`解释：和文件的拥有者相同的组、对该文件的权限`）
    * 7～9位置 表示其他用户拥有该文件的权限（`解释：不与文件拥有者同组的用户对该文件的权限`）
  * rwx 权限详解
    * rwx 作用到文件上
      * r 有读取、查看
      * w 有修改的权限 `但是不见得有删除权限、删除文件的前提是：对文件的所在目录有写的权限`
      * x 代表可以执行
    * rwx 作用到目录上
      * r 读取 ls 可以查看
      * w 有修改权限 修改、删除、重命名目录
      * x 代表可以进入到该目录下
  
  * 修改权限
    * 基本说明：通过chmod可以修改目录或者文件的权限
    * 第一种方式 通过+、-、= 方式变更权限
      * u:所有者 g:所在组 o:其他人 a:所有人（u、g、o 的总和）
      * chmod u=rwx,g=rx,o=x 文件目录名 （表示给文件所有者 读写执行/进入权限、文件所在组：读执行/进入权限、其他组：可执行/可进入权限）
      * chmod o+x 文件目录名 （给文件的其他加上可执行/可进入的权限）
      * chmod a-x 文件目录名 （给所有人去掉可执行/可进入 权限）
    * 第二种方式 通过数字变更权限
      * r=4 w=2 x=1 rwx=4+2+1=7
      * chmod u=rwx,g=rw,o=r 相当于 chmod 751
 
 ## crond 任务调度
  * 基本说明：在特定的时间、执行特定的命令或者程序
  * 基本语法：crontab [选项]
     * -e 编辑crontab   定时任务
     * -l 查询crontab任务
     * -r 删除当前用户所有的crontab任务
  * 案例 
     * */1 * * * * ls -l /etc/ > /tem/to.txt 意思是 每小时的每分钟执行 ls -l /etc/ > /tem/to.txt
     * 5个占位符说明
        * 第一个* ： 一个小时的第几分钟 取值： 0～59
        * 第二个* ： 一天当中第几个小时 取值： 0～23
        * 第三个* ： 一个月中的第几天   取值： 1～31
        * 第四个* ： 一年当中的第几个月 取值： 1～12
        * 第五个* ： 一周当中的星期几。 取值： 0～7 0和7都代表的周日
     * 特殊符号说明
        * [*] 代表任何时间、比如第一个* 就表示每个小时的每一分钟都执行一次的意思
        * [,]代表不连续的时间 比如‘0 8，12，16 * * *’ 表示每天8：00 12:00 16:00 都执行一次命令
        * [-] 代表连续的时间范围 比如‘0 5 * * 1-6’ 表示周一到周六5:00 执行命令
        * [*/n] 代表每隔多久执行一次 比如 ‘*/10 * * * * ’ 表示每隔十分钟执行一次命令
     * 特定时间执行案例
        * '45 22 * * *'     在22:45分执行命令
        * '0 17 * * 1'      在周一17:00分执行命令
        * '0 5 1，15 * *'   在1号和15号凌晨五点执行命令
        * '40 4 * * 1-5'    在周一到周五凌晨四点40分执行命令
        * '*/10 4 * * *'     每天凌晨四点每隔十分钟之行命令
        * '0 0 1，15 * 1'    每月的1号和15号、和每周一0点0分之行命令
  ## 磁盘查看指令
   * 查看系统磁盘使用情况 df -h 
   * 统计文件或者目录所占磁盘空间的大小 du -ach --max-depth=1 /zhangfy_test 
   * 工作的实用指令
      * 统计/home 文件夹下文件的个数 ls -l /home | grep '^-' | wc -l
      * 统计/home 文件夹下目录的个数 ls -l /home | grep '^d' | wc -l
      * 统计/home 文件夹下文件个数 包括子文件里面的 ls -lR /home | grep '^-' | wc -l
      * 统计/home 文件夹下目录的个数 包括子文件里面的 ls -lR /home | grep '^d' | wc -l
      * 以树状结构显示目录结构 tree /home
  ## Linux 网络环境配置
   * 设置固定IP 
      * 原始配置<br>
          BOOTPROTO=dhcp <br>
          DEVICE=eth0 <br> 
          HWADDR=52:54:00:6f:04:0c <br>
          NM_CONTROLLED=no <br>
          ONBOOT=yes <br>
          PERSISTENT_DHCLIENT=yes <br>
          TYPE=Ethernet <br>
          USERCTL=no <br>
      * 固定IP<br>
          BOOTPROTO=static        开机协议，有dhcp及static <br>
          ONBOOT=yes  设置为开机启动<br>
          IPADDR=192.168.2.123  你想要设置的固定IP，192.168.2.2-255之间都可以，请自行验证<br>
          NETMASK=255.255.255.0 子网掩码，不需要修改<br>
          GATEWAY=	192.168.2.1 网关，这里 NAT设置里的网关地址要一样<br>
          DNS1=114.114.114.114 这个是国内的DNS地址，是固定的<br>
          
  ## Linux 进程管理
    
    * 先看一张图片
   ![image](https://github.com/zhangfuyin/java/blob/master/Linux/image/ps_details.png)
    
    * ps -aux | more   如果想查看进程的CPU占用率和内存占用率，可以使用aux
    
    
    *  ps -ef 可以查看到父进程如果想查看进程的父进程ID和完整的COMMAND命令，可以使用ef
    
    * pstree 直观的看进程信息
      * -p：显示进程pid
      * -u: 显示进程的所属用户
    
    
    * 杀掉进程 
      * kill 根据进程ID删除
      * killall 根据进程名称删除
      
    
  ## Linux 服务管理
  
     * 背景介绍:
             每个服务都是一个进程。通常都是后台运行、并监听一个端口 等待其他程序的请求，比如（防火墙、mysql 等等）因此我们有叫守护进程
     
     * serivce 服务 [start | stop |  reload | status ] 但是从CentOS7.0之后 使用 systemctl
     
     * telnet指令用来测试Linux的某个端口是否运行、并可以连接  telnet ip port
     
     * 细节讨论：
      * 关闭或者启动防火墙、立即生效
      * 这种方式都是临时生效、当系统重启后、还是回归以前对服务的配置
      * 如果希望设置某个服务自动启动或永久关闭 用chkconfig 指令
     
     * Linux到底有那么服务 查询服务指令
      * setup
      * ls -l  /etc/init.d/  但是从CentOS7.0之后 /usr/lib/systemd/system
      
     * Linux运行级别（7个）
      * 0： 关机
      * 1： 单用户登陆（找回密码）
      * 2： 多用户、无网络服务
      * 3： 多用户、有网络服务
      * 4： 保留
      * 5： 图形界面
      * 6： 系统重启
     
      * 指定运行级别的指令 init(0 | 1 | 2 | .....)
      * 查看运行级别 cat /etc/inittab
      
     
     * chkconfig 指令  可以给服务各个设置运行级别设置自动启动/关闭
      * 查看服务 chkconfig -- list | grep xx  或者 chkconfig 服务名 --list    CentOS7.0之后使用systemctl list-unit-file
      * 某个服务在某个运行级别下自启动 chkconfig --level 3 on/off
      
      
     * 动态监控进程 top指令
                top和ps指令很相似 都是显示正在执行的进程、最大的不同 top指令执行一段时间后、可以更新正在运行的进程
    
   ![image](https://github.com/zhangfuyin/java/blob/master/image/top_detail.png)
   
      * 选项
        * -d 20  每隔多久刷新  按下q退出
        * -i 不显示任何闲置或者僵死进程
        * -p 指定进程ID 监控某个进程的状态 
      
      
      * 互动指令
        * P 以cpu使用率排序 默认
        * M 以内存的使用率排序
        * N PID排序
        * q 退出
        
    * netstat 指令监控网络服务
      * 选项
        * -an 按一定的顺序排序输出
        * -p 显示哪个进程在调用
        * netstat -anp | more 查询系统所有的网络服务


      * 互动指令
        * P 以cpu使用率排序 默认
        * M 以内存的使用率排序
        * N PID排序
        * q 退出
  
  
  ## shell编程
   * 变量声明
   
    *  开头加上#!/bin/bash
    
    * 输出系统变量 echo “PATH = $PATH”   echo "USER = $USER"
    
    * 定义变量 A=100  echo "$A"; 撤销变量 unset A  ; 注意 静态变量不能unset 声明静态变量： readonly A=99;
    
    * 可以把变量提升为全局变量、可供其他shell程序使用
    
    * 将运行结果返回给一个变量  RESULT=`ls -l`  或者RESULT=`ls -a`
    
   * 配置环境变量
    
    * 在/etc/profile  加上比如 MY_HOME=“江苏省 苏州市” export MY_HOME 在别的shell脚本就可以直接使用这个变量了 echo "$MY_HOME" 
    
   * 位置变量参数（脚本如何接受 外部传入的参数呢？？？）
    
    * $n  n为数字1～9 $0: 代表命令本身 $1~$9代表1～9个参数  当超过10个使用${10} ....
    
    * $*  代表命令中所有参数 把所有参数看成一个整体 
    
    * $@  代表命令行中所有参数 但是和$*的区别是 $@把每个参数区分对待
    
    * $#  代表参数的个数
    
   * 预定义变量 （就是shell设计者事先设计好的变量 可以在脚本中直接使用）
    
    * $$ 当前进程ID
    
    * $! 后台运行的最后一个进程进程号（PID）
    
    * $? 代表最后一次命令执行状态 如果是0 代码上一个命令正常结束 如果非0 （具体哪个数 由命令自己决定）则代表上一个命令执行不正确了
    
   
   * 运算符
   
    * 第一种方式 $((运算))
    
    * 第二种方式 $[]
    
    * 第三种方式 `expr 运算 `  + - \* / %  注意： 乘 需要\* 

   * 条件判断

    * = 比较字符串是否相等

    * 数据比较大小  -lt：小于 、 -gt：大于 、-eq : 等于 、  -le:小于等于 、-ge:大于等于 、 -ne: 不等于

    * 按照文件类型判断 -f：文件存在并且是一个常规文件、 -e: 判断文件是否存在、-d:判断目录是否存在

    * 按照文件权限  -r 有读的权限 -w有写的权限 -x可执行权限
   
   * 流程控制
    
    * if流程控制    
          if [  条件  ]
          then 
             程序
          elif [ 条件 ]
             程序
          then 
             程序
           else
             程序
           fi
     * case流程控制
           case $变量名 in  
           "值1”）
              程序
            ;;
            
           "值2"）
              程序
            ;;
            
            *)
              程序
            ;;
            esac
            
            
      * for 循环
        
        * 第一种方式
          for i in $@
          do
            echo "$i"
          done
         
        * 第二种方式
           for((初始值；选控制条件；变量变化))
           do
             程序
           done
           
           
           计算Sum（1 ～ 100）
           SUM=0
           for((i=1 ; i<=100 ; i++))
           do 
             SUM=$[$SUM+$i]
           done
           echo "SUM============$SUM"
           
       * while 循环
       
         while[条件判断]
         do
          程序
         done
         
         计算累加的值
         NUM=$1
         SUM=0
         while [ $NUM ge 1 ]
         do
          SUM=$[$SUM+$NUM]
          NUM=$[$NUM-1]
         donw'
         
## 安装JDK

  * 通过tar -zxvf 解压包
  * 配置环境变量 vi /etc/profile
    * export JAVA_HOME=/opt/jdk1.8.0_281
    * export PATH=$JAVA_HOME/bin:$PATH
    * export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

  * source /etc/profile


        
 ## mysql安装
 
 * 通过rpm -qa | grep mysql 来查询mysql是否安装
 * 
 
         
         
        
        
      
          
          
          




  
    
    
    
   
       
      
                
                
     
     
      
      
      
      
     
     
     
      
     


    
        
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    
    
    
    
    
    
  
  
  
    
    
    
  
  
  
  
  
   
    
  
  
  
    
  
  
  
  
  
  
  
  
