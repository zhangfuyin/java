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
  6、在正常模式下撤销 u</br>
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


   
  
  
  
   
    
  
  
  
    
  
  
  
  
  
  
  
  
