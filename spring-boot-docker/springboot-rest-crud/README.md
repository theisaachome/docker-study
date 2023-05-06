## Step by Step Springboot CRUD with Mysql and Docker


### Mysql Container Running
1. Create Network in Container   
   MySQL Container will connect other Container.
    ```shell
    docker network ls 
    docker network create spring-mysql-network
   ```
2. Pull Image from Dockerhub
    ```shell
    docker pull mysql
    ```
3. Running the Container from Image
    ```shell
    docker run --name mysqldb --network spring-mysql-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=employeedb -d mysql
    ```
4. Create Dockerfile to build Image for Springboot application
  
   ```shell
    FROM eclipse-temurin:17

    LABEL mentainer="admint@hihghway65.com"

    WORKDIR /app

    COPY target/springboot-rest-crud-0.0.1-SNAPSHOT.jar /app/springboot-restful-webservices.jar

    ENTRYPOINT ["java", "-jar", "springboot-restful-webservices.jar"]
  
   ```
  
5. Build Docker image from dockerfile
  
   ```shell
     docker build -t springboot-restful .
   ```

6. Running Spring boot App Docker Image

```shell
docker run --network spring-mysql-network --name sb-mysql-container -p 8080:8080 -d springboot-restful
```