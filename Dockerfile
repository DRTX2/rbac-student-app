# Usa una imagen ligera de Java 17
FROM eclipse-temurin:21-jdk-jammy

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR al contenedor
COPY target/students-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto (Render usa el 10000 por defecto)
EXPOSE 10000

# Ejecuta la app
ENTRYPOINT ["java", "-jar", "app.jar"]
