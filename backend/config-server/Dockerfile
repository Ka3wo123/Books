FROM gradle:8.11.1-jdk17-alpine AS build

WORKDIR /app/backend/config-server

COPY . .

RUN gradle clean build --no-daemon -x test

FROM openjdk:17-alpine

WORKDIR /app/backend/config-server

COPY --from=build /app/backend/config-server/build/libs/config-server-*.jar config-server.jar

CMD [ "java", "-jar", "config-server.jar" ]