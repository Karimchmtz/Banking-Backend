# syntax=docker/dockerfile:1

FROM openjdk:17-oracle

# copy the packaged jar file into our docker image
COPY target/api-0.0.1-SNAPSHOT.jar /api.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/api.jar"]