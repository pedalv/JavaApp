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
- Relies on YAML (or JSON) files to represent desire state
- Nodes and pods play a central role
- Master: Also known as head nodes or the control plane
- A container runs in a pod
- Pod
  * One or mor containers
  * It's your application or service
  * The most basic unit of work
  * Unit of acheduling
  * Ephemeral - no Pod is ever "redeployed"
  * Atomicity - ther're there or NOT
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
  * kubectl get pods --all-namespaces --watch
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
  * kubectl get pods --watch
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
  * kubectl get pods --watch
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

## Example YAML file
```
# Simple Kubernetes Pod to deploy the app contained in nigelpoulton/getting-started-k8s:1.0
apiVersion: v1
kind: Pod
metadata:
  name: hello-pod
  labels:
    app: web
spec:
  containers:
    - name: web-ctr
      image: nigelpoulton/getting-started-k8s:1.0
      ports:
        - containerPort: 8080
```

## Kubernetes for Developers: Core Concepts
