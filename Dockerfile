FROM eclipse-temurin:17-jdk-alpine
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon


FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/Movie-App-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]