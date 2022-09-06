FROM java:8
ADD target/geofence-0.0.1-SNAPSHOT.jar geofence-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","geofence-0.0.1-SNAPSHOT.jar"]