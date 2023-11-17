FROM maven:3.6.3-openjdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container

# Copy the packaged JAR file into the container at /app
COPY --from=build /target/Coding-1.0-SNAPSHOT.jar Coding-1.0-SNAPSHOT.jar

# Expose the port that your application will run on (Render expects 8080)
EXPOSE 8080

# Specify the command to run on container start
ENTRYPOINT ["java", "-jar", "Coding-1.0-SNAPSHOT.jar"]