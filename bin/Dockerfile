# Start with a base image containing Java runtime
FROM openjdk:8
VOLUME /tmp
VOLUME /logs
RUN echo "Africa/Tunis" > /etc/timezone
ADD /target/abt-smw-registry-0.0.1-SNAPSHOT.jar abt-smw-registry-0.0.1-SNAPSHOT.jar
# Run the jar file 
ENTRYPOINT ["java","-jar","abt-smw-registry-0.0.1-SNAPSHOT.jar"]