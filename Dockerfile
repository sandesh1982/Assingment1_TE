FROM openjdk:8
ADD target/springboot2-jpa-crud-example-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","springboot2-jpa-crud-example-0.0.1-SNAPSHOT.jar"]