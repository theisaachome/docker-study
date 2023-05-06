## Spring boot with Docker file

1. Create Spring boot project with restful webservice endpoint
2. build spring boot project 
   ```sh 
     mvn clean install
   ```
   Copy the file name from /target/(generated jar )
3. Create Dockerfile 
    ```shell
    FROM eclipse-temurin:17
    
    LABEL mentainer="devop@highway65.com"
    
    WORKDIR /app
    
    COPY target/spring-boot-dockerfile-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar
    
    ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]
    ```

4. Build Docker images from Docker file   
   docker build -t (docker image name) . 
    ```sh 
     docker build -t springboot-docker-demo:0.1-release .
   ```
5. Running  Docker Container from the image

   ```sh 
    docker run -p 8080:8080 springboot-docker-demo
   ```
    Running in Detached mode
   ```sh 
    docker run -p 8080:8080 -d springboot-docker-demo
   ```
   Monitoring Docker log
   ```sh 
    docker logs -f 414235 (container-id)
   ```
   Stop Running Container 
   ```sh 
    docker stop (container-id)
   ```
   
6. Pushing Docker Image to Dockerhub
    
    login at dockerhub from terminal 
    
    ```sh 
    docker login
    ```
    
    ```shell
    docker tag spring-boot-docker-demo isaachome/springboot-docker-demo:0-1-release
    ```
7. Push to DockerHub
    ```shell
    docker push isaachome/springboot-docker-demo:0-1-release
   ```