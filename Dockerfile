# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container at /app
COPY target/Coding-1.0-SNAPSHOT.jar /app/Coding-1.0-SNAPSHOT.jar

# Expose the port that your application will run on (Render expects 8080)
EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "Coding-1.0-SNAPSHOT.jar"]