FROM openjdk:8-jdk-alpine
EXPOSE 8700
WORKDIR /app
COPY ./service/rating-service.jar ./
CMD ["java", "-jar", "rating-service.jar"]
