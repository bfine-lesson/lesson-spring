# 1. 빌드 단계
FROM openjdk:17-jdk-slim as builder

# 2. 모든 파일을 컨테이너로 복사
WORKDIR /app
COPY . .

# 3. Gradle Wrapper에 실행 권한 부여
RUN chmod +x ./gradlew

# 4. Gradle을 사용하여 프로젝트 빌드
RUN ./gradlew clean :domestic:build --no-daemon

# 2. 실행 단계
FROM openjdk:17-jdk-slim

# 3. 빌드 단계에서 생성된 JAR 파일을 실행 단계로 복사
COPY --from=builder /app/domestic/build/libs/*.jar /app.jar

# 4. 컨테이너에서 사용할 포트 노출
EXPOSE 8080

# 5. 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]