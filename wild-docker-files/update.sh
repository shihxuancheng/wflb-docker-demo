#!/bin/bash
for x in $(docker ps -q -f "ancestor=shihxuancheng/wildfly-cluster")
do 
    docker stop $x
    docker cp ./$1 $x:/opt/jboss/wildfly/standalone/deployments/$2
    docker start $x
done