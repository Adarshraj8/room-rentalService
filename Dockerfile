# Use a base image with OpenJDK 17
FROM openjdk:17-jdk-slim

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean;

# Set the working directory
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/RoomRental-0.0.1-SNAPSHOT.jar /app/

# Expose the application port (use 1000 if your app runs on port 1000)
EXPOSE 1000

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/RoomRental-0.0.1-SNAPSHOT.jar"]
