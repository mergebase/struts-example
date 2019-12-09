FROM tomcat:8.5

COPY target/struts2-showcase.war webapps/
COPY inoculator-1.0-SNAPSHOT.jar .

EXPOSE 8080

CMD ["catalina.sh", "run"]