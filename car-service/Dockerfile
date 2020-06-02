FROM openjdk:8-jdk-alpine
EXPOSE 8600
WORKDIR /app
COPY ./target/car-service.jar ./
CMD ["java", "-jar", "car-service.jar"]
