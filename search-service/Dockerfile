FROM openjdk:8-jdk-alpine
EXPOSE 8800
WORKDIR /app
COPY ./target/search-service.jar ./
CMD ["java", "-jar", "search-service.jar"]
