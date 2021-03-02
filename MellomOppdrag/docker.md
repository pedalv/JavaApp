# DOCKER
- [Getting Started with Docker](https://app.pluralsight.com/library/courses/getting-started-docker/table-of-contents)
- [Docker and Kubernetes: The Big Picture](https://app.pluralsight.com/library/courses/docker-kubernetes-big-picture/table-of-contents)
- [Docker Deep Dive](https://app.pluralsight.com/library/courses/docker-deep-dive-update/table-of-contents)
- [Docker for Web Developers](https://app.pluralsight.com/library/courses/docker-web-development/table-of-contents)  
- [Docker Networking (TODO)](https://app.pluralsight.com/library/courses/docker-networking/table-of-contents)
- [Docker Swarm: Native Docker Clustering (TODO)](https://app.pluralsight.com/library/courses/docker-swarm-native-docker-clustering/table-of-contents)
- [Integrating Docker with DevOps Automated Workflows (TODO)](https://app.pluralsight.com/library/courses/integrating-docker-with-devops-automated-workflows/table-of-contents)
- [Containerizing Angular Applications with Docker (TODO)](https://app.pluralsight.com/library/courses/containerizing-angular-apps-docker/table-of-contents)

## Resume
- VM world => Virtual Machine
- Kubernets => Pod as apps and nodes as infrastructure
- [docker kitematic](https://github.com/docker/kitematic/releases)
- Docker => Container
  * REGISTER/REPO:IMAGE (tag) => docker.io/redis:latest
  * [github](https://github.com/pedalv)
  * [dockerhub](https://hub.docker.com/u/pedalv)

```
                   <docker Hub ID>/<Repo name>:<Image name>
docker image build -t nigelpoulton/gsd:ctr --no-cache .
```

## YAML
```
- deploy (stateless) sts - statefull apps
    - pod
        - container === app
          send to cluster === Google Kubernetes Engine, GKE, and Azure Kubernetes Service
    - Master (Linux for cluster) === control plane === head nodes => 3 (5 | 7 masters), 1 Leader and 2 Follower
    - node (Linux or Win for Apps)
    * Register node with cluster
    * Watches API Server for work tasks (Pods)
    * Executes Pods
    * Reports back to Master
      gVisor and katacontainers
```

## Komandoer

- docker --version => Docker version 20.10.2, build 2291f61

#### list images
- docker image ls
- docker image ls nigelpoulton/ctr-demo:2
- docker image ls nigelpoulton/getting-started-k8s:1.0
  
#### build image
- docker image build -t nigelpoulton/ctr-demo:2 .
- docker build -t docker101tutorial .
- docker image build -t nigelpoulton/getting-started-k8s:1.0 .
- docker image build -t nigelpoulton/gsd:ctr --no-cache .

#### push image til dockerhub
- docker image push nigelpoulton/ctr-demo:2
- docker image push nigelpoulton/getting-started-k8s:1.0
  
#### run, start, stop, clone container
- docker run -d -p 80:80  --name docker-tutorial docker101tutorial
- docker container run -d --name web -p 8080:8080 nigelpoulton/ctr-demo:1
- docker stop web
- docker container start web
- docker run --name repo alpine/git clone https://github.com/docker/getting-started.git
- docker cp repo:/git/getting-started
    *  cp: Copy files/folders between a container and the local filesystem

#### Share 
- docker tag docker101tutorial {userName}/docker101tutorial
    * tag: Create a tag TARGET_IMAGE that refers to SOURCE_IMAGE
- docker push {userName}/docker101tutorial

## Docker compose 
- Run more than one container in a certain order of dependency.
- The tool is used for defining and running multi-container Docker applications.
- An example is a Django application running behind an NGINX proxy on a Postgres database.

```
docker-compose up
```

## [Docker Swarm](https://github.com/docker/swarmkit)

```
docker swarm init --advertise-addr=<192.168.0.20> --external-ca ...
docker swarm join-token manager
docker swarm join-token worker
docker swarm joing-token --rotate worker
sudo openssl x509 -in /var/lib/docker/swarm/certificates/swarm-code.ctr -text
```
- secure swarm (n Manager + n Worker) cluster. 
- Have 3, 5, or 7 for Managements.
- Manager / worker token  => Identifier + Cluster Identifier + Worker or Manager
- Swarm unlocks Docker Services!

#### Lock your Swarm with Autolock
- Prevents restarted Managers from automatically re-joing the Swarm
- Prevents accidentally restoring old copies of the Swarm
  * Autolock new Swarm => docker swarm init --autolock
  * Autolock existing Swarm => docker swarm update --autolock=true
  * sudo service docker restart
  * docker swarm unlock ====> docker node ls (works after unlock)
  * docker swarm update--cert-expiry 48h


## LINK containers (below info)
- docker network create --driver bridge isolated_network

#### NETWORKING
1. Bridge Networking ==== Docker0: Single-host
   * bridge|nat driver Linux|Windows
    
2. Overlay Networking: Multi-host, container-only
   * docker network create -o encrypted
   * docker network create -d overlay overnet
   * docker service create -d --name pinger --replicas 2 --network overnett alpine sleep 1d
   * docker service ps pinger
   * docker network inspect overnett
   * docker container lsdocker container exec -it 279 sh
   * ping 10.0.0.06
   * clean all services => docker service rm $(docker service ls -q)
   * docker service create -d --name ping --network overnet --replicas 3 alpine sleep 1d
   * docker service create -d --name pong --network overnet --replicas 3 alpine sleep 1d
   * docker container exec -it c8 sh
   * ping pong
   * docker service -d --name web --network overnet --replicas 1 -p 8080:80
   * docker service inpect web --pretty
    
3. MACVLAN|transparent driver Windows: Existing VLANDs, requires promiscuous mode (not for cloud)
   * docker network ls
   * docker network inspect bridge|nat
   * docker container run --rm d alpine sleep 1d
   * docker container run ... -p Host:Container
   * docker container run --rm -d --name web -p 8080:80 nginx
   * docker port web
   * docker service create ...-p Mapper on every Swarm node: Service replica port
   * docker network create -d bridge golden-gate
   * docker container run --rm -d --network golden-gate alpine sleep 1d


## Docker Services
* docker service create --name web -p 8080:8080 --replicas 3 nigelpoulton/gsd:firts-ctr
* docker container ls
* docker service ps web
* docker service scale web=10

## Docker Stacks
* docker image build -t nigelpoulton/gsd:swarm-stack .
* docker image push nigelpoulton/gsd:swarm-stack
* docker stack deploy -c docker-compose.yml counter
* docker stack ls
* docker stack services counter
* docker stack ps counter (container)

## Linux
* sudo apt-get update
* sudo apt-get install docker-ce docker-ce-cli containerd.io

## Komandoer MAC | Win Docker Client
* docker --version: Used to identify the currently installed version of Docker on the host system
* docker ps: Used to list all running containers
* docker ps -a
* docker images: Used to list locally stored images
* docker login: Used to login into your Dockerhub account
* docker push <username/imagename>: Used to upload an image to your remote Dockerhub repository
* docker pull <imagename>: Used to download images from Dockerhub
* docker pull [image name]
* docker build <path/to/docker/file>: Used to generate an image from the specified Docker file
* docker run -it -d <imagename>: Used to create a container from the built image
* docker run [image name]
* docker stop <container id>: Used to halt the running of the defined container
* docker rm <container id>: Used to delete a stopped container
* docker rm [container ID]
* docker rmi <imageid>: Used to delete the specified image ID from local storage.
* docker rmi [image ID]
  
```
                   <docker Hub ID>/<Repo name>:<Image name>	
docker image build -t nigelpoulton/gsd:ctr --no-cache .
docker image ls
docker login			  
docker image push nigelpoulton/gsd:ctr
docker container run -d --name web -p 8000:8080 nigelpoulton/gsd:ctr
docker container ls
See in browser: localhost:8000
docker container stop <web>
docker container ls -a
docker container start <web>
docker container rm <web> -f

docker container run -it --name test alpine sh
exit or Ctrl+P+Q
docker container rm <test> -f

docker-compose version
docker-compose up -d (mongo redis 3 node nginx)
docker-compose down
```

## Module 3 [Docker Machine](https://docs.docker.com/machine/) Commands MAC | Win old Docker Client
- Install and run Docker on Mac or Windows
- Provision and manage multiple remote Docker hosts
- Provision Swarm clusters

* docker-machine ls
* docker-machine start [machine name]
* docker-machine stop [machine name]
* docker-machine env [machine name]
* docker-machine ip [machine name]
* docker-machine status [machine name]
* docker-machine ls
* docker-machine ip <default>
* docker-machine status <default>
* docker-machine env default
* eval "$(docker-machine env default)"
* eval "$('c:\Program Files\Docker Toolbox\docker-machine.exe' env default)"
* docker ps (works now)

## Komandoer MAC | Win Docker Client

```
docker pull hello-world
docker images
docker run hello-world
docker ps -a
docker rm <container_id>
docker rmi <image_id>
```

```
docker pull hello-world
docker-machine env default
eval "$(docker-machine env default)"
eval "$('c:\Program Files\Docker Toolbox\docker-machine.exe' env default)"
docker ps (works now)
docker stop <container_id>
docker ps -a
docker rm <container_id>
docker rmi <image_id>
```

```
docker pull kitematic/hello-world-nginx
docker images
docker run -p 80:80 kitematic/hello-world-nginx
docker run -p 81:80 kitematic/hello-world-nginx
http://127.0.0.1/ or  192.168.0.14
$ docker ps
CONTAINER ID   IMAGE                         COMMAND          CREATED         STATUS         PORTS                NAMES
832618254ae7   kitematic/hello-world-nginx   "sh /start.sh"   3 minutes ago   Up 3 minutes   0.0.0.0:81->80/tcp   ecstatic_poitras
```

- [Docker Volumes and “print working directory” Command Syntax](https://blog.codewithdan.com/docker-volumes-and-print-working-directory-pwd/)
```
docker run -p 8080:3000 node (create a container)
docker run -p 8080:3000 -v /var/www node (mounts a volume)
docker run -p 8080:3000 -v $(pwd):/var/www node
```

## Create a project for build an image

```
npm install express express-generator -g
express ExpressSite --hbs
cd ExpressSite && npm install
npm start


- DOCKERFILE
docker build -f <file_name> -t <your username>/node .    (-t === --tag)
rimraf node_modules
docker build -f Dockerfile -t pedalv/node .
docker images
docker run -d -p 8080:3000 pedalv/node
docker ps
Browser: 192.168.0.14:8080

docker login
docker push <your username>/node
docker pull <your username>/node

- Witout DOCKERFILE 
docker pull node
docker run -p 8080:3000 -v /var/www node
docker ps -a
docker inspect <container_id> => search for Mounts
"Mounts": [
    {
    "Type": "volume",
    "Name": "4cfe540df1afba1d081f6e29623b3cd9f145d5d733a0b91adbb983b3b35cb41d",
    "Source": "/var/lib/docker/volumes/4cfe540df1afba1d081f6e29623b3cd9f145d5d733a0b91adbb983b3b35cb41d/_data",
    "Destination": "/var/www",
    "Driver": "local",
    "Mode": "",
    "RW": true,
    "Propagation": ""
    }
],
docker rm -v <container_id>
cd ExpressSite
ls
docker run -p 8080:3000 -v $(pwd):/var/www -w "/var/www" node npm start
docker run -p 8082:3000 -v /e:/development/docker/ExpressSite://var/www -w "//var/www" node npm start
docker run -p 8080:3000 -v $(pwd)://var/www -w "//var/www" node npm start
Browser: 192.168.0.14:8080
```

```
dotnet new mvc
docker pull mcr.microsoft.com/dotnet/core/sdk == https://hub.docker.com/_/microsoft-dotnet-sdk
MAC - LINUX: docker run -p 8080:3000 -it -p 8080:5000 -v $(pwd):/app -w "/app" mcr.microsoft.com/dotnet/core/sdk /bin/bash
Power Shell: docker run -p 8080:3000 -it -p 8080:5000 -v ${PWD}:/app -w "/app" mcr.microsoft.com/dotnet/core/sdk /bin/bash
DOS: docker run -p 8080:3000 -it -p 8080:5000 -v %cd%:/app -w "/app" mcr.microsoft.com/dotnet/core/sdk /bin/bash
- endre fra: "applicationUrl": "https://localhost:5001;http://localhost:5000",
- til: "applicationUrl": "https://+:5000",
dotnet build
dotnet run
dotnet watch run

- DOCKERFILE
docker build -t <your username>/aspnetcore . (-t === --tag, file er default)
docker build --pull --rm -f "dev.dockerfile" -t donetsite-dev .
rimraf node_modules
docker build -f dev.dockerfile -t aspnetcore-dev . (-t === --tag)
docker run -p 8080:5000 -v $(pwd):/app aspnetcore-dev
docker run -p 8080:80 -v $(pwd):/app donetsite:latest
Browser: 192.168.0.14:8080

docker login
docker push <your username>/node => pedalv/donetsite
docker pull <your username>/node 

- Without DOCKERFILE
docker pull aspnetcore-dev
docker run -p 8080:5000 -v $(pwd):/app aspnetcore-dev dotnet watch run
docker run -p 8080:80 -v $(pwd):/app donetsite:latest dotnet watch run
Browser: 192.168.0.14:8080
```

## LINK
* https://itnext.io/asp-net-core-3-1-entity-framework-core-with-postgresql-with-code-first-approach-33b102e1734f
* docker build -f aspnetcore.dockerfile -t pedalv/dotnetcore .
* docker pull postgres

#### option 1
* docker run -d --name my-postgres -e POSTGRESS_PASSWORD=password postgres
* docker run -d -p 5000:5000  --name my-dotnetsite --link my-postgres:postgres pedalv/dotnetsite

#### option 2 (above info)
* docker network create --driver bridge isolated_network
* docker run -d --net=isolated_network --name postgres -e POSTGRESS_PASSWORD=password postgres
* docker run -d --net=isolated_network --name dotnetsite -p 5000:5000 pedalv/dotnetsite

## LINK
* https://docs.microsoft.com/en-us/aspnet/core/tutorials/first-mongo-app?view=aspnetcore-5.0&tabs=visual-studio
* docker pull mongo

#### option 1
* docker run -d --name my-mongodb mongo
* docker run -d -p 3000:3000 --link my-mongodb:mongodb pedalv/node
* docker exec <container_id> node dbSeeder.js
* docker exec nodeapp node dbSeeder.js

#### option 2 Container Networks LINK bridge driver (above info)
* docker network create --driver bridge isolated_network
* docker network ls
* docker network inspect isolated_network
* docker run -d --net=isolated_network --name mongodb mongo
* docker run -d --net=isolated_network --name nodeapp -p 3000:3000 pedalv/node
* docker exec nodeapp node dbSeeder.js

## link or network functionality => docker compose
- Run more than one container in a certain order of dependency.
- The tool is used for defining and running multi-container Docker applications.
- An example is a Django application running behind an NGINX proxy on a Postgres database.
- docker-compose.yml File === Services

* docker-compose build
* docker-compose build mongo
* docker-compose up === docker run -d --net=isolated_network --name nodeapp -p 3000:3000 pedalv/node
* docker-compose up --no-deps node
* docker-compose down => stop and remove
* docker-compose down --rmi all --volumes
* docker-compose logs
* docker-compose ps
* docker-compose stop
* docker-compose start
* docker-compose rm

## Module 7
* docker-compose build
* docker images
* docker-compose up
* docker-compose up -d (d not block terminal)
* docker-compose down
* docker-compose ps
* docker-compose logs

## Module 8
* docker-compose build
* docker images
* docker ps -a
* docker rm -f $(docker ps -a -q)
* docker ps -a
* docker-compose up -d
* docker exec <container_id> node dbSeeder.js

## docker compose => kubernetes
- Minikube vs Docker Desktop for run kubernetes
  * https://github.com/kubernetes/minikube
  * https://www.docker.com/products/docker-desktop
- Migrating Docker Compose to Kubernetes
  * https://github.com/docker/compose-on-kubernetes
  * https://kompose.io/
    * kompose convert --out test.yaml (docker-compose.yml)

#### Kubernets commands
* kubectl versionkubectl get [deployments | services | pods]
* kubectl run nginx-server --image=nginx:alpine
* kubectl delete deployments nginx-server (delete deploy and pods)
* kubectl apply -f [fileName | folderName]

* kubectl port-forward [name-of-pod] 8080:80
* kubectl apply -f ./.k8s (folder or yaml file)
* kubectl delete -f [fileName | folderName]

## 2018 course

#### Update docker windows server 2016
* Install-Module DockerProvider -Force
* Install-Package Docker -ProviderName DockerProvider -Force

#### LINUX
* wget -q0- https://get.docker.com/ | sh
* sudo usermod -aG docker ubuntu === not need sudo

#### Ubuntu
* docker image pull redis
* docker image pull nigelpoulton/tu-demo -a
* docker system info
* docker image ls
* docker image ls --digests
* ls -l /var/lib/docker/aufs/diff/
* docker history redis
* docker image inspect redis
* docker image rm redis === docker rmi redis
* docker image ls
* docker container ls

```
REGISTER/REPO:IMAGE (tag)
docker.io/redis:latest
```

* docker image build -t nigelpoulton/ctr-demo:2 .
* docker image build -t  <tag> /home/ubuntu/psweb/
* docker image build -t psweb https://github.com/nigelpoulton/psweb.git
* docker history pswebdocker image inspect psweb
  * history     Show the history of an image

## Tips
- Unikernels ===  no OS for run apps, https://en.wikipedia.org/wiki/Unikernel
- Blueprint === an early plan or design that explains how something might be achieved
- Big band ===  is popular in situations or adopted when the project's stakeholders or customers are not certain regarding their wants and requirements
- on-prem === On-premises software is installed and runs on computers on the premises of the person or organization using the software, rather than at a remote facility such as a server farm or cloud.
- it === interactive terminal

#### LINUX
* docker image build -t multistage .
* docker container ls
* docker container run -it alpine sh (it === interactive terminal)
* ps -elf (inside the container terminal. Ctrl+P+Q to exit from container terminal)
* docker container ls
* docker container run -d alpine sleep 1d
* docker conatainer exec -it 60 sh (60 container_id)
* ps -elf
* docker image build -t multistage .echo "devops FTW" > newfile (use volume to add data to a container, It is lab people)
* docker image build -t multistage .docker container stop 60 (60 container_id)
* docker image build -t multistage .socker container start 60 (60 container_id)
* docker image build -t multistage .docker container exec 60 ls -l (60 container_id)
* docker image build -t multistage .docker container exec 60 cat newfile (60 container_id)
* docker image build -t multistage .docker container rm $(docker contailer ls -aq) -f

#### Windows
* docker container run -d --name web1 -p 80:80 microsoft/iis
* docker port web1
* docker inspect -f "{{ .NetworkSettings.Networks.nat.IPAddress}}" web1
* docker container rm $(docker contailer ls -aq) -f

## Volumes and Persistent Data
* docker volume
* docker volume ls
* docker volume create myvol
* docker valume inspect myvol
* docker volume create psvol
* ls -l /var/lib/docker/volumes/
* docker volume rm myvol psvol

* docker container run -dit --name voltest --mount source=ubervol,target=/vol alpine:latest
* ls -l /var/lib/docker/volumes/_data
* docker container exec -it voltest sh
* ls -l /vol/ (inside container)
* echo "some data" > /vol/newfile
* cat /vol/newfile
* exit
* ls -l /var/lib/docker/volumes/_data
* cat /var/lib/docker/volumes/_data/newfile
* docker container rm voltest -f
* docker container run -dit --name volmore --mount source=ubervol,target=/app nginx
* docker container exec -it volmore sh
* ls -l /app (inside container)
* cat /app/newfile
* echo "more data" > /app/newfile
* exit
* cat /var/lib/docker/volumes/_data/newfile
* docker volume rm ubervol (volume is in use === unable to remove volume)
* docker container rm volmore -f
* docker volume rm ubervol
* ls -l /var/lib/docker/volumes/

## secrets
* docker secret create wp-sec-v1 .\classified
* docker sercret ls
* docker secrets inspect wp-sec-v1

 docker service create -d --name secret-service `
--secret wp-sec-v1 `
microsoft/powershell:windowsservercore `
PowerShell Start-Sleep -s 86400
(Downloading the microsoft/powershell:windowsservercore image in the background)

* docker service ls
* docker service inspect sercret-service
* docker container ls
* docker container exec -it 44 PowerShell
* ls C:\ProgramData\Docker\secrets (inside container)
* cat C:\ProgramData\Docker\secrets\wp-sec-v1
* docker secret rm wp-sec-v2 (secret is in use === unable to remove secret)
* docker service rm secret-service
* docker secret rm wp-sec-v2

## Stacks & Services
* docker stack deploy
* https://github.com/dockersamples/example-voting-app

curl -o stackfile.yml \
https://raw.githubusercontent.com/dockersamples/example-voting-app/master/docker-stack.yml

* ls -l => docker-stack.yml
* docker stack deploy -c docker-stack.yml voter
* docker stack ls
* docker stack ps voter
* docker stack services voter
* docker service scale voter_vote=20
* docker stack services voter
* docker service inspect voter_vote --pretty
* docker stack deploy -c docker-stack.yml voter

## [Docker Compose vs Docker stack](https://vsupalov.com/difference-docker-compose-and-docker-stack/) 
- Docker Compose is an official tool that helps you manage your Docker containers by letting you define everything through a docker-compose. yml file.
- Docker Stack is a command that's embedded into the Docker CLI. It lets you manage a cluster of Docker containers through Docker Swarm.
