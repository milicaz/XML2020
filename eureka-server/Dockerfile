FROM openjdk:8-jdk-alpine
EXPOSE 8761
WORKDIR /app
COPY ./target/eureka-server.jar ./
CMD ["java", "-jar", "eureka-server.jar"]
