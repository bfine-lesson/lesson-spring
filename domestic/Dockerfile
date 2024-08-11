FROM openjdk:17-jdk-slim

CMD ["./gradlew", ":domestic:build"]

VOLUME /tmp

ARG JAR_FILE=domestic/build/libs/domestic-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} myapp.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]