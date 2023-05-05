# Docker Work Flow

- Develop
- Test
- Deploy

---

1. Create Github Repo

Create Branches

1.1 Feature  
1.2 Master

---

### Docker Purpose

A tool in a normal development flow.  
It makes some of the task a lot easier.

### Project lab

- Create React Project

```sh
npm install -g create-react-app

# create react project
create-react-app frontend
```

---

### Necessary Commands

```sh
npm run start

npm run test

npm run build
```

---

## Creating Docker file

One for Development  
Dockerfile.dev

```sh
FROM node:alpine

WORKDIR '/app'

COPY package.json .
RUN npm install

COPY . .
CMD ["npm","run","start"]

```

### Build the Dockerfile.dev

```sh
docker build -f Dockerfile.dev .
```

### Run the container

copy the image id from build result

```sh
docker run -p 3000:3000 (image-id)
```

### Docker Volume

```sh
docker run -p 3000:3000 -v /app/node_modules -v $(pwd):/app (image-id)
```

---

### Shorthand with Docker Compose

create docker compose file

```sh
version: '3'
services:
  web:
    build:
      context: .
      dockerfile: Dockerfile.dev
    ports:
      - "3000:3000"
    volumes:
      - /app/node_modules
      - .:/app
```

### run the docker-compose file

```sh
docker-compose up
```

### runing npm run test

```sh
docker build -f Dockerfile.dev .

docker run (image-id) npm run test

docker run -it (image-id) npm run test
```

---

One for Production

Dockerfile
