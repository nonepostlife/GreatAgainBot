FROM openjdk:11
WORKDIR /
COPY target/GreatAgainBot*.jar /app/GreatAgainBot.jar
EXPOSE 8383
CMD ["java", "-jar", "/app/GreatAgainBot.jar"]