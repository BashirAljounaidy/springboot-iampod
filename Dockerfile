FROM maven:3.9.4-eclipse-temurin-17-alpine AS build

WORKDIR /app

COPY ./pom.xml pom.xml



COPY . .

CMD ["mvn", "spring-boot:run", "-DskipTests"]