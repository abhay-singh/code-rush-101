# Kubernetes
System for automating deployment, scaling and container management + clustering. Manages applications, **not machines**, (still need chef to provision machines) allows distributed components across varied infrastructure (cloud providers). 

Kubernetes addresses the disconnect between how clustered infrastructure is designed and some of the assumptions that applications have about their environment (surrounding infrastructure). 

Google container engine is built on Kubernetes, manages clusters of Docker containers. 
- Users interact with *master* through apis, clis
- master manages nodes 

- choose cloud AWS
- choose node os, Debian
- provision machines

### Pod
A group of one or more contianers (Docker containers for example) 
- shared storage
- shared namespace
- share IP address and localhost

The shared context of a pod is set by linux namespaces, cgroups; same things that isolate Docker containers. 

### Google Cloud
Cloud native computing; contianer packaged, micro-services oriented.
- Built on containers, faster than AWS? 

### Networking
IPs are cluster-scoped (unlike docker which requires all containers to have same IP) with IP address ranges.
- containers within a pod share an IP address and port space
  - communicate with `localhost` and inter-process communication (IPC)
- containers in different pods have distinct IP addresses, cannot communicate by IPC

