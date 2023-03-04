FROM openjdk:8-jdk-alpine

EXPOSE 8080

ADD target/NetolStringBootRest-0.0.1-SNAPSHOT.jar myAppAuth.jar

CMD ["java", "-jar", "myAppAuth.jar"]