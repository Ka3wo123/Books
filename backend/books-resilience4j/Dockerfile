FROM gradle:8.11.1-jdk17-alpine AS build

WORKDIR /app/backend/books-hystrix

COPY . .

RUN gradle clean build --no-daemon -x test

FROM openjdk:17-alpine

WORKDIR /app/backend/books-hystrix

COPY --from=build /app/backend/books-hystrix/build/libs/books-hystrix-*.jar books-hystrix.jar

CMD [ "java", "-jar", "books-hystrix.jar" ]