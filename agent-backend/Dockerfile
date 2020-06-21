FROM openjdk:8-jdk-alpine
EXPOSE 8081
WORKDIR /app
COPY ./target/agent-backend.jar ./
CMD ["java", "-jar", "agent-backend.jar"]
