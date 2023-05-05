# Using Docker with NoSQL Database

Get started by creating the volume that will store the Cassandra database files. This volume uses disk space on the local machine and in a part of the filesystem managed by the Docker engine:

```sh
docker volume create  --driver local --label example=cassandra cass-shared
```

This volume is not associated with any containers;it is just a named bit of disk that can be accessed by containers.

The volume you just created is named cass-shared. In this case, you added a label to the volume with the key example and the value cassandra. Adding label metadata to your volumes can help you organize and clean up volumes later. You’ll use this volume when you create a new container running Cassandra:

```sh
docker run -d --volume cass-shared:/var/lib/cassandra/data --name cass1 cassandra:2.2
```

```sh
docker run -it --rm --link cass1:cass cassandra:2.2 cqlsh cass
```

```sh

select *
from system.schema_keyspaces
where keyspace_name = 'docker_hello_world';
```

```sh

```

## Anonymous volumes and the volumes-from flag

The Docker command line provides another way to specify mount dependencies instead of referencing volumes by name.
The docker run command provides a flag, --volumes-from, that will copy the mount definitions from one or more containers to the new container.

```sh
docker run --name fowler --mount type=volume,dst=/library/PoEAA --mount type=bind,src=/tmp,dst=/library/DSL alpine:latest echo "Fowler collection created."
```

```sh
docker run --name knuth --mount type=volume,dst=/library/TAoCP.vol1 --mount type=volume,dst=/library/TAoCP.vol2 --mount type=volume,dst=/library/TAoCP.vol3 --mount type=volume,dst=/library/TAoCP.vol4.a alpine:latest echo "Knuth collection created"
```

### Lists all volumes as they were copied into new container

```sh
docker run --name reader --volumes-from fowler --volumes-from knuth alpine:latest ls -l /library/
```

### Checks out volume list for reader

```sh
docker inspect --format "{{json .Mounts}}" reader
```

copying the volumes from another container, you’ll also copy the volumes that it copied from some other container.

```sh
docker run --name aggregator --volumes-from fowler --volumes-from knuth alpine:latest echo "Collection Created."
```

```sh
docker run --rm --volumes-from aggregator alpine:latest ls -l /library/
```

## Cleaning up volumes

Single Remove container Volume

```sh
docker volume remove (volume name)
```

list all volumes

```sh
docker volume list
```

---

Create Docker Volume

```sh
docker volume create myVol
```

list all volumes

```sh
docker volume ls
```

inspect detial of the volume

```sh
docker volume inspect myVol(volume-name)
```

---

Hand On Lab

```sh
docker run -itd --name myContainer --mount source=myVol,target=/vol alpine:latest
```

Executing inside container

```sh
docker exec -it myContainer sh
```
