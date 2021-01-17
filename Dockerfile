FROM openjdk:17-oraclelinux8
COPY build/libs /usr/src/ArisWorld
WORKDIR /usr/src/ArisWorld/
EXPOSE 8999
ENTRYPOINT ["java", "-jar", "arisWorld-0.0.1-SNAPSHOT.jar"]
