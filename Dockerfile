# Etapa 1: Build del proyecto
FROM eclipse-temurin:17-jdk AS build

# Copia el código fuente al contenedor
COPY . /app
WORKDIR /app

# Da permisos de ejecución al wrapper de Maven
RUN chmod +x mvnw

# Compila el proyecto
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagen final para ejecutar la app
FROM eclipse-temurin:17-jdk

# Copia el JAR generado desde la etapa build
COPY --from=build /app/target/nightplus-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "/app.jar"]
