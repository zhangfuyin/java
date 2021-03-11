## 三要素
        容器、镜像、仓库

## docker run imageName 到底执行了什么？
![image](https://github.com/zhangfuyin/java/blob/master/docker/images/docker_run.jpeg)


## docker安装 
  * 参照官网 www.docker.com


## docker常用命令
### 1、帮助命令

        docker version
        docker info 
        docker --help

### 2、镜像命令

        docker images 列出本地主机上的镜像
        OPTION 说明
            1、-a 列出本地所有镜像（含中间映像层）
            2、-q 只显示镜像ID

        docker search 搜索从https://hub.docker.com 上的某个镜像的名字
        OPTION 说明
            1、-s 列出 镜像收藏不小于多少的 eg: 收藏说不小于30tomcat镜像 docker search -s 30 tomcat  

        docker pull imageName  从仓库中拉取镜像 eg: docker pull tomcat 相当于 docker pull tomcat:latest

        docker rmi 某个镜像名字/ID 
            删除单个： docker rmi -f 镜像ID
            删除多个： docker rmi -f imageName1:TAG imageName2:TAG
            全部删除： docker rmi $(docker image -qa)

### 3、容器命令

        docker run [options] image[COMMOND][AGR] 启动并创建容器
        OPTION 说明
            1、-i 以交互式运行容器  通常于-t 同时使用
            2、-t 为容器重新分配一个伪输入终端  通常于-i同时使用  eg: docker run -it --name mycentos centos
            3、-p 指定端口运行容器  docker run -it -p 8899:8080 tomcat   那么通过浏览器直接输入 www.ip:8899 自动就能访问docker运行的tomcat实例
            4、-P 随机指定端口      docker run -it -P tomcat
            AS.AD

        docker ps[options] 查看正在运行的容器
        OPTION 说明：
            1、-a 列出当前正在运行的+历史上运行过的
            2、-l 显示最近创建的容器
            3、-n 显示最近n个创建的容器
            4、-q 静默模式 只显示容器ID
            5、 --no-trunk 不截断输出
        
        退出容器
            1、exit 容器停止退出
            2、control + p + q 容器不停止退出

        启动/停止容器
            1、docker start +   容器ID/容器名称
            2、docker stop  +   容器ID/容器名称
            3、docker restart + 容器ID/容器名称
            4、docker kill  +   容器ID/容器名称  强制停止容器

        删除容器
            1、docker rm + 容器ID
            2、docker rm -f + 容器ID
            3、docker rm -f $(docker ps -qa )  或者 docker ps -qa | xagrs docker rm 一次性删除多个容器

        docker容器后台启动 docker run -d centos  注意：docker ps -a 查看发现容器已经退出（这是docker机制问题）
                如何解决呢 加一个客户端 比如 docker run -d centos /bin/sh -c "while true; do echo zhangfuyin;sleep 3; done"

        docker logs 查看容器日志 docker logs -t -f -tail 4 容器ID
        OPTION 说明：
            1、-t 加入时间戳
            2、-f 跟随最新的日志打印
            3、-tail 数字  显示最后多少条

        docker top 容器ID 查看容器内运行的进程

        docker inspect 容器ID 查看容器内部细节
        
        进入容器：
              docker attach 容器ID  进入容器内部
              docker exec -it 容器ID ls -l /opt 不进入容器  执行容器命令返回结果
              
        容器文件备份到宿主机上  docker cp 容器ID:文件路径 宿主机文件路径
        
        docker commit 提交容器副本 使之成为新的镜像
               docker commit -a='zhangfuyin' -m='remove doc' 容器ID
               
   ### 4、容器数据卷
        1、作用 数据持久化、容器间继承 + 共享数据
        
        2、如何添加数据卷呢  
           * 命令行 实现宿主机和容器的数据共享
              1、docker run -it -v 宿主机路径：容器路径 镜像ID   eg： (docker run -it -v /hostDataVolume: /containerDataVolume 2cd663b9e521)
              2、如何查看容器和宿主机数据挂载成功（数据共享）呢？ docker inspect 
              3、比如容器停止后、修改宿主机数据 、重新启动容器  数据是否同步呢？  答案是同步的
              4、带权限的数据共享 比如让容器文件只读操作  eg:(docker run -it -v /hostDataVolume:/contailnerDataVolume:ro 2cd663b9e521) 执行上述命令 容器的目录只读 无法更改
              
              
              
           * dockerfile 体系结构
              *
         
   
   

        
        
        
        
        

