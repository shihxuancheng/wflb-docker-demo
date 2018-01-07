# IPADDRESS=$(ifconfig | grep -A 1 'eth0' | tail -1 | awk -F ' ' '{print $2}')
IPADDRESS=$(hostname -i)
MCASTADDRESS=234.0.0.4
/opt/jboss/wildfly/bin/standalone.sh -c standalone-ha.xml \
-u ${MCASTADDRESS} \
-b ${IPADDRESS} \
-Djboss.bind.address=${IPADDRESS} \
-Djboss.bind.address.management=${IPADDRESS} \
-Djboss.bind.address.private=${IPADDRESS} \
-Djboss.node.name=$(hostname) \
-u=${MCASTADDRESS}