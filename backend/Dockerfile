  FROM openjdk:8

  COPY . /server
  WORKDIR /server

  RUN ./gradlew -no-daemon bootJar

  FROM openjdk:8
 
  COPY --from=0 /server/build/libs/backend-0.0.1-SNAPSHOT.jar /app.jar

   ENTRYPOINT ["java", "-jar", "/app.jar"]


