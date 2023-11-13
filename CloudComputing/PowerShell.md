# PowerShell
- It is a management execution engine
  - Command-line shell
  - Scripting language
  - Automation platform
  - Configuration management
- [Install PowerShell on Windows, Linux, and macOS](https://learn.microsoft.com/en-us/powershell/scripting/install/installing-powershell?view=powershell-7.3)
- [Approved Verbs for PowerShell Commands](https://learn.microsoft.com/en-us/powershell/scripting/developer/cmdlet/approved-verbs-for-windows-powershell-commands?view=powershell-7.3)
- [Windows Terminal](https://learn.microsoft.com/en-us/windows/terminal/)
- [PowerShell Documentation](https://learn.microsoft.com/nb-no/powershell/)
  - ``` winget install --id Microsoft.Powershell --source winget ```
- [Azure Cloud PowerShell](https://learn.microsoft.com/en-us/azure/cloud-shell/overview)
- ``` $PSEdition ``` : Desktop
- PowerShell version
	```
	PS C:\dockuments\Pluralsight\PowerShell> $PSVersionTable

	Name                           Value
	----                           -----
	PSVersion                      5.1.22621.2428
	PSEdition                      Desktop
	PSCompatibleVersions           {1.0, 2.0, 3.0, 4.0...}
	BuildVersion                   10.0.22621.2428
	CLRVersion                     4.0.30319.42000
	WSManStackVersion              3.0
	PSRemotingProtocolVersion      2.3
	SerializationVersion           1.1.0.1
	
	---
	
	Name                           Value
	----                           -----
	PSVersion                      7.3.9
	PSEdition                      Core
	GitCommitId                    7.3.9
	OS                             Microsoft Windows 10.0.22621
	Platform                       Win32NT
	PSCompatibleVersions           {1.0, 2.0, 3.0, 4.0…}
	PSRemotingProtocolVersion      2.3
	SerializationVersion           1.1.0.1
	WSManStackVersion              3.0
	```
- [Differences between Windows PowerShell 5.1 and PowerShell 7.x](https://learn.microsoft.com/en-us/powershell/scripting/whats-new/differences-from-windows-powershell?view=powershell-7.3)
  - Windows PowerShell 5.1 is built on top of the .NET Framework v4.5. With the release of PowerShell 6.0, PowerShell became an open source project built on .NET Core 2.0. Moving from the .NET Framework to .NET Core allowed PowerShell to become a cross-platform solution. PowerShell runs on Windows, macOS, and Linux.

##Command basics, dash(-)
``` 
Get-Command
Get-Help
Get-Member
get-service | get-member

get-help get-verb | more 
clear-host
get-verb | more
get-verb -verb M*
get-verb -verb set | more
get-verb -verb set | format-list
get-verb -Group security | format-list	
```

- Others commands:
```
Get-Member
Get-History
Get-Alias
```

- Get-Service command:
	```
	Get-Service -Name P* -ComputerName Client1,Client2
		#Command name
		Get-Service 
		#First Parameter
		-Name P* 
		#Second Parameter
		-ComputerName Client1,Client2

	Gsv P* -Comp Client1,Client2
	Get-Servive -Name Spooler -RequiredServices
	Get-Service -Name B* -ComputerName Client1,Client2

	get-service | where-object status -eq "Stopped" 
	get-service | where-object status -eq "Stopped" | select-object Name, Status
	get-service | where-object status -eq "Stopped" | start-service
	```

- Sample to import and export data
```
$data = get-service | where-object status -eq "Stopped" | select-object Name, Status
clear-host
#Export data
$data | out-file .\services.csv				
notepad .\services.csv
#Export data
$data | export-csv .\Sevices2.csv
get-content .\Sevices2.csv
#Import data
$ImportData = import-csv -Path .\Sevices2.csv
$ImportData
```

- Get-Commad, man, Help, Get-Help, ... commands
```
Get-Command -Verb Get -Noun *DNS*
Get-Command -Name *Firewall* -CommandType Function
Get-Command -Verb Get -Nound *DNS*
Get-Command -Name *Firewall* -CommandType Function

Get-Help -Name Get-Commad -Detailed
Get-Help -Name *DNS*
how-to -Name Get-Commmand -Detailed
man -Name Get-Commmand -Detailed
Help about_*
Help about_command_syntax
help about_commonparameters
help get-service
help get-command
help get-command -examples
```
