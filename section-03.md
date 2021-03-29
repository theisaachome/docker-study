## **Section 03: Container Images: Where To Find Them and How To Build Them**

## Table of Contents

- [**Section 03 : Container Images Where To Find Them and How To Build Them**](#section-03-container-images-where-to-find-them-and-how-to-build-them)
- [Table of Contents](#table-of-content)
  - [What's in an image](#what's-in-an-image)
  - [Images and Their Layers](#images-and-their-layers)
  - [Image Tagging and Pushing to Docker Hub](#image-tagging-and-pushing-to-docker-hub)
  - [Building Images The Docker File](#building-images-the-docker-file)
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

### Images and Their Layers

```console
 docker container run --publish 80:80 nginx
```

### Image Tagging and Pushing to Docker Hub

### Building Images The Docker File
