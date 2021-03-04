# DOCKER
- [Docker and Kubernetes: The Big Picture](https://app.pluralsight.com/library/courses/docker-kubernetes-big-picture/table-of-contents)
- [Getting Started with Docker](https://app.pluralsight.com/library/courses/getting-started-docker/table-of-contents)
- [Docker for Web Developers](https://app.pluralsight.com/library/courses/docker-web-development/table-of-contents)
- [Docker Deep Dive](https://app.pluralsight.com/library/courses/docker-deep-dive-update/table-of-contents)
- [Integrating Docker with DevOps Automated Workflows](https://app.pluralsight.com/library/courses/integrating-docker-with-devops-automated-workflows/table-of-contents)
- [Docker Networking (TODO)](https://app.pluralsight.com/library/courses/docker-networking/table-of-contents)
- [Docker Swarm: Native Docker Clustering (TODO)](https://app.pluralsight.com/library/courses/docker-swarm-native-docker-clustering/table-of-contents)
- [Containerizing Angular Applications with Docker (TODO)](https://app.pluralsight.com/library/courses/containerizing-angular-apps-docker/table-of-contents)

## Resume
- VM world => Virtual Machine
- Kubernets => Pod as apps and nodes as infrastructure
- [docker kitematic](https://github.com/docker/kitematic/releases)
- Docker => Container
  * REGISTER/REPO:IMAGE (tag) => docker.io/redis:latest
  * [github](https://github.com/pedalv)
  * [dockerhub](https://hub.docker.com/u/pedalv)
  * [docker kitematic](https://github.com/docker/kitematic/releases)
  * [Dashboard UI](http://127.0.0.1:8082/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#/overview?namespace=default)
  * Build an image from a Dockerfile => docker build [OPTIONS] PATH | URL | -
```
docker image build -t <docker Hub ID>/<Repo name>:<Image name> <path>
docker image build -t nigelpoulton/gsd:ctr --no-cache .
```
- Image: A read-only template compose of layered filesystems used to share common files and create Docker container instances.
- Container: An isolated and secured shipping container created from an image that can be run, started, stopped, moved and deleted.

## Tips
- Unikernels ===  no OS for run apps, https://en.wikipedia.org/wiki/Unikernel
- Blueprint === an early plan or design that explains how something might be achieved
- Big band ===  is popular in situations or adopted when the project's stakeholders or customers are not certain regarding their wants and requirements
- on-prem === On-premises software is installed and runs on computers on the premises of the person or organization using the software, rather than at a remote facility such as a server farm or cloud.
- cloud === Google Kubernetes Engine, GKE, and Azure Kubernetes Service
- it === interactive terminal
- Community Edition (CE) and Enterprise Edition (EE)
- [Play with Docker](https://labs.play-with-docker.com/)
- Docker: (ESXI) - start | stop | delete ... container
- [Play with Kubernetes](https://labs.play-with-k8s.com/)
- Kubernetes: (vCenter) - Scheduling, scaling, healing, updating..., Alpha (v1alpha1, v1alpha2,...) => Beta (v1beta1, v1beta2,...) => GA (v1)

## Update docker windows server 2016
* Install-Module DockerProvider -Force
* Install-Package Docker -ProviderName DockerProvider -Force

## [Docker Toolbox Tools](https://docs.docker.com/docker-for-windows/docker-toolbox/) (deprecated) 
- Legacy option for Windows 7/8
- Provide image and container tools
- Uses VirtualBox  
- Docker Client, Docker Machine, Docker Compose, Docker Kitematic, VirtualBox

#### [Docker Machine](https://docs.docker.com/machine/) Commands MAC | Win Docker Toolbox (deprecated)
- Create and Manager Local Machines
- Create and Manager Cloud Machines
- Configure Docker Client to talk to Machines
- Install and run Docker on Mac or Windows
- Provision and manage multiple remote Docker hosts
- Provision Swarm clusters
- Docker Machine creates and manages machines (Docker Toolbox only)
- Docker Machine Commands
* docker-machine ls
* docker-machine start [machine name]
* docker-machine stop [machine name]
* docker-machine env [machine name]
* docker-machine env default
* eval "$(docker-machine env default)"
* eval "$('c:\Program Files\Docker Toolbox\docker-machine.exe' env default)"
* docker-machine ip [machine name]
* docker-machine status [machine name]
* docker-machine ls
* docker-machine ip <default>
* docker-machine status <default>
* docker-machine env default
* eval "$(docker-machine env default)"
* eval "$('c:\Program Files\Docker Toolbox\docker-machine.exe' env default)"
* docker ps (works now)

#### [docker kitematic](https://github.com/docker/kitematic/releases)
- GUI used to provision VMs and work with Images and Containers
- Visually Search for Docker images
- Create, Run and Manager Containers

## Docker Desktop
- Windows 10 Pro+ or Mac
- Provide image and container tools
- Using Hyper-V/Hyperkit to run VMs
- Works on Windows, Mac, Linux (Docker Engine)
- [Docker Get Started](https://docs.docker.com/get-started/)
- Docker Client, Docker Compose, Docker Kitematic

#### Docker Client
- Interact with Docker Engine
- Build and Manage Images
- Run and Manage Containers
- docker --version => Docker version 20.10.2, build 2291f61
- Docker Client manages images and containers

#### Docker Client Commands
* docker --version: Used to identify the currently installed version of Docker on the host system
- Docker Client Image Commands: code => Dockerfile => docker image build => container
* docker pull [image name]
* docker pull hello-world  
* docker pull kitematic/hello-world-nginx
* docker images: Used to list locally stored images
* docker image build -t multistage .
* docker image build -t multistage .echo "devops FTW" > newfile (use volume to add data to a container, It is lab people)
* docker image build -t multistage .docker container stop 60 (60 container_id)
* docker image build -t multistage .socker container start 60 (60 container_id)
* docker image build -t multistage .docker container exec 60 ls -l (60 container_id)
* docker image build -t multistage .docker container exec 60 cat newfile (60 container_id)
* docker image build -t multistage .docker container rm $(docker contailer ls -aq) -f
* docker image pull redis
* docker history redis  
* docker image pull nigelpoulton/tu-demo -a
* docker image inspect redis
* docker image inspect alpine
* docker image rm redis === docker rmi redis
* docker image rm $(docker image ls -q)  
* docker image ls
* docker image ls
* docker image ls --digests
* docker image build -t nigelpoulton/ctr-demo:2 .
* docker history pswebdocker image inspect psweb
    * history: Show the history of an image  
* docker image build -t psweb .    
* docker image build -t  <tag> /home/ubuntu/psweb/
* docker image build -t psweb https://github.com/nigelpoulton/psweb.git
* docker image history psweb
* docker image inspect psweb
* docker image build -t nigelpoulton/gsd:ctr --no-cache .
* docker image build -t <docker Hub ID>/<Repo name>:<Image name>
* docker rmi [image ID]
* docker rmi <imageid>: Used to delete the specified image ID from local storage.
- Docker Client Container Commands
* docker run [image name]
* docker run hello-world
* docker container run -d --name <name> -p <Hosp port>:<Container port> <name>
* docker run -d --name <name> -p <Hosp port>:<Container port> <name>
* docker run -p 80:80 kitematic/hello-world-nginx
* docker run -p 81:80 kitematic/hello-world-nginx
* docker run -it -d <imagename>: Used to create a container from the built image
* http://127.0.0.1/ or  192.168.0.14  
* docker ps: Used to list all running containers
```
$ docker ps
CONTAINER ID   IMAGE                         COMMAND          CREATED         STATUS         PORTS                NAMES
832618254ae7   kitematic/hello-world-nginx   "sh /start.sh"   3 minutes ago   Up 3 minutes   0.0.0.0:81->80/tcp   ecstatic_poitras
```
* docker ps -a
* docker rm [container ID]
* docker rm <container id>: Used to delete a stopped container
* docker rm -f $(docker ps -a -q)
* docker exec <container_id> node dbSeeder.js

- list images

```
REGISTER/REPO/IMAGE (tag)
docker.io/redis/latest
docker.io/bginx/1.13.5
docker.io (default)/<repo>/ latest(default)
```

* docker image ls
* docker image ls nigelpoulton/ctr-demo:2
* docker image ls nigelpoulton/getting-started-k8s:1.0
  
- build image
* docker build <path/to/docker/file>: Used to generate an image from the specified Docker file
* docker image build -t nigelpoulton/ctr-demo:2 .
* docker build -t docker101tutorial .
* docker image build -t nigelpoulton/getting-started-k8s:1.0 .
* docker image build -t nigelpoulton/gsd:ctr --no-cache .

- push image til dockerhub
* docker image push nigelpoulton/gsd:ctr
* docker image push nigelpoulton/ctr-demo:2
* docker image push nigelpoulton/getting-started-k8s:1.0
* docker login: Used to login into your Dockerhub account
* docker push <username/imagename>: Used to upload an image to your remote Dockerhub repository
* docker pull <imagename>: Used to download images from Dockerhub
* docker pull [image name]

- run, start, stop, clone container
* docker run -d -p 80:80 docker/getting-started
* docker run -d -p 80:80  --name docker-tutorial docker101tutorial
    * docker container run -d --name <name> -p <Hosp port>:<Container port> <name>
* docker container run -d --name web -p 8080:8080 nigelpoulton/ctr-demo:1
* docker stop <container id>: Used to halt the running of the defined container
* docker container stop $(docker container ls -aq)
* docker stop web
* docker container start web
* docker container run -ts alpine === Start a new container without specifying a main process for it to run
* docker container run -it alpine sh === Start another new container  
* docker run --name repo alpine/git clone https://github.com/docker/getting-started.git
* docker cp repo:/git/getting-started
    *  cp: Copy files/folders between a container and the local filesystem
* docker container ls
* docker container run -it alpine sh (Start anew container, it === interactive terminal)
    * ps -elf (inside the container terminal. Ctrl+P+Q to exit from container terminal)
* docker container ls
* docker container run -d alpine sleep 1d
* docker conatainer exec -it 60 sh (60 container_id)
    * ps -elf
* docker container ls
* docker container run -d --name web1 -p 80:80 microsoft/iis === Start a new background container running the default IIS web server and map port 80 on the host to 80 in the container
* docker port web1 === Check the port mapping
* docker inspect -f "{{ .NetworkSettings.Networks.nat.IPAddress}}" web1 === Get the containers IP
* docker container rm $(docker container ls -aq) -f
* docker container run -d --name web -p 8000:8080 nigelpoulton/gsd:ctr
* docker container ls
    * See in browser: localhost:8000
* docker container stop <web>
* docker container ls -a
* docker container start <web>
* docker container rm <web> -f
* docker container run -it --name test alpine sh
    * exit or Ctrl+P+Q
* docker container rm <test> -f

- Share 
* docker tag docker101tutorial {userName}/docker101tutorial
    * tag: Create a tag TARGET_IMAGE that refers to SOURCE_IMAGE
* docker push {userName}/docker101tutorial

- LINUX
* Tips 1
    * wget -q0- https://get.docker.com/ | sh
    * sudo usermod -aG docker ubuntu === not need sudo
* Tips 2
    * sudo apt-get update
    * sudo apt-get install docker-ce docker-ce-cli containerd.io
* Tips 3
    * docker system info
    * ls -l /var/lib/docker/aufs/diff/
* Tips 4
    * List the processes running inside the container => ps -elf
	* Press `Ctrl-P-Q` to gracefully exit the container, leaving it's main process (PID1) running

## [Docker Volumes and “print working directory” Command Syntax](https://blog.codewithdan.com/docker-volumes-and-print-working-directory-pwd/)
- Docker images and containers rely on a "layered file system"
- Source Code can be hooked to a container using valumes: docker run -v
- Volumes are persisted on the Docker Host
- Volumes can be removed using: docker rm -v lastContainer 

* docker run -p 8080:3000 node (create a container)
* docker run -p 8080:3000 -v /var/www node (creating a data volume | -v => mounts a volume | /var/www)
    * docker run -p 8080:3000 "create a volume === -v" "Container Volume === /var/www" node
* docker run -p 8080:3000 -v $(pwd):/var/www node (Customizing the Host Location for a Data Volume)
    * docker run -p 8080:3000 "create a volume === -v" "Host Location $(pwd)":"Container Volume === /var/www" node

## Clone the following Git repo project for build an image
* git clone https://github.com/nigelpoulton/atsea-sample-shop-app.git
* cd atsea-sample-shop-app/app
* docker image build -t multistage .
* docker image ls

## Create a project for build an image
- Dockerfile is a simple text file with instructions that is used to create an image
- Each Dockerfile starts with a FROM instruction
- Custom images are built using: docker build -t <username>/imageName
- Images can be pushed to Docker Hub

#### Project 1
* npm install express express-generator -g
* express ExpressSite --hbs
* cd ExpressSite && npm install
* npm start

- DOCKERFILE and Images: Dockerfile => docker build => Docker Image
* docker build -t <your username>/node .  
    *  docker build "Short for --tag | -t" "Tag name"/"Custom image name | node" "Build context | ."  
* docker build -f <file_name> -t <your username>/node .    (-t === --tag)
* rimraf node_modules
* docker build -f Dockerfile -t pedalv/node .
* docker images
* docker run -d -p 8080:3000 pedalv/node
* docker ps
* Browser: 192.168.0.14:8080

- Push to DockerHub
* docker login
* docker push <your username>/node
* docker pull <your username>/node

- Witout DOCKERFILE 
* docker pull node or 
* docker image build -t node .
* docker run -p 8080:3000 -v /var/www node
* docker ps -a
* docker inspect <container_id> => search for Mounts
```
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
```
* docker rm -v <container_id>
* cd ExpressSite
* ls
* docker run -p 8080:3000 -v $(pwd):/var/www -w "/var/www" node npm start
* docker run -p 8082:3000 -v /e:/development/docker/ExpressSite://var/www -w "//var/www" node npm start
* docker run -p 8080:3000 -v $(pwd)://var/www -w "//var/www" node npm start
* Browser: 192.168.0.14:8080

#### Project 2
* dotnet new mvc
* docker pull mcr.microsoft.com/dotnet/core/sdk == https://hub.docker.com/_/microsoft-dotnet-sdk
* MAC - LINUX: docker run -p 8080:3000 -it -p 8080:5000 -v $(pwd):/app -w "/app" mcr.microsoft.com/dotnet/core/sdk /bin/bash
* Power Shell: docker run -p 8080:3000 -it -p 8080:5000 -v ${PWD}:/app -w "/app" mcr.microsoft.com/dotnet/core/sdk /bin/bash
* DOS: docker run -p 8080:3000 -it -p 8080:5000 -v %cd%:/app -w "/app" mcr.microsoft.com/dotnet/core/sdk /bin/bash
```
endre fra: "applicationUrl": "https://localhost:5001;http://localhost:5000",
til: "applicationUrl": "https://+:5000",
```
* dotnet build
* dotnet run
* dotnet watch run

- DOCKERFILE and Images: Dockerfile => docker build => Docker Image
* docker build -t <your username>/aspnetcore . (-t === --tag, file er default)
    *  docker build "Short for --tag | -t" "Tag name"/"Custom image name | aspnetcore" "Build context | ."
* docker build --pull --rm -f "dev.dockerfile" -t donetsite-dev .
* rimraf node_modules
* docker build -f dev.dockerfile -t aspnetcore-dev . (-t === --tag)
* docker run -p 8080:5000 -v $(pwd):/app aspnetcore-dev
* docker run -p 8080:80 -v $(pwd):/app donetsite:latest
* Browser: 192.168.0.14:8080

- Push to DockerHub
* docker login
* docker push <your username>/node => docker push pedalv/donetsite
* docker pull <your username>/node 

- Without DOCKERFILE
* docker pull aspnetcore-dev
* docker run -p 8080:5000 -v $(pwd):/app aspnetcore-dev dotnet watch run
* docker run -p 8080:80 -v $(pwd):/app donetsite:latest dotnet watch run
* Browser: 192.168.0.14:8080

## Communicating between Docker Containers
- Docker container communicate using link or network functionality
- the --link switch provides "legacy linking" === option 1
- the --net command-line switch can be used to setup a bridge network === option 2
- Docker Compose can be use to link multiple containers to each other === option 3
- Kubernetes === option 4
- Docker Swarm === option 5

#### option 1: Container Linking
- Options
* Use Legacy Linking
* Add Containers to a Bridge Network
- Steps:
1. Run a Container with a Name
    * docker run -d --name my-postgres postgres
   * docker run -d "Define a name for the container | --name" my-postgres postgres
2. Link to Running Container by Name
   * docker run -d -p 5000:5000 --link my-postgres:postgres danwahlin/aspnetcore
   * docker run -d -p 5000:5000 "Link to named container | --link" "Name of linked container | my-postgres":"Linked container alias | postgres" danwahlin/aspnetcore
3. Reapeat for additional Containers

#### option 2: Container Network
- Steps:
1. Create a Custom Bridge Network
    * docker network create --driver bridge isolated_network
    * docker network "Create a custom network | create" --driver "Use a bridge network | bridge" "Name of custom network | isolated_network"
2. Run Containers in the Network
    * docker run -d --net=isolated_network --name mongodb mongo
    * docker run -d "Run container in network | --net"=isolated_network --name "'Link' to this container by name | mongodb" mongo

- Types:   
1. Bridge Networking ==== Docker0: Single-host
    * bridge|nat driver Linux|Windows
    * docker network create --driver bridge isolated_network


2. Overlay Networking: Multi-host, container-only
    * docker network create -o encrypted
    * docker network create -d overlay overnet === Create a new OVERLAY network called "overnet"
    * docker service create -d --name pinger --replicas 2 --network overnett alpine sleep 1d === Create a new service called "pinger" and put it on the overnet overlay network
    * docker service ps pinger
    * docker network inspect overnett
    * docker container ls
    * docker container exec -it <ID> sh === Exec onto the service replica running on this node. You will need to substitute <ID> with the ID of the service replica in your environment
    * ping 10.0.0.06
    * clean all services => docker service rm $(docker service ls -q)
    * docker service create -d --name ping --network overnet --replicas 3 alpine sleep 1d
    * docker service create -d --name pong --network overnet --replicas 3 alpine sleep 1d
    * docker container exec -it c8 sh
    * ping pong
    * docker service -d --name web --network overnet --replicas 1 -p 8080:80

    * Deploy a new web server service called "web". This example uses an NGINX web server that listens on port 80. If you are following along on Windows you might want to use an IIS container
	    * docker service create -d --name web --network overnet --replicas 1 -p 8080:80 nginx
            * docker service create ... -p 'Mapped on every Swarm mode | 8080':''Service replica port | 80'
    * docker service inpect web --pretty

3. MACVLAN|transparent driver Windows: Existing VLANDs, requires promiscuous mode (not for cloud)
    * docker network ls
    * docker network inspect bridge|nat
    * docker container run --rm d alpine sleep 1d
    * docker container run -d --name <name> -p <Hosp port>:<Container port> <name>
    * docker container run --rm -d --name web -p 8080:80 nginx
    * docker port web
    * docker service create ...-p Mapper on every Swarm node: Service replica port
    * docker network create -d bridge golden-gate
    * docker container run --rm -d --network golden-gate alpine sleep 1d
    * docker container run --name SLEEP -d alpine sleep 1d === Start another container (We will call this on the SLEEP container. Start this in the background (-d) and tell it to run the sleep process for one day
    * docker container stop SLEEP
    * docker container start SLEEP
    * docker container exec -it SLEEP sh === Start a new interactive shell session to the SLEEP container 
    * echo "devops FTW" > newfile
    * docker container exec <ID or name of SLEEP container> ls -1 === Use the `docker container exec` command to run some commands in the SLEEP container
    * docker container exec <ID or name of SLEEP container> cat newfile === Use the `docker container exec` command to run some commands in the SLEEP container
    
#### Example 1: [Linking Node.js and MongoDB Containers](https://docs.microsoft.com/en-us/aspnet/core/tutorials/first-mongo-app?view=aspnetcore-5.0&tabs=visual-studio)
* docker pull mongo

#### option 1: Container Linking
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

#### Example 2: [Getting Started with ASP.NET Core 3.1, Entity Framework Core with PostgreSQL database (code first approach)](https://itnext.io/asp-net-core-3-1-entity-framework-core-with-postgresql-with-code-first-approach-33b102e1734f)
* docker pull postgres
* docker build -f aspnetcore.dockerfile -t pedalv/dotnetcore .

#### option 1
* docker run -d --name my-postgres -e POSTGRESS_PASSWORD=password postgres
* docker run -d -p 5000:5000 --name my-dotnetsite --link my-postgres:postgres pedalv/dotnetsite

#### option 2 (above info)
* docker network create --driver bridge isolated_network
* docker run -d --net=isolated_network --name postgres -e POSTGRESS_PASSWORD=password postgres
* docker run -d --net=isolated_network --name dotnetsite -p 5000:5000 pedalv/dotnetsite

#### option 3: link or network functionality => Docker compose
- Docker Compose simplifies the process of building, starting and stopping services
- docker-compose.yml defines services
- Excellent way to manage services used in a development environment
- Key Docker Compose commands include "build", "up", and "down"  
- Run more than one container in a certain order of dependency.
- The tool is used for defining and running multi-container Docker applications.
- An example is a Django application running behind an NGINX proxy on a Postgres database.
- docker-compose.yml File === Service Configuration => Docker Compose Build => Docker Images (Services)
- Docker Compose Manages Your Application Lifecycle
    * Start, stop and rebuild services
    * View the status of running services
    * Stream the log output of running services
    * Run a one-off command on a service
- Key Docker Compose Commands:
* docker-compose build
* docker-compose build mongo
* docker-compose up === docker run -d --net=isolated_network --name nodeapp -p 3000:3000 pedalv/node
* docker-compose up --no-deps node
* docker-compose up -d (mongo redis 3 node nginx)
* docker-compose down => stop and remove
* docker-compose down --rmi all --volumes
* docker-compose logs
* docker-compose ps
* docker-compose stop
* docker-compose start
* docker-compose rm
* docker-compose version
- Building Services 
1. docker-compose.yml File === Service Configuration
2. Build Services
    * docker-compose build (Build or rebuild services defenid in docker-compose.yml)  
    * docker-compose build mongo (Only build/rebuild mongo service)
3. Start up Services
    * docker-compose up (Create and start the containers)
    * docker-compose up --no-deps node
        * docker-compose up "Do not recreate services that node depends on | --no-deps" "Rebuild node image and stop, destroy and create only node | node"
        * docker-compose up -d (d not block terminal)
4. Tear Down Services 
    * docker-compose down (Take all of the containers down - stop and remove)
    * docker-compose down rmi all --volumes
        * docker-compose down "Remove all images | rmi" all "Remove all volumes | --volumes"

## option 4: docker compose => [kubernetes](https://kubernetes.io/)
- Kubernets is an open-source system for automating deployment, scaling, and management of containerized application
- Container and cluster management
- Support by all major cloud platforms
- Provides a declarative way to define a cluster's state using manifest files (YAML)
- Interact with kubernetes using kubeectl  
- [Minikube](https://github.com/kubernetes/minikube) vs [Docker Desktop](https://www.docker.com/products/docker-desktop) for run kubernetes locally
* Deployment
    * Describe desired state
    * Can be used to replicate pods
    * Support rolling updates and rollbacks
* Service
    * Pods live and die
    * Services abstract pod IP addresses from consumers
    * Load balances between pods
- Migrating Docker Compose to Kubernetes
    * [Compose on kubernetes](https://github.com/docker/compose-on-kubernetes)
    * [Kompose](https://kompose.io/)
        * kompose convert --out test.yaml (docker-compose.yml)

#### Kubernets Key Commands
* kubectl version
* kubectl get [deployments | services | pods]
* kubectl run nginx-server --image=nginx:alpine
* kubectl apply -f [fileName | folderName]
    * kubectl apply -f ./.k8s (folder or yaml file)
* kubectl port-froward [name-of-pod] 8080:80
* kubectl delete -f [fileName | folderName]
    * kubectl delete deployments nginx-server (delete deploy and pods)

#### KUBERNETES Summary
- Kubernetes provide a robust solution for automating deployment, scaling, and management of containers
- Provides a way to move to a desired state
- Relies on YAML (or JSON) files to represent desire state
- Nodes and pods play a central role
- A containner runs in a pod
- kubectl can be used to issue commands and interact with the Kubernetes API

## option 5: [Docker Swarm](https://github.com/docker/swarmkit)
- secure swarm (n Manager + n Worker) cluster.
- Have 3, 5, or 7 for Managements.
- Manager / worker token  => Identifier + Cluster Identifier + Worker or Manager
- Swarm unlocks Docker Services!
- Key commands
* docker swarm init === Initialize a new Swarm
* docker swarm init --advertise-addr=<192.168.0.20> --external-ca ... === Initialize a new Swarm
* docker system info === Verify that Swarm is showing as `inactive`
* docker swarm join-token manager
* docker swarm join-token worker
* docker swarm join-token --rotate  
* sudo openssl x509 -in /var/lib/docker/swarm/certificates/swarm-code.ctr -text 
* docker swarm update--cert-expiry 48h
- create a Swarm (anywhere)
* Create a Swarm manager
    * Assign it a crypto ID
    * Elect it as the Swarm leader
* Create an Swarm configDB
    * Encrypt it
    * Configure it to automatically replicate with all Swarm managers
* Create a Swarm joing token for new workers
* Create a Swarm joing token for new managers
* configure a new Root CA on the leader
    * Configure a 90 day certificat rotation period

## Docker Services
* docker container run ... -p Host:Container
* docker service create ... -p 'Mapped on every Swarm mode | 8080':''Service replica port | 80'
* docker service create --name green --secret sec1 --replicas 2 ...
* docker service rm green
* docker service create --name web -p 8080:8080 --replicas 3 nigelpoulton/gsd:firts-ctr
* docker container ls
* docker service ps web
* docker service scale web=10
* docker service scale reporting=4

## Volumes and Persistent Data
* docker volume
* docker volume ls
* docker volume create myvol
* docker volume inspect myvol
* docker volume create psvol
* ls -l /var/lib/docker/volumes/ === Look at where the volume is stored on the local Docker host
* docker volume rm myvol psvol

* docker container run -dit --name voltest --mount source=ubervol,target=/vol alpine:latest === Create a new container and create a new volume as part of the operation
* ls -l /var/lib/docker/volumes/_data === Inspect the contents of the volume in the Docker host's local filesystem
* docker container exec -it voltest sh === Exec onto the container created in the earlier step
* ls -l /vol/ (inside container) === Inspect the contents of the volume within the container
* echo "some data" > /vol/newfile === Write some data to a new file in the volume
* cat /vol/newfile
* exit
* ls -l /var/lib/docker/volumes/_data
* cat /var/lib/docker/volumes/_data/newfile
* docker container rm voltest -f
* docker container run -dit --name volmore --mount source=ubervol,target=/app nginx === Start a brand new container and attach the "ubervol" volume
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
- String <=500k
- Safe
- Secure
- Infrastructure independent
- Requires Swarm-mode Services only. Linux: 1.13+ and Windows: 17.06+
* echo "Pluralsight rocks" > secret.txt
* docker secret create wp-sec-v1 .\classified
* docker secret create wp-sec-v1 ./secret.txt
* docker secret ls
* docker secrets inspect wp-sec-v1

- Create a new Service and grant it access to the secret. If you are using Windows containers you should substitute the Alpine container for a PowerShell container running `Start-Sleep -s 86400`
* docker service create -d --name secret-service --secret wp-sec-v1 alpine sleep 1d
* docker service create -d --name secret-service --secret wp-sec-v1 microsoft/powershell:windowsservercore  PowerShell Start-Sleep -s 86400

(Downloading the microsoft/powershell:windowsservercore image in the background)

* docker service ls
* docker service inspect secret-service
* docker container ls
* docker container exec -it <ID> PowerShell|sh
* ls C:\ProgramData\Docker\secrets or ls -l /run/secrets/ (inside container)
* cat C:\ProgramData\Docker\secrets\wp-sec-v1 or cat /run/secrets/wp-sec-v1
* docker secret rm wp-sec-v1 (secret is in use === unable to remove secret)
* docker service rm secret-service
* docker secret rm wp-sec-v1 === delete okay after delete secret-service

## Docker Stacks
* docker image build -t nigelpoulton/gsd:swarm-stack .
* docker image push nigelpoulton/gsd:swarm-stack
* docker stack deploy -c docker-compose.yml counter
* docker stack ls
* docker stack services counter
* docker stack ps counter (container)

## [Docker Compose vs Docker stack](https://vsupalov.com/difference-docker-compose-and-docker-stack/)
- Docker Compose is an official tool that helps you manage your Docker containers by letting you define everything through a docker-compose. yml file.
- Docker Stack is a command that's embedded into the Docker CLI. It lets you manage a cluster of Docker containers through Docker Swarm.

## Stacks & Services
* https://github.com/dockersamples/example-voting-app
* curl -o stackfile.yml https://raw.githubusercontent.com/dockersamples/example-voting-app/master/docker-stack.yml
* ls -l => docker-stack.yml
* docker stack deploy -c stackfile.yml voter
* docker stack ls
* docker stack ps voter
* docker stack services voter
* docker service scale voter_vote=20
* docker stack services voter
* docker service inspect voter_vote --pretty
* vim|cat stackfile.yml === Alter the desired state in the stack file (Stackfile.yml) to be 10 replicas for the voter_vote service
* docker stack deploy -c stackfile.yml vote


#### Lock your Swarm with Autolock
- Prevents restarted Managers from automatically re-joing the Swarm
- Prevents accidentally restoring old copies of the Swarm
  * Autolock new Swarm => docker swarm init --autolock
  * Autolock existing Swarm => docker swarm update --autolock=true
  * sudo service docker restart
  * docker swarm unlock ====> docker node ls (works after unlock)
  * docker swarm update--cert-expiry 48h


## Example Dockerfile
```
FROM node:latest
LABEL author="Pedro Alves"
ENV NODE_ENV=production
ENV PORT=3000
COPY 	. /var/www
WORKDIR	/var/www
RUN 	npm install
VOLUME ["/var/www"]
EXPOSE $PORT
ENTRYPOINT ["npm","start"]
```

```
FROM mcr.microsoft.com/dotnet/aspnet:3.1 AS base
WORKDIR /app
EXPOSE 5000

FROM mcr.microsoft.com/dotnet/sdk:3.1 AS build
WORKDIR /src
COPY ["donetSite.csproj", "./"]
RUN dotnet restore "donetSite.csproj"
COPY . .
WORKDIR "/src/."
RUN dotnet build "donetSite.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "donetSite.csproj" -c Release -o /app/publish

FROM base AS final
## run in port 80 if line above is comment
#ENV ASPNETCORE_URLS=http://*:5000 
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "donetSite.dll"]
```

## Example docker-compose.yml
```
version: '3.7'

services:

  node:
    container_name: nodeapp
    image: nodeapp
    build:
      context: .
      dockerfile: node.dockerfile
    ports:
      - "3000:3000"
    networks:
      - nodeapp-network
    depends_on: 
      - mongodb
      
  mongodb:
    container_name: mongodb
    image: mongo
    networks:
      - nodeapp-network

networks:
  nodeapp-network:
    driver: bridge
```