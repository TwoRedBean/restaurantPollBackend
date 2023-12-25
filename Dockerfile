FROM openjdk:17-jdk-alpine
ARG JARFILE=target/*.jar
COPY ./target/restaurantPollBackend-0.0.1-SNAPSHOT.jar restaurantPollBackend.jar
ENTRYPOINT ["java","-jar","/restaurantPollBackend.jar"]