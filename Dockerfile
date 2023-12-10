FROM openjdk:17
EXPOSE 7070
ADD target/app.jar app.jar
ENTRYPOINT [ "java","-jar","app.jar" ]