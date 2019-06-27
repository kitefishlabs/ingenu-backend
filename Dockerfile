FROM openjdk:8-alpine

COPY target/uberjar/ingenu-backend.jar /ingenu-backend/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/ingenu-backend/app.jar"]
