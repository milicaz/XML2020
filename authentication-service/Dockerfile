FROM openjdk:8-jdk-alpine
EXPOSE 9100
WORKDIR /app
COPY ./target/authentication-service.jar ./
CMD ["java", "-jar", "authentication-service.jar"]
