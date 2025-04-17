# Use OpenJDK as the base image
FROM openjdk:17-jdk-slim as build

# Set the working directory
WORKDIR /app

# Copy the jar file from your target directory into the container
COPY target/your-springboot-app.jar app.jar

# Expose the port your application will run on
EXPOSE 8083

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]