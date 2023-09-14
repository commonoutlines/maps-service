FROM lolhens/baseimage-openjre
ADD target/map-service-0.0.1-SNAPSHOT.jar springbootApp.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "springbootApp.jar"]