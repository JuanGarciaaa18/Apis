# Build stage: compila el proyecto
FROM maven:3.9-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Runtime stage: corre la app
FROM amazoncorretto:17-alpine-jdk
COPY --from=build /app/target/nightplus-0.0.1-SNAPSHOT.jar /api-v1.jar

# Comando que ejecutará Render en el contenedor
ENTRYPOINT ["java", "-jar", "/api-v1.jar"]
