FROM openjdk:11
RUN mkdir -p /opt/app
WORKDIR /opt/app
COPY target/KubernetesDemo-0.0.1-SNAPSHOT.jar /opt/app/app.jar
CMD ["java", "-jar", "app.jar" ]
