FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY src ./src
COPY pom.xml .
RUN mvn package  # This generates the target directory

FROM openjdk:17-jre-slim
COPY --from=builder /app/target/app.jar /app.jar