FROM openjdk:8-jre-alpine
COPY ./target/tms-backend-0.0.1-SNAPSHOT.jar usr/src/demir/
WORKDIR /usr/src/demir
EXPOSE 8080:80
CMD ["java", "-jar", "tms-backend-0.0.1-SNAPSHOT.jar"]
MAINTAINER Murat Demir