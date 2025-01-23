FROM gradle:8.11.1-jdk17-alpine AS build

WORKDIR /app/backend/books-inventory

COPY . .

RUN gradle clean build --no-daemon -x test

FROM openjdk:17-alpine

WORKDIR /app/backend/books-inventory

COPY --from=build /app/backend/books-inventory/build/libs/books-inventory-*.jar books-inventory.jar

CMD [ "java", "-jar", "books-inventory.jar" ]