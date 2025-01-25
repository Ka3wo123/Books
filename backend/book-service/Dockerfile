FROM gradle:8.11.1-jdk17-alpine AS build

WORKDIR /app/backend/book-service

COPY . .

RUN gradle clean build --no-daemon -x test

FROM openjdk:17-alpine

WORKDIR /app/backend/book-service

COPY --from=build /app/backend/book-service/build/libs/book-service-*.jar book-service.jar

CMD [ "java", "-jar", "book-service.jar" ]