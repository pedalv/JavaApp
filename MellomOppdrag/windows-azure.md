# [Windows Azure](https://en.wikipedia.org/wiki/Microsoft_Azure)
- Microsoft Azure, commonly referred to as Azure (/ˈæʒər/), 
- Azure is a cloud computing service created by Microsoft for building, testing, deploying, and managing applications and services through Microsoft-managed data centers. 
- It provides software as a service (SaaS), platform as a service (PaaS) and infrastructure as a service (IaaS) and supports many different programming languages, tools, and frameworks, including both Microsoft-specific and third-party software and systems. 
- [Create your Azure free account today, Get started with 12 months of free services](https://azure.microsoft.com/en-us/pricing/)

##  Accounts
- [Portal Azure](https://portal.azure.com/?quickstart=true#blade/Microsoft_Azure_Resources/QuickstartCenterBlade)
    * [Learn new skills and discover the power of Microsoft products with step-by-step guidance. Start your journey today by exploring our learning paths and modules.](https://docs.microsoft.com/en-us/learn/browse/?WT.mc_id=Portal-Microsoft_Azure_Resources&products=azure&expanded=azure)
    * [Take an online course](https://portal.azure.com/?quickstart=true#blade/Microsoft_Azure_Resources/QuickstartCenterBlade)
- [github](https://github.com/pedalv)
- [dockerhub](https://hub.docker.com/u/pedalv)
- [Dashboard UI Kubernetes](http://127.0.0.1:8082/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#/overview?namespace=default)

## Tips
- [Find the Azure geography that meets your needs](https://azure.microsoft.com/en-us/global-infrastructure/geographies/)
- Blueprint === an early plan or design that explains how something might be achieved
- Big band === is popular in situations or adopted when the project's stakeholders or customers are not certain regarding their wants and requirements
- off-premises === performed remotely, across the internet  
- Type of Cloud Computing Services 
    * on-prem === On-premises software is installed and runs on computers on the premises of the person or organization using the software, rather than at a remote facility such as a server farm or cloud
      * Ex: Made Pizza at home
    * Infrastructure as a Service (IaaS) ===  Ex: Take and bake (frozen pizza), access a virtual machine in the cloud
        * Providers: 
          * Microsoft Azure, Amazon Web Services, Google Compute Engine 
            * Azure Compute (Virttual Machines), Azure Storage
        * Scenarios:    
            * Test and development
            * Storage and backups
            * High performance computing
            * Big data analysis
      * virtualization is the logical division of physical computing resources
      * container is operating-system level virtualization where the OS kerne provides isolated user spaces to run specific applications === Docker container
      * Iaas Networking options
            
        > Virtual Privaye Cloud (VPC) Networking
        
        * Public Networking: Using public IP addresses
        * Private Networking: via VPN tunnel or, in some cases dedicated connections
      * Storage
        * Inside the Virtual Machine: Each VM has storage of ith own 
            * Disk, database
        * Outside the Virtual Machine: Each VM can access external storage  
            * Cloud File Storage === Dropbox, Microsoft OneDrive, Google Drive
            * Object Storage === amazon webservice S3 Simple Storage Service, Microsoft Azure Blob Storage
                * usually used for pictures, videoa, and archival data
            * Data Protection in the Cloud === CRASHPLAN, CARBONITEO, AWS STORAGE Gateway, Microsoft Azure Backup
                * Disaster Recovery to the Cloud === Zert, veeam, Infrascale
      * Security
        * Encryption: the process of converting information or data into ciphertext, which cannot be easily understood by anymore except those who have the key
            * Compliance === Laws,Requirements, Policies, Rules, Standards, Governance, Regulations 
    * Platform as a Service (PaaS) === Ex: Pizza delivery
        * is for developers who want to develop, run, and manage applications
        * No servers, storage, network, OS, middleware, or database are needed
        * Providers: 
          * Azure Logic Apps, Heroku, Amazon Elastic Beanstalk, Google App Engine, Cloud Foundry 
            * Azure Logic Apps, Azure Functions, Azure Web Jobs, Azure Automation          
        * Scenarios:    
            * Analytics or business intelligence
            * Development framework    
    * Software as a Service(SaaS) === Ex: Dine out, access application direct in the cloud
        * Benefits
            * No hardware/software to buy or install
            * No Software to maintain or upgrade
            * You only pay for what you use
            * New features are included
        * Providers: 
          * Office 365, Google G Suite, Salesforce, Dropbox 
            * SharePoint, OneDrive for Business, Microsoft Teams, Power Platform
        * Scenarios:    
            * Gain access to sophisticated applications
            * Mobilize your workforce easily 
- Cloud Computing 
    * enables companies to consume a compute resource, such as a virtual machine, storage, or an application, as a utility -- just like electricity -- rather than having to build and maintain computing infrastructures in-house
    * The more things change, the more they stay the same
- Cloud Computing Deployment Models
    * Public Cloud: Cloud service provided by a third-party provider, harware can be shared amongst multiple clients
    * Private Cloud (1): Hardware is only used by a single company, which often owns the hardware and datacenter
    * Hybrid Cloud (1): Combination of public and private cloud with automation and orchestration between the tho
        * (1) Azure Stack allows you to run cloud services on-premises
        * (1) Azure Stack can be used for connected or disconnected scenarios
        * (1) Consistent tools, experiences, and app models
        * (1) Easy transfer workloads to Azure (public cloud)
    * Community Cloud: Infrastructure is shared between several orgs from a specific community concerns (security, compliance, jurisdiction, etc)
        * Azure Government is an Azure offeing specific to government entities
        * Can handle data that is subjec to government regulation & requirements - FedRAMP /DOD /CJIS /etc
        *Other Azure community cloud offerings - Azure China - Azure Germany
      
Docker
* Third-part solutions (cloud === Google Kubernetes Engine, GKE, and Azure Kubernetes Service)

Kubernetes
* Support by all major cloud platforms: Google cloud, Kubernetes Engine, cloud.linode.com/kubernetes/create, Windows Azure, etc
* [Error listening on port 8001](https://github.com/Azure/azure-cli/issues/6811)
* Azure Kubernetes Services ([AKS](https://docs.microsoft.com/en-us/azure/aks/kubernetes-walkthrough))
* Cloud Volumes
    * Cloud providers (Azure, AWS, GCP, etc) support different types of Volumes:
        * Azure: Azure Disk and Azure File

Virtualization
* Client Hyper-V:
    * is the same hypervisor which powers virtualization in Windows Server and the Microsoft Azure datacenters.
* To install the Azure-tuned kernel on 16.04, 18.04 and 20.04, run the following commands as root (or sudo):
```
# apt-get update
# apt-get install linux-azure
```
* Managing Linux Environments
    * [Azure documentation](https://docs.microsoft.com/en-us/azure/)
    * [Assign Azure roles using Azure PowerShell](https://docs.microsoft.com/en-gb/azure/role-based-access-control/role-assignments-powershell)
    * How are Norwegian organizations like Vipps, Elkjøp and NRK using Azure Kubernetes Service (AKS), and how does Microsoft support them?
        * In the first section the speakers will briefly tell about their experiences with AKS and insights that are most valuable to them:
            * [Azure Kubernetes Service (AKS) at Norway | DEVREAL.io](https://www.youtube.com/watch?v=-UQmGM4r-rQ)
        * In the second section, Gustav Kaleta from Microsoft will tell about how they help and support us developers:
            * [the second section available soon](https://www.meetup.com/azure-meetup-oslo)
        * In the third section we will have a short tech conversation where we will discuss topics and answer questions coming from the audience and the moderator:
            * [the thirs section available soon](https://www.meetup.com/azure-meetup-oslo)
    * [Windows Subsystem for Linux Installation Guide for Windows 10](https://docs.microsoft.com/en-us/windows/wsl/install-win10)
* Ubuntu in the Cloud (AWS, Azure...)
    * MicrosoftAzure, amazon web services, etc
    * Infrastructure as a Service
        * ssh azureuser@pod-ubuntu.cloudapp.net
            * apt-get update
            * sudo apt-get install nginx
            * service nginx restart
    * juju (DOCKER for 2021): creating and configuring servers and deploying software like web servers via script files
        * juju deploy --repository=/home/elton/charms local:trusty/omnium-web
        * juju status
        * ab -r -n 5000 -c 500 http://juju-azure-d3r0l4sypr.cloudapp.net/index.html === ab apache bench - Apache HTTP server benchmarking tool
    * openstack: create their own Clouds on their own hardware
    * Microsoft Azure: Virtual Machines => create image OS => Config
        * ssh elton@ub-ws-01.cloudapp.net
            * sudo apt-get update && sudo apt-get upgrade
        * SSH and File Transfer: /var/www
            * ftp –u ftp://user@ub-ws-01.cloudapp.net ~/a-file === user/password
            * git push azure master
            * scp ~/a-file user@ub-ws-01.cloudapp.net:/dest === pair of keys
            * sudo mkdir -p  /var/www/
            * sudo chmod a+w /var/www
            * sudo chmod a+x /var/www
            * scp -r /var/www/omnium.net azure:/var/www/omnium.net/
            * scp user@ub-ws-01.cloudapp.net:~/a-file ~/
            * scp user@x.y.z:~/a-file user@a.b.c:~/a-file

## On-line courses:
- [POPULAR - Microsoft Azure: The Big Picture](https://app.pluralsight.com/library/courses/microsoft-azure-the-big-picture/table-of-contents)
- [POPULAR - Microsoft Azure Cloud Concepts](https://app.pluralsight.com/library/courses/microsoft-azure-cloud-concepts)
- [Fundamentals of Cloud Computing](https://app.pluralsight.com/library/courses/cloud-computing-fundamentals/table-of-contents)
- 3h38m Feb 26, 2021 [Microsoft Azure Services and Concepts](https://app.pluralsight.com/library/courses/microsoft-azure-services-concepts/table-of-contents)

- 2h 31m Mar 2, 2020 [Microsoft Azure Security and Privacy Concepts](https://app.pluralsight.com/library/courses/microsoft-azure-security-privacy-concepts/table-of-contents)
- 1h 37m July 1h 37, 2020 [Microsoft Azure Pricing and Support Options](https://app.pluralsight.com/library/courses/microsoft-azure-pricing-support-options/table-of-contents)
- 3h 40m 25 Apr 2019 [Azure Functions Fundamentals](https://app.pluralsight.com/library/courses/azure-functions-fundamentals/table-of-contents)


- TODO [POPULAR - Microsoft Azure Solutions Architect: Introduction to the AZ-303 Exam](https://app.pluralsight.com/library/courses/microsoft-azure-solutions-architect-introduction-az-303-exam/table-of-contents)
- TODO [POPULAR - Deploying Windows Virtual Desktop in Microsoft Azure](https://app.pluralsight.com/library/courses/deploying-windows-virtual-desktop-microsoft-azure/table-of-contents)
- TODO [POPULAR - Microsoft Azure Developer: Implement API Management](https://app.pluralsight.com/library/courses/microsoft-azure-developer-implement-api-management/table-of-contents)
- TODO [POPULAR - Managing Identities in Microsoft Azure Active Directory](https://app.pluralsight.com/library/courses/microsoft-azure-active-directory-managing-identities)
- TODO [Deploying Data Pipelines in Microsoft Azure](https://app.pluralsight.com/library/courses/microsoft-azure-data-pipelines-deploying)
- TODO [Integrating Data in Microsoft Azure](https://app.pluralsight.com/library/courses/microsoft-azure-data-integrating)
- TODO [POPULAR - Designing a Microsoft Azure Messaging Architecture](https://app.pluralsight.com/library/courses/microsoft-azure-messaging-architecture-designing)
- TODO [POPULAR - Microsoft Azure Administrator: Preparing for the AZ-104 Exam](https://app.pluralsight.com/library/courses/microsoft-azure-administrator-preparing-az-104-exam)
- TODO [POPULAR - Configuring and Managing Microsoft Azure Key Vault](https://app.pluralsight.com/library/courses/microsoft-azure-key-vault-configuring-managing)
- TODO [POPULAR - Microsoft Azure Developer: Preparing to Take the AZ-204 Exam](https://app.pluralsight.com/library/courses/microsoft-azure-developer-preparing-take-az-204-exam)
- TODO [POPULAR - Continuous Delivery and DevOps with Azure DevOps: The Big Picture](https://app.pluralsight.com/library/courses/continuous-delivery-azure-devops-big-picture)
- TODO [POPULAR - Microsoft Azure DevOps Engineer: Implement and Manage Azure Pipelines Infrastructure](https://app.pluralsight.com/library/courses/microsoft-azure-implement-manage-pipelines-infrastructure)
- TODO [POPULAR - Microsoft Azure Administrator: Monitor Resources with Azure Monitor](https://app.pluralsight.com/library/courses/microsoft-azure-administrator-monitor-resources-az-monitor)
- TODO [POPULAR - Designing an API Management Strategy for Microsoft Azure](https://app.pluralsight.com/library/courses/microsoft-azure-api-management-strategy-designing/table-of-contents)
- TODO [POPULAR - Microsoft Azure Developer: Implement Azure Functions](https://app.pluralsight.com/library/courses/microsoft-azure-developer-implement-azure-functions)
- TODO [POPULAR - Microsoft Azure Developer: Implementing Azure Cache](https://app.pluralsight.com/library/courses/microsoft-azure-cache-implementing)
- TODO [POPULAR -  Microsoft Azure API Management Essentials](https://app.pluralsight.com/library/courses/microsoft-azure-api-management-essentials/table-of-contents)
- TODO [POPULAR -  Securing Applications in Microsoft Azure](https://app.pluralsight.com/library/courses/microsoft-azure-applications-securing)
- TODO [POPULAR - Microsoft Azure Service Bus In-depth](https://app.pluralsight.com/library/courses/azure-service-bus-in-depth)
- TODO [POPULAR - Microsoft Azure Developer: Create Serverless Functions](https://app.pluralsight.com/library/courses/microsoft-azure-serverless-functions-create/table-of-contents)
- TODO [POPULAR - Implementing a Cloud Data Warehouse in Microsoft Azure Synapse Analytics](https://app.pluralsight.com/library/courses/microsoft-azure-implementing-cloud-data-warehouses)
- TODO [POPULAR - Implementing an Azure Databricks Environment in Microsoft Azure](https://app.pluralsight.com/library/courses/microsoft-azure-databricks-environment-implementing/table-of-contents)
- TODO [POPULAR - Implementing Terraform on Microsoft Azure](https://app.pluralsight.com/library/courses/implementing-terraform-microsoft-azure/table-of-contents)  
- TODO [More Page 2 - 5](https://app.pluralsight.com/search/?q=Microsof%20Azure&type=conference%2Cvideo-course%2Cdemo%2Cguide%2Cwebinar%2Cpath%2Cassessment&m_sort=relevance&page=2&query_id=ae077725-6252-42db-ab3e-95158529902d&source=user_typed)
#### Paths
- TODO [Integration on Microsoft Azure](https://app.pluralsight.com/paths/skill/integration-on-microsoft-azure)
- TODO [Microsoft Azure Deployment](https://app.pluralsight.com/paths/skill/microsoft-azure-deployment)  
- TODO [Monitoring Microsoft Azure](https://app.pluralsight.com/paths/skill/monitoring-microsoft-azure)  
- TODO [Deploying and Managing Microsoft Azure AI Solutions](https://app.pluralsight.com/paths/skill/deploying-and-managing-microsoft-azure-ai-solutions)
- TODO [Microsoft Azure AI Engineer (AI-100)](https://app.pluralsight.com/paths/certificate/microsoft-azure-ai-engineer-ai-100)
- TODO [Developing Microsoft Azure AI Solutions](https://app.pluralsight.com/paths/skill/developing-microsoft-azure-ai-solutions)
- TODO [Testing on Microsoft Azure](https://app.pluralsight.com/paths/skill/testing-on-microsoft-azure)
- TODO [Planning Microsoft Azure Solutions](https://app.pluralsight.com/paths/skill/planning-microsoft-azure-solutions)
- TODO [Application Development on Microsoft Azure](https://app.pluralsight.com/paths/skill/application-development-on-microsoft-azure)
- TODO [Managing Microsoft Azure Compute](https://app.pluralsight.com/paths/skill/managing-microsoft-azure-compute)
- TODO [Designing Microsoft Azure Applications](https://app.pluralsight.com/paths/skill/designing-microsoft-azure-applications)
- TODO [Microsoft Azure Compute for Developers](https://app.pluralsight.com/paths/skill/microsoft-azure-compute-for-developers)
- TODO [Managing Microsoft Azure Networking](https://app.pluralsight.com/paths/skill/managing-microsoft-azure-networking)
- TODO [Managing Microsoft Azure Storage](https://app.pluralsight.com/paths/skill/managing-microsoft-azure-storage)
- TODO [Planning Microsoft Azure Infrastructure](https://app.pluralsight.com/paths/skill/planning-microsoft-azure-infrastructure)
- TODO [Enabling Platform Protection in Microsoft Azure](https://app.pluralsight.com/paths/skill/enabling-platform-protection-in-microsoft-azure)
- TODO [Implementing the Data Science Workflow in Microsoft Azure](https://app.pluralsight.com/paths/skill/implementing-the-data-science-workflow-in-microsoft-azure)
- TODO [Managing Microsoft Azure Identity and Security](https://app.pluralsight.com/paths/skill/managing-microsoft-azure-identity-and-security)
- TODO [Planning Microsoft Azure Deployment & Integration](https://app.pluralsight.com/paths/skill/planning-microsoft-azure-deployment-and-integration)
- TODO [Planning Microsoft Azure Identity and Security](https://app.pluralsight.com/paths/skill/planning-microsoft-azure-identity-and-security)
- TODO [Microsoft Azure Storage for Developers](https://app.pluralsight.com/paths/skill/microsoft-azure-storage-for-developers)
- TODO [Managing Microsoft Azure App Services](https://app.pluralsight.com/paths/skill/managing-microsoft-azure-app-services)
Maybe repeated 
- TODO [Deploying Multiple Virtual Machines in Microsoft Azure](https://app.pluralsight.com/library/courses/microsoft-azure-deploying-multiple-virtual-machines/table-of-contents)  
- TODO [Getting Started with Azure Automation](https://app.pluralsight.com/library/courses/azure-automation-getting-started/table-of-contents)  
- TODO [Deploying a Virtual Machine in Microsoft Azure](https://app.pluralsight.com/library/courses/microsoft-azure-virtual-machine-deploying/table-of-contents)
- TODO [Managing Network Load Balancing in Microsoft Azure](https://app.pluralsight.com/library/courses/microsoft-azure-network-load-balancing-managing/table-of-contents)  
- TODO [Learning Azure Cosmos DB](https://app.pluralsight.com/library/courses/azure-cosmos-db/table-of-contents)
- TODO [Monitoring Microsoft Azure](https://app.pluralsight.com/paths/skill/monitoring-microsoft-azure)
- TODO [Microsoft Azure Deployment](https://app.pluralsight.com/paths/skill/microsoft-azure-deployment)
- TODO [Testing on Microsoft Azure](https://app.pluralsight.com/paths/skill/testing-on-microsoft-azure)
- TODO [Azure Monthly Update](https://app.pluralsight.com/paths/conference/microsoft-azure-monthly-update)
- TODO [Microsoft Azure datacenters](https://app.pluralsight.com/search/?q=Microsoft%20Azure%20datacenters&type=conference%2Cvideo-course%2Cdemo%2Cguide%2Cwebinar%2Cpath%2Cassessment&m_sort=relevance&query_id=3a4f71ed-57a8-409b-897d-51aa7c5660ff&source=user_typed)
- TODO [Customer Stories: ServiceNow gains business scalability, speeds time to market with SAP on Microsoft Azure](https://customers.microsoft.com/en-us/story/779822-servicenow-partner-professional-services-azure)
- TODO [Handling Streaming Data with Azure Databricks Using Spark Structured Streaming](https://app.pluralsight.com/library/courses/handling-streaming-data-azure-databricks-using-spark-structured-streaming/table-of-contents)
- TODO [Managing Configurations with Azure Automation DSC](https://app.pluralsight.com/library/courses/azure-automation-dsc-managing-configurations/table-of-contents)
- TODO [Connecting PowerShell to Your Azure Subscription](https://app.pluralsight.com/library/courses/connect-powershell-to-azure-subscription/table-of-contents)
- TODO [Configuring Encryption for Data at Rest in Microsoft Azure](https://app.pluralsight.com/library/courses/microsoft-azure-configuring-encryption-data-rest/table-of-contents)
- TODO [Managing Azure IaaS with PowerShell](https://app.pluralsight.com/library/courses/managing-azure-iaas-with-powershell/table-of-contents)
- TODO [Building an Azure Continuous Integration Pipeline](https://app.pluralsight.com/library/courses/azure-continuous-integration-pipeline-building/table-of-contents)
- TODO [Troubleshooting with Microsoft Azure Network Watcher](https://app.pluralsight.com/library/courses/azure-network-watcher-troubleshooting/table-of-contents)
- TODO [Managing Public Networking in Microsoft Azure](https://app.pluralsight.com/library/courses/microsoft-azure-managing-public-networking/table-of-contents)
- TODO [Configuring Virtual Machines in Microsoft Azure](https://app.pluralsight.com/library/courses/microsoft-azure-configuring-virtual-machines/table-of-contents)
- TODO [Managing Infrastructure with Microsoft Azure - Getting Started](https://app.pluralsight.com/library/courses/managing-infrastructure-microsoft-azure-getting-started/table-of-contents)
- TODO [Backing Up Virtual Machines in Microsoft Azure](https://app.pluralsight.com/library/courses/microsoft-azure-virtual-machines-backing-up/table-of-contents)
- TODO [Microsoft Azure DevOps Engineer: Implement Imperative Virtual Machine Configuration Management](https://app.pluralsight.com/library/courses/microsoft-azure-imperative-vm-implement/table-of-contents)
- TODO [Monitoring Microsoft Azure Hybrid Cloud Networks](https://app.pluralsight.com/library/courses/microsoft-azure-hybrid-cloud-networks-monitoring/table-of-contents)
- TODO [Getting Started with Azure Operational Insights](https://app.pluralsight.com/library/courses/azure-operational-insights-getting-started/table-of-contents)
#### Articles
- TODO [How to Use Managed Identities with Azure SQL Database](https://app.pluralsight.com/guides/how-to-use-managed-identity-with-azure-sql-database)
- TODO [Deploy a React App to Azure](https://app.pluralsight.com/guides/deploy-a-react-app-to-azure)
- TODO [How to Use Managed Identities with Azure Service Bus](https://app.pluralsight.com/guides/how-to-use-managed-identity-with-azure-service-bus)
- TODO [Access Azure Storage Account Resources from Postman](https://app.pluralsight.com/guides/access-azure-storage-account-resources-from-postman)
- TODO [How to Use Managed Identities with Azure Blob and Queue Storage](https://app.pluralsight.com/guides/how-to-use-managed-identity-with-azure-blob-and-queue-storage)
- TODO [Maybe usefully](https://app.pluralsight.com/search/?q=windows%20azure&type=conference%2Cvideo-course%2Cdemo%2Cguide%2Cwebinar%2Cpath%2Cassessment&m_sort=relevance&page=3&query_id=aa070f68-951e-4d82-a2f7-4336a3acb010&source=user_typed)
#### Certifications
- TODO [Microsoft Azure Fundamentals (AZ-900)](https://app.pluralsight.com/paths/certificate/microsoft-azure-fundamentals-az-900)
  * [Exam AZ-900: Microsoft Azure Fundamentals](https://docs.microsoft.com/en-gb/learn/certifications/exams/az-900?wt.mc_id=learningredirect_certs-web-wwl)
- TODO [Microsoft Azure Administrator (AZ-104)](https://app.pluralsight.com/paths/certificate/microsoft-azure-administrator-az-104)
- TODO [Microsoft Azure Architect Design (AZ-304)](https://app.pluralsight.com/paths/certificate/microsoft-azure-architect-design-az-304)
- TODO [Microsoft Azure Architect Technologies (AZ-303)](https://app.pluralsight.com/paths/certificate/microsoft-azure-architect-technologies-az-303)
- TODO [Developing Solutions for Microsoft Azure (AZ-204)](https://app.pluralsight.com/paths/certificate/developing-solutions-for-microsoft-azure-az-204)
- TODO [Microsoft Azure Security Technologies (AZ-500)](https://app.pluralsight.com/paths/certificate/microsoft-azure-security-technologies-az-500)
- TODO [AZ-900: Microsoft Azure Fundamentals Exam Prep - Jan 2021](https://www.udemy.com/course/az900-azure/)
- TODO [Microsoft Certified: Azure Fundamentals](https://docs.microsoft.com/en-us/learn/certifications/azure-fundamentals/)  
- TODO [Cloud Certifications: Azure Database Administrator Associate](https://app.pluralsight.com/guides/cloud-certifications:-azure-database-administrator-associate)
- TODO [Microsoft Azure Data Engineer (DP-200)]https://app.pluralsight.com/paths/certificate/microsoft-azure-data-engineer-dp-200)


## Microsoft Azure Security and Privacy Concepts
- What Is Azure Active Directory?
    * for Authentication
      * Something you Know / have / are
      * add user to a group
    * Single sigh on and application
    * User and computer registration
    * Does not provide group policies
    * No trust relationships
    * Application management
    * Use Azure AD connect to replicate objects from Active Directory Domain Services
    * No domain controller
    * Azure AD provides:
        * User management
        * Application integration
        * Single signon
        * Integration with other directory services
  * Azure AD conditional access can used to secure access to Azure AD integrated applications
  * Azure AD Conditional Access
        * Controll access to applications no mather where our users are
        * We create conditional access policies which at their heart are if-then statements
        * Signals are used to make decisions
            * IP location information
            * Risk analysis
            * Device information
            * Application being accessed
                * Common Decisions
                    * Block access: Block access if the various policy conditions are met
                    * Grant access: Can be qualified to include requirements like MFA required or an AD joined device required
-  Azure AD Domain Services
   * Application migration, NTLM and Kerberos Support
- Active Directory Domain Services (use on-prem)
    * Full directory service, all features offered by active directory
    * User and computer registration
    * Provides group policies
    * Can create trusts
    * Application and device management and deployment
    * Kerberos and NTLM support
    * Schema a management
    * Hierarchical directory service
- What is RBAC?
    * for Authorization
      * There will be different types of users requiring different access to Azure
      * Some users will require admin access to Azure while others will use the resources we deploy
      * These different types of users need to be managed and monitored
    * is used daily   
    * is the tool we use to provide shared access  
    * Central to access control in Azure
    * Roles allow you to group together sets of permissions
    * We can make users or groups members of roles
    * Member of role inherit all the permissions assigned to the role
    * When using roles
        * Choose or create a role
        * Assign role members
    * three of the built-in roles
        1. Owner: Lets you manage everything including access to resources
        2. Contributor: Lets you manage everything except grating access to resources
        3. Reader: Lets youview everything but not make changes
    * using roles
        * Built-in roles: use the buil-in roles first. Dozens to choose from
        * Custom roles: if the buil-in roles don't meet your requirements, then create you own
        * Least Privilege: Always follow the principal of least privilege



# Resume

![Types of Cloud Computing Services](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/types-of-cloud-computing-services.PNG)

![Types of Cloud Computing Services](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/cloud-computing-deployment-models.PNG)

![IaaS vs PaaS](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/IaaS_PaaS.PNG)
