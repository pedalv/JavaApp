# KUBERNETES
- [Getting Started with Kubernetes](https://app.pluralsight.com/library/courses/kubernetes-getting-started/table-of-contents)
- [Kubernetes for Developers: Integrating Volumes and Using Multi-container Pods](https://app.pluralsight.com/library/courses/kubernetes-developers-integrating-volumes-using-multi-container-pods/table-of-contents)
- [Kubernetes for Developers: Core Concepts (Todo)](https://app.pluralsight.com/library/courses/kubernetes-developers-core-concepts/table-of-contents)
- [Kubernetes for Developers: Moving from Docker Compose to Kubernetes (Todo)](https://app.pluralsight.com/library/courses/kubernetes-developers-docker-compose-to-kubernetes/table-of-contents)
- [Webinar: Getting Started with Docker Containers (Todo)](https://app.pluralsight.com/library/courses/getting-started-docker-containers-webinar/table-of-contents)
- [Kubernetes for Developers: Deploying Your Code (Todo)](https://app.pluralsight.com/library/courses/kubernetes-developers-deploying-code/table-of-contents)

## [Install and Set Up kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)
Steg 1
- https://storage.googleapis.com/kubernetes-release/release/stable.txt
- https://dl.k8s.io/release/v1.20.4/bin/windows/amd64/kubectl.exe
- https://dl.k8s.io/release/v1.20.4/bin/windows/amd64/kubectl.exe.sha256

Steg 2
* CertUtil -hashfile kubectl.exe SHA256
* type kubectl.exe.sha256
* $($(CertUtil -hashfile .\kubectl.exe SHA256)[1] -replace " ", "") -eq $(type .\kubectl.exe.sha256)

Steg 3 - Add the binary in to your PATH, D:\tools\kubernetes


or Steg 1 - Install with PowerShell from PSGallery
- PS > Install-Script -Name 'install-kubectl' -Scope CurrentUser -Force
- PS > install-kubectl.ps1 C:\kubectl

Steg 4
* PS > kubectl version --client

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

- PS D:\> kubectl get pods --kubeconfig=D:\tools\kubernetes\config -n kube-system

> error: CreateFile D:\tools\kubernetes\config: The system cannot find the file specified.

## Create kubernetes
- Google cloud, Kubernetes Engine
- cloud.linode.com/kubernetes/create
- Windows Azure
- etc
  Kubernetes on your Laptop
- docker, minikube

## COMMANDS
- step 1
  * git clone https://github.com/nigelpoulton/getting-started-k8s.git
  * cd getting-started-k8s/Pods
  * kubectl apply -f pod.yml
  * kubestl get pods
  * kubectl get pods -o wide
  
- step 2: SVC IP is not trush
  kubectl expose pod hello-pod --name=hello-svc \
  -- target-port=8080 --type=NodePort
  * kubectl get svc
  * kubectl delete svc hello-svc
  * kubectl get pods --show-labels
  
- step 2: correct way with yml file
  * kubectl apply -f svc-nodeport.yml
  * kubectl describe scv ps-nodeport
  
- step 3: deploy
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
  
- rollbacks
  * kubectl get pods --watch
  * kubectl rollout status deploy web-deploy
  * kubectl apply -f deploy.yml
  * kubectl get rs
  * kubectl rs <name>
  * kubectl rollout history deploy web-deploy
  * kubectl rollout undo deploy web-deploy --to-revision=1

```
deploy: updates and rollbacks..
  - rs: scalability, reliability, desired state...
  -- pod: scheduling, execution...
  --- <app> container
```

* kubectl version --short
* kubectl get nodes

* kubectl cluster-info
* kubectl apply -f pod.yml
* kubectl delete -f multi-pod.yml
* kubectl get pods
* kubectl get pods --watch
* kubectl get pods -o wide
* kubectl describe pods hello-pod

- https://github.com/nigelpoulton/ps-vols-and-pods
- https://github.com/container-storage-interface
- https://github.com/kubernetes-csi

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
