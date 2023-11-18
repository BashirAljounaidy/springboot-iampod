FROM maven:3.9.4-eclipse-temurin-17-alpine AS build

WORKDIR /app

COPY ./pom.xml pom.xml

RUN mvn dependency:go-offline -B

COPY . .

RUN mvn package -DskipTests

CMD ["mvn", "spring-boot:run"]