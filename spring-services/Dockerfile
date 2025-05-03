FROM gradle:8.13-jdk21 AS build

ARG SERVICE_NAME

WORKDIR /home/gradle/project

COPY build.gradle.kts settings.gradle.kts gradle.properties ./
COPY gradle ./gradle
COPY buildSrc ./buildSrc

COPY ${SERVICE_NAME} ./${SERVICE_NAME}

RUN gradle :${SERVICE_NAME}:build --no-daemon || true

RUN gradle :${SERVICE_NAME}:build --no-daemon

FROM eclipse-temurin:21-jre

ARG SERVICE_NAME

WORKDIR /app

COPY --from=build /home/gradle/project/${SERVICE_NAME}/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]