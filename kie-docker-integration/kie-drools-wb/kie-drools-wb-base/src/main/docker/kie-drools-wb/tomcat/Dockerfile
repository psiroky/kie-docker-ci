####### BASE ############
FROM tomcat:7.0.61-jre7

####### MAINTAINER ############
MAINTAINER "Roger Martinez" "romartin@redhat.com"

####### ENVIRONMENT ############
ENV JAVA_OPTS -XX:MaxPermSize=256m -Xms256m -Xmx512m
ENV CATALINA_OPTS -Xmx512M -XX:MaxPermSize=512m -Dbtm.root=$CATALINA_HOME -Dbitronix.tm.configuration=$CATALINA_HOME/conf/btm-config.properties
ENV KIE_CONNECTION_URL jdbc:h2:file:~/jbpm
ENV KIE_CONNECTION_DRIVER h2
ENV KIE_CONNECTION_USER sa
# Empty password by default
# ENV KIE_CONNECTION_PASSWORD 
ENV KIE_CONNECTION_DATABASE kie
LABEL org.kie.kie-drools-wb.artifact=${kie.docker.drools-wb.tomcat7.repositoryPath}

####### KIE-DROOLS-WB & SITE WAR############
ADD maven/kie-drools-wb.war $CATALINA_HOME/webapps/kie-drools-wb.war
ADD maven/site $CATALINA_HOME/webapps/site

RUN unzip -q -d $CATALINA_HOME/webapps/kie-drools-wb $CATALINA_HOME/webapps/kie-drools-wb.war && \
rm -rf $CATALINA_HOME/webapps/kie-drools-wb.war && \
unzip -q -d $CATALINA_HOME/webapps/site $CATALINA_HOME/webapps/site/kie-drools-wb-site.jar && \
rm -rf $CATALINA_HOME/webapps/site/kie-drools-wb-site.jar

####### TOMCAT EXTRA LIBRARIES ############
ADD maven/tomcat-libs/btm-2.1.4.jar $CATALINA_HOME/lib/btm-2.1.4.jar
ADD maven/tomcat-libs/btm-tomcat55-lifecycle-2.1.4.jar $CATALINA_HOME/lib/btm-tomcat55-lifecycle-2.1.4.jar
ADD maven/tomcat-libs/h2-1.3.161.jar $CATALINA_HOME/lib/h2-1.3.161.jar
ADD maven/tomcat-libs/jta-1.1.jar $CATALINA_HOME/lib/jta-1.1.jar
ADD maven/tomcat-libs/slf4j-api-1.7.12.jar $CATALINA_HOME/lib/slf4j-api-1.7.12.jar
ADD maven/tomcat-libs/javax.security.jacc-api-1.5.jar $CATALINA_HOME/lib/javax.security.jacc-api-1.5.jar
ADD maven/tomcat-libs/kie-tomcat-integration.jar $CATALINA_HOME/lib/kie-tomcat-integration.jar
ADD maven/tomcat-libs/mysql-connector-java-5.1.35.jar $CATALINA_HOME/lib/mysql-connector-java-5.1.35.jar
ADD maven/tomcat-libs/postgresql-9.1-901-1.jdbc4.jar $CATALINA_HOME/lib/postgresql-9.1-901-1.jdbc4.jar

####### TOMCAT CONF FILES ############
ADD etc/btm-config.properties  $CATALINA_HOME/conf/btm-config.properties
ADD etc/context.xml  $CATALINA_HOME/conf/context.xml
ADD etc/resources.properties.template  $CATALINA_HOME/conf/resources.properties.template
ADD etc/server.xml  $CATALINA_HOME/conf/server.xml
ADD etc/tomcat-users.xml  $CATALINA_HOME/conf/tomcat-users.xml
ADD etc/start_kie-drools-wb.sh  $CATALINA_HOME/bin/start_kie-drools-wb.sh
ADD etc/update-jpa-config.sh  $CATALINA_HOME/bin/update-jpa-config.sh
RUN chmod +x $CATALINA_HOME/bin/*.sh

####### EXPOSE INTERNAL KIE-DROOLS-WB GIT PORT ############
EXPOSE 8001

####### RUNNING KIE_DROOLS-WB ############
WORKDIR $CATALINA_HOME/bin
CMD ["./start_kie-drools-wb.sh"]