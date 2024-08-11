FROM openjdk:17-jdk-slim

VOLUME /tmp

CMD ["./gradlew", "clean", ":domestic:build"]

ARG JAR_FILE=domestic/build/libs/domestic-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} myapp.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/myapp.jar"]