# [Microsoft Azure](https://en.wikipedia.org/wiki/Microsoft_Azure)
- Microsoft Azure, commonly referred to as Azure (/ˈæʒər/), 
- Azure is a cloud computing service created by Microsoft for building, testing, deploying, and managing applications and services through Microsoft-managed data centers. 
- It provides software as a service (SaaS), platform as a service (PaaS) and infrastructure as a service (IaaS) and supports many different programming languages, tools, and frameworks, including both Microsoft-specific and third-party software and systems. 
- [Create your Azure free account today, Get started with 12 months of free services](https://azure.microsoft.com/en-us/pricing/)

##  Accounts
- [Portal Azure](https://portal.azure.com/?quickstart=true#blade/Microsoft_Azure_Resources/QuickstartCenterBlade)
    * [Learn new skills and discover the power of Microsoft products with step-by-step guidance. Start your journey today by exploring our learning paths and modules.](https://docs.microsoft.com/en-us/learn/browse/?WT.mc_id=Portal-Microsoft_Azure_Resources&products=azure&expanded=azure)
    * [Take an online course](https://portal.azure.com/?quickstart=true#blade/Microsoft_Azure_Resources/QuickstartCenterBlade)
    * Used: 
      * Users, Azure AD Conditional Access, Azure Active Directory, 
      * Resource groups, Policy, Blueprints, Advisor, Security, 
      * Network security groups, Application security groups,
      * Route tables, Distributed Denial of Service (DDoS) Protection, Firewalls,
      * Key vaults, Security Center, 
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

## Microsoft Azure Security and Privacy Concepts
- Azure Identity Services
    - authentication
        * the act of proving who or what something is
    - authorization
        * Granting the correct level of access to a resource or service
    - What Is Azure Active Directory?
        * for Authentication
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
    - Azure multi-factor authentication
        * Something you Know / have / are
            * add user to a group
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
- Implementing Azure Role Based Access Control
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
- Implementing Azure Access and Governance Tools
    * Why Do We Need Governance Tools?
        * Enforce our security requirements: We will have mapped out our security requirements. Governance tools give us a way to enforce some of these requirements.
        * Enforce our technical requirements: We will have standard sizes, builds and configurations that we will wish to enforce.
    * Azure Tags
        * key/value pairs assigned to resources
        * Organizations should have a tagging policy enforced by Azures policies
        * Tags can be used
            * To enforce security requirements
            * To control costs
            * To deploy software
    * What Is Azure Policy?
        * Azure policy is a collection of rules
        * Each policy is assigned to a scope such as an Azure subscription
        * Using Azure policy means that resources will remain compliant with corporate standards
        * Using Azure policy
            * Policy definition
            * Policy assignment
            * policy parameters
    * What Are Initiatives?
        * Initiatives are a collection of policies
        * Policies in an initiative are grouped to achieve a larger goal
        * Initiative are assigned to a scope such as a resource group
        * Using initiatives
            * initiative definition
            * initiative assignment
            * initiative parameters
    * Built-in Policies === Think about your teams and resources they will need to work with. Use Azure Policy to allow these resources
        * Storage accounts: Defines wich storage SKU (Stock Keeping Unit)  sizes can be used
        * Resource types: Defines which resource types can be used
        * Allowed locations: Restrict locations that can be used
        * Enforce tags: Enforces a required tag
        * Virtual machine DKUs: Specifies a set of Virtual Machines SKUs that cvan be deployed
    * Azure Blueprints
        * Blueprints are a way of orchestrating the deployment of resource tenmplates and artifacts
        * Blueprints maintain a relationsship with the deployed resources
        * Blueprints include Azure policy and initiatives as well as artifacts such as roles
        * Using Blueprints
            * Blueprint definition
                * Resource groups can be defined and created
                * Azure resource manager templates can be included to deploy resources
                * Azure policy can be included to enforce compliance
                * Roles can be assigned to resources thet blueprints have created
            * Blueprint publishing
            * Blueprint assignment
    * What is Azure Adviser Security Asssistance?
        * Azure adviser integrates with Azure security center
        * Adviser security assistance helps prevent, detect and respond to threats
        * You should be using this tool everyday
        * Configuration is managed through security center
- Security Azure Virtual Network
    * Plan your security with defense-in-depth at its heart
        * Physical security: Manager by Microsoft
        * Identity and access: Managed by you using Azure AD
        * Perimeter: Standard Distributed Denial of Service (DDoS) protection enabled by default
        * Network and application: Network security groups, firewalls and gateways
        * Compute and data: OS security, access control and encryption
    * What Are Network Security Groups (NSGs)?
        * NSGs filter traffic: NSGs allow or deny inboud and outbound traffic
        * NSGs contain rules: Rules are ordered based on a number from 100 (processe first) to 4096 (processed last)
        * Attached to subnets or network cards
        * Each NSG can be linked to multiple resources
        * NSGs are [stateful](https://www.redhat.com/en/topics/cloud-native-apps/stateful-vs-stateless)
        * NSGs properties include
          * Name
          * Priority
          * Source or destination
          * Protocol
          * Direction
          * Port range
          * Action
    * Problems with Network Security Groups
        * Can become complex: Can contain lots of rules, the more rules we need the more complex the design
        * Can be difficult to maintain: If we add more resources, we may need to update several network security groups
    * Solving Network Security Group Problems
        * Use service tags: Represent services like Azure load balancer or API management and locations like internet
        * Use the default security rules: Default security allow and deny common traffic
        * Use application security groups: Application security groups allow us define a service made up of resources like virtual machines.
    * What Are Application Security Groups?
        * Allows us to reference a group of resources
        * Used as a source or destination in network security groups
        * Network security group are still required
        * Working ith application security groups
            * Create the application security group
            * Link the group to resources
            * Use the group when working with network security groups
        * Think About Your Requirements
            * N-Tier applications: Each tier would have its own application security groups 
            * DMZ : Resources in your DMZ would be added to their own application security groups
                * DMZ or demilitarized zone is a physical or logical subnetwork that contains and exposes an organization's external-facing services to an untrusted, usually larger, network such as the Internet 
                * DMZ called a perimeter network, between the on-premises network and an Azure virtual network
            * Automation: When automating deployments include application security groups
- Working with Azure Firewalls and User Defined Routes
    * WHat Is Azure Firewall?
        * Azure managed stateful firewall service
        * Protects access to virtual networks
        * Highly available
        * Features include
            * Threat intelligence
            * Outbound and inbound Network address translation (NAT) support  
            * Integration with Azure Monitor
            * Network traffic filtering rules
            * Unrestricted scalability
    * What Is Azure Distributed Denial of Service (DDoS) Protection?
        * Distributed Denial of Service (DDoS) mitigation for networks and applications
        * Always-on monitoring
        * Application layer protection
        * Integration with Azure monitor
        * Features offered
            * Multi-layered protection  
            * Attack analytics
            * Scale and elasticity
            * Protection against unplanned costs
    * Azure Distributed Denial of Service (DDoS) Service Tiers
        * Basic
            * active traffic monitoring and always on detection
            * Availability Guarantee
            * Backed by an service-level agreement (SLA)
            * Free      
        * Standard
            * Everything offered by the basic tier
            * Real time Metrics
            * Post attack reports
            * Access to Distributed Denial of Service (DDoS) experts during and active attack
            * Security information and event management (SIEM) integration
            * Monthly fee and usage based
        * Think About Your Azure Networks === Virtual appliances can be deployed to add additional protection
            * Will you need Azure firewall? 
                * Do you use a network firewall noe? What rules will need to configure?
            * Witch Distributed Denial of Service (DDoS) tier will yopu need? 
               * The Basic tier is free but might not offer the service-level agreement (SLA), reporting or response you might need
        * Azure User Defined Routers
            * Default system routes are enabled by default
            * System routes allow routing between subnet and to the internet
            * User defined routes allow us to override Azure's default system routes
            * Often used when we want traffic to be filtered through a virtual applicance
        * Azure Security Options
            1. Azure firewall
            2. Azure Distributed Denial of Service (DDoS) Protection
            3. Azure web application firewall
            4. Network security groups
            5. Forced tunneling  
            5. Marketplace devices
        * Security Scenarios
            * Controll internet traffic
                * You wish to control the flow of traffic heading to the internet so that it cab be inspected at layer 7
                    * Security Solutions: User defines routes, Azure firewall or marketplace device
            * Azure hosted SQL Server
                * Only traffic from your Azure subnets should be allowed to access your Azure SQL server
                    * Security Solutions: Network security groups (NSGs) 
            * Router internet traffic
                * All internet bound traffic that is generated by your application servers must be routed through HQ
                    * Security Solutions: Forced tunneling
 - Working with Azure Security and Reporting Tools  
    * What Is Azure Information Protection (AIP)?
        * Azure Information Protection (AIP) is used to classsify documents and emails
        * Azure Information Protection (AIP) applies labels to documents
        * Labeled documents can be protected
        * Azure Information Protection (AIP) labels
            * Can be applied automatically
            * Can be applied manually
            * Can be recommended to users
    * Two Sides to Azure Information Protection (AIP)
        * Classification: Metadata is added to documents. Clear text and visual markings like headers, footers and watermarks
        * Protection: Azure rights management encrypts documents using rights management templates
    * Classifying and Protecting Existing Documents
        * Ideally documents and emails should be labeled and protected when they are created
        * you will probably have lots of existing documents in Azure and on-premises
        * For on-premise data stores you can use Azure information protection scanner
        * For cloud data stores we cab use Microsoft cloud app security
    * Three Security and Reporting Resources
        * Azure monitor: Collect and analyze metric information for Azure and on-premises resources 
          * What is Azure monitor
            * Collect, analyze and act on telemetry
            * Azure or on-premises
            * Troubleshooting and performance monitoring
            * Data collected by Azure monitor
                * Metrics
                * Logs
        * Azure service health: Notifies you about Azure services and planned maintenance
          * What is Azure Service Health?
            * Notifies you about service status
            * Reports incidents and planned maintenance
            * Azure service health offers
                * Personalized dashboards
                * Configurable alerts
                * Guidance and support
        * Azure advanced threat protection: Detect and investigate attacks in Azure and on-premises
            * What Is Azure Advanced Threat Protection?
                * Monitor and analyze user activity
                * Identifies suspecious activity and events
                * Works with your on-premises Active Directory forest
                * Identifies
                    * Reconnaissance attacks
                    * Compromised credentials
                    * Lateral movements
                    * Domain dominance
        * Azure key vault
            * The problem with secrets
                * Secrets management: How do you control access tokens, passwords, API keys and other secrets?
                * Key management: How do you create and control encryption keys?
                * Certificate management: How do you provision, manage and deploy certificates?
            * What Is Azure Key Vault?
                * Centralize the storage or application secrets 
                * Uses FIPS 140-2 level 2 Validated HSMs
                * Enable logging to monitor how and when secrets are being used
                * Enable centralized administration of secrets  
            * Azure Key Vault recommendations
                * Use separate key vault for each application or environment
                * Take regular backups of your key vault  
                * Turn on logging and set up alerts   
                * Turn on soft date and purge protection   
        * Azure Security Centre and Azure Sentinel
            * Cloud Security Challenges
                * Rapid change: How do you make sure that changes to services meet your security requirements?
                * Complex attacks: Attacks are becoming more sophisticated, How do you keep up with new threats?
                * Skils shortage: Lots of information available but who monitors it?
        * Azure Security Center
            * Protect Paas: No deployment needed, just works
            * Non-Azure services: Deploy monitoring agent
            * Compliance: Reports our compliance posture
            * Assessement: Continous assessment of existing and new sources
            * Threat protection:  Detect and prevent threats to IaaS and PaaS
            * Azure Sentinel
                * Cloud-native security information event management (SIEM) and security orchestration automated response (SOAR) solution
                * A single solution for:
                    * Collect data at cloud scale
                    * Detect previously undetected threats
                    * Investigate threats with artificial intelligence
                    * Respond to incidents rapidly 
                * Connect to your security source with data connectors
                * Analyze your data using workbooks and analytics
                * Security automation and orchestration using playbooks
                * Deep investigation and hunting
- Understanding Azure compliance and data protection standards
    * Azure Industry Compliance
        * Regulatory Compilance
            * Process of ensuring that you follow the standards or laws laid out by governing bodies
            * People and process monitor systems to detect and prevent violations
            * Compliance monitoring can be complex  
            * Azure provides several tools to help us asses our compliance posture
    * Selected Compliance Standards 
      * HIPAA
      * PCI
      * GDPR
      * FredRAMP
      * ISO 27001
    * Azure Compliance
        * Global compliance: More than 90 compilance offerings
        * Industry compilance: Over 35 industry specific offerings
        * Blueprints: Deploy compliant environments   
        * Proof: Access to 3rd party reports
        * Azure security center: Unify security management
    * Azure Service Trust Portal and Service Trust Center
        * Azure Service Trust Portal
            * Contents: Details of Microsoft's implementation of controls and processes
            * Access: Login as an authenticated user with a Microsoft cloud service account
            * What will we find?
                * Compliance manager: Workflow based risk assessment tool
                * Trust socuments: Security implementation and design information
                * Industries and regions: Industry and regionspecific compilance information  
                * Trust Center: Links to the Microsoft trust center
                * My library: You cab save and access your compliance documents
        * What is Service Trust Center?
            * Security, privacy and compliance information
            * Access to Microsoft product compliance information
            * Compliance tools
                * Compliance score
                * Audit reports
                * Data protection resources
    * Azure Special Regions === You must request access to the Azure special regions if you whish to deploy resources to them.
        * US Gov: US Goc Virginia and US Gov lowa. US goverment agencies
            * Additional compliance certifications such as FedRAMP and DISA. Level 5 DoD approval
        * Chine: Chine East and Chine North- Available through a partnership with 21Vianet
            * Microsoft does not directly maintain these data centers
        * Germany: Germany central and Germany Northeast. Available through a data trustee model
            * Customer data remains under the control of T-System, A Deutsche Telekom company
    * Azure compilance Resources
        * Trusted Cloud
            * Security: Azure helps to keep customers data secure
            * Privacy: Azure gives customers ownership and control of their own data
            * Compliance: Azure conforms to global standards
        * Microsoft Cloud Adoption Framework
            * Outlines cloud adoption best prectices from Microsoft employees, partners and customers
            * Guidance for busines leaders and IT decision makers
            * Helps you define a busuness strategy for cloud adoption
            * Provides guidance on best practice governance of Microsoft cloud services
        * Azure compliance Documentation
            * Starting point for learning about compliance in Azure
            * Organized into regional and global compliance offerings
            * Industry specific offerings
                * Financial services
                * Automative 
                * Media
                * Energy
        * Microsoft Privacy Statment
            * Explains how Microsoft collects and processes personal data and for what proposes
            * Includes product specific information
            * Microsoft use personal data
                * Improve and develop products
                * Personalize products and make recommendations
                * Advertising and marketing
                * Performance analyses and reasearch
        * Service Agreements and Terms
            * Microsoft Online Subscription Agreement (MOSA)
            * Online Services Terms (OST)
            * Online Service Data Protection Addendum (DPA)
            * Service Level Agreements
        * Dedicated Hosts
            * Azure Dedicated Host provide physical servers that host one or more virtual machines
            * Your server is dedicated to your organization
            * Host-level isolation helps address compliance requirements
            * Visibility of underlying cores to meet server-based software licensing requirements
- Course Summary
    * Identity and Access Management
       * Azure AC
       * Azure AD Domain Services
       * Role base access control (RBAC)
       * Built in and custom roles
    * Governace Tools and Secure Virtual Networks
      * Azure policy
      * Azure initiatives
      * Azure blueprints
      * Secure virtual networks
        * Network security groups
        * Application security groups
    * Azure Firewalls and User Defined Routes
        * Azure firewall
        * Azure DDoS protection
        * User defined routes
        * Azure security solutions
    * Azure Security and Compliance
        * Azure information protection
        * Azure key vault
        * Azure monitor
        * Azure security center
        * Compliance
            * Compliance standards
            * Azure special regions
            * Azure trust center
            * Azure service trust portal


# Resume

![Types of Cloud Computing Services](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/types-of-cloud-computing-services.PNG)

![Types of Cloud Computing Services](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/cloud-computing-deployment-models.PNG)

![IaaS vs PaaS](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/IaaS_PaaS.PNG)


## On-line courses:
- [POPULAR - Microsoft Azure: The Big Picture](https://app.pluralsight.com/library/courses/microsoft-azure-the-big-picture/table-of-contents)
- [POPULAR - Microsoft Azure Cloud Concepts](https://app.pluralsight.com/library/courses/microsoft-azure-cloud-concepts)
- [Fundamentals of Cloud Computing](https://app.pluralsight.com/library/courses/cloud-computing-fundamentals/table-of-contents)
- [Microsoft Azure Security and Privacy Concepts](https://app.pluralsight.com/library/courses/microsoft-azure-security-privacy-concepts/table-of-contents)
-
- - 3h38m Feb 26, 2021 [Microsoft Azure Services and Concepts](https://app.pluralsight.com/library/courses/microsoft-azure-services-concepts/table-of-contents)
- 3h 40m 25 Apr 2019 [Azure Functions Fundamentals](https://app.pluralsight.com/library/courses/azure-functions-fundamentals/table-of-contents)
- - 1h 37m July 1h 37, 2020 [Microsoft Azure Pricing and Support Options](https://app.pluralsight.com/library/courses/microsoft-azure-pricing-support-options/table-of-contents)
-
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
