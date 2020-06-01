FROM openjdk:8-jdk-alpine
EXPOSE 8900
WORKDIR /app
COPY ./service/message-service.jar ./
CMD ["java", "-jar", "message-service.jar"]
