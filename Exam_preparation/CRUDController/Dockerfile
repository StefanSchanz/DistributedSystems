FROM openjdk:11
RUN mkdir -p /opt/CRUDController
WORKDIR /opt/CRUDController
COPY target/CRUDController-0.0.1-SNAPSHOT.jar /opt/CRUDController
CMD ["java", "-jar", "CRUDController-0.0.1-SNAPSHOT.jar" ]
