## 三要素
        容器、镜像、仓库

## docker run imageName 到底执行了什么？
![image](https://github.com/zhangfuyin/java/blob/master/docker/images/docker_run.jpeg

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

        docker logs 查看容器日志 docker logs -t -f -tail 4 容器ID
        OPTION 说明：
            1、-t 加入时间戳
            2、-f 跟随最新的日志打印
            3、-tail 数字  显示最后多少条

        docker top 容器ID 查看容器内运行的进程

        docker inspect 容器ID 查看容器内部细节
