# Simple Web Application

一個簡單的web application範例

## 建置

### build war file

```shell
$ ./gradlew clean build
```

### build docker image

```shell
$ docker build -t ${image_tag} .
```

## 執行

透過docker執行，並將主機上port 8080映設至container port 8080
```shell
$ docker run -d --rm -p 8080:8080 ${image_tag}
```
