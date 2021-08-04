FROM openjdk:8-jre-alpine
CMD mvnw clean package -DskipTests
WORKDIR /app/backend
COPY target/orange-0.0.1-SNAPSHOT.jar ./app.jar
CMD ["/usr/bin/java", "-jar", "app.jar"]
