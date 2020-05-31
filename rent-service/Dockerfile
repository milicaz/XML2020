FROM openjdk:8-jdk-alpine
EXPOSE 8085
WORKDIR /app
COPY ./service/rent-service.jar ./
CMD ["java", "-jar", "rent-service.jar"]
