FROM tomcat:8.5

COPY target/struts2-showcase.war webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]