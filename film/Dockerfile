FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x /wait-for-it.sh
ENTRYPOINT ["/wait-for-it.sh","--timeout=40","dbfilm:3306","--","/wait-for-it.sh","--timeout=20","configurationserver:8888","--","java","-jar","/app.jar"]