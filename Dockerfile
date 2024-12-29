# Use OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Create a volume
VOLUME /tmp

# Argument for the JAR file
ARG JAR_FILE=target/RoomRental-0.0.1-SNAPSHOT.jar

# Copy the built JAR into the container
COPY ${JAR_FILE} app.jar

# Expose port 8070
EXPOSE 8070

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
