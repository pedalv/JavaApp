# Virtualization
- [How to create an Ubuntu VM on Windows 10](https://www.thomasmaurer.ch/2019/06/how-to-create-an-ubuntu-vm-on-windows-10/)
- [How to Install Ubuntu Linux on Windows 10 With VirtualBox](https://www.lifewire.com/install-ubuntu-linux-windows-10-steps-2202108)
- [Install Linux Inside Windows Using VirtualBox](https://itsfoss.com/install-linux-in-virtualbox/)
- VMware Fusion:  is a software hypervisor developed by VMware for Macintosh computers

## [Getting Started with the Linux Command Line](http://bootstrap-it.com/linux-cli)
-  Creating Data Archives
  * ``` ls ```=> latest.tar.gz
  * extract zip file: ``` tar xzt latest.tar.gz ```
  * ``` ls ```=> latest.tar.gz   wordpress
  * create zip file: ``` tar czf newarchive.tar.gz wordpress ```
  *  [Akismet Spam Protection](https://wordpress.org/plugins/akismet/#description)
    * ``` wget https://downloads.wordpress.org/plugin/akismet.4.1.9.zip ```
      * ``` unzip akismet.4.1.9.zip ```
      * ``` zip newname.zip * ```
- List items in directory: 
  * ``` ls ```
  * ``` ls -a ``` or ``` ls --all ```
  * ``` less .bashrc ```
  * ``` ssh ubuntu@10.0.70.110 ```
  * ``` less .profile ```
  * ``` less /etc/profile ```
  * ``` cat /etc/passwd ```
- List items, showing source for linked files: ``` ls -L ```
- Long list items: 
  * ``` ls -l /var/log ``` === command name | ls + Arguments | -l + operand | /var/log
  * ``` ls -l /bin/p* ```
  * ``` ls -l /etc/ ```
- Long list items and size: ``` ls -lh ```
- Long list items and size and order files by sending chronological order: ``` ls -lht ```
- Long lisy item in working directory: 
  * ``` ls -l -G ```  === ``` ls -l --no-group ```
  * ``` ls -L ```
- [serverfault - Questions tagged [linux]] (https://serverfault.com/questions/tagged/linux)
  * Show the manual for ls: ``` man ls ```
  * Show the manual for wget: 
    * ``` man wget  ```
        * ``` sudo apt install man-db ```
    * ``` wget wordpress.org/latest.tar.gz ```
    * ``` info wget examples simple ```
        * ``` sudo apt install info ```
        * ``` info  ```
        * ``` less cd /usr/share/doc/wget/README ```
    * ``` wget --help | less  ```
    * ``` type wget ``` => wget is hashed (/usr/bin/wget) 
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
- Create a file: 
  * ``` sudo touch /var/file.txt ```
  * ``` touch another four word name ``` => created 4 empty files: another, four, word and name
    * ``` touch another\ four\ word\ name ```
    * ``` touch "another four word name" ```
    * ``` touch another-four-word-name ```
    * ``` touch file1 file2  file12 ```
  * ``` nano file1 ``` === create a file to edit
    * ``` mkdir newdata ```
    * ``` cp file1 newdata/ ```
    * ``` cp file* newdata/ ```
    * ``` rm file? ``` === file12 wasn't removed
    * ``` rm file* ``` === all files were removed
    * ``` mv ../file* . ```
    * ``` rm * ```
    * ``` rmdir newdata/ ```
- Open a file for edit: ``` nano touch /var/file.txt ```
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
  * ``` ls -l /var/log/syslog* ```
  * ``` find /var/log/syslog* ```
  * ``` find /var/log/syslog* -type f ```  (f for files) 
  * ``` find /var/log/syslog* -type f -print0 ```
  * Change permissions for all files matching the pattern: ``` sudo find /var/log/syslog* -print0 | xargs -0 sudo chmod a+r ```
  * Unzip all *.gz files: ``` sudo find /var/log/syslog*.gz -type f -print0 | xargs -0 sudo gunzip ```
  * cat all files: ``` sudo find /var/log/syslog* -type f -print0 | xargs -0 cat ```
  * find word or sentence in files: 
    * ``` sudo find /var/log/syslog* -type f -print0 | xargs -0 cat | grep "word or sentence" ```
    *  ``` sudo find /var/log/syslog* -type f -print0 | xargs -0 cat | grep "NetworkManage" ```
    * ``` sudo find /var/log/syslog* -type f -print0 | xargs -0 cat | grep "NetworkManage.*warn" ```
    * ``` sudo find /var/log/syslog* -type f -print0 | xargs -0 cat | grep -c "NetworkManage.*warn" ``` === 111
   * network connectivity
      * ``` ip route show  ``` === ``` route  ```  (old)
      * ``` sudo dhclient  ```
      * display layer 3 the IP (IPv4 and IPv6, etc) addresses assigned to all interfaces: 
        * ``` ip addr ```  or ``` ip a ```      ==== ``` ifconfig ``` (old)   
        * ``` ip address show ```
        * ``` ip address show | grap inet ```
        * ``` ip address show | grap inet | head -n 1 ``` === get first result === 
        * ``` ip address show | grap inet | head -n 1 | cut -d ":" -f 2 ``` === 10.0.2.15 Bcast
        * ``` ip address show | grap inet | head -n 1 | cut -d ":" -f 2 | cut -d " " -f 1 ``` === 10.0.2.15 
        * details about the layer 2 (MAC address, ethernet address, etc) properties of the interface
          * ``` ip link show ```
        * Listing available Wi-Fi APs
          * ``` nmcli device wifi list ``` === [nmcli](https://developer.gnome.org/NetworkManager/stable/nmcli-examples.html)
      * Network Addressing
        * IPv4
          * 256.256.256.256 = 4,294,967,296 (2^32)
          * Example address: 192.168.1.3
        * Network Address Translation (NAT) ranges
          * 10.0.0.0 to 10.255.255.255
          * 172.16.0.0 to 172.31.255.255
          * 192.168.0.0 to 192.168.255.255
        * IPv6
          * Example address:
            * fd42:7fd5:d2a7:bf0d:216:3eff:fed3:5889
        * Print network connections, routing tables, interface statistics, masquerade connections, and multicast memberships
          * ``` netstat -l  ```
          * ``` netstat -i  ```  
            * Install: ``` sudo apt install net-tools ```
          * ``` ssh -i  ```
            * ``` ssh -i mykeyfile.pem ubuntu@10.0.31.131  ```
      * Domain Name System (DNS) configuration
        * ``` host bootstrap-it.com ``` => bootstrap-it.com has address 52.3.203.146
        * ``` ping 8.8.8.8  ``` => one of google servers
        * ``` cat /etc/resolv.conf  ```
          * ``` systemd-resolve --status  ```
          * ``` sudo nano /etc/hosts  ``` === add for eksemple 192.168.1.5 mysite.com to the file
      * Remote connections and Secure and SSH
        * SSH Key Exchange, Client (private key), Server (public key) === pair of keys
          * Step 1: connection request
          * Step 2: encrypted number
          * Step 3: decrypted number
          * connection started
        * [OpenSSH in Windows 10!](https://devblogs.microsoft.com/commandline/openssh-in-windows-10/)
          * Installing OpenSSH
            * Server (It is the machine that owns the session, the resources you want administration)
              * ``` apt install openssh-server ```
              * ``` yum install openssh-server ```
            * Client (it is your machine, laptop, or workstation)
              * ``` apt install openssh-client ```
              * ``` yum install openssh-clients ```
            * ``` cd /etc/ssh ``` 
              * ssh_config: handler the way your system login as a client on remote hosts  
              * sshd_config: manager your system hosts behaviour
                * ``` sudo nano sshd_config ```
                * from 2016, [Protocol Deep Dive: SSH and Telnet](https://app.pluralsight.com/library/courses/ssh-telnet-protocol-deep-dive/table-of-contents)
            *  ``` ssh ubuntu@10.0.31.131 ``` === pair of keys
                *  ``` ssh -p 2222 ubuntu@10.0.31.131 ```
                *  ``` ssh -i /home/myusername/mykeyfile.pem ubuntu@10.0.31.131 ``` === Amazon
            *  ``` scp update-local.sh ubuntu@10.0.31.131:/home/ubuntu ``` === pair of keys
                * ``` scp script.sh ubuntu@10.0.31.131:/home/ubuntu  ```
  * Scripting commands
    * Script name: write-ip.sh
    * Run permissions: ``` chmod a+x write-ip.sh```
    * Run script: ``` ./write-ip.sh ```   
    * Show Ip address: ``` tail -f ip.txt ``` === show last changes in the file that come  
    * Show script: ``` nano write-ip.sh ```
    * script example 1:
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
    * script example 2:      
      ``` 
      #!/bin/bash
      chmod +x myscript.sh
      read number1
      total=$number1*$number2
      for filename in file1 file2 file3
      if test $text1 != $text2; then
      while [ $counter -gt 2 ]; do
      case $weather in
      ```
    * [Shell Scripting with Bash](https://app.pluralsight.com/library/courses/bash-shell-scripting/table-of-contents)
    * ``` mkdir scripts ```
    * ``` cd /home/ubuntu/scripts ```
    * ``` pwd ``` => /home/ubuntu/scripts
      * exemple 3:
        * ``` nano myscript.sh ``` 
          ```
          #!/bin/bash
          declare -i number1
          declare -i number2
          declare -i total
          echo "What's your favorite number? "
            read number1
          echo "What number do you really hate? "
            read number2
          total=$mumber1*$number2
            echo "Aha! They equal " $total
          exit 0
          ```
          * ``` chmod +x myscript.sh ```
          * ``` ./myscript.sh ```
      * exemple 4:
        * ``` nano theloop.sh ```
          ```
          #!/bin/bash
          for i in {0..10..2}
            do
              echo "We've been through this $i times already!"
            done
          ```
          * ``` chmod +x theloop.sh ```
          * ``` ./theloop.sh ```
      * exemple 5:    
        * ``` touch file1 file2 file3 ```
        * ``` ls ```
        * ``` nano newloop.sh ```
          ```
          #!/bin/bash
          for filename in file1 file2 file3
            do
              echo "Important stuff" >> $filename
            done
          ```
          * ``` chmod +x newloop.sh ```
          * ``` ./newloop.sh ```
          * ``` cat file3 ``` => Important stuff
      * exemple 6:    
        * ``` nano colors.sh ```
        ```
        #!/bin/bash
        #declare -s text1
        #declare -s text2
        echo "What's your favorite color? "
          read text1
        echo "What's your best friend's favorite color? "
          read text2
          if test $text1 != $text2; then
            echo "I quess opposites attract.
          else 
            echo "You two do think alike!
          fi
        exit 0
        ```
        * ``` chmod +x colors.sh ```
        * ``` ./colors.sh ```
      * exemple 7:    
        * ``` nano counter.sh ```
        ```
        #!/bin/bash
        declare -i counter
        counter=10
          while [ $counter -gt 2]; do
            echo the counter is $counter
            counter=counter-1
          done
        exit 0
        ```
        * ``` chmod +x counter.sh ```
        * ``` ./counter.sh ```
      * exemple 8:    
        * ``` nano weather.sh ```
        ```
        #!/bin/bash
        echo "What's tomorrow's wather going to be like? "
        read weather
          case $weather in
            sunny | warm ) echo "Nice! I love it when it's " $weather
            ;;
            cloudy | cool ) echo "Not bad... " $weather" is ok, too"
            ;;
            rainy | cold ) echo "Yuk!" $weather" weather is depressing"
            ;;
            * ) echo "Sorry, I'm not faniliar with that weather system."
            ;;
          esac        
        exit 0
        ```
        * ``` chmod +x weather.sh ```
        * ``` ./weather.sh ```
      * bash built-in commands: ``` man builtins ```
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
  * ``` whoami ```: Print currebt user's name
  * ``` hostname ```: Print computer name
  * ``` pwd ```: Print working directory
  * ``` ls ```: List items in directory
  * ``` man [command/tool name] ```: Show manual
  * ``` cat [file] ```: Print file(s) to screen
  * ``` tail [file] ```: Print the last X line of file
  * ``` nano [file] ```: print file 
  * ``` less [file] ```: Print files in pages
  * chmod: Change permissions
    * Make script executable: 
      * ``` chmod u+x script.sh ```
      * ``` chmod u+x [file] ```
    * Run script: ``` ./script.sh ```
  * ``` chown [OPTIONS] USER[:GROUP] FILE(s) ```: Change owner
  * ``` find [-H] [-L] [-P] [-D debugopts] [-Olevel] [starting-point...] [expression] ```: Find files by pattern 
- copy from to: 
  * ``` sudo cp -r * /var/www/prosject-frontend ```
  * ``` sudo cp /etc/nginx/sites-available/default /etc/nginx/sites-available/prosjekct-frontend ```
- create a link: ``` sudo ln -s /etc/nginx/sites-available//prosjekt /etc/nginx/sites-enabled/  ```  
- remove a link: ``` sudo rm -s /etc/nginx/sites-available/default/  ```

 
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
- [Getting Started With Ubuntu](https://app.pluralsight.com/library/courses/ubuntu-getting-started/table-of-contents)
- [Linux Fundamentals](https://app.pluralsight.com/paths/skill/linux-fundamentals-1)  
- TODO [Shell Scripting with Bash](https://app.pluralsight.com/library/courses/bash-shell-scripting/table-of-contents)  
- TODO [Protocol Deep Dive: SSH and Telnet](https://app.pluralsight.com/library/courses/ssh-telnet-protocol-deep-dive/table-of-contents)
- TODO [Linux Performenca Monitoring and Tuning](https://app.pluralsight.com/library/courses/linux-performance-monitoring-tuning/table-of-contents)
- TODO [Linux Network Security](https://app.pluralsight.com/library/courses/linux-network-security-lpic-3-303/table-of-contents)
- TODO [Securing Linux Servers](https://app.pluralsight.com/library/courses/securing-linux-servers/table-of-contents)
- TODO [Linux Encryption Security](https://app.pluralsight.com/library/courses/linux-encryption-security-lpic-3-303/table-of-contents)  
- TODO [Managing Docker on Linux Servers](https://app.pluralsight.com/library/courses/managing-docker-linux-servers/table-of-contents)
- TODO [Creating Shell Scripts in Enterprise Linux](https://app.pluralsight.com/library/courses/creating-shell-scripts-enterprise-linux/table-of-contents)
- TODO [Linux: Managing Web Services (LPIC-2)](https://app.pluralsight.com/library/courses/linux-managing-web-services-lpic-2/table-of-contents)
- TODO [LPIC-2: Linux Engineer (201-450 and 202-450)](https://app.pluralsight.com/paths/certificate/lpic-2)
- TODO [Linux 10 Paths](https://app.pluralsight.com/search/?q=linux&type=path&m_sort=relevance&query_id=2e3d4a30-67b5-4cb0-91aa-e9d6ebce4299&source=user_typed)
- TODO [Using Docker with AWS Elastic Beanstalk](https://app.pluralsight.com/library/courses/docker-aws-elastic-beanstalk/table-of-contents)

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
- [Bootstrap IT - linux-star](http://bootstrap-it.com/linux-start/)
- [Vagrant](https://www.vagrantup.com/downloads)
- [Install Docker Engine on Ubuntu](https://docs.docker.com/engine/install/ubuntu/)

## About Linux: 
* Open Source Licensing Models:
  * Free Software Foundation (FSF)
    * GPL (Linux kernel) 
  * Open Source Initiative (OSI)
    * MIT, Apache, BSD
  * Creative Commons    
* Linux kernel
  * Core operating system
  * CPU intructions
  * Accesing storage
  * Device communication
* Linux desktops (GNOME, KDR, Cinnamon)
* Linux distributions (Red Hat or Ubuntu)
  * Android (mobile devices)
  * Red Hat Enterprise Linux (CentOS and Fedora)
    * YUM package manager
    * CentOS
  * SUSE
    * openSUSE
  * Scientific Linux (science and math)  
  * Kali Linux (security)
  * Raspbian (mini architectures), [Raspberry Pi](https://www.raspberrypi.org/)
  * Ubuntu (all-round)  
    * Free Open Source Distro
    * Linux kernel
    * Unity user interface
    * GNOME desktop
    * APT package manager
    * LVM: this will set up Logical Volume Management. It allows taking snapshopts and easier partition resizing
  * Mint (consummer-friendly)
  * Viryual Machines
  * Cloud Computing
* Distribution Families - Linux package managers   
  * Debian (Ubuntu, Mint, Kali Linux) - APT/DPKG
  * Red Hat Enterprise Linux (CentOS and Fedora) - YUM/RPM (DNF)
  * SUSE (openSUSE) - ZYpp
  * Arch Linux (LinHES and Manjaro) - Pacman
  * komandoer:
    * ubuntu package manager: ``` sudo nano /etc/apt/sources.list ```
      * updates the package lists for upgrades for packages that need upgrading: ``` sudo apt update ```
      * fetch new versions of packages existing on the machine: ``` sudo apt-get update && sudo -apt-get upgrade ```
      * Ubuntu Software Repositories
        * Main: Support by Canonical
        * Restricted: Proprietary
        * Universe: Community supported
        * Multiverse: Restricted usage      
      * third part repositories: 
        * ``` ls /etc/apt/sources.d ```
        * ``` apt list --all-versions | wc ```
        * search for third part repo: 
          * ``` apt search business card | less ```
          * ``` apt search glabels ```
          * ``` apt show glabels ```
          * ``` sudo apt install glabels ``` or ``` sudo apt-get glabels ``` ==== recommended
    * CentOS    
      *  search for packages: ``` yum infor vino  ```
      *  ``` yum info vino ```
      *  ``` yum install vino ```
      *  ``` yum infor trousers ```
      * YUM will be replaced by DNF
    * Linux Desktop Application
      * Format: *.deb
      * [LibreOffice](https://www.libreoffice.org/discover/libreoffice/) === write, calc, impress, draw, base
      * from 2016, [Linux Networking Security](https://app.pluralsight.com/library/courses/linux-network-security-lpic-3-303/table-of-contents)
      * Thunderbird Mail, Firefox Web Browser (standard)
      * [How to Install Google Chrome Web Browser on Ubuntu 20.04](https://linuxize.com/post/how-to-install-google-chrome-web-browser-on-ubuntu-20-04/)
        * wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
        * sudo apt install ./google-chrome-stable_current_amd64.deb
      * Cheese (webcam)
      * Empathy Ubuntu (skype, mattermost, slack, signal, teams, osv)
      * Rhythmbox ubuntu (Rubyripper for better som quality)
      * Games: Battle for Wesnoth,
      * Lifesstyle front: Stellarium
      * web and nettwork applications
        * [APACHE HTTP SERVER PROJECT](https://httpd.apache.org/)
        * [MariaDB Foundation](https://mariadb.org/)
        * [Samba opening windows to a wider world](https://www.samba.org/)
      * [Vagrant](https://www.vagrantup.com/downloads)     
      * [GIMP GNU IMAGE MANIPULATION PROGRAM](https://www.gimp.org/)
      * [kdenlive for edit videos](https://kdenlive.org/en/)
      * [blender Open source #D creation](https://www.blender.org/)
      * [jEdit](http://www.jedit.org/)
      * [Visual Studio Code on Linux](https://code.visualstudio.com/docs/setup/linux)
      * jetbrains === ubuntu software
          * [Install WebStorm](https://www.jetbrains.com/help/webstorm/installation-guide.html)
          * [Install as a snap package on Linux](https://www.jetbrains.com/help/webstorm/installation-guide.html#snap)
    * Linux Desktops
      * Cinnamon/Mate
        * ``` sudo apt install mint-meta-meta ```
      * Gnome
      * Xfce
* Ubuntu and Canonical
  * Standdard Ubuntu desktop and server
  * Ubuntu GNOME and Kubuntu, which use different desktops
  * Xubuntu and Lubuntu, which are built to run on modest hardware
  * Edubunto, which is built for schools
  * Ubunto Studio, which is built for designers
* [Filesystem Hierarchy Standard](https://en.wikipedia.org/wiki/Filesystem_Hierarchy_Standard)  
  * Root-level Directories  
    * /bin: Binary files for (single user mode) system commands
    * /sbin: Binary files for (multi-user) system commands
    * /boot: Linux images and boot configuration files
    * /dev: Pseudo files representing devices
    * /etc: Configuration files
    * /home: User files
    * /lib: Software library dependencies
    * /root: Root user files
    * /usr: Additional binaries
    * /var: Updating files: logs, application data, cache
  * Pseudo (ephemeral) File Directories
    * /proc: Files representing running system processes
    * /dev: Pseudo files representing devices
    * /sys: Data on system and kernel resources
      * first drive read by the system: ``` cd ls/sys/block/sda/ ```      
      * second drive in the system: ``` cd ls/sys/block/sdb/ ```
      * partition 1...n from second drive in the system: ``` cd ls/sys/block/sdb/sdb1 ```
      * ``` cat size ``` => size of sdb1
      * list block devices 
        * ``` lsblk ``` 
        * ``` lsblk | grep sd ```
      * mount a partition|drive: 
          * ``` sudo mkdir /media /newplace ```
          * ``` sudo mount /dev/sdb2 /media/newplace/ ```
      * Troubleshooting Peripherals
        * Display the information about USB:
          * ``` lsusb ```
        * Display the information about all PCI devices:
          * ``` lspci ```
        * list hardware
          * ``` sudo lshw | less ```
          * ``` sudo lshw > lshw-output ```
          * ``` less  lshw-output ```
          * ``` ls /lib/modules/ ```
            * ``` uname -r ```
            * ``` cd  /lib/modules/`uname -r`/kernel/sound ```
              * ``` lsmod | grep sound ```
              * to load the module: ``` modprobe soundcore ```
      * report file system disk space usage 
        * ``` df -h ```
        * ``` df -ht ext4 ```
        * [Lvm](https://wiki.ubuntu.com/Lvm)
      * print or control the kernel ring buffer
        * ``` dmesg ```
        * ``` dmesg | less ```
        * wireless land: ``` dmesg | wl ```       
* The Linux Boot Process
  * BIOS/UEFI
  * Master Boot Record (MBR) on boot disk launched
  * Bootloader (GRUB) launched
  * Linux kernel loaded into memory
  * init executes config file targets (runlevels)
  * Display manager loaded
  * Desktop loaded
  * Bootstrap directory : ``` ls /boot ``` 
  * Se bootstrap config: ``` ls /boot/grub/grub.cfg ```
  * Se how bootstrap config: ``` less /boot/grub/grub.cfg ```
  * Edit bootstrap config: ``` less /etc/default/grub ``` and ``` ls /etc/grub.d ```
  * Update grub: ``` sudo update-grub ```
* Linus Runnlevels
  * 0: system halt
  * 1: single-user (rescue) mode
  * 3: multi-user mode without GUI
  * 5: multi-user mode with GUI
  * 6: reboot
  * kommandoer: 
    * ``` sudo telinit 0 ```, 
    * ``` systemctl get-default ``` => graphical.target,
    * ``` systemctl isolate rescue.target ```
    * ``` systemctl enable multi-user.target ```   
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
    * Kommmandoer:
      * ``` locale ```
        * ``` locale adduser ```
          * ``` sudo nano /etc/adduser.conf ``` 
          * ``` sudo updatedb ``` == update index from all recent files changed for find them
            * ``` cat /var/log/systlog ```
            * ``` cat /etc/group | grep ubuntu ```
            * ``` cat /etc/group | grep ubuntu >> newfile ``` === create and append
            * ``` cat /etc/group | grep ubuntu > newfile ``` === create or overwriting 
            * ``` head /etc/group  ``` === print first 10 lines of a file
            * ``` tail /etc/group  ``` === print last 10 lines of a file
            * ``` cut -d: -f3 /etc/group  ``` === print only third column
              * ``` cut -d: -f3 /etc/group | sort -n  ``` === print only third column ascending order
              * ``` cut -d: -f3 /etc/group | sort -rn  ``` === print only third column descending order
              * word count: ``` wc /etc/group ```
        * Located:  ``` cd /usr/share/i18n/locales/ ``` 
        * Edit locale: ``` less en_CA ```
      * Standard Strems

        | Name            | designation | Numeric Code  |
        | --------------- |:-----------:| -------------:|
        | Standard Input  | stdin       |       0       |
        | Standard Output | stdout      |       1       |
        | Standard Error  | stderr      |       2       |

          * Standard Input: ``` mysql -u root -p < mydatabase.sql ```
          *  ``` echo "Hello"  ``` or ``` cat myfile.txt ``` === stdout
          * ``` echo "Hello" >> myfile.txt ``` === stdin   
          * ``` wget pluralsight.comm 2> errorfile.txt ``` === stderr

      * view and edit locale settings: 
        * ``` localectl status  ```
        * ``` localectl list-locales ```
        * ``` localectl set-locale LANG=en_CA.utf8 ```
      * Present work directory: ``` pwd ``` or ``` echo $PWD ``` 
      * Environment: 
        * ``` env ``` or ``` env | less ```
        *  ``` myval=5 ```, ``` echo $myval ``` => 5             
        * open a new terminal: ``` bash ```, myval is not available
          * ``` export myval=5 ```, myval is available on a new terminal
      * history from all commands in terminal: ``` history ``` 
      * Location commands: ``` type wget ``` => wget is /usr/bin/wget
      * print current time zone: ``` timedatectl ```
      * print all time zones: ``` timedatectl list-timezones | grep -i america ```
      * set time zones: ``` timedatectl set-timezone Canada/Toronto ```
 
#### Working with the Linux Server
  * Server applications: Apache, Nextcloud, Yum, Snaps
  * LXC (Linux Containers)
    * [Amazon EC2 - Free AWS Cloud Compute Service](https://aws.amazon.com/ec2/?ec2-whats-new.sort-by=item.additionalFields.postDateTime&ec2-whats-new.sort-order=desc)
    * [Linux Containers](https://linuxcontainers.org/)
    * ``` sudo apt install lxd ```  
      * from 2016, [Linux Server Virtualization](https://app.pluralsight.com/library/courses/linux-server-virtualization-lpic3-304-1/table-of-contents)
    * From ubuntu: 
      * ``` sudo lxd launch images:centos/7/amd64 cebtos7 ```
      * ``` sudo lxc list ```
      * ``` sudo lxc exec centros7 /bin/bash ``` ==== inside the linux server
        * Installing and Working with Server Apps: Apache
          * ``` yum install httpd ``` (install firewall for allowed who as access and permitions)
          * ``` systemctl start httpd ```
          * ``` systemctl enable httpd ``` === for start witch time boot the computer
          * ``` ip address ``` => inet 10.0.160.1/16 
          * browser: 10.0.160.1 or ``` curl 10.0.160.1 ``` 
          * ``` echo "Hello World" > /var/www/html/hello.html ``` 
          * default web root for search for web resources === /var/www/html/  => ``` curl 10.0.160.1/hello.html ```
        * Installing and Working with Server Apps: [Nextcloud](https://nextcloud.com/)
          * Manual Nextcloud Installation
            * Install a LAMP server
            * Configure service connectivity
            * Download Nextclod archive
            * Set permissions
            * Troubleshoot
            * [snapcraft - The app store for Linux](https://snapcraft.io/docs/getting-started)  
            * [David Clinton](https://www.youtube.com/channel/UCzAhxo5HNimfjSj1i85utMA/videos)  
            * kommandoer:
              * ``` snap install nextcloud ``` 
              * browser: 10.0.31.131 - create an admin account on Nextcloud
              * ``` cd /var/snap, ls ``` => core nextcloud 
              * ``` cd nextcloud ``` => 10314 common  current
              * ``` cd 10314, ls ``` => apache certs mysql nextcloud php redis 
              * ``` less nextcloud/config/config.php ```
              * ``` cd /etc/,  nano hosts ```
                * Backup always before any change: ``` sudo cp hosts hosts.backup ```
  * Compiling code in Linux
    * Packages needed to compile binaries: [Bootstrap IT - linux-start](http://bootstrap-it.com/linux-start/)
      * Maybe is need install package to compile binaries
        ```
          sudo apt install autoconf g++ subversion linux-source \
                linux-headers-`uname -r` build-essential tofrodos \
                  git-core subversion dos2unix make gcc automake cmake \
                checkinstall git-core dpkg-dev fakeroot pbuilder \
                  dh-make debhelper devscripts patchutils quilt \
                  git-buildpackage pristine-tar git yasm checkinstall \
                  cvs mercurial 
        ```
      * for heavy network analysis, [NMAP.org (gzip compressed)](https://nmap.org/download.html)  
        * ``` wget https://nmap.org/dist/nmap-7.91.tgz ```
        * ``` tar xzf nmap-7.91.tgz ```
        * ``` cd nmap-7.91  ```
        * ``` ./configure ```
        * ``` make ```
        * ``` make install ```
        * ``` nmap -F 10.0.0.0/16 ```

## web Development ==== Ubuntu Desktop
- [How to Install and Configure Docker on Ubuntu 20.04](https://linuxhint.com/install_configure_docker_ubuntu/)
- [How to install IntelliJ IDEA on Ubuntu 20.04 Linux Desktop](https://linuxconfig.org/how-to-install-intellij-idea-on-ubuntu-20-04-linux-desktop)
- [Aptana Studio 3](http://www.aptana.com/)
- [How to Install Apache Maven on Ubuntu 20.04](https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-20-04/)
- [How To Install Java with Apt on Ubuntu 20.04](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-20-04)
- [https://vitux.com/how-to-install-java-on-ubuntu-20-04/](https://vitux.com/how-to-install-java-on-ubuntu-20-04/)
  * sudo apt install openjdk-11-jdk
- Java, python, perl, bash shell, .NET

#### front-end, Nginx web server: 
  * Apache 
  * IIS 
  *  NGinx (frontend)
    * sudo apt-get update
    * apt search nginx
    * sudo apt-get install nginx
    * sudo apt-get install nodejs
    * sudo npm install -g gulp
    * sudo service nginx restart

#### Back-end workloads === Ubuntu server and the Cloud (AWS, Azure...)
- SSH and Command Line
  * [sudo...](https://askubuntu.com/questions/376199/sudo-su-vs-sudo-i-vs-sudo-bin-bash-when-does-it-matter-which-is-used)
    * sudo su
    * sudo su - 
    * sudo -i
    * sudo /bin/bash
  * ssh 172.16.141.186
    * whoami
    * hostname
    * sudo apt-get install nginx
    * sudo ls -l /var/logs/syslog*
    * sudo tail –f /var/logs/syslog
  * ssh elton@ub-ws-01.cloidapp.net
    * user/password
    * privat/public key === pair of keys
      * ssh-keygen -b 2018 -t rsa -C elton@sixeyed.com
      * ls .ssh
      * cat .shh/id_rsa.pub
      * ssh-copy-id -i .ssh/id_rsa.pub elton@172.16.141.186
      * ls .ssh
      * ls .ssh/authorizer_keys
- Ubuntu in the Cloud (AWS, Azure...)
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

## [Linux System Administration](http://bootstrap-it.com/linux-admin/)
- Why Linux?
  * Most web and application servers run on Linux
  * Most Continuous Integration/Continuous Deployments run on Linux
  * Docker vurtualizes kernel resources of its Linux host
  * All SWS EC2 instances run on Linux hosts (using Xen or KVM)
- [Linux Performenca Monitoring and Tuning](https://app.pluralsight.com/library/courses/linux-performance-monitoring-tuning/table-of-contents)
  * ``` cd /proc ```
  * ``` ls ```
  * ``` less /proc/meminfo ```
  * ``` less /proc/cpuinfo ```
  * HW: ``` top ``` === CPU + MEM
  * ``` free ``` or  ``` free -h ```
  * ``` df  ``` or ``` df -ht ext4 ``` == for format partitions 
  * [Speed Test](http://www.dslreports.com/speedtest)
  * ``` sudo apt update && sudo apt install iftop ```
  * ``` ip addr ``` or ``` ip a  ```
  * ``` sudo iftop -i eth0  ```
  * report a snapshot of the current processes:
    * ``` ps  ```
    * ``` ps  aux ```
    * ``` ps  aux | wc ```
    * ``` ps  aux | grep sshd ```
    * ``` man sshd ```
    * ``` journalctl --since "10 minutes ago" ```
    * ``` cat /var/log/syslog | grep sshd ```
    * ``` cat /var/log/syslog | grep eth0 ```
    * print or control the kernel ring buffer
        * ``` dmesg ```
        * ``` dmesg | less ```
        * wireless land: ``` dmesg | wl ```
        * ``` ssh ubuntu@10.0.31.131 ```
          * ``` snap list ```
    * ``` yes > /dev/null & ```  === it will bw automatic deleted
      * ``` ps ```
      * ``` kill 11287 ``` === kill only one processe
      * ``` killall yes ``` === kill all instances of yes run on the system
      * ``` nice -19 yes > /dev/null &``` === change the run priority, 0: neutral, 1-20: high, -1-20: low  
        *  ``` renice 15 -p 1187 ``` 
  * ``` sudo systemctl status apache2 ```
    * ``` sudo systemctl disable apache2 ```
    * ``` sudo systemctl enable apache2 ```
    * ``` sudo systemctl start apache2 ```
    * ``` sudo systemctl stop apache2 ```
- Users and Groups
  * ``` less /etc/shadow ``` => Permission denied  
  * ``` sudo less /etc/shadow ```
  * ``` sudo less /etc/passwd ```
  * ``` sudo less /etc/group ```
  * ``` id ubuntu ``` , ``` id steve ```
  * ``` who ``` === who is loggin
  * ``` w ``` === who is loggin and what he/she doing
  * ``` last | less``` 
  * ``` sudo useradd -m jane ``` === ``` cd /home/jane && ls -a ``` => . .. .bash_logout .bashrc .profile
  * ``` ls -a /etc/skel && ls -a ``` => . .. .bash_logout .bashrc .profile 
  * ``` sudo passwd jane ``` 
  * ``` sudo mkdir /var/secret ```  
    * ``` sudo groupadd secret-group ``` 
    * ``` sudo chown :secret-group /var/secret ``` 
    * ``` sudo usermod -a -G secret-group jane ```
    * ``` sudo chmod g+w /var/secret ``` === group can edit files now
- [Linux Network Security - Security your Linux Server](https://app.pluralsight.com/library/courses/linux-network-security-lpic-3-303/table-of-contents)
  * ``` cd /var/secret ```
  * ``` ls ```
  * ``` su jane ``` == janes new terminal 
  * ``` touch data.txt ```
  * ``` ls ```
  * ``` touch /var/log/stuff ``` => Permission denied
  * ``` ls -l ```  => -rw-rw-r-- 1 jane jane 0 Jan 23 20:30 data.txt
    * -rw-rw-r-- 1 jane jane 0 Jan 23 20:30 data.txt
      * 1: Type: file (-)
      * 3: Owner permissions: read + write
      * 3: Group permissions: read + execute
      * 3: Other user permissions: read 
      * : File references: 1 link
      * Owner: jane
      * Group: jane
      * Size: 0 bytes
      * Last modified: Jan 23 20:30
      * Name: data.txt
  * ``` ls -dl ``` => drwxrwxr-x 2 root secret-group 4096 Jan 23 20:03
  * drwxrwxr-x 2 root secret-group 4096 Jan 23 20:03
    * 1: Type: directory (d)
    * 3: Owner permissions: read + write + execute
    * 3: Group permissions: read + write + execute
    * 3: Other user permissions: read + execute
    * : File references: 2 link
    * Owner: root
    * Group: secret-group
    * Size: 4096  bytes
    * Last modified: Jan 23 20:30
    * Name: -
  * ``` sudo chown ubuntu:secret-group /var/secret/ ```
  * ``` chmod o+x data.txt ```
  * ``` chmod u+x data.txt ``` 
  * ``` chmod +x data.txt ```
  * Permission: Numeric Notation

        | Read      | r |  4 |
        | Write     | w |  2 |
        | Execeute  | x |  2 |
      
    * Full permissions: 7
    * Read/execute: 5
    * Execute: 1
    * chmod 777 data.txt => -rwxrwxrwx 1 jane jane 0 Jan 23 20:30 data.txt
  * ``` ls -dl ``` => drwxrwxr-x 2 root secret-group 4096 Jan 23 20:03
  * ``` sudo chmod +t . ``` === A sticky bit is a permission bit that is set on a directory that allows only the owner of the file within that directory, the owner of the directory or the root user to delete or rename the file. No other user has the needed privileges to delete the file created by some other user.
  * ``` ls -dl ``` => drwxrwxr-t 2 root secret-group 4096 Jan 23 20:03
  * chmod +s /var/secret  === set user or group ID on execution (s)
  * create symbolic link 
    * ``` mkdir scripts ```
    * ``` cd /home/ubuntu/scripts ```  
    * ``` nano myscript.sh ```
    ```
    #!/bin/bash
    # Lots of secret stuff  
    ```
    * ``` sudo ln -s /home/ubuntu(scripts/myscript.sh /var/secret ``` === sudo ln -s FILE_LOCATED FILE_AVAILABLE 
    * ``` ls -l ``` => lrwxrwxrwx 1 root root 32 Aug 6 17:58 myscript.sh -> /home/ubuntu(scripts/myscript.sh 
  * Hardening Your Server 
    * [Dpkg Team](https://wiki.debian.org/Teams/Dpkg)
    * [Ubuntu Security Notices](https://ubuntu.com/security/notices)
    * Software updates
      * ``` sudo apt update && sudo apt upgrade ```
      * ``` yum update ```
    * Service Access Controls
      * Service Hardening
      * Port control
        * Open/close ports
          * ``` nmap -v -sT localhost ``` === scan computer for open ports
          * ``` systemctl disable apache2 ``` === 443=https
      * Firewall rules
        * [Securing Linux Servers](https://app.pluralsight.com/library/courses/securing-linux-servers/table-of-contents) 
        * [Cisco](https://app.pluralsight.com/search/?q=cisco&type=conference%2Cvideo-course%2Cdemo%2Cguide%2Cwebinar%2Cpath%2Cassessment&m_sort=relevance&query_id=44ece8ef-8dec-4645-9551-14ea74a36090&source=user_typed) 
    * Data encryption 
      * [Linux Encryption Security](https://app.pluralsight.com/library/courses/linux-encryption-security-lpic-3-303/table-of-contents)
      * [Let's encrypt - A nonprofit Certificate Authority providing TLS certificates to 240 million websites.](https://letsencrypt.org/)
      * Disk Encryption (Installation Choice)
      * Web servers: 
        * SSL Encryption
        * TLS Encryption, computer - server, [certbot instructions](https://certbot.eff.org/lets-encrypt/ubuntubionic-apache)
          * compute -> server, valid CA certificate?
          * compute <- server, Response
          * compute -> server, Page request
          * compute <- server, Encrypted web page
      * Email Server Elements
        * Mail transport agent (MTA): Postfix, Sendmail
        * Mail delivery agent (MDA): Dovecot
        * Mail user agents (MUA): Thunderbird
- Working with Docker and Linux Containers
  * Virtualization (< 2012)
  * Container virtualization (> 2013)
    * Docker === Dockerfile 
    * Kubernetes === Orchestrators 
  * Linux In a Container World
    * Host administration
      * Privileges
      * kernel access
    * Container administration
      * Application design
    * The Future of Linux
      * Microservices
      * DevOps
      * Development support
  * Understand the Docker ecosystem
    * Docker Resources
      * Image hosting:
        * [Docker Hub](https://hub.docker.com/)
        * [Docker Registry](https://docs.docker.com/registry/#:~:text=The%20Registry%20is%20a%20stateless,under%20the%20permissive%20Apache%20license.)
      * Storage:
        * Docker Volumes
        * Third-part solutions (cloud === Google Kubernetes Engine, GKE, and Azure Kubernetes Service)
      * [docker](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/docker.md)
        * ```  docker network ls ```
        * ```  docker networlk create newnet ```
          * [Swarm mode overview](https://docs.docker.com/engine/swarm/)  
          * [kubernetes](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/kubernetes.md)
  * Install Docker Engine on Linux
    * [Install Docker Engine](https://docs.docker.com/engine/install/)
    * [How to Install and Configure Docker on Ubuntu 20.04](https://linuxhint.com/install_configure_docker_ubuntu/)
    * Exampel 1 - Docker repositories: 
      * From 
        * [DockerHub](https://hub.docker.com/search?q=&type=image) 
        * [harbor](https://goharbor.io/) 
      * ``` sudo docker run hello-world ==== image1: hello-world ``` === [hello-world](https://hub.docker.com/_/hello-world)
        *  ``` curl 172.17.0.2 ``` => hello-world
      * ``` sudo docker run -it ubuntu bash ==== image2: ubuntu ``` === [ubuntu](https://hub.docker.com/_/ubuntu)
         * ``` sudo namo /etc/group ```  
            * Edit group file from "docker:x:999:" to "docker:x:999:ubuntu" === not need sudo anymore
            * ``` ssh ubuntu@192.168.1.21 ```
      * ``` sudo docker ps -a ``` => image1 and image2 
    * Exampel 2 - Docker deployment:
      * From Dockerfile script: 
        * ``` sudo namo Dockerfile ```
        * from course 1:
          ```
          # Create a webserver on Ubuntu
          FROM ubuntu:latest
          MAINTAINER D Clinton info@bootstrap-it.com
          RUN apt-get update
          RUN apt-get install -y apache2
          ADD index.html /var/www/html/
          CMD /usr/sbin/apache2ctl -D FOREGROUND
          EXPOSE 80
          ```
        * from course 2:
          ```
          # Dockerfile to create Ubuntu webserver
          #
          FROM ubuntu:latest
          
          RUN apt-get update
          RUN apt-get install -y apache2
          RUN echo "Welcome to my web site" > /var/www/html/index.html
          EXPOSE 80
          ```
      *  Work with a Dockerfile script
        * ``` ls ``` => Dockerfile
        * ``` docker build -t webserver . ```
        * ``` docker images => webserver ```
        * Example 2 for course 1: 
          * ``` docker run -d webserver ```
            * ``` docker ps ```
            * ``` curl 172.17.0.2 ``` => 'html page'
        * Example 2 for course 2: 
          * ``` docker run -d -p 80:80 webserver /usr/sbin/apache2ctl -D FOREGROUND ```  === 80 is default port 
            * ``` docker ps ```            
            * ``` curl 172.17.0.2 ``` or from a browser 192.168.1.21 => Welcome to my web site
        * Set example 2 in DockerHub
          * ``` docker login ```
          * ``` docker tag webserver pedalv/webserver ```
          * ``` docker push pedalv/webserver ```
        * Search and pull a image inside DockerHub    
          * ``` docker search nextcloud ```
          * ``` docker pull nextcloud ```  

# Resume

![Datacenters in the Past](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/datacenters-in-the-past.PNG)

![Virtual Host and Machines](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/virtual-host-machines.PNG)

![containers](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/containers.PNG)