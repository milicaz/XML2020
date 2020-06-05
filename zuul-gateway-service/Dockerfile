FROM openjdk:8-jdk-alpine
EXPOSE 8762
WORKDIR /app
COPY ./target/zuul-gateway-service.jar ./
CMD ["java", "-jar", "zuul-gateway-service.jar"]
