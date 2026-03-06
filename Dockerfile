FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/java-app-1.0.jar app.jar

EXPOSE 8081

CMD ["java","-jar","app.jar"]
