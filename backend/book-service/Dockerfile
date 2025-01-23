FROM openjdk:17-alpine
ARG JAR_FILE=/build/libs/book-service*.jar
COPY ${JAR_FILE} book-service.jar
ENTRYPOINT [ "java", "-jar", "book-service.jar" ]
EXPOSE 9090