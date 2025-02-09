# Use the official OpenJDK 17 slim image as the base
#FROM openjdk:17-jdk-slim

# Set the working directory inside the container
#WORKDIR /app

# Copy the packaged JAR file into the container
#COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (default is 8080 for Spring Boot)
#EXPOSE 8080

# Command to run the Spring Boot application
#ENTRYPOINT ["java", "-jar", "app.jar"]



#FROM maven:3.8.5-openjdk-17 AS builder
#WORKDIR /app
FROM openjdk:17-jdk-slim
COPY src ./src
COPY pom.xml .
RUN mvn package 

FROM openjdk:17-jdk-slim
COPY --from=builder /shubham_project/target/backend-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]