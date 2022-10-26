FROM openjdk:11.0.1-jre-slim
ARG JAR_FILE
ADD ${JAR_FILE} /home/springboot.jar
ENTRYPOINT java -jar $JAVA_OPTS /home/springboot.jar
