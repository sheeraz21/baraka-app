FROM maslick/minimalka:jdk11
EXPOSE 8080
ADD /target/baraka-app-0.0.1-SNAPSHOT.jar baraka-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","baraka-app-0.0.1-SNAPSHOT.jar","-web -webAllowOthers -tcp -tcpAllowOthers -browser"]