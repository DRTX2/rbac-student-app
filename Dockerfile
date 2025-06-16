# Etapa 1: Compilar con Maven
FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar JAR
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/students-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 10000
ENTRYPOINT ["java", "-jar", "app.jar"]