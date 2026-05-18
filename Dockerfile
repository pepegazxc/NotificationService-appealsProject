FROM eclipse-temurin:21-jdk

WORKDIR /notification-service

COPY target/notification-service.jar notification-service.jar

EXPOSE 8083

ENTRYPOINT ["java" , "-jar", "notification-service.jar"]