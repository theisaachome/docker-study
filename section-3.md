## **Section 03: Container Images: Where To Find Them and How To Build Them**

## Table of Contents

- [**Section 03 : Container Images Where To Find Them and How To Build Them**](#section-03-container-images-where-to-find-them-and-how-to-build-them)
- [Table of Contents](#table-of-content)
  - [What's in an image](#what's-in-an-image)
  - [What happens When we run a Container](#what-happens-when-we-run-a-container)
  - [lab](#lab)
  - [What's Going On In Container](#what's-going-on-in-container)
  - [Getting A Shell Inside Containers](#Getting-a-shell-inside-containers)
  - [Docker Networks: Concepts](#docker-networks-concepts)

## What's in an image

- App binaries and dependencies.
- Metadata about the image data and how to run the image.
- Not Complete OS.
- No kernel
- No kernel moudles (e.g. drivers)
- It can be small as ONE file (your app binary) like
  a golang static binary
- Big as a Ubuntu distro with apt, and Apache, PHP
  and more installed.

### running Nginx Web Server

```console
 docker container run --publish 80:80 nginx
```

### run at brower

```console
localhost
```

picture here

### what docker does behind

- Download image 'nginx' from docker hub
- Start a new container from that image
- open port 80 on the host IP
- Routes that traffice to the container IP, port 80.
- note: port on the left can be any port

```console
 docker container run --publish 9999:80 nginx
```

- then use localhost:9999

### To run the container in the background

```console
 docker container run --publish 9999:80 --detach nginx
```

### list all containers that running

- (new version) command

```console
docker container ls

docker container ls -a
```

- old version command

```console
 docker ps
```

### stop container

```console
docker container stop  69088 (container id )
```

### docker run vs docker start

```console
docker container run
```

- always starts a new container

---

```console
docker container start
```

- to start an existing one which is currently stop.

---

### give a container a name

- --name for giving a name to container

```console
 docker container run --publish 9999:80 --detach --name higway65 nginx
```

---

### logs container

```console
 docker container logs highway65 (name or id)
```

---

### remove container

- use -f for force to delete in case if container is still running

```console
 docker container rm 632 878 898 [container Ids]
```

**[⬆ back to top](#table-of-contents)**

---

### What happens When we run a Container

---

- Looks for that image locally if not found then look in remote repository (defaults to Docker hub).
- Downlaod the latest version (nginx:latest by default).
- Creates new container based on that image.
- Give virtual IP on a private network inside docker engine.
- opens up port 80 on host and forwards to port 80 in container.

  **[⬆ back to top](#table-of-contents)**

### Lab

- run nginx, mysql, apache server (httpd)
- ngxin port : 80:80
- mysql port : 3307:3306
- httpd port : 8080:80
- note: for mysql
  - use --env option (-e) to pass in
  ```console
  MYSQL_RANDOM_ROOT_PASSWORD=yes
  ```
  - to docker contianer log on mysql to find the random password it created on startup.

### Mysql in docker

```console
docker container run -d -p 3306:3306 --name dockerDB -e MYSQL_RANDOM_PASSWORD=yes mysql
```

- get generated password

```console
docker container logs dockerDB
```

#### Check at console! there we go!

```
GENERATED ROOT PASSWORD : da789afdsjla8754930-09099
```

### https (apache) Server in docker

```console
docker container run -d --name webserver -p 8080:80 httpd
```

### nginx in docker

```console
docker container run -d --name proxy -p 80:80 nginx
```

### Using curl for testing all the container

### Test Nginx

```console
curl localhost
```

### Test httpd

```console
curl localhost:8080
```

---

### What's Going On In Container

- to show process that running in a container
  - mysql container must be running

```console
docker container top mysql
```

- show metadata about the container ( startup config, volumes,networking etc) in json format.

```console
docker container inspect mysql [container name]
```

- show live performance data for all containers

```console
docker container stats
```

**[⬆ back to top](#table-of-contents)**

---

### Getting A Shell Inside Containers

- Start new container interactively

```console
   docker container run -it
```

### note:

- i interactive
  - keep seesion open to receive terminal input.
- t pseudo-tty
  - simulates a real terminal, like what SSH does.

### example

```console
   docker container run -it --name  proxy nginx bash
```

- bash argument : for terminal inside running container.
- run additional command in existing container

---

### Different Linux distros in containers

### ubuntu image

```console
docker container run -it --name ubuntu ubuntu

```

#### then inside ubuntun container

- you can use normal command like

#### example

- updating apt-get update

```console
   apt-get update

  ##instal  curl at terminal
   apt-get install -y curl

  ## test curl
   curl google.com
```

#### Running exisitng container in interactive mode

```console
docker container start -ai ubuntu
```

### Running into mysql shell in contiainers

```console
docker container exec -it mysql bash

##check process inside running container
ps aux

```

**[⬆ back to top](#table-of-contents)**

---

### Docker Networks: Concepts

### Docker Networks defaults:

- Each Container connected to a private virtual netowrk "bridge"

- Each virtual network routes through NAT firewall on host IP

- All containers on a virtual network can talk to each other without -p

- Best practice is to create a new virtual netowrk for each app:

  - network "my_web_app" for mysql and php/apache containers
  - network "my_api" for mongo and nodejs containers.

## Lab

- Publishing ports is always in HOST:CONTAINER format.

- -p [ --publish ] 8888:80

```console
 $ docker container run -p 80:80 --name webhost -d nginx

   ##To check which port is forwwarding traffice to container
 $ docker container port webhost (container name)
```

### Inspect container ip

```console
$ docker container inspect --format '{{.NetworkSettings.IPAddress}}' webhost
```
