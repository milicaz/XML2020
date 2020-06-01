FROM openjdk:8-jdk-alpine
EXPOSE 8800
WORKDIR /app
COPY ./service/search-service.jar ./
CMD ["java", "-jar", "search-service.jar"]
