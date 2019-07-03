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
  1、拷贝当前行的第N行 yy 按下p键进行黏贴  注意：在普通模式上按下yy复制 p黏贴
  2、删除当前行 dd，删除当前行的下5行 5dd
  3、在文件中查找某个单子，在编辑模式下输入 /单词 回车查找 输入n就是查找下一个
  4、设置文件文件行号，取消文件行号 在命令模式下 设置行号：set nu   取消行号：set nonu
  5、在正常模式下 G光标跳到文件最后一行  gg跳到文件首行
  6、在正常模式下撤销 u
  7、在正常模式 输入行号 然后 shift+g  跳转到指定行数
## 4、Linux 关机 重启指令
  1、shutdown -h now 立即关机
  2、shutdown -h 1 一分钟后关机
  3、shutdown -r now 立即重启
  4、reboot 重启
  4、sync 把内存的数据保存到磁盘上、作为一个运行人员 在`任何重启或者关机 养成一个好习惯，先执行sync命令，再执行重启或者关机命令`
