FROM openjdk:17

WORKDIR /app

COPY ./target/kafka.jar /app

EXPOSE 8080

CMD ["java","-jar","kafka.jar"]

