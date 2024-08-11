FROM openjdk:17-jdk-slim

VOLUME /tmp

CMD ["./gradlew", "build"]

ARG JAR_FILE=build/libs/domestic-0.0.1-SNAPSHOT.jar

CMD ["pwd"]

COPY ${JAR_FILE} myapp.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/myapp.jar"]