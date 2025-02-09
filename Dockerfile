# Use the official OpenJDK 17 slim image as the base
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/*.jar backend-0.0.1-SNAPSHOT.jar

# Expose the application port (default is 8080 for Spring Boot)
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]
