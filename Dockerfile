FROM maven:3.9.4-eclipse-temurin-17-alpine AS build

WORKDIR /app

COPY ./pom.xml pom.xml

RUN mvn dependency:go-offline -B

COPY . .

RUN mvn package -DskipTests


FROM openjdk:17-alpine AS prod

WORKDIR /app

COPY --from=build /app/target/iampod-*.jar /app/app.jar

EXPOSE 8080

Entrypoint ["java", "-jar", "app.jar"]