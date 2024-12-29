
FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/RoomRental-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
#Build project
RUN mvn clean package

#expose port 8070
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "/app.jar"]




























