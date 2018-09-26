FROM java:8

MAINTAINER zlikun <https://zlikun.com/>

ADD open-async-notify-1.0.0.jar /opt/app.jar

EXPOSE 80

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/opt/app.jar"]
