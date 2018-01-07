#!/bin/sh
warFrom="zkweb100.war"
warTo="zkweb.war"

if [ "$1" != "" ]
then
     warFrom=$1
fi

if [ "$2" != "" ]
then
    warTo=$2
fi
echo "$warFrom => $warTo"

docker build -t shihxuancheng/wildfly-cluster --build-arg WAR_FILE_FROM=$warFrom --build-arg WAR_FILE_DEPLOY=$warTo .
