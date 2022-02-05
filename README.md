# Simple Web Application

一個簡單的web application範例，base on `ZK8.0.2.2` + `jdk8` + `wildfly11`  
程式打包為image並以container方式運行


## 建置

### 1. war file

```shell
$ ./gradlew clean build
```

### 2. docker image

```shell
$ docker build -t ${image_tag} .
```

## 執行

透過docker執行，並將主機上port 8080映射至container port 8080
```shell
$ docker run -d --rm -p 8080:8080 ${image_tag}
```
