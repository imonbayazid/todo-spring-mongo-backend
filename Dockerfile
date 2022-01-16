FROM tomcat:8.0.20-jre8

RUN ["apt-get", "update"]
RUN ["apt-get", "install", "-y", "vim"]
COPY target/TODOapp*.war /usr/local/tomcat/webapps/todoapp.war
