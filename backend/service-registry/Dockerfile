FROM gradle:8.11.1-jdk17-alpine AS build

WORKDIR /app/backend/service-registry

COPY . .

RUN gradle clean build --no-daemon -x test

FROM openjdk:17-alpine

WORKDIR /app/backend/service-registry

COPY --from=build /app/backend/service-registry/build/libs/service-registry-*.jar service-registry.jar

CMD [ "java", "-jar", "service-registry.jar" ]