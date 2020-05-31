FROM openjdk:8-jdk-alpine
EXPOSE 8082
WORKDIR /app
COPY ./service/car-service.jar ./
CMD ["java", "-jar", "car-service.jar"]
