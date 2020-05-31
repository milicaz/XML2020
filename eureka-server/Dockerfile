FROM openjdk:8-jdk-alpine
EXPOSE 8088
WORKDIR /app
COPY ./service/eureka-server.jar ./
CMD ["java", "-jar", "eureka-server.jar"]
