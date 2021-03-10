# Virtualization
- [How to create an Ubuntu VM on Windows 10](https://www.thomasmaurer.ch/2019/06/how-to-create-an-ubuntu-vm-on-windows-10/)
- [How to Install Ubuntu Linux on Windows 10 With VirtualBox](https://www.lifewire.com/install-ubuntu-linux-windows-10-steps-2202108)
- [Install Linux Inside Windows Using VirtualBox](https://itsfoss.com/install-linux-in-virtualbox/)

## Linux commands line
- updates the package lists for upgrades for packages that need upgrading,: ``` sudo apt update ```
- fetch new versions of packages existing on the machine: ``` sudo apt-get update && sudo -apt-get upgrade ```
- Single Partition Install: ``` df -h ```
- Display the information about USB: ``` lsusb ```
- List items in directory: ``` ls ```
- List items, showwing source for linked files: ``` ls -L ```
- Long list items: 
  * ``` ls -l /var/log ``` === command name | ls + Arguments | -l + operand | /var/log
  * ``` ls -l /bin/p* ```  
- Long lisy item in working directory: 
  * ``` ls -l -G ```  === ``` ls -l --no-group ```
  * ``` ls -L ```
- Show the manual for ls: ``` man ls ```  
- Files and User
  * -rwxr-xr-x 1 elton staff 97 Dec 7 19:49 example.sh
    * 1: Type: directory 8d) or file (-) 
    * 3: Owner permissions: read + write + execure
    * 3: Group permissions: read + execute
    * 3: Other user permissions: read + execute
    * : File references: 1 link
    * Owner: elton
    * Group: staff
    * Size: 97 bytes
    * Last modified: Dec 7 19:49
    * Name: example.sh
- Create a file: ``` sudo touch /var/file.txt ```
- Print to output: ``` echo "line 1" ```
- Print to file: ``` sudo echo "line 1">> /var/file.txt ``` 
- Run as root: ``` sudo su ```
- Print file(s) to screen: ``` cat /var/file.txt ```
- Print the last X line of file: ``` tail /var/file.txt ```
- Print files in pages: ``` less /var/file.txt ```
- Give permission to all users to write: ``` chmod a+w /var/file.txt  ```
- Give permission to all users to read only: ``` chmod a-w /var/file.txt  ```
- Change owner: ``` chmown pedro /var/file.txt  ```
- Give to owner write permissions: ``` chmod u-w /var/file.txt  ```
- combine commands
  * ls -l /var/log/syslog* 
  * find /var/log/syslog*
  * find /var/log/syslog* -type f (f for files)
  * find /var/log/syslog* -type f -print0
  * Change permissions for all files matching the pattern: ``` sudo find /var/log/syslog* -print0 | xargs -0 sudo chmod a+r ```
  * Unzip all *.gz files: ``` sudo find /var/log/syslog*.gz -type f -print0 | xargs -0 sudo gunzip ```
  * cat all files: ``` sudo find /var/log/syslog* -type f -print0 | xargs -0 cat ```
  * find word or sentence in files: 
    * ``` sudo find /var/log/syslog* -type f -print0 | xargs -0 cat | grep "word or sentence" ```
    *  ``` sudo find /var/log/syslog* -type f -print0 | xargs -0 cat | grep "NetworkManage" ```
    * ``` sudo find /var/log/syslog* -type f -print0 | xargs -0 cat | grep "NetworkManage.*warn" ```
    * ``` sudo find /var/log/syslog* -type f -print0 | xargs -0 cat | grep -c "NetworkManage.*warn" ``` === 111
   * network
      * display layer 3 the IP (IPv4 and IPv6, etc) addresses assigned to all interfaces: 
        * ``` ip address show ```
        * ``` ip address show | grap inet ```
        * ``` ip address show | grap inet | head -n 1 ``` === get first result === 
        * ``` ip address show | grap inet | head -n 1 | cut -d ":" -f 2 ``` === 10.0.2.15 Bcast
        * ``` ip address show | grap inet | head -n 1 | cut -d ":" -f 2 | cut -d " " -f 1 ``` === 10.0.2.15 
        * details about the layer 2 (MAC address, ethernet address, etc) properties of the interface: ``` ip link show ```
        * Listing available Wi-Fi APs: ``` nmcli device wifi list ``` === [nmcli](https://developer.gnome.org/NetworkManager/stable/nmcli-examples.html)
  * Scripting commands
    * Script name: write-ip.sh
    * Run permissions: ``` chmod a+x write-ip.sh```
    * Run script: ``` ./write-ip.sh ```   
    * Show Ip address: ``` tail -f ip.txt ``` === show last changes in the file that come  
    * Show script: ``` nano write-ip.sh ```
    * script example:      
      ```
      - Specify BASH shell
      #!/bin/bash
      - Save IP address in variable
      originalAddress=$(ifconfig |
                        grep "inetaddr" |
                        head -n 1 |
                        cut -d ":" -f 2 |
                        cut -d " " -f 1)
      - Print variable to screen
      echo $originalAddress
      - Print variable to file
      echo $originalAddress>> ~/ip.txt
      ```
- CRON (daily, weekly, montly): run script.sh as pedro
  * evert 10 minutes, every day:  ```` 10 * * * * [script or command] ```
  * at 00:05 am, every day:  ```` 5 0 * * * [script or command] ```
  * at 00:05 am, every sunday:  ```` 5 0 * * 7 [script or command] ```
  * evert hour:  ```` * */1 * * * [script or command] ```
  * evert 5 minutes:  ```` */5 * * * * [script or command] ```
  * at 00:01, on wednesday 3rd:  ``` 1 0 3 * 3  [script or command] ```
  * at 05:00 am, every week:  ``` 0 5 * * 1 tar -zcf /var/backups/home.tgz /home/ ```
  * every day at 02:00: ``` 0 2 * * * sudo apt-get update && sudo apt-get upgrade ```
  * every year 10 of jun at 02:01 : ```` 1 2 10 6 * [script or command] ```
  * every year where 10 of jun is on a sunday at 02:01: ```` 1 2 10 6 7 [script or command] ```
  * evert hour:  ```` * */1 * * * ¨/write-ip.sh ```
  * crontab -e === m h dom mon dow command (minutes hour dayOgmonth month dayOfweek )
- DO NOT RUN THIS COMMAND! REALLY!, clean your hard disk: sudo rm –R –f –no-preserve-root /
- The UNIX Philosophy
  * whoami: Print currebt user's name
  * hostname: Print computer name
  * pwd: Print working directory
  * ls: List items in directory
  * man: Show manual
  * cat: Print file(s) to screen
  * tail: Print the last X line of file
  * nano: print file 
  * less: Print files in pages
  * chmod: Change permissions
    * Make script executable: 
      * ``` chmod u+x script.sh ```
      * ``` chmod u+x [file] ```
    * Run script: ``` ./script.sh ```
  * chown: Change owner
  * find: Find files by pattern 
   
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
- [Linux: Managing Web Services (LPIC-2)](https://app.pluralsight.com/library/courses/linux-managing-web-services-lpic-2/table-of-contents)
- [LPIC-2: Linux Engineer (201-450 and 202-450)](https://app.pluralsight.com/paths/certificate/lpic-2)
- [Linux 10 Paths](https://app.pluralsight.com/search/?q=linux&type=path&m_sort=relevance&query_id=2e3d4a30-67b5-4cb0-91aa-e9d6ebce4299&source=user_typed)
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
- [Vagrant](https://www.vagrantup.com/downloads)

## About Linux: 
  * Linux kernel
    * Core operating system
    * CPU intructions
    * Accesing storage
    * Device communication    
  * Linux distributions: 
    * Ubuntu
      * Free Open Source Distro
      * Linux kernel
      * Unity user interface
      * GNOME desktop
      * APT package manager
      * LVM: this will set up Logical Volume Management. It allows taking snapshopts and easier partition resizing
    * Debian
      * APT package manager
    * redhat
      * YUM package manager
    * suse, 
    * CentOS
      * YUM package manager
    * Android
* Ubuntu and Canonical
  * Standdard Ubuntu desktop and server
  * Ubuntu GNOME and Kubuntu, which use different desktops
  * Xubuntu and Lubuntu, which are built to run on modest hardware
  * Edubunto, which is built for schools
  * Ubunto Studio, which is built for designers

#### Install Ubuntu programs
- Format: *.deb
- [How to Install Google Chrome Web Browser on Ubuntu 20.04](https://linuxize.com/post/how-to-install-google-chrome-web-browser-on-ubuntu-20-04/)
  * wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
  * sudo apt install ./google-chrome-stable_current_amd64.deb
- Thunderbird Mail
- Cheese (webcam)
- Empathy Ubuntu (skype, mattermost, slack, signal, teams, osv)
- Rhythmbox ubuntu (Rubyripper for better som quality)
- Games: Battle for Wesnoth,
- Lifesstyle front: Stellarium
- LibreOffice (write, calc, impress, draw)
  
##  Dockerfile Script
```
FROM ubuntu:latest
MAINTAINER D Clinton info@bootstrap-it.com
RUN apt-get update
RUN apt-get install -y apache2
ADD index.html /var/www/html/
CMD /usr/sbin/apache2ctl -D FOREGROUND
EXPOSE 80
```
