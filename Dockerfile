FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /home/gradle/src
COPY . .
RUN chmod +x ./gradlew && ./gradlew build --no-daemon

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]