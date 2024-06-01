FROM maven:3-openjdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11-jdk-slim-sid
COPY --from=build /target/bookclub-0.0.1-SNAPSHOT.jar bookclub.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","bookclub.jar"]