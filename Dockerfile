FROM: openjdk:17
ADD target/map-service-0.0.1-SNAPSHOT.jar springbootApp.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "springbootApp.jar"]