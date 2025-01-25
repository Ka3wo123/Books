FROM gradle:8.11.1-jdk17-alpine AS build

WORKDIR /app/backend/books-gateway

COPY . .

RUN gradle clean build --no-daemon -x test

FROM openjdk:17-alpine

WORKDIR /app/backend/books-gateway

COPY --from=build /app/backend/books-gateway/build/libs/books-gateway-*.jar books-gateway.jar

CMD [ "java", "-jar", "books-gateway.jar" ]