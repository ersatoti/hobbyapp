FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
COPY ./build/libs/hobbyapp-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
#CMD ["java", "-Dspring.data.mongodb.uri=mongodb://mongodb:27017/hobby","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
#ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo:27017/hobby", "-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
