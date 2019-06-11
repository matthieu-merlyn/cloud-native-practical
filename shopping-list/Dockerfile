FROM maven:3-jdk-8-alpine as builder
LABEL maintainer="matthieu.merlyn@kbc.be"

COPY src/ /opt/src/
COPY pom.xml /opt/
WORKDIR /opt

RUN mvn -B package -DskipTests

FROM openjdk:8-jre-alpine

COPY --from=builder /opt/target/shopping-list-0.0.1-SNAPSHOT.jar /opt/app.jar
ADD src/main/resources/application.properties /config/application.properties

EXPOSE 8080
EXPOSE 8443

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/opt/app.jar", "-Dspring.config.location=/config/application.properties" ]
