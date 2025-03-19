# 1단계: 빌드 환경 (Gradle을 포함한 JDK 사용)
FROM gradle:jdk21-alpine AS build
WORKDIR /app

# Gradle 캐시 활용을 위해 먼저 dependencies를 복사 후 빌드
COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle
COPY libs libs
COPY src/main/resources/jooq src/main/resources/jooq
RUN sed -i 's/\r$//' gradlew # window 환경에서 생성된 파일 이슈
RUN chmod +x ./gradlew
#RUN ./gradlew build -x test --no-daemon --parallel
RUN --mount=type=cache,target=/root/.gradle ./gradlew dependencies

COPY src src
RUN --mount=type=cache,target=/root/.gradle ./gradlew build -x test --daemon

# 2단계: 실행 환경 (JDK만 포함)
FROM amazoncorretto:11-alpine
WORKDIR /app

# 빌드된 JAR 파일을 실행 단계로 복사
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

# 컨테이너 실행 시 JAR 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
