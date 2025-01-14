# Use Maven image with JDK 17
FROM maven:3.9.4-eclipse-temurin-17 as builder

# Set working directory
WORKDIR /app

# Copy the application source code
COPY . .

# Build the application
RUN mvn clean package

# Use a lightweight JDK image for running the application
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/agora-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 9090

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
