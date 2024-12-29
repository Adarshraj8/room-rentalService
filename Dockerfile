# Use OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Create a volume
VOLUME /tmp

# Argument for the JAR file
ARG JAR_FILE=target/RoomRental-0.0.1-SNAPSHOT.jar

# Copy the application JAR into the container
COPY ${JAR_FILE} app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]




























