FROM eclipse-temurin:21-jdk

WORKDIR /norification-service

COPY target/norification-service norification-service.jar

EXPOSE 8083

ENTRYPOINT ["java" , "-jar", "norification-service.jar"]