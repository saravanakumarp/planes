FROM openjdk:8
EXPOSE 8080
ADD target/planes-docker.jar planes-docker.jar 
ENTRYPOINT ["java","-jar","/planes-docker.jar"]