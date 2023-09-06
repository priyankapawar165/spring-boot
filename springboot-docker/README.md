# springboot-docker
How to Dockerize Spring Boot Application

# Build Docker Image
$ docker build -t springboot-docker-3.1.3.jar .

# Check Docker Image
$ docker image ls

# Run Docker Image
$ docker run -p 8888:8888 springboot-docker-3.1.3.jar

In the run command, we have specified that the port 8888 on the container should be mapped to the port 9090 on the Host OS.