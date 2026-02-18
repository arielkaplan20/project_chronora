FROM eclipse-temurin:11-jre
COPY target/project_chronora*.jar /usr/src/project_chronora.jar
COPY src/main/resources/application.properties /opt/conf/application.properties
CMD ["java", "-jar", "/usr/src/project_chronora.jar", "--spring.config.location=file:/opt/conf/application.properties"]