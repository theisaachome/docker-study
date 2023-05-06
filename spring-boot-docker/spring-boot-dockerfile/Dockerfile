FROM eclipse-temurin:17

LABEL mentainer="devop@highway65.com"

WORKDIR /app

COPY target/spring-boot-dockerfile-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar

ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]