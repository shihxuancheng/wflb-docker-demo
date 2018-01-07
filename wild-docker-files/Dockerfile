FROM jboss/wildfly

# Environment variable with default value
ARG WAR_FILE_FROM=appfile.war
ARG WAR_FILE_DEPLOY=${WAR_FILE_FROM}

#RUN echo ${APP_FILE}

USER root
# RUN yum install net-tools -y

#setup zk module(8.0.2.2)
RUN mkdir -p /zk_lib && \
mkdir -p /opt/jboss/wildfly/modules/system/layers/base/org/zkoss/zk/main && \
curl -#L https://www.zkoss.org/zkdownload/downloadEvalFile?id=1884780989 | bsdtar -xf- -C /zk_lib && \
find /zk_lib/zk-bin-8.0.2.2/dist/lib -name '*.jar' | xargs -I{} cp {} /opt/jboss/wildfly/modules/system/layers/base/org/zkoss/zk/main && \
rm -rf ./zk_lib
COPY module_zk8.xml /opt/jboss/wildfly/modules/system/layers/base/org/zkoss/zk/main/module.xml

# Add your application to the deployment folder
COPY ${WAR_FILE_FROM} /opt/jboss/wildfly/standalone/deployments/${WAR_FILE_DEPLOY}
COPY standalone-ha.xml /opt/jboss/wildfly/standalone/configuration/standalone-ha.xml
COPY startwf-ha.sh /opt/jboss/wildfly/bin/startwf-ha.sh

# Add user for adminstration purpose
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin123 --silent
USER jboss

EXPOSE 8080 9990 45688

CMD ["sh","-c","/opt/jboss/wildfly/bin/startwf-ha.sh"]