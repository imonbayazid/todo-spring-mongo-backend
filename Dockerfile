#FROM tomcat:8.0.20-jre8
FROM tomcat:7.0.67-jre7
COPY target/TODOapp*.war /usr/local/tomcat/webapps/todoapp.war
