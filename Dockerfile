# Use OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean

# Verify Maven installation (this will print the Maven version during build)
RUN mvn -v

# Create a volume
VOLUME /tmp

# Argument for the JAR file
ARG JAR_FILE=target/RoomRental-0.0.1-SNAPSHOT.jar

# Copy the source code into the container
COPY . .

# Run Maven to build the project
RUN mvn clean package

# Copy the built JAR file into the container
COPY ${JAR_FILE} app.jar

# Expose port 8070
EXPOSE 8070

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
