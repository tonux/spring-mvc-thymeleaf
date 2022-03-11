# jdk
FROM adoptopenjdk/openjdk11:alpine-jre

#maven build -> fileName
ARG JAR_FILE=target/appTest-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# copy file
COPY --from=build /workspace/target/appTest-0.0.1-SNAPSHOT.jar app.jar

# java -jar
ENTRYPOINT ["java", "-jar", "app.jar"]