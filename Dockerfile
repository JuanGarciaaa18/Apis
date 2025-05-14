FROM ubuntu:latest As build
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .
RUN ./mvnw spring-boot:run  --no-daemon

FROM openjdk:21-jdk-slim
EXPOSE 8080
COPY --from=target/*.jar how-much-pay-api-0.0.1.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
