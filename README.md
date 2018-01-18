# wflb-docker-demo
Example on how to setup a Wildfly cluster using Docker
<p align="center">
<img src="https://d33wubrfki0l68.cloudfront.net/e29410f43273a18d40e1bd6e41641f5afdfc8057/eb7ca/traefik.logo.png" width="150px"/>
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Plus_font_awesome.svg/2000px-Plus_font_awesome.svg.png" width="35px"/>
<img src="http://logo-logos.com/wp-content/uploads/2016/10/Docker_logo.png" width="200px"/>
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Plus_font_awesome.svg/2000px-Plus_font_awesome.svg.png" width="35px"/>
<img src="https://ms-vsts.gallerycdn.vsassets.io/extensions/ms-vsts/jboss-wildfly-management-extension/0.112.1/1485289762175/Microsoft.VisualStudio.Services.Icons.Default" width="200px"/>
</p>
<p align="center">
    <img src="https://docs.traefik.io/img/architecture.png" width="85%"/>
</p>
## 建立docker image
1. 本地端建立
```
./build.sh
```  

2. Pull from [Docker Hub](https://hub.docker.com/r/shihxuancheng/wildfly-cluster/)
```
docker pull shihxuancheng/wildfly-cluster:latest
```  

## 執行
1. 透過**[Docker cli](https://docs.docker.com/engine/reference/commandline/cli/)**  
    建立private network  
    ``docker network create --driver=bridge --subnet=172.28.0.0/16 --ip-range=172.28.5.0/24 --gateway=172.28.5.254  wildnetwork``  

    執行並執行wildfly docker container  
    ``docker run -d -p 8081:8080 -p 9991:9990 --name wild1 -h wild1 --network wildnetwork -l traefik.backend=wild1 -l traefik.frontend.rule=PathPrefix:/zkweb shihxuancheng/wildfly-cluster``
    
    ``docker run -d -p 8082:8080 -p 9992:9990 --name wild2 -h wild2 --network wildnetwork -l traefik.backend=wild1 -l traefik.frontend.rule=PathPrefix:/zkweb shihxuancheng/wildfly-cluster``  

    建立並執行traefik docker container  
    ``docker run -d -p 9090:8080 -p 80:80 --name wild-balancer --network wildnetwork -l traefik.enable=false -v /var/run/docker.sock:/var/run/docker.sock -v $PWD/traefik.toml:/etc/traefik/traefik.toml traefik``  

2. 透過**[Docker Compose](https://docs.docker.com/compose/)**  
```
docker-compose up -d
```  

## 參考
* [Traefik](https://traefik.io/)  
* [Docker](https://www.docker.com/)  
* [Wildfly](http://wildfly.org/)  

