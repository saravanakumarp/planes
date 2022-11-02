FROM openjdk:8
EXPOSE 8080
ADD target/Planes.jar Planes.jar 
ENTRYPOINT ["java","-jar","/Planes.jar"]