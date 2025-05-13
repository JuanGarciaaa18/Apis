# Etapa 1: Compilar el proyecto
FROM eclipse-temurin:17-jdk AS build

# Copiar código fuente al contenedor
COPY . /app
WORKDIR /app

# Construir el JAR
RUN ./mvnw clean package -DskipTests

# Etapa 2: Crear imagen final
FROM eclipse-temurin:17-jdk

# Copiar el JAR generado desde la etapa de build
COPY --from=build /app/target/nightplus-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "/app.jar"]
