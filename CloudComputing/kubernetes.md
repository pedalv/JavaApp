# KUBERNETES
- [Docker and Kubernetes: The Big Picture](https://app.pluralsight.com/library/courses/docker-kubernetes-big-picture/table-of-contents)
- [Getting Started with Kubernetes](https://app.pluralsight.com/library/courses/kubernetes-getting-started/table-of-contents)
- [Kubernetes for Developers: Integrating Volumes and Using Multi-container Pods](https://app.pluralsight.com/library/courses/kubernetes-developers-integrating-volumes-using-multi-container-pods/table-of-contents)
- [Kubernetes Installation and Configuration Fundamentals](https://app.pluralsight.com/library/courses/kubernetes-installation-configuration-fundamentals/table-of-contents)
- [Kubernetes for Developers: Core Concepts](https://app.pluralsight.com/library/courses/kubernetes-developers-core-concepts/table-of-contents)
- [Kubernetes for Developers: Moving from Docker Compose to Kubernetes (Todo)](https://app.pluralsight.com/library/courses/kubernetes-developers-docker-compose-to-kubernetes/table-of-contents)
- [Webinar: Getting Started with Docker Containers (Todo)](https://app.pluralsight.com/library/courses/getting-started-docker-containers-webinar/table-of-contents)
- [Kubernetes for Developers: Deploying Your Code (Todo)](https://app.pluralsight.com/library/courses/kubernetes-developers-deploying-code/table-of-contents)
- [kubernetes](https://github.com/kubernetes/kubernetes)
- [Kubernetes The Hard Way](https://github.com/kelseyhightower/kubernetes-the-hard-way/)
- [Play with Kubernetes](https://labs.play-with-k8s.com/)
- Kubernetes: (vCenter) - Scheduling, scaling, healing, updating..., Alpha (v1alpha1, v1alpha2,...) => Beta (v1beta1, v1beta2,...) => GA (v1)
- [kubeadm init](https://kubernetes.io/docs/reference/setup-tools/kubeadm/kubeadm-init/#external-ca-mode)
- [Cluster Networking](https://kubernetes.io/docs/concepts/cluster-administration/networking/)

# [KUBERNETES](https://kubernetes.io/) Summary
- Kubernets is an open-source system and provide a robust solution for automating deployment, scaling, and management of containerized application
- Kubernetes (K8s) is an open-source system for automating deployment, scaling, and management of containerized applications.
- Kubernetes is the conductor of a container orchestra.
- Kubernetes provides container orchestration capabilities.
- Use for production, emulating production, testing, and more
- Several options are available to run Kubernetes locally
- Interact with Kubernetes using kubectl  
- Relies on YAML (or JSON) files to represent desire state
- Nodes and pods play a central role
- Master: Also known as head nodes or the control plane
- A container runs in a pod
- Pod
  * A Pod is the basic execution unit of a Kubernetes application-the smallest and simplest unit in the Kubernetes object model that you create or deploy
  * One or more containers
  * It's your application or service === server, caching, APIs, database, etc
  * Pod IP, memory, volumes, etc shared across container
  * Pods live and die but never come back to life  
  * Scale horizontally by adding Pod replicas
  * Pod containers share the same Network namespace (share IP/port)
  * Pod containers have the same loopback network interface (localhost)
  * Container processes need to bind to different ports within a Pod
  * Ports can be reused by containers in separate Pods
  * The most basic unit of work
  * Unit of scheduling
  * Ephemeral - no Pod is ever "redeployed"
  * Atomicity - there or NOT
  * kubernets' job is keeping your Pods running
  * More specifically keeping the desired state an provides a way to move to a desired state
    * State - is the Pod up and running
    * Health - is the application in the Pod running
    * Livenesss probes
- Controllers
  * Create and manage Pods for you
  * Define your desired state
  * Respond to Pod state and health
  * ReplicaSet - Number of replicas
  * Deployment - Manage rollout of ReplicaSet
- Service
  * Adds persistency to our ephemeral world
  * Networking abstraction for Pod access
  * IP and DNS name for the service
  * Redeployed Pods automatically updated
  * Scaled by adding/removing Pods
  * Load balancing
- Container and cluster management
- Support by all major cloud platforms: Google cloud, Kubernetes Engine, cloud.linode.com/kubernetes/create, Windows Azure, etc
- Provides a declarative way to define a cluster's state using manifest files (YAML)
- kubectl can be used to issue commands and interact with the Kubernetes API
- Interact with kubernetes using kubectl
- Kubernetes on your Laptop === on-prem, On-premises software is installed and runs on computers on the premises of the person or organization using the software, rather than at a remote facility such as a server farm or cloud.
- for run kubernetes locally
  * [Minikube](https://github.com/kubernetes/minikube) 
  * [Docker Desktop](https://www.docker.com/products/docker-desktop) 
  * [kind](https://kind.sigs.k8s.io/)
  * [Kubeadm](https://kubernetes.io/docs/reference/setup-tools/kubeadm/)
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

## Kubectl Commands
* PowerShell: Set-Alias -Name k -Value kubectl === Create alias for PowerShell
* Mac/Linux: alias k="kubectl" === Create alias for Mac/Linus shell
* kubectl version (k version) ===  Check Kubernetes version
* kubectl cluster-info (k cluster-info) === View cluster information
* kubectl get all (k get all) === Retrive information about Kubernetes Pods, Deployments, Services, and more
* kubectl run [container-name] image=[image-name] === Simple way to create a Deployment for a Pod
* kubectl port forward [pod] [ports] === Forward a port to allow external access
* kubectl expose ... === Expose a port for a Deployment/Pod
* kubectl create [resource] === Create a resource
* kubectl apply [resource] === Create or modify a resource
* k get pods
* k get services

Steps to enable the Web UI [Dashboard](https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/)
* kubectl apply [dashbord-yaml-url]
  * kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0/aio/deploy/recommended.yaml
* kubectl describe secret -n kube-system
  * Locate the kubernetes.io/service-account-token and copy the token
* kubectl proxy --port 8082
  * netstat -ano | findstr 8081
  * taskkill /F /PID nnnn
  * [Cannot bind to some ports due to permission denied](https://stackoverflow.com/questions/48478869/cannot-bind-to-some-ports-due-to-permission-denied) 
  * [Error listening on port 8001](https://github.com/Azure/azure-cli/issues/6811)
  * [Web UI Dashboard login](http://127.0.0.1:8082/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#/login)
  * [Web UI Dashboard](http://127.0.0.1:8082/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#/overview?namespace=default)
- visit the dashboard URL and login using token

#### Dashboard UI - dockerhub - github
* [Dashboard UI](http://127.0.0.1:8082/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#/overview?namespace=default)
* [dockerhub](https://hub.docker.com/u/pedalv)
* [docker kitematic](https://github.com/docker/kitematic/releases)
* [github](https://github.com/pedalv)

## YAML
- Stateful Application - An application that create and saves data that needs to be kept.
```
- deploy (stateless) sts - statefull apps - Manages updates, Self-healing, scaling, rolling updates, rollbacks...
-- rs - Replica count, self-healing, previous versions, scalability, reliability, desired state...
--- pod - Labels, annotations, co-scheduling, execution...
---- container === app, send to cluster via EKS, GKE, AKS, ... 
    - Master (Linux for cluster) === control plane === head nodes => 3 (5 | 7 masters), 1 Leader and 2 Follower
    - node (Linux or Windows for Apps) === worker nodes
    * Register node with cluster
    * Watches API Server for work tasks (Pods)
    * Executes Pods
    * Reports back to Master
      gVisor and katacontainers
```
- send to cluster
* Elastic Container Service for Kubernetes ([EKS](https://aws.amazon.com/getting-started/hands-on/deploy-kubernetes-app-amazon-eks/)),
* Google Kubernetes Engine ([GKE](https://cloud.google.com/kubernetes-engine/docs/how-to/)), and 
* Azure Kubernetes Services ([AKS](https://docs.microsoft.com/en-us/azure/aks/kubernetes-walkthrough))


## Kubernetes Installation and Configuration Fundamentals 
- [Install and Set Up kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)
Steg 1 - Install with PowerShell from PSGallery
- PS > Install-Script -Name 'install-kubectl' -Scope CurrentUser -Force
- PS > install-kubectl.ps1 C:\kubectl

or Steg 1 - Install with PowerShell from PSGallery
- choco install Kubernetes-cli

or Steg 1 - Install with PowerShell from PSGallery
- scoop install kubectl

or Steg 1.1
- https://storage.googleapis.com/kubernetes-release/release/stable.txt
- https://dl.k8s.io/release/v1.20.4/bin/windows/amd64/kubectl.exe
- https://dl.k8s.io/release/v1.20.4/bin/windows/amd64/kubectl.exe.sha256

and Steg 1.2
* CertUtil -hashfile kubectl.exe SHA256
* type kubectl.exe.sha256
* $($(CertUtil -hashfile .\kubectl.exe SHA256)[1] -replace " ", "") -eq $(type .\kubectl.exe.sha256)

and Steg 1 for Ubuntu
* apt-get update
* apt-get install -y kubelet kubeadm kubectl docker.io
* apt-mark hold kubelet kubeadm kubectl docker.io

Steg 2 - Add the binary in to your PATH, D:\tools\kubernetes

Steg 3 - kubectl version --client

> Client Version: version.Info{Major:"1", Minor:"19", GitVersion:"v1.19.3", GitCommit:"1e11e4a2108024935ecfcb2912226cedeafd99df", GitTreeState:"clean", BuildDate:"2020-10-14T12:50:19Z", GoVersion:"go1.15.2", Compiler:"gc", Platform:"windows/amd64"}

* PS > kubectl version --short

> Client Version: v1.19.3

> Unable to connect to the server: dial tcp [::1]:8080: connectex: No connection could be made because the target machine actively refused it.

* PS > kubectl version --short

> Client Version: v1.20.4

> Server Version: v1.19.3

- PS > docker --version

> Docker version 20.10.2, build 2291f61

- PS > kubectl get pods -n kubesystem
> Unable to connect to the server: dial tcp [::1]:8080: connectex: No connection could be made because the target machine actively refused it.

- PS D:\> kubectl get pods --kubeconfig=C:\Users\p\.kube\config -n kube-system

- Creating a master (Nodes) === [Calico](https://docs.projectcalico.org/getting-started/kubernetes/) 
  * vi calico.yaml, https://docs.projectcalico.org/manifests/calico.yaml
  * sudo kubeadm init --pod-network-cidr=192.168.0.0/16 (--kubernetes-version 1.19.1 for install last version)
  * mkdir -p $HOME/.kube
  * sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
  * sudo chown $(id -u):$(id -g) $HOME/.kube/config
  * kubectl apply -f calico.yaml
  * kubectl get pods --all-namespaces
  * **kubectl get pods --all-namespaces --watch**
  * kubectl get pods --all-namespaces
  * kubectl get nodes
  * sudo systemctl status kubelet.service
  * ls /etc/kubernetes
  * ls /etc/kubernetes/manifests
  * sudo more /etc/kubernetes/manifests/etcd.yaml
  * sudo more /etc/kubernetes/manifests/kube-apiserver.yaml
- Creating a Nodes
  * ssh aen@c1-node1 
  * See CreateNodes.sh file
- Cloud 
  * See CreateAKSCluster.sh, CreateGKECluster.sh files

## [Operations](https://kubernetes.io/docs/reference/kubectl/overview/#operations) and - [Overview of kubectl](https://kubernetes.io/docs/reference/kubectl/overview/)
* apply/create - create resource(s)
* run - start a pod from an image
* explain - documentation of resources
* delete - delete resource(s)
* get - list resources
* describe - detailed resource information
* exec - execute a command on a container
* logs - view logs on a container

## [Resource types](https://kubernetes.io/docs/reference/kubectl/overview/#resource-types)
## [Output options](https://kubernetes.io/docs/reference/kubectl/overview/#output-options)
## [kubectl](https://kubernetes.io/docs/reference/kubectl/kubectl/)
## [kubectl Cheat Sheet](https://kubernetes.io/docs/reference/kubectl/cheatsheet/)
## Application Deployment in Kubernetes
- Imperative
  * kubectl create deployment nginx --image=nginx
  * kubectl run nginx --image=nginx
  * Example: kubectl run [podname] --image=nginx:alpine
- Declarative   
  * Define our desired state in code
  * Manifest
  * YAML or JSON
  * kubectl apply -f deployment.yaml
 
## Getting Started with Kubernetes - Pre-created image - YAML manifests are in 'Pods', 'Services', and 'Deployments'
- Example 1: Pods 
  * git clone https://github.com/nigelpoulton/getting-started-k8s.git
  * cd getting-started-k8s/Pods
  * kubectl apply -f pod.yml
  * kubestl get pods === List all pods in ps output format.
  * kubectl get pods -o wide === List all pods in ps output format with more information (such as node name).
  * route
  * ip addr
  
- Example 2: Service - SVC IP is not trush
  * kubectl expose pod hello-pod --name=hello-svc -- target-port=8080 --type=NodePort === Create a service for a pod hello-pod
  * kubectl get svc === List one or more resources by their type and names.
  * kubectl delete svc hello-svc === Delete resources by filenames, stdin, resources and names, or by resources and label selector.
  * kubectl get pods --show-labels
  
- Example 2: Service - correct way with yml file
  * kubectl apply -f svc-nodeport.yml
  * kubectl describe scv ps-nodeport === Show details of a specific resource or group of resources
  
- Example 3: deploy
  * kubectl apply -f deploy.yml
  * kubectl get pods
  * kubectl get deploy
  * kubectl get rs
  * kubectl get svc
  * kubectl describe svc ps-lb
  * kubectl get pods --show-labels
  * kubectl get ep
  * kubectl describe ep ps-lb
  * kubectl delete pod <name>
  * kubectl get pods -o wide
  
- Example 4: Rollbacks
  * **kubectl get pods --watch**
  * kubectl rollout status deploy web-deploy
  * kubectl apply -f deploy.yml
  * kubectl get rs
  * kubectl rs <name>
  * kubectl rollout history deploy web-deploy
  * kubectl rollout undo deploy web-deploy --to-revision=1
  
- Commands
  * kubectl version --client
  * kubectl version --short
  * kubectl get nodes
  * kubectl cluster-info
  * kubectl apply -f pod.yml
  * kubectl delete -f multi-pod.yml
  * kubectl get pods
  * **kubectl get pods --watch**
  * kubectl get pods -o wide
  * kubectl describe pods hello-pod

## Kubernetes for Developers: Integrating Volumes and Using Multi-container Pods
- Persistent Volume Subsystem PVS, Container Storege Interface CSI
- [Container Storage Interface](https://github.com/container-storage-interface)
- [Kubernetes CSI](https://github.com/kubernetes-csi)

* kubectl exec -it sc-pod -c helper-ctr /bin/bash
* echo 'Pluralsight FTW!!' > ./data/index.html
* kubectl exec block-pod -- ls -l /dev

* kubectl exec -it origin-pod /bin/bash
* echo 'I am the original' > /data/file
* kubectl exec clone-pod -- cat /data/file
* kubectl exec origin-pod -- cat /data/file

* kubectl explain pods --recursive
* kubectl explain pods.spec.restartPolicy

* kubectl logs ps-init -c init-ctr

* kubectl exec -t ambassador-app /bin/bash

* kubectl cluster-info
* ls ~/.kube/cache|config|http-cache

* kubectl config current-context

* kubectl get sa (serices account)
* kubectl describe sa default
* kubectl get secret <default-token-dmcfa>
* kubectl describe secret default <default-token-dmcfa>
* kubectl get sa default -o yaml
* kubectl exec -it k8s-api bash
* ls /vaar/run/secrets/kubernets.io/serviceaccount/ (ca.crt namespace token)
* RBAC Role Based Access Control
* kubectl get clusterrolebindings
* kubectl delete clusterrolebindings
* kubectl create serviceaccount service-reader
* kubectl describe sa service-reader

## Example Pod YAML file
```
apiVersion: v1
kind: Pod
metadata:
  name: my-nginx
  labels:
    app: nginx
    rel: stable
    
    //--save-config
    annotations:
    kubectl.kubernetes.io/
    last applied configuration: 
    {
        "apiVersion":"v1",
        "kind":"Pod",
        "nametadata": {
          "name": "my-nginx"
          ...
          }
    }
    
spec:
  containers:
    - name: my-nginx
      image: nginx:alpine
      ports:
      - containerPort: 80
```

## Kubernetes for Developers: Core Concepts

#### Running a Pod, view and delete
 * kubectl run command
   * kubectl run [podname] --image=nginx:alpine
    * kubectl get pods === List only Pods
    * kubectl get all === List all resources
    * kubectl port-forward [name-of-pod] 8080:80 === Expose a Pod Port "external por":"Internal port"
    * kubectl delete pod [name-of-pod] === will cause pod to be recreated
    * kubectl delete deployment [name-of-deployment] === Delete Deployment that manages the Pod
    * kubectl delete -f file.pod.yml === Detele Pod using YAML file thet created it
 * kubectl create/apply command with a yaml file
    * kubectl create -f file.pod.yml --dry-run validate=true === Perform a "trial" create and also validate the YAML
    * kubectl create -f file.pod.yml === Create a Pod from YAML, will error if Pod already exists

- Creating or Applying Changes to a Pod
  * kubectl apply -f file.pod.yml === Alternate way to create or apply changes to a Pod from YAML
  * kubectl create -f file.pod.yml --save-config === Use --save-config (Store current properties in resource's annotations) when you want to use kubectl apply in the future
    * In-place/non-disruptive changes can also be made to a Pod by
        * kubectl edit -f nginx.pod.yml or
        * kubectl patch f nginx.pod.yml  
    * kubectl describe pod [pod-name] 
    * kubectl exec [pod-name] -it sh

#### LAB: PowerShell
```
Set-Alias -Name k -Value kubectl
k run my-nginx --image=nginx:alpine
k get pods
k get services
k port-forward my-nginx  8080:80
k get pods
k delete pod my-nginx
k get pods

cd .\Pluralsight\kubernetes-developers-core-concepts
k create -f .\nginx.pod.yml --save-config
k get pods
k get pod my-nginx -o yaml
k apply -f .\nginx.pod.yml
k describe pod my-nginx
k get pods
k exec my-nginx -it sh
k edit -f .\nginx.pod.yml
k delete -f .\nginx.pod.yml
```

## Pod Health
- Kubernetes relies on Prodes to determine the health of a Pod container
- A Prode is a diagnostic performed periodically by the kubelet on a Container: Success - Failure - Unknow
- Types of Prodes, Failed Pod containers are recreated by default (restartPolicy defaults to Always)
  * Liveness prode: determine if a Pod is healthy and running as expected    
  * Readiness Prode: determine if a Pod should receive requests
  * ExecAction: Executes an action inside the container
  * TCPSocketAction: TCP check against the container's IP address on a specified port
  * HTTPGetAction: HTTP GET request against container

#### Lab
```
Set-Alias -Name k -Value kubectl
k create -f .\nginx.pod.yml
k exec my-nginx -it sh
  cd /usr/share/nginx/html
  rm -rf index.html
exit  
k describe my-nginx
k delete -f .\nginx.pod.yml

k create -f .\healthy.nginx.pod.yml
k get pods
k describe pod my-healthy-nginx
k delete -f .\healthy.nginx.pod.yml
```

## Deployment
- A ReplicaSet is a declarative way to manage Pods
- A Deployment is a declarative way to manage Pods using a ReplicaSet
- Deployment and ReplicaSets ensue Pods stay running and can be used to scale Pods
- ReplicaSets act as a Pod controller:
  * Self-healing mechanism
  * Ebsure the requested number of Pods are available
  * Provide fault-tolerance
  * cab be used to scale Pods
  * Relies on a Pod template
  * No need to create Pods directly!
  * Used by Deployments
- A Deployment manages Pods:
  * Pods are manager using ReplicaSets
  * Scales ReplicaSets, which scale Pods
  * Supports zero-downtime updates by creating and destroying ReplicaSets
  * Provides rollback functionality
  * Creates a unique label thet is assigned to the ReplicaSet and generated Pods
  * YAML is very similar to a ReplicaSet
- Deployment Options
  * Rolling updates
  * Blue-green deployments
  * Canary deployments
  * Rollbacks
- Pods are deployed, managed, and scaled using deployments and ReplicaSets
- Deployments are a higher-level resource that define one or more Pod templates
- The kubectl create or apply commands can be used to run a deployment
- Kubernetes supports zero downtime deployments

#### Running a deployment, view and delete
* kubectl create -f nginx.deployment.yml --save-config === Create a Deployment
* kubectl create -f file.deployment.yml === Create a Deployment
* kubectl describe [pod | deployment] [pod-name | deployment name]
* kubectl apply -f nginx.pod.yml === Alternate way to create or apply changes to a Deployment from YAML
* kubectl get deployments === List all Deployments
* kubectl get deployment(s) --show-labels === List all Deployments and their labels
* kubectl get deployment -l app=nginx === Get all Deployments with a specific label
* kubectl delete deployment [deployment name] === Delete Deployment
* kubectl delete -f nginx.pod.yml === Delete Deployment with YAML
* kubectl scale deployment [deployment-name] --replicas=5 === Scale the Deployment Pods to 5
* kubectl scale -f file.deployment.yml --replicas=5 === Scale by refencing the YAML file


## Example Deployment YAML file
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: my-nginx
  labels:
    app: my-nginx
spec:
  replicas: 2
  selector:
    matchLabels:
      app: my-nginx
  template:
    metadata:
      labels:
        app: my-nginx
    spec:
      containers:
        - name: my-nginx
          image: nginx:alpine
          ports:
            - containerPort: 80
          resources:
            limits:
              memory: "128Mi" #128 MB
              cpu: "200m" #200 millicpu (.2 cpu or 20% of the cpu)
```

#### Lab
```
Set-Alias -Name k -Value kubectl
cd .\Pluralsight\kubernetes-developers-core-concepts\
k create -f .\nginx.deployment.yml --save-config
k get all
k describe deployment my-nginx
k get deploy
k get deployments -l app=my-nginx
k get all
k scale -f .\nginx.deployment.yml --replicas=5
k get all
k delete -f .\nginx.deployment.yml

cd .\Pluralsight\GitHub\DockerAndKubernetesCourseCode\samples\deployments\node-app (files from the course)
docker build -f .\v1\dockerfile -t node-app:1.0 .\v1\.
docker build -f .\v2\dockerfile -t node-app:2.0 .\v2\.
docker build -f .\v3\dockerfile -t node-app:3.0 .\v3\.
k get all
k apply -f .\node-app-v1.deployment.yml
k get all
k apply -f .\node-app-v2.deployment.yml
k get all
k apply -f .\node-app-v3.deployment.yml
k get all

k delete -f .\node-app-v1.deployment.yml
k delete -f .\node-app-v2.deployment.yml
k delete -f .\node-app-v3.deployment.yml
```

## Service
- A Service provides a single point of entry for accessing one or mor Pods
  * Since Pods live and die, we can not rely on their IP. So that's why we need Services - IPs change a lot 
- The Life of a Pod
  * Pods are "mortal" and may only live a short time (ephemeral)
  * You can't rely on a Pod IP adddress staying the same
  * Pods can be horizontally scaled so each Pod gets its own IP address
  * A Pod gets an IP address after it has been schedule (no way for client to know IP ahead of time)
- The Role of Services
  * Services abstract Pod IP addresses from consumers
  * Load balances between Pods
  * Relies on labels to associate a Service with a Pod
  * Node's kube-proxy creates a vurtual IP for Services
  * Layer 4 (TCP/UDP over IP)
  * Services are not ephemeral
  * Creates endpoints which sit between a Service and Pod
- Services types
  * ClusterIP: Expose the service on a cluster-internal IP (default)
    * Service IP is exposed internally within the cluster
    * Only Pods within the cluster can talk to the Service
    * Allows Pods to talk to other Pods
  * NodePort: Expose the service on each Node's IP at a static port
    * Exposes the Service on each Node's IP at a static port
    * Allocates a port from a range (default is 30000-32767)
    * Each Node proxies the allocated port
  * LoadBalancer: Provide an external IP to act as a load balancer for the service
    * Exposes a Service externally
    * Useful when combined with a cloud provider's load balancer
    * NodePort and ClusterIP Service are created
    * Each Node proxies the allocated port
  * ExternalName: Maps a service to a DNS name
    * Services thar acts as an alias for an external service
    * Allows a Service to act as the proxy for an external service
    * External service details are hidden from cluster (easier to change)

#### Running a service, view and delete
* kubectl port-forward pod/[pod name] 8080:80 === Listen on port 8080 locally and forward to port 80 in Pod
* kubectl port-forward deployment/[deployment name] 8080 === Listen on port 8080 locally and forward to Deployment's Pod 
* kubectl port-forward service/[service name] 8080 === Listen on port 8080 locally and forward to Service's Pod
* kubectl create -f file.service.yml === Create a Service
* kubectl apply -f file.service.yml === Update a Service, Assumes save config was used with create
* kubectl delete -f file.service.yml === Delete a Service
* kubectl exec [pod-name] curl s http://podIP == Shell into a Pod and test a URL. Add -c [containerID] in cases where multiple containers are running in the Pod
* kubectl exec [pod-name] -it sh === Install and use curl (example shown is for Alpine Linux)
  * > apk add curl
  * > curl -s http://podIP

#### Lab
```
Set-Alias -Name k -Value kubectl
cd .\Pluralsight\GitHub\DockerAndKubernetesCourseCode\samples\deployments (files from the course)
k apply -f .\nginx.deployment.yml
k get all
k get pods
k port-forward pod/my-nginx-5bb9b897c8-7d2jb 8080:80
k get deploy
k port-forward deployment/my-nginx 8080:80
http://localhost:8080/
k delete -f .\nginx.deployment.yml


cd .\Pluralsight\GitHub\DockerAndKubernetesCourseCode\samples\services
k create service -f .\clusterIP.service.yml
k create -f .\clusterIP.service.yml
k get services
k get pods
k exec my-nginx-5bb9b897c8-cx9kg -it sh
- inside pod
  apk add curl
  curl http://10.1.0.54
  curl http://10.107.21.38:8080
  curl http://nginx-clusterip:8080
  exit

- other termninal to get podId
Set-Alias -Name k -Value kubectl
k get pods
k get pod my-nginx-5bb9b897c8-7d2jb -o YAML
k get services
k delete -f .\clusterIP.service.yml
  
k create -f .\nodeport.service.yml or k apply -f .\nodeport.service.yml
http://localhost:31000/

k create -f .\loadbalancer.service.yml
http://localhost
k delete service nginx-loadbalancer
```

## Storage Options
- Store application state/data and exchange it between Pods with Kubernetes via Volumes or database
- A Volume can be used to hold data and state for Pods and containers
- Pod State and Data
  * Pods live and die so their file system is short-lived (ephemeral)
  * Volumes cab be used to store state/data and use it in a Pod
  * A Pod can have multiple Volumes to access a Volume
  * Kubernetes supports:
    * Volumes
    * PersistentVolumes (PV)
      * PV is a cluster-wide storage unit provisioned by an administrator with a lefecycle independent from a Pod
      * PV is a cluster-wide storage resource that relies on network-attached storage (NAS)
      * Normally provisioned by a cluster administrator
      * Available to a Pod even if it gets rescheduled to a different Node
      * Rely on a sttage provider such as NFS, cloud storage, or other options
      * Assosciated with a Pod by using a PVC
    * PersistentVolumesClaims (PVC)
      * PCV is a request for a storage unit (PV)
    * StorageClasses (SC)
      * SC is a type of storage template that can be used to dynamically provision storage
      * Used to define different "classes" of storage
      * Act as a type of storege template
      * Supports dynamic provisioning of PV
      * Supports dynamic provisioning od PV
      * Administrators don't have to create PVs in advance
- Volumes an Volumes Mounts
  * A Volume references a storage location
  * Must have a unique name
  * Attached to a Pod and may or may not be tied to the Pod's lifetime (depending on the Volume type)
  * A Volume Mount references a Volume by name and defines a mountPath
- Volumes Type Examples
  * emptyDir: Empty directory for storing "transient" data (shares a Pod's lifetime) usefull for sharing files between containers in a Pod
  * hostPath: Pod mounts into the node's filesystem
  * nfs - An NFS (Network File Syste,) share mounted into the Pod
  * configMap/secret: Special types of columes that provide a Pod with access to Kubernetes resources
  * persistentVolumeClaim: Provides Pods with a more persistent storage option that is abstracted from the details
  * Cloud: Cluster-wide storage
- Cloud Volumes
  * Cloud providers (Azure, AWS, GCP, etc) support different types of Volumes:
    * Azure: Azure Disk and Azure File
    * AWS: Elastic Block Store
    * GCP: GCE Persistent Disk

#### Viewing a Pod's Volumes
* kubectl describe pod [pod name] === Describe Pod
* kubectl get pod [pod name] -o yaml === Get Pod YAML

#### Lab 
- emptyDir
```
Set-Alias -Name k -Value kubectl
cd .\Pluralsight\GitHub\DockerAndKubernetesCourseCode\samples\volumes
k apply -f nginx-alpine-emptyDir.pod.yml
k port-forward nginx-alpine-volume 8080:80
http://localhost:8080/
k delete -f nginx-alpine-emptyDir.pod.yml
```

- hostPath
```
Set-Alias -Name k -Value kubectl
cd .\Pluralsight\GitHub\DockerAndKubernetesCourseCode\samples\volumes
k apply -f docker-hostPath.pod.yml
k get pods
k describe pod docker-volume 
# Once Pod is created you can shell into it to run Docker commands:
k exec docker-volume -it sh
  #inside the pod
  docker
  docker ps -a
```

- PersistentVolume (PV) Workflow, [examples](https://github.com/kubernetes/examples)
  1. Create network storage resource (NFS, cloud, etc)
  2. Define a Persistent Volume (PV) and send to the Kubernetes API
  3. Create a PersistentVolumeClaim (PVC)
  4. Kubernetes binds the PVC to the PV
  5. Pod Volumes references the PVC

- StorageClass (SC) Workflow === cloud or local network (database), [statefulset](https://kubernetes.io/docs/concepts/workloads/controllers/statefulset/), [storage-classes (provisioner)](https://kubernetes.io/docs/concepts/storage/storage-classes/#provisioner)
  1. Create StorageClass (SC)
  2. Create PersistentVolumeClaim (PVC) that references StorageClass (SC)
  3. Kubernetes uses StorageClass (SC) provisioner to provision a PersistentVolume (PV)
  4. Storage provisioned, PersistentVolume (PV) created and bound to PersistentVolumeClaim (PVC)
  5. Pod volume references PersistentVolumeClaim (PVC)

```
Set-Alias -Name k -Value kubectl
cd .\Pluralsight\GitHub\DockerAndKubernetesCourseCode\samples\volumes\pv-pvc-sc-cm
docker pull mongo
docker images
docker image inspect mongo
k create -f .\mongo.deployment.win.yml --save-config
k get pods
k describe pod mongo
k exec mongo-0 -it sh
  #inside pod
  mongo
#mange files in C:\temp\data\db
kubectl describe pod mongo-0
k get pv
k delete -f .\mongo.deployment.win.yml   
``` 

#### ConfigMaps
- ConfigMaps provide a way to store configuration information and provide it to containers
- Provides a way to inject configuration data into a container
- Can store entire files or provide key/value pairs
  * Store in a File. Key is the filename, value is the file content (can be JSON, XML, keys/values, etc)
  * Provide on the command-line
  * ConfigMap manifest
- Accessing ConfigMap Data in a Pod
  * Environment variables  (key/value)
  * ConfigMap Volume (access as files)

#### Create, delete, etc a ConfigMap 
* kubectl create -f file.configmap.yml === Create from a ConfigMap manifest 
* kubectl create configmap [cm-name] --from-file=[path to file] === Create a ConfigMap using data from a file
* kubectl create configmap [cm name] --from-env-file=[path to file] === Create a env ConfigMap using data from a file
* kubectl create configmap [cm name] --from-literal=apiUrl=https://my-api --from-literal=otherKey=otherValue ... === Create a ConfigMap from individual data values
* kubectl get cm [cm-name] -o yaml === Get a ConfigMap
* kubectl delete cm [cm name]

#### Lab
```
Set-Alias -Name k -Value kubectl
cd .\Pluralsight\GitHub\DockerAndKubernetesCourseCode\samples\configMaps
docker build -t node-configmap .
kubectl create cm app-settings --from-env-file=settings.config
k get cm
k get cm app-settings -o yaml
kubectl apply -f node.deployment.yml
k get pods
k port-forward node-configmap-577f5d6b98-t22fv 9000
k exec node-configmap-577f5d6b98-t22fv -it sh
  #inside th epod 
  cd /etc/config 
  ls
  cat enemies => aliens
  cat enemies.cheat => true
  cat enemies.cheat.level => noGoodRotten
  cat lives => 3
```

#### [Secrets - best-practices](https://kubernetes.io/docs/concepts/configuration/secret/#best-practices)
- A secret is an object that contains a small amount of sensitive data such as a password, a token, or a key
- Kubernetes can store sensitive information (passwords, keys, certificates, etc)
- Avoid storing secrets in container images, in files, or in deployment manifests
- Use caution when working with Secrets and ensure proper security is in place  
- Mount secrets into pods as files or as environment variables
- Kubernetes only makes secrets available to Nodes that have a Pod requesting the secret
- Secrets are stored in tmpfs on a Node (not on disk)
- Enable encrytion at rest for cluster data - [encrypt-data](https://kubernetes.io/docs/tasks/administer-cluster/encrypt-data/)
- Limit access to etcd (where Secrets are stored) to only admin users
- Use SSL/TLS for etcd peer-to-peer communications
- Manifest (YAML/JSON) files only base64 encode the Secret
- Pods can access Secrets to secure which users can create Pods. Role-based access control (RBAC) can be used
- [Secrets best practices](https://kubernetes.io/docs/concepts/configuration/secret/#best-practices)

#### Create, delete, etc a Secret
* kubectl create secret generic my-secret --from-literal=pwd=my-password === Create a secret and store securely in Kubernetes
* kubectl create secret generic my-secret --from-file=ssh-privatekey=~/.ssh/id_rsa --from-file=ssh-publickey=~/.ssh/id_rsa.pub === Create a secret from a file
* kubectl create secret tls tls-secret --cert=path/to/tls.cert --key=path/to/ tls.key === Create a secret from a key pair
* kubectl get secrets === Get secrets
* kubectl get secrets db-passwords -o yaml ===  Get YAML for specific secret
- You can declaratively define secrets using YAML, but any secret data is only base64 encoded in the manifest file!
  * Use caution when working with Secrets and ensure proper security is in place
- Secrets provide a way to store sensitive data or files
- Access key/value pairs using environment variables or volumes
* k exec [mongo-pod-name] -it sh
* kubectl delete pod [mongo-pod-name] === Delete the mongo Pod

#### Lab
```
Set-Alias -Name k -Value kubectl
cd .\Pluralsight\GitHub\DockerAndKubernetesCourseCode\samples\
#on Windows go into `mongo.deployment.win.yml` and change the PersistentVolume's local path to `/c/temp/data/db`. Save the file.
kubectl create secret generic db-passwords --from-literal=db-password='password' --from-literal=db-root-password='password' === Run the following to add the database passwords as secrets
k get secrets
kubectl create -f mongo.deployment.yml === Start up the Pod
k get pods
kubectl port-forward mongo-0 27017 === If you have a tool that can hit MongoDB externally  to the pod to expose 27017.
k exec mongo-0 -it sh
   #Inside the Pod
    cd /etc/db-passwords
    ls
    cat deb-password => password    
    mongo === to make sure the database is working
    exit 
kubectl delete pod mongo-0 === Delete the mongo Pod
kubectl get pv === Once the pod is deleted, run it and note the reclaim policy that's shown and the status (should show Bound since the policy was Retain)  
kubectl delete -f mongo.deployment.yml === Delete everything else 
```
## Putting It All Together
- Accessing Logs
* kubectl logs [pod-name] === View the logs for a Pod's container
* kubectl logs [pod-name] -c [container-name] === View the logs for a specific container within a Pod
* kubectl logs -p [pod-name] === View the logs for a previously running Pod
* kubectl logs -f [pod-name] === Stream a Pod's logs

- Getting Details about a Pod
* kubectl describe pod [pod-name] === Describe a Pod
* kubectl get pod [pod-name] -o yaml === Change a Pod's output format
* kubectl get deployment [deployment-name] -o yaml === Change a Deployment's output format

- Shell into a Pod container
* kubectl exec [pod-name] -it sh === Shell into a Pod container

- YAML manifest files are used to define different Kubernetes resources
- kubectl create or apply can be used with -f to deploy multiple manifest files
- Learning different Pod trobleshooting commands and teckniques is important to resolve issues

#### Lab
```
Set-Alias -Name k -Value kubectl
cd .\Pluralsight\GitHub\CodeWithDanDockerServices
# Ubuntu
export APP_ENV=development
export DOCKER_ACCT=codewithdan
# Windowns DOS      
set APP_ENV=development
set DOCKER_ACCT=codewithdan
# Windows Powershell
$env:APP_ENV="development"
$env:DOCKER_ACCT="codewithdan"
- Run
npm install === to install the Node.js dependencies for the project (when running containers in development mode since a volume is defined docker-compose.yml file)
docker-compose build
docker-compose up
Visit http://localhost in a browser

# Windows Powershell
$env:APP_ENV="production"
$env:DOCKER_ACCT="codewithdan"
docker-compose build
kubectl create secret generic db-passwords --from-literal=db-password='password' --from-literal=db-root-password='password'
k get secrets
kubectl create -f .k8s
k get all
Open the browser and go to http://localhost === (mongoDB feil in windows)

kubectl delete -f .k8s

kubectl apply -f .k8s
k get pods
k get pod mongo-0 -o yaml
k describe pod mongo-0
k logs mongo-0
k logs nginx-6669dbb5c-p5vt7
k describe pod node-f7b7d579c-mxbmd
k logs node-f7b7d579c-mxbmd
Open the browser and go to http://localhost === (mongoDB feil in windows)

docker-compose build (if there is feil and correction on file as comfig.productiom.json)
k get pods --watch
kubectl apply -f .k8s
Open the browser and go to http://localhost === (mongoDB feil in windows)
#NOTE: The local storage hostname volume is commented out in the `.k8s/mongo.deployment.yml` StatefulSet because MongoDB doesn't support that type of volume correctly on Docker for Windows. It does work on Mac/Linux. You'd need to create a `/tmp/data/db` directory and then uncomment the `volumes` and `volumeMounts` properties (and sub-properties) in the StatefulSet to actually use the volume on Mac/Linux.

l get pods
k exec node-f7b7d579c-n2p4q -it sh
  #inside the pod
  apk add curl
  curl http://node:8080  (node.servie.yml)
  
kubectl delete -f .k8s  
```

#### Load Balancer versus Port Forwarding
- This demo includes a LoadBalancer service for the nginx Pod which is why you can hit http://localhost.
- To expose a specific port for localhost for the nginx Pod, get the name of the `nginx` pod by running
`kubectl get pods` and use the pod name in the following command: `sudo kubectl port-forward [name-of-nginx-pod] 8080:80`
- Note that sudo is needed to enable port 80 in this case on Mac. You can choose a different port as well such as 8081:80.

#### Running with Skaffold
-  Open a command-prompt at the root of the project
- Run the following to add the database passwords as secrets (yes - these are simple passwords for the demo :-)): `kubectl create secret generic db-passwords --from-literal=db-password='password' --from-literal=db-root-password='password'`
- Install Skaffold from https://skaffold.dev.
- Run the following command at the root of the project: `skaffold dev`


# Resume

![K8s Orchestrator](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/game_orchestrator.PNG)


![K8s View](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/kubernetes_view.PNG)

![K8s Service](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/kubernetes_service.PNG)

![K8s Network](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/kubernetes_network.PNG)


![K8s Pods](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/Kubernetes_Pods.PNG)

![K8s Pods + App + Service](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/Kubernetes_Pods_app_service.PNG)



![K8s Deploy](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/kubernetes_deploy_rs_pod_app.PNG)

![K8s Container](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/run_demo_container_service-2.PNG)



![K8s Cluster](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/K8s_cluster-1.PNG)

![K8s Cluster View](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/K8s_cluster-2.PNG)

![K8s Master](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/kubernetes_master.PNG)

![K8s Node](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/kubernetes_node.PNG)

![Kubernetes deployments vs. pods: What's the difference?](https://www.techtarget.com/searchitoperations/answer/Kubernetes-deployments-vs-pods-Whats-the-difference)
- A pod is the core building block for running applications in a Kubernetes cluster; 
- A deployment is a management tool used to control the way pods behave
  - A deployment is responsible for keeping a set of pods running.
  - For instance, instead of manually upgrading the container image version in a pod, you can use a deployment to tell Kubernetes to do it automatically with a single file and command.
- A service is responsible for enabling network access to a set of pods.
- ![Kubernets Network Topology](https://github.com/pedalv/JavaApp/blob/master/CloudComputing/kubernets-network-topology.JPG)
## API Discovery 
- Get information about our current cluster context, ensure we're logged into the correct cluster.
``` kubectl config get-contexts ```

- Change our context if needed by specifying the Name
``` kubectl config use-context kubernetes-admin@kubernetes ```

- Get information about the API Server for our current context, which should be kubernetes-admin@kubernetes
``` kubectl cluster-info ```

- Get a list of API Resources available in the cluster
``` kubectl api-resources | more ```

- **Using kubectl explain to see the structure of a resource...specifically it's fields**
- In addition to using the API reference on the web this is a great way to discover what it takes to write yaml manifests
``` kubectl explain pods | more ```

- Let's look more closely at what we need in pod.spec and pod.spec.containers (image and name are required)
``` 
kubectl explain pod.spec | more
kubectl explain pod.spec.containers | more
```

- Let's check out some YAML and creating a pod with YAML
``` kubectl apply -f pod.yaml ```

- Get a list of our currently running pods
``` kubectl get pods ```


- Remove our pod...this command blocks and can take a second to complete
``` kubectl delete pod hello-world ```


- Working with kubectl dry-run
- Use kubectl dry-run for server side validatation of a manifest...the object will be sent to the API Server.
- dry-run=server will tell you the object was created...but it wasn't...
- it just goes through the whole process but didn't get stored in etcd.
``` kubectl apply -f deployment.yaml --dry-run=server ```

- No deployment is created
``` kubectl get deployments ```


- Use kubectl dry-run for client side validatation of a manifest...
``` kubectl apply -f deployment.yaml --dry-run=client ```

- Let's do that one more time but with an error...replica should be replicas.
``` kubectl apply -f deployment-error.yaml --dry-run=client ```

- Use kubectl dry-run client to generate some yaml...for an object
``` kubectl create deployment nginx --image=nginx --dry-run=client ```

- Combine dry-run client with -o yaml and you'll get the YAML for the object...in this case a deployment
``` kubectl create deployment nginx --image=nginx --dry-run=client -o yaml | more ```


- Can be any object...let's try a pod...
``` kubectl run pod nginx-pod --image=nginx --dry-run=client -o yaml | more ```

- We can combine that with IO redirection and store the YAML into a file
``` 
kubectl create deployment nginx --image=nginx --dry-run=client -o yaml > deployment-generated.yaml
more deployment-generated.yaml
```

- And then we can deploy from that manifest...or use it as a building block for more complex manfiests
``` kubectl apply -f deployment-generated.yaml ``` 

- Clean up from that demo...you can use delete with -f to delete all the resources in the manifests
``` kubectl delete -f deployment-generated.yaml ```

- Working with kubectl diff
- Create a deployment with 4 replicas
``` kubectl apply -f deployment.yaml ```

- Diff that with a deployment with 5 replicas and a new container image...you will see other metadata about the object output too.
``` kubectl diff -f deployment-new.yaml | more ```

- Clean up from this demo...you can use delete with -f to delete all the resources in the manifests
``` kubectl delete -f deployment.yaml ```

- Let's ask the API Server for the API Resources it knows about.
``` kubectl api-resources | more ```

- A list of the objects available in a specific API Group such as apps...try using another API Group...
``` kubectl api-resources --api-group=apps ```

- We can use explain to dig further into a specific API Resource and version
- Check out KIND and VERSION, we'll see the API Group in the from group/version
- Deployments recently moved from apps/v1beta1 to apps/v1
``` kubectl explain deployment --api-version apps/v1 | more ```

- Print the supported API versions and Groups on the API server again in the form group/version.
- Here we see several API Groups have several versions in various stages of release...such as v1, v1beta1, v2beta1...and so on.
``` kubectl api-versions | sort | more ```

- Anatomy of an API Request
- Creating a pod with YAML
``` kubectl apply -f pod.yaml ```

- Get a list of our currently running Pods
``` kubectl get pod hello-world ```

- We can use the -v option to increase the verbosity of our request.
- Display requested resource URL. Focus on VERB, API Path and Response code
``` kubectl get pod hello-world -v 6 ```

- Same output as 6, add HTTP Request Headers. Focus on application type, and User-Agent
``` kubectl get pod hello-world -v 7 ```

- Same output as 7, adds Response Headers and truncated Response Body.
``` kubectl get pod hello-world -v 8 ```

- Same output as 8, add full Response. Focus on the bottom, look for metadata
``` kubectl get pod hello-world -v 9 ```

- Start up a kubectl proxy session, this will authenticate use to the API Server
- Using our local kubeconfig for authentication and settings, updated head to only return 10 lines.
```
kubectl proxy &
curl http://localhost:8001/api/v1/namespaces/default/pods/hello-world | head -n 10

fg
ctrl+c
```

- Watch, Exec and Log Requests
- A watch on Pods will watch on the resourceVersion on api/v1/namespaces/default/Pods
``` kubectl get pods --watch -v 6 & ```

- We can see kubectl keeps the TCP session open with the server...waiting for data.
``` netstat -plant | grep kubectl ```

- Delete the pod and we see the updates are written to our stdout. Watch stays, since we're watching All Pods in the default namespace.
``` kubectl delete pods hello-world ```

- But let's bring our Pod back...because we have more demos.
``` kubectl apply -f pod.yaml ```

- And kill off our watch
```
fg
ctrl+c
```

- Accessing logs
```
kubectl logs hello-world
kubectl logs hello-world -v 6
``` 

- Start kubectl proxy, we can access the resource URL directly.
```
kubectl proxy &
curl http://localhost:8001/api/v1/namespaces/default/pods/hello-world/log
```

- Kill our kubectl proxy, fg then ctrl+c
```
fg
ctrl+c
```

- Authentication failure Demo
``` cp ~/.kube/config  ~/.kube/config.ORIG ```

- Make an edit to our username changing user: kubernetes-admin to user: kubernetes-admin1
``` vi ~/.kube/config ```

- Try to access our cluster, and we see GET https://172.16.94.10:6443/api?timeout=32s 403 Forbidden in 5 milliseconds
- Enter in incorrect information for username and password
``` kubectl get pods -v 6 ```

- Let's put our backup kubeconfig back
``` cp ~/.kube/config.ORIG ~/.kube/config ```

- Test out access to the API Server
``` kubectl get pods ```

- Missing resources, we can see the response code for this resources is 404...it's Not Found.
``` kubectl get pods nginx-pod -v 6 ```

- Let's look at creating and deleting a deployment.
- We see a query for the existence of the deployment which results in a 404, then a 201 OK on the POST to create the deployment which suceeds.
``` kubectl apply -f deployment.yaml -v 6 ```

- Get a list of the Deployments
``` kubectl get deployment ```

- Clean up when we're finished. We see a DELETE 200 OK and a GET 200 OK.
```
kubectl delete deployment hello-world -v 6
kubectl delete pod hello-world
```

- Get a list of all the namespaces in our cluster
``` kubectl get namespaces ```

- get a list of all the API resources and if they can be in a namespace
```
kubectl api-resources --namespaced=true | head
kubectl api-resources --namespaced=false | head
```

- Namespaces have state, Active and Terminating (when it's deleting)
``` kubectl describe namespaces ```

- Describe the details of an indivdual namespace
``` kubectl describe namespaces kube-system ```

- Get all the pods in our cluster across all namespaces. Right now, only system pods, no user workload.
- You can shorten --all-namespaces to -A
``` kubectl get pods --all-namespaces ```

- Get all the resource across all of our namespaces
``` kubectl get all --all-namespaces ```

- Get a list of the pods in the kube-system namespace
``` kubectl get pods --namespace kube-system ```

- Imperatively create a namespace
``` kubectl create namespace playground1 ```

- Imperatively create a namespace...but there's some character restrictions. Lower case and only dashes.
``` kubectl create namespace Playground1 ```

- Declaratively create a namespace
```
more namespace.yaml
kubectl apply -f namespace.yaml
```

- Get a list of all the current namespaces
``` kubectl get namespaces ```

- Start a deployment into our playground1 namespace
```
more deployment.yaml
kubectl apply -f deployment.yaml
```

- Creating a resource imperatively...the generator parameter is deprecated and removed from the demo.
``` 
kubectl run hello-world-pod \
   --image=psk8s.azurecr.io/hello-app:1.0 \
   --namespace playground1
```

- Where are the pods?
``` kubectl get pods ```

- List all the pods on our namespace
```
kubectl get pods --namespace playground1
kubectl get pods -n playground1
```

- Get a list of all of the resources in our namespace...Deployment, ReplicaSet and Pods
``` kubectl get all --namespace=playground1 ```

- Try to delete all the pods in our namespace...this will delete the single pod.
- But the pods under the Deployment controller will be recreated.
```
kubectl delete pods --all --namespace playground1
```

- Get a list of all of the *new* pods in our namespace
``` kubectl get pods -n playground1 ```

- Delete all of the resources in our namespace and the namespace and delete our other created namespace.
- This deletes the Deployment controller, the Pods...or really ALL resources in the namespaces
``` 
kubectl delete namespaces playground1
kubectl delete namespaces playgroundinyaml
```

- List all resources in all namespaces, now our Deployment is gone.
```
kubectl get all
kubectl get all --all-namespaces
```

- Create a collection of pods with labels assigned to each
```
more CreatePodsWithLabels.yaml
kubectl apply -f CreatePodsWithLabels.yaml
```

- Look at all the Pod labels in our cluster
``` kubectl get pods --show-labels ```

- Look at one Pod's labels in our cluster
``` kubectl describe pod nginx-pod-1 | head ```

- Query labels and selectors
```
kubectl get pods --selector tier=prod
kubectl get pods --selector tier=qa
kubectl get pods -l tier=prod
kubectl get pods -l tier=prod --show-labels
```

- Selector for multiple labels and adding on show-labels to see those labels in the output
```
kubectl get pods -l 'tier=prod,app=MyWebApp' --show-labels
kubectl get pods -l 'tier=prod,app!=MyWebApp' --show-labels
kubectl get pods -l 'tier in (prod,qa)'
kubectl get pods -l 'tier notin (prod,qa)'
```

- Output a particluar label in column format
```
kubectl get pods -L tier
kubectl get pods -L tier,app
```

- Edit an existing label
```
kubectl label pod nginx-pod-1 tier=non-prod --overwrite
kubectl get pod nginx-pod-1 --show-labels
```

- Adding a new label
```
kubectl label pod nginx-pod-1 another=Label
kubectl get pod nginx-pod-1 --show-labels
```

- Removing an existing label
```
kubectl label pod nginx-pod-1 another-
kubectl get pod nginx-pod-1 --show-labels
```

- Performing an operation on a collection of pods based on a label query
```
kubectl label pod --all tier=non-prod --overwrite
kubectl get pod --show-labels
```

- Delete all pods matching our non-prod label
``` kubectl delete pod -l tier=non-prod ```

- And we're left with nothing.
``` kubectl get pods --show-labels ```

- Kubernetes Resource Management
- Start a Deployment with 3 replicas, open deployment-label.yaml
``` kubectl apply -f deployment-label.yaml ```

- Expose our Deployment as  Service, open service.yaml
``` kubectl apply -f service.yaml ```

- Look at the Labels and Selectors on each resource, the Deployment, ReplicaSet and Pod
- The deployment has a selector for app=hello-world
``` kubectl describe deployment hello-world ```

- The ReplicaSet has labels and selectors for app and the current pod-template-hash
- Look at the Pod Template and the labels on the Pods created
``` kubectl describe replicaset hello-world ```

- The Pods have labels for app=hello-world and for the pod-temlpate-hash of the current ReplicaSet
``` kubectl get pods --show-labels ```

- Edit the label on one of the Pods in the ReplicaSet, change the pod-template-hash
``` kubectl label pod PASTE_POD_NAME_HERE pod-template-hash=DEBUG --overwrite ```

- The ReplicaSet will deploy a new Pod to satisfy the number of replicas. Our relabeled Pod still exists.
``` kubectl get pods --show-labels ```

- Let's look at how Services use labels and selectors, check out services.yaml
``` kubectl get service ```

- The selector for this serivce is app=hello-world, that pod is still being load balanced to!
``` kubectl describe service hello-world ```

- Get a list of all IPs in the service, there's 5...why?
``` kubectl describe endpoints hello-world ```

- Get a list of pods and their IPs
``` kubectl get pods -o wide ```

- To remove a pod from load balancing, change the label used by the service's selector.
- The ReplicaSet will respond by placing another pod in the ReplicaSet
```
kubectl get pods --show-labels
kubectl label pod PASTE_POD_NAME_HERE app=DEBUG --overwrite
```

- Check out all the labels in our pods
``` kubectl get pods --show-labels ```

- Look at the registered endpoint addresses. Now there's 4
``` kubectl describe endpoints hello-world ```

- To clean up, delete the deployment, service and the Pod removed from the replicaset
```
kubectl delete deployment hello-world
kubectl delete service hello-world
kubectl delete pod PASTE_POD_NAME_HERE
```

- Scheduling a pod to a node
- Scheduling is a much deeper topic, we're focusing on how labels can be used to influence it here.
``` kubectl get nodes --show-labels ``` 

- Label our nodes with something descriptive
```
kubectl label node c1-node2 disk=local_ssd
kubectl label node c1-node3 hardware=local_gpu
```

- Query our labels to confirm.
``` kubectl get node -L disk,hardware ```

- Create three Pods, two using nodeSelector, one without.
```
more PodsToNodes.yaml
kubectl apply -f PodsToNodes.yaml
```

- View the scheduling of the pods in the cluster.
``` 
kubectl get node -L disk,hardware
kubectl get pods -o wide
```

- Clean up when we're finished, delete our labels and Pods
```
kubectl label node c1-node2 disk-
kubectl label node c1-node3 hardware-
kubectl delete pod nginx-pod
kubectl delete pod nginx-pod-gpu
kubectl delete pod nginx-pod-ssd
```

- Start up kubectl get events --watch and background it.
``` kubectl get events --watch & ```

- Create a pod...we can see the scheduling, container pulling and container starting.
``` kubectl apply -f pod.yaml ```

- Start a Deployment with 1 replica. We see the deployment created, scaling the replica set and the replica set starting the first pod
``` kubectl apply -f deployment.yaml ```

- Scale a Deployment to 2 replicas. We see the scaling the replica set and the replica set starting the second pod
``` kubectl scale deployment hello-world --replicas=2 ```

- We start off with the replica set scaling to 1, then  Pod deletion, then the Pod killing the container
``` 
kubectl scale deployment hello-world --replicas=1 

kubectl get pods
```

- Let's use exec a command inside our container, we can see the GET and POST API requests through the API server to reach the pod.
```
kubectl -v 6 exec -it PASTE_POD_NAME_HERE -- /bin/sh
hostname
ps
exit
```

- Let's look at the running container/pod from the process level on a Node.
```
kubectl get pods -o wide
ssh aen@c1-node[xx]
ps -aux | grep hello-app
exit
```

- Now, let's access our Pod's application directly, without a service and also off the Pod network.
``` kubectl port-forward PASTE_POD_NAME_HERE 80:8080 ```

- Let's do it again, but this time with a non-priviledged port
``` kubectl port-forward PASTE_POD_NAME_HERE 8080:8080 & ```

- We can point curl to localhost, and kubectl port-forward will send the traffic through the API server to the Pod
``` curl http://localhost:8080 ```

- Kill our port forward session.
```
fg
ctrl+c

kubectl delete deployment hello-world
kubectl delete pod hello-world-pod
```

- Kill off the kubectl get events
```
fg
ctrl+c
```

- Static pods
- Quickly create a Pod manifest using kubectl run with dry-run and -o yaml...copy that into your clipboard
``` kubectl run hello-world --image=psk8s.azurecr.io/hello-app:2.0 --dry-run=client -o yaml --port=8080 ```

- Log into a node...
``` ssh aen@c1-node1 ```

- Find the staticPodPath:
``` sudo cat /var/lib/kubelet/config.yaml ```

- Create a Pod manifest in the staticPodPath...paste in the manifest we created above
```
sudo vi /etc/kubernetes/manifests/mypod.yaml
ls /etc/kubernetes/manifests
```

-Log out of c1-node1 and back onto c1-cp1
``` exit ```

- Get a listing of pods...the pods name is podname + node name
``` kubectl get pods -o wide ```

- Try to delete the pod...
``` kubectl delete pod hello-world-c1-node1 ```

- Its still there...
``` kubectl get pods ```

- Remove the static pod manifest on the node
``` 
ssh aen@c1-node1
sudo rm /etc/kubernetes/manifests/mypod.yaml
```

- Log out of c1-node1 and back onto c1-cp1
``` exit ```

- The pod is now gone.
``` kubectl get pods ```

- Review the code for a multi-container pod, the volume webcontent is an emptyDir...essentially a temporary file system.
- This is mounted in the containers at mountPath, in two different locations inside the container.
- As producer writes data, consumer can see it immediatly since it's a shared file system.
``` more multicontainer-pod.yaml ```

- Let's create our multi-container Pod.
``` kubectl apply -f multicontainer-pod.yaml ```

- Let's connect to our Pod...not specifying a name defaults to the first container in the configuration
```
kubectl exec -it multicontainer-pod -- /bin/sh
ls -la /var/log
tail /var/log/index.html
exit
```

- Let's specify a container name and access the consumer container in our Pod
```
kubectl exec -it multicontainer-pod --container consumer -- /bin/sh
ls -la /usr/share/nginx/html
tail /usr/share/nginx/html/index.html
exit
```

- This application listens on port 80, we'll forward from 8080->80
```
kubectl port-forward multicontainer-pod 8080:80 &
curl http://localhost:8080
```

- Kill our port-forward.
```
fg
ctrl+c

kubectl delete pod multicontainer-pod
```

- Use a watch to watch the progress
- Each init container run to completion then the app container will start and the Pod status changes to Running.
``` kubectl get pods --watch & ```


- Create the Pod with 2 init containers...
- each init container will be processed serially until completion before the main application container is started
``` kubectl apply -f init-containers.yaml ```

- Review the Init-Containers section and you will see each init container state is 'Teminated and Completed' and the main app container is Running
- Looking at Events...you should see each init container starting, serially...
- and then the application container starting last once the others have completed
``` kubectl describe pods init-containers | more ```

- Delete the pod
``` kubectl delete -f init-containers.yaml ```

- Kill the watch
```
fg
ctrl+c
```

- Start up kubectl get events --watch and background it.
```
kubectl get events --watch &
clear
```

- Create a pod...we can see the scheduling, container pulling and container starting.
``` kubectl apply -f pod.yaml ```

- We've used exec to launch a shell before, but we can use it to launch ANY program inside a container.
- Let's use killall to kill the hello-app process inside our container
```
kubectl exec -it hello-world-pod -- /bin/sh
ps
exit
```

- We still have our kubectl get events running in the background, so we see if re-create the container automatically.
``` kubectl exec -it hello-world-pod -- /usr/bin/killall hello-app ```

- Our restart count increased by 1 after the container needed to be restarted.
``` kubectl get pods ```

- Look at Containers->State, Last State, Reason, Exit Code, Restart Count and Events
- This is because the container restart policy is Always by default
``` kubectl describe pod hello-world-pod ```

- Cleanup time
``` kubectl delete pod hello-world-pod ```

- Kill our watch
```
fg
ctrl+c
```

- Remember...we can ask the API server what it knows about an object, in this case our restartPolicy
``` kubectl explain pods.spec.restartPolicy ```

- Create our pods with the restart policy
```
more pod-restart-policy.yaml
kubectl apply -f pod-restart-policy.yaml
```

- Check to ensure both pods are up and running, we can see the restarts is 0
``` kubectl get pods ```

- Let's kill our apps in both our pods and see how the container restart policy reacts
```
kubectl exec -it hello-world-never-pod -- /usr/bin/killall hello-app
kubectl get pods
```

- Review container state, reason, exit code, ready and contitions Ready, ContainerReady
``` kubectl describe pod hello-world-never-pod ```

- let's use killall to terminate the process inside our container.
``` kubectl exec -it hello-world-onfailure-pod -- /usr/bin/killall hello-app ```

- We'll see 1 restart on the pod with the OnFailure restart policy.
``` kubectl get pods ```

- Let's kill our app again, with the same signal.
``` kubectl exec -it hello-world-onfailure-pod -- /usr/bin/killall hello-app ```

- Let's hop inside a pod and check out it's networking, a single interface an IP on the Pod Network
- The line below will get a list of pods from the label query and return the name of the first pod in the list
```
PODNAME=$(kubectl get pods --selector=app=hello-world -o jsonpath='{ .items[0].metadata.name }')
echo $PODNAME
kubectl exec -it $PODNAME -- /bin/sh
ip addr
exit
```

- Check its status, which is now Error too...why? The backoff.
``` kubectl get pods ```

- Let's check the events, we hit the backoff loop. 10 second wait. Then it will restart.
- Also check out State and Last State.
``` kubectl describe pod hello-world-onfailure-pod ```

- Check its status, should be Running...after the Backoff timer expires.
``` kubectl get pods ```

- Now let's look at our Pod statuses
```
kubectl delete pod hello-world-never-pod
kubectl delete pod hello-world-onfailure-pod
```

- Local Cluster - Calico CNI Plugin
- Get all Nodes and their IP information, INTERNAL-IP is the real IP of the Node
``` kubectl get nodes -o wide ```

- Let's deploy a basic workload, hello-world with 3 replicas to create some pods on the pod network.
``` kubectl apply -f Deployment.yaml ```

- Get all Pods, we can see each Pod has a unique IP on the Pod Network.
- Our Pod Network was defined in the first course and we chose 192.168.0.0/16
``` kubectl get pods -o wide ```


- Let's hop inside a pod and check out it's networking, a single interface an IP on the Pod Network
- The line below will get a list of pods from the label query and return the name of the first pod in the list
```
PODNAME=$(kubectl get pods --selector=app=hello-world -o jsonpath='{ .items[0].metadata.name }')
echo $PODNAME
kubectl exec -it $PODNAME -- /bin/sh
ip addr
exit
```

- For the Pod on c1-node1, let's find out how traffic gets from c1-cp1 to c1-node1 to get to that Pod.

- Look at the annotations, specifically the annotation projectcalico.org/IPv4IPIPTunnelAddr: 192.168.19.64...your IP may vary
- Check out the Addresses: InternalIP, that's the real IP of the Node.
  - Pod IPs are allocated from the network Pod Network which is configurable in Calico, it's controlling the IP allocation.
  - Calico is using a tunnel interfaces to implement the Pod Network model.
  - Traffic going to other Pods will be sent into the tunnel interface and directly to the Node running the Pod.
  - For more info on Calico's operations https://docs.projectcalico.org/reference/cni-plugin/configuration
``` kubectl describe node c1-cp1 | more ```

- Let's see how the traffic gets to c1-node1 from c1-cp1
- Via routes on the node, to get to c1-node1 traffic goes into tunl0/192.168.19.64...your IP may vary
- Calico handles the tunneling and sends the packet to the correct node to be send on into the Pod running on that Node based on the defined routes
- Follow each route, showing how to get to the Pod IP, it will need to go to the tun0 interface.
- There cali* interfaces are for each Pod on the Pod network, traffic destined for the Pod IP will have a 255.255.255.255 route to this interface.
```
kubectl get pods -o wide
route
```

- The local tunl0 is 192.168.19.64, packets destined for Pods running on c1-cp1 will be routed to this interface and get encapsulated
- Then send to the destination node for de-encapsulation.
``` ip addr ```


- Log into c1-node1 and look at the interfaces, there's tunl0 192.168.222.192...this is this node's tunnel interface
``` ssh aen@c1-node1 ```


- This tunl0 is the destination interface, on this Node its 192.168.222.192, which we saw on the route listing on c1-cp1
``` ip addr ```

- All Nodes will have routes back to the other Nodes via the tunl0 interface
``` route ```

- Exit back to c1-cp1
``` exit ```


####Azure Kubernetes Service - kubenet
- Get all Nodes and their IP information, INTERNAL-IP is the real IP of the Node
```
kubectl config use-context 'CSCluster'
kubectl config use-context 'k8s-could'
```

- Let's deploy a basic workload, hello-world with 3 replicas.
``` kubectl apply -f Deployment.yaml ```

- Note the INTERNAL-IP, these are on the virtual network in Azure, the real IPs of the underlying VMs
``` kubectl get nodes -o wide ```


- This time we're using a different network plugin, kubenet. It's based on routes/bridges rather than tunnels. Let's explore
- Check out Addresses and PodCIDR
``` kubectl describe nodes | more ```

- The Pods are getting IPs from their Node's PodCIDR Range
``` kubectl get pods -o wide ```

- Access an AKS Node via SSH so we can examine it's network config which uses kubenet
- https://docs.microsoft.com/en-us/azure/aks/ssh#configure-virtual-machine-scale-set-based-aks-clusters-for-ssh-access
```
NODENAME=$(kubectl get nodes -o jsonpath='{.items[0].metadata.name}')
kubectl debug node/$NODENAME -it --image=mcr.microsoft.com/aks/fundamental/base-ubuntu:v0.0.11
```

- Check out the routes, notice the route to the local Pod Network matching PodCIDR for this Node sending traffic to cbr0
- The routes for the other PodCIDR ranges on the other Nodes are implemented in the cloud's virtual network.
``` route ```

- In Azure, these routes are implemented as route tables assigned to the virtual machine's for your Nodes.
- You'll find the routes implemented in the Resource Group as a Route Table assigned to the subnet the Nodes are on.
- This is a link to my Azure account, your's will vary.
- https://portal.azure.com/#@nocentinohotmail.onmicrosoft.com/resource/subscriptions/fd0c5e48-eea6-4b37-a076-0e23e0df74cb/resourceGroups/mc_kubernetes-cloud_cscluster_centralus/providers/Microsoft.Network/routeTables/aks-agentpool-89481420-routetable/overview

- Check out the eth0, actual Node interface IP, then cbr0 which is the bridge the Pods are attached to and
- has an IP on the Pod Network.
- Each Pod has an veth interface on the bridge, which you see here, and and interface inside the container
- which will have the Pod IP.
``` ip addr ```

- Let's check out the bridge's 'connections'
```
sudo apt-get install bridge-utils
sudo brctl show
```

- Exit the container on the node
``` exit ```

- Here is the Pod's interface and it's IP.
- This interface is attached to the cbr0 bridge on the Node to get access to the Pod network.
```
PODNAME=$(kubectl get pods -o jsonpath='{ .items[0].metadata.name }')
kubectl exec -it $PODNAME -- ip addr
```

- And inside the pod, there's a default route in the pod to the interface 10.244.0.1 which is the brige interface cbr0.
- Then the Node will route it on the Node network for reachability to other nodes.
``` kubectl exec -it $PODNAME -- route ```

- Delete the deployment in AKS, switch to the local cluster and delete the deployment too.
```
kubectl delete -f Deployment.yaml
kubectl config use-context kubernetes-admin@kubernetes
kubectl delete -f Deployment.yaml 
```

1. Investigating the Cluster DNS Service
- https://coredns.io/manual/toc/
- It's Deployed as a Service in the cluster with a Deployment in the kube-system namespace
``` kubectl get service --namespace kube-system ```


- Two Replicas, Args injecting the location of the config file which is backed by ConfigMap mounted as a Volume.
``` kubectl describe deployment coredns --namespace kube-system | more ```


- The configmap defining the CoreDNS configuration and we can see the default forwarder is /etc/resolv.conf
``` kubectl get configmaps --namespace kube-system coredns -o yaml | more ```

2. Configuring CoreDNS to use custom Forwarders, spaces not tabs!
- Defaults use the nodes DNS Servers for fowarders
- Replaces forward . /etc/resolv.conf
- with forward . 1.1.1.1
- Add a conditional domain forwarder for a specific domain
- ConfigMap will take a second to update the mapped file and the config to be reloaded
``` kubectl apply -f CoreDNSConfigCustom.yaml --namespace kube-system ```


- How will we know when the CoreDNS configuration file is updated in the pod?
- You can tail the log looking for the reload the configuration file...this can take a minute or two
- Also look for any errors post configuration. Seeing [WARNING] No files matching import glob pattern: custom/*.override is normal.
``` kubectl logs --namespace kube-system --selector 'k8s-app=kube-dns' --follow ```


- Run some DNS queries against the kube-dns service cluster ip to ensure everything works...
```
SERVICEIP=$(kubectl get service --namespace kube-system kube-dns -o jsonpath='{ .spec.clusterIP }')
nslookup www.pluralsight.com $SERVICEIP
nslookup www.centinosystems.com $SERVICEIP
```

- On c1-cp1, let's put the default configuration back, using . forward /etc/resolv.conf
``` kubectl apply -f CoreDNSConfigDefault.yaml --namespace kube-system ```

3. Configuring Pod DNS client Configuration
``` kubectl apply -f DeploymentCustomDns.yaml ```

- Let's check the DNS configuration of a Pod created with that configuration
- This line will grab the first pod matching the defined selector
```
PODNAME=$(kubectl get pods --selector=app=hello-world-customdns -o jsonpath='{ .items[0].metadata.name }')
echo $PODNAME
kubectl exec -it $PODNAME -- cat /etc/resolv.conf
```

- Clean up our resources
``` kubectl delete -f DeploymentCustomDns.yaml ```

- Demo 3 - let's get a pods DNS A record and a Services A record
- Create a deployment and a service
``` kubectl apply -f Deployment.yaml ```

- Get the pods and their IP addresses
``` kubectl get pods -o wide ```

- Get the address of our DNS Service again...just in case
``` SERVICEIP=$(kubectl get service --namespace kube-system kube-dns -o jsonpath='{ .spec.clusterIP }') ```

- For one of the pods replace the dots in the IP address with dashes for example 192.168.206.68 becomes 192-168-206-68
- We'll look at some additional examples of Service Discovery in the next module too.
``` nslookup 192-168-206-[XX].default.pod.cluster.local $SERVICEIP ```

- Our Services also get DNS A records
- There's more on service A records in the next demo
```
kubectl get service
nslookup hello-world.default.svc.cluster.local $SERVICEIP
```

- Clean up our resources
``` kubectl delete -f Deployment.yaml ```

- TODO for the viewer...you can use this technique to verify your DNS forwarder configuration from the first demo in this file.
- Recreate the custom configuration by applying the custom configmap defined in CoreDNSConfigCustom.yaml
- Logging in CoreDNS will log the query, but not which forwarder it was sent to.
- We can use tcpdump to listen to the packets on the wire to see where the DNS queries are being sent to.


- Find the name of a Node running one of the DNS Pods running...so we're going to observe DNS queries there.
```
DNSPODNODENAME=$(kubectl get pods --namespace kube-system --selector=k8s-app=kube-dns -o jsonpath='{ .items[0].spec.nodeName }')
echo $DNSPODNODENAME
```

- Let's log into THAT node running the dns pod and start a tcpdump to watch our dns queries in action.
- Your interface (-i) name may be different
```
ssh aen@$DNSPODNODENAME
sudo tcpdump -i ens33 port 53 -n
```

- In a second terminal, let's test our DNS configuration from a pod to make sure we're using the configured forwarder.
- When this pod starts, it will point to our cluster dns service.
- Install dnsutils for nslookup and dig
```
ssh aen@c1-cp1
kubectl run -it --rm debian --image=debian
apt-get update && apt-get install dnsutils -y
```

- In our debian pod let's look at the dns config and run two test DNS queries
- The nameserver will be your cluster dns service cluster ip.
- We'll query two domains to generate traffic for our tcpdump
```
cat /etc/resolv.conf
nslookup www.pluralsight.com
nslookup www.centinosystems.com
```

- Switch back to our second terminal and review the tcpdump, confirming each query is going to the correct forwarder
- Here is some example output...www.pluralsight.com is going to 1.1.1.1 and www.centinosystems.com is going to 9.9.9.9
- 172.16.94.13.63841 > 1.1.1.1.53: 24753+ A? www.pluralsight.com. (37)
- 172.16.94.13.42523 > 9.9.9.9.53: 29485+ [1au] A? www.centinosystems.com. (63)

- Exit the tcpdump
``` ctrl+c ```

- Log out of the node, back onto c1-cp1
``` exit ```

- Switch sessions and break out of our pod and it will be deleted.
``` exit ```


- Exit out of our second SSH session and get a shell back on c1-cp1
``` exit ```
