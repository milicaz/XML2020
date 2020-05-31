FROM openjdk:8-jdk-alpine
EXPOSE 8081
WORKDIR /app
COPY ./service/authentication-service.jar ./
CMD ["java", "-jar", "authentication-service.jar"]
