#base image
FROM jboss/wildfly:11.0.0.Final

#copy war file from pc into container
COPY build/libs/*.war ${JBOSS_HOME}/standalone/deployments/