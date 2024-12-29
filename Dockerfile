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
