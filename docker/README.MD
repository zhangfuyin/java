## 三要素
容器、镜像、仓库
## docker run imageName 到底执行了什么？
![](https://github.com/zhangfuyin/java/raw/master/docker/images/docker_run.jpeg)
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

