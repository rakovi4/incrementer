FROM jboss/wildfly:17.0.1.Final
ARG app
COPY build/libs/$app.war /opt/jboss/wildfly/standalone/deployments/
