# 1단계: 빌드 이미지 생성
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# 프로젝트의 모든 파일을 Docker 컨테이너에 복사
COPY . .

# Gradle 실행 권한 부여
RUN chmod +x ./gradlew

# 프로젝트 빌드 (여기서 :domestic 모듈을 빌드)
RUN ./gradlew clean :domestic:build

# 빌드 결과물 (JAR 파일)을 실행 이미지로 복사
COPY /app/domestic/build/libs/domestic-0.0.1-SNAPSHOT.jar /app/domestic.jar

# 컨테이너 시작 시 실행할 명령어
CMD ["java", "-jar", "/app/domestic.jar"]