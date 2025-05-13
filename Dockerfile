# Imagen base con JDK 17 (la más usada para Spring Boot 3.x)
FROM eclipse-temurin:17-jdk

# Copia el archivo JAR al contenedor
ARG JAR_FILE=target/nightplus-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Exponer el puerto (Render usa variable PORT pero Spring Boot puede quedarse en 8080)
EXPOSE 8080

# Comando para arrancar tu aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
