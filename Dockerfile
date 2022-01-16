FROM tomcat:8.0.20-jre8

RUN apt-get update && \
    apt-get install -y nano
COPY target/TODOapp*.war /usr/local/tomcat/webapps/todoapp.war
