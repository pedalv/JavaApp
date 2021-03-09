# Virtualization
- [How to create an Ubuntu VM on Windows 10](https://www.thomasmaurer.ch/2019/06/how-to-create-an-ubuntu-vm-on-windows-10/)
- [How to Install Ubuntu Linux on Windows 10 With VirtualBox](https://www.lifewire.com/install-ubuntu-linux-windows-10-steps-2202108)
- [Install Linux Inside Windows Using VirtualBox](https://itsfoss.com/install-linux-in-virtualbox/)

## Only some Windows version has [Hyper-V on Windows 10](https://docs.microsoft.com/en-us/virtualization/hyper-v-on-windows/about/) 
- Client Hyper-V: 
  * is the same hypervisor which powers virtualization in Windows Server and the Microsoft Azure datacenters.
  * With Hyper-V, you can create virtual machines running on Windows 10, without the need for third-party software.
- Hyper-V specifically provides hardware virtualization. That means each virtual machine runs on virtual hardware. 
- Hyper-V lets you create virtual hard drives, virtual switches, and a number of other virtual devices all of which can be added to virtual machines.
- [Windows 10 Hyper-V System Requirements](https://docs.microsoft.com/en-us/virtualization/hyper-v-on-windows/reference/hyper-v-requirements)
- [Supported Windows guests](https://docs.microsoft.com/en-us/virtualization/hyper-v-on-windows/about/supported-guest-os)
- [Supported Linux Guest Operating Systems](https://docs.microsoft.com/en-us/windows-server/virtualization/hyper-v/Supported-Linux-and-FreeBSD-virtual-machines-for-Hyper-V-on-Windows)
- [Supported Ubuntu virtual machines on Hyper-V](https://docs.microsoft.com/en-us/windows-server/virtualization/hyper-v/Supported-Ubuntu-virtual-machines-on-Hyper-V)
- [Supported Oracle Linux virtual machines on Hyper-V](https://docs.microsoft.com/en-us/windows-server/virtualization/hyper-v/Supported-Oracle-Linux-virtual-machines-on-Hyper-V)

#### Hyper-V commands:
* Enable Hyper-V using PowerShell: ``` Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V -All ```
* Enable Hyper-V with CMD and DISM: ``` DISM /Online /Enable-Feature /All /FeatureName:Microsoft-Hyper-V ```
* Return a list of Hyper-V commands:  ``` Get-Command -Module hyper-v | Out-GridView ``` 
* To learn more about a particular PowerShel:  ``` Get-Help Get-VM ```  
* Return a list of virtual machines: ``` Get-VM ```
* To return a list of only powered on virtual machines: ``` Get-VM | where {$_.State -eq 'Running'} ```
* To list all virtual machines in a powered off state: ``` Get-VM | where {$_.State -eq 'Off'} ```
* Start and shut down virtual machines: 
    * ``` Start-VM -Name <virtual machine name> ```
    * ``` Get-VM | where {$_.State -eq 'Off'} | Start-VM ```
    * ``` Get-VM | where {$_.State -eq 'Running'} | Stop-VM ```
* Create a VM checkpoint: ``` Get-VM -Name <VM Name> | Checkpoint-VM -SnapshotName <name for snapshot> ```
* View a list of checkpoints for a virtual machine: ``` Get-VMCheckpoint -VMName <VMName> ```
* To apply the checkpoint: ``` Restore-VMCheckpoint -Name <checkpoint name> -VMName <VMName> -Confirm:$false ```
* Set to Standard Checkpoint: ``` Set-VM -Name <vmname> -CheckpointType Standard ```
* Set to Production Checkpoint: ``` Set-VM -Name <vmname> -CheckpointType Production ```
* Set to Production Checkpoint:  ``` Set-VM -Name <vmname> -CheckpointType ProductionOnly ```
* Renaming checkpoints: ``` Rename-VMCheckpoint -VMName <virtual machine name> -Name <checkpoint name> -NewName <new checkpoint name>```, default: virtual_machine_name (MM/DD/YYY -hh:mm:ss AM\PM)
* Deleting checkpoints: ``` Export-VMCheckpoint -VMName <virtual machine name> -Name <checkpoint name> -Path <path for export> ```
* Exporting checkpoints: ``` Export-VMCheckpoint -VMName <virtual machine name> -Name <checkpoint name> -Path <path for export> ```

## On-line courses:
- TODO [Getting Started With Ubuntu](https://app.pluralsight.com/library/courses/ubuntu-getting-started/table-of-contents)
- TODO [Linux Fundamentals](https://app.pluralsight.com/paths/skill/linux-fundamentals-1)
- [Managing Docker on Linux Servers](https://app.pluralsight.com/library/courses/managing-docker-linux-servers/table-of-contents)
- [Creating Shell Scripts in Enterprise Linux](https://app.pluralsight.com/library/courses/creating-shell-scripts-enterprise-linux/table-of-contents)
- [inux: Managing Web Services (LPIC-2)](https://app.pluralsight.com/library/courses/linux-managing-web-services-lpic-2/table-of-contents)
- [LPIC-2: Linux Engineer (201-450 and 202-450)](https://app.pluralsight.com/paths/certificate/lpic-2)
- [Linux 10 Paths](https://app.pluralsight.com/search/?q=linux&type=path&m_sort=relevance&query_id=2e3d4a30-67b5-4cb0-91aa-e9d6ebce4299&source=user_typed)
- [Vagrant](https://www.vagrantup.com/downloads)
- TODO [Microsoft Azure API Management Essentials](https://app.pluralsight.com/library/courses/microsoft-azure-api-management-essentials/table-of-contents)
- TODO [Microsoft Azure Developer: Implement API Management](https://app.pluralsight.com/library/courses/microsoft-azure-developer-implement-api-management/table-of-contents)
- TODO [Designing an API Management Strategy for Microsoft Azure](https://app.pluralsight.com/library/courses/microsoft-azure-api-management-strategy-designing/table-of-contents)
- TODO [Azure Functions Fundamentals](https://app.pluralsight.com/library/courses/azure-functions-fundamentals/table-of-contents)
- TODO [Learning Azure Cosmos DB](https://app.pluralsight.com/library/courses/azure-cosmos-db/table-of-contents)
- [Monitoring Microsoft Azure](https://app.pluralsight.com/paths/skill/monitoring-microsoft-azure)
- [Microsoft Azure Deployment]https://app.pluralsight.com/paths/skill/microsoft-azure-deployment)
- [Integration on Microsoft Azure](https://app.pluralsight.com/paths/skill/integration-on-microsoft-azure)
- [Testing on Microsoft Azure](https://app.pluralsight.com/paths/skill/testing-on-microsoft-azure)
- [Azure Monthly Update](https://app.pluralsight.com/paths/conference/microsoft-azure-monthly-update)
- [Microsoft Azure datacenters](https://app.pluralsight.com/search/?q=Microsoft%20Azure%20datacenters&type=conference%2Cvideo-course%2Cdemo%2Cguide%2Cwebinar%2Cpath%2Cassessment&m_sort=relevance&query_id=3a4f71ed-57a8-409b-897d-51aa7c5660ff&source=user_typed)
- [Customer Stories: ServiceNow gains business scalability, speeds time to market with SAP on Microsoft Azure](https://customers.microsoft.com/en-us/story/779822-servicenow-partner-professional-services-azure)

## Tips og råd
- LTS, stands for long-term support: which means five years, until April 2025, of free security and maintenance updates, guaranteed
- Install from a .iso or .vhdx file
- To install the Azure-tuned kernel on 16.04, 18.04 and 20.04, run the following commands as root (or sudo):
```
# apt-get update
# apt-get install linux-azure
```
- disable secure boot in the Firmware section of the settings for the virtual machine in Hyper-V Manager or you can disable it using Powershell:
```
Set-VMFirmware -VMName "VMname" -EnableSecureBoot Off
```
- [Bootstrap IT](http://bootstrap-it.com/linux-start/)
- About Linux: redhat, suse, Centos, kernel, ubuntu, Android
- Thunderbird Mail
-  Dockerfile Script
```
FROM ubuntu:latest
MAINTAINER D Clinton info@bootstrap-it.com
RUN apt-get update
RUN apt-get install -y apache2
ADD index.html /var/www/html/
CMD /usr/sbin/apache2ctl -D FOREGROUND
EXPOSE 80
```

## command
- Single Partition Install: ``` df -h ```
- Linux package managers
  * APT: Debian/Ubuntu
  * YUM: Red Hat/CentOS