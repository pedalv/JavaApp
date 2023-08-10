# Azure CLI
- [Azure Command-Line Interface (CLI) documentation](https://learn.microsoft.com/en-us/cli/azure/)
- [JMESPath](https://jmespath.org/)
- [Microsoft Azure CLI](https://github.com/Azure/azure-cli)
- [Quickstart: Create a Linux virtual machine with the Azure CLI]https://learn.microsoft.com/en-us/azure/virtual-machines/linux/quick-create-cli)
- [Create a complete Linux virtual machine with the Azure CLI](https://learn.microsoft.com/en-us/azure/virtual-machines/linux/create-cli-complete)
- [Azure CLI sample scripts](https://learn.microsoft.com/en-us/cli/azure/samples-index?tabs=service)
- [How to install the Azure CLI](https://learn.microsoft.com/en-us/cli/azure/install-azure-cli?view=azure-cli-latest)
- [Azure Command-Line Interface (CLI) documentation](https://learn.microsoft.com/en-us/cli/azure/?view=azure-cli-latest)
- [Querying tables and entities](https://learn.microsoft.com/en-us/rest/api/storageservices/Querying-Tables-and-Entities)

## Logg in commands
- ``` az --version```
- ``` az login ``` https://aka.ms/devicelogin and enter de code nnnnn to authenticate
- ``` az account show ```
- ``` az account list ```
- ``` az account set -s "<name> ```

## Help commands
- ``` az ```
- ``` az webapp -h ``` or ``` az webapp create -h ``` or ``` az webapp config -h ```
- ``` az interactive ```

## Formatting output commands
- ``` az group list ```
- ``` az group list -o table ```
- ``` az group list -o tsv ``` for query parameters
- ``` az group list -o jsonc ```
- ``` az functionapp list | more ```

## Filtering output with --query commands, [JMESPath](https://jmespath.org/)
- ``` az functionapp show -n whosplayingfuncs -g whosplayingfuncs ``` a lot of information
- ``` az functionapp show -n whosplayingfuncs -g whosplayingfuncs --query state ``` only state information
- ``` az functionapp show -n whosplayingfuncs -g whosplayingfuncs --query "[state,ftpPublishingUrl]" ```
- ``` az functionapp show -n whosplayingfuncs -g whosplayingfuncs --query "[State:state,Ftp:ftpPublishingUrl]" ``` See [JMESPath](https://jmespath.org/) for more examples
- ``` az functionapp list --query "[].state" ```
- ``` az functionapp list --query "[].{Name:name, Group:resourceGroup,State:state}" ```
- ``` az functionapp list --query "[0].{Name:name, Group:resourceGroup,State:state}" ```
- ``` az functionap config appsettings list -n whosplayingfuncs -g whosplayingfuncs--query  "[?name=='FUNCTIONS_EXTEBSION_VERSION']" ```
- ``` az functionap config appsettings list -n whosplayingfuncs -g whosplayingfuncs--query  "[?name=='FUNCTIONS_EXTEBSION_VERSION'].value" ```
- ``` az functionap config appsettings list -n whosplayingfuncs -g whosplayingfuncs--query  "[?name=='FUNCTIONS_EXTEBSION_VERSION'].value" -o tsv ```
- ``` az network public-ip show -n mypublicip -g myresourcegroup --query ipAddress -o tsv ```
- ``` az keyvault secret show --vault-name mykeyvault --name mysecretname --query value -o tsv ```
- ``` az network lb show -n myloadbalancer -g myresourcegroup --query "inboundNatRules[].frontendPort" -o tsv ```

## Azure Cloud Shell
- Use Azure CLI in the browser
- Locate in Microsoft Azure to be installer and pay for the subscription
- ``` az group list -o table ```
- ``` cd clouddrive ```
- ``` mano myscript.sh ```
- ``` ./myscript.sh ```

## Managing Virtual Machines: images + disks + CPU and RAM + Networking Port osv + Configuration + Stop and start + credentials
Exploring VM images and Sizes
- ``` az vm -h ```
- ``` az vm image list -o table ```
- ``` az vm image list --all -f elasticsearch -o table  ```
- ``` az vm image list --all -s VS-2017 -o table ```
- ``` az vm list-sizes --location westeurope -o table ```
Create a new VM and get information about a VM 
- bash for PowerShell $ResourceGroupName... 
```  
ResourceGroupName="CreateVMDemo"
az group create --name $ResourceGroupName --location westeurope
az vm create -h | more
VmName="ExampleVm"
AdminPassword="<passord-name"
az vm create \ 
    --resource-group $ResourceGroupName \ 
    --name $VmName \
    --image win2016datacenter \ 
    --admin-user azureuser \
    --admin-password $AdminPassword
    (--size
    --use-unmanager-disk)
```
- ``` az resource list -g $ResourceGroupName -o table ``` === disk+ virtualMachines + networkInterfaces + networkSecurityGroups + publicIPAddressses + virtualNetworks
- ``` az vm show -g $ResourceGroupName -n $VmName --query "hardwareProfile.vmSize" ```
Configuring VM: Open port 80, Run a Custom script to install IIS and set up a website
- ``` az vm list-ip-addresses -n $VmName -g $ResourceGroupName -o table ```
- ``` az vm open-port --port 80 --resource-group $ResourceGroupName --name $VmName ```
- Run from a file named extensionSettings.json
```  
az vm extension set \
    --publisher Microsoft.Compute \
    -- version 1.8 \
    --name CustomScriptExtension \
    --vm-name $VmName \
    --resource-group $ResourcesGroupName \
    --settings extensionSettings.json
```
Stop and start VM and delete a VM
- ``` az vm -h ```
- ``` az vm show -d -g $ResourceGroupName -n $VmName --query "powerState" -o tsv  ``` === VM running
- ``` az vm deallocate -n $VmName -g $ResourceGroupName ``` === deallocate because stop play for execution == Stop a VM (and deallocate)
- ``` az vm show -d -g $ResourceGroupName -n $VmName --query "powerState" -o tsv  ``` === VM deallocated => stopped
- ``` az vm start -n $VmName -g $ResourceGroupName ```
- ``` az vm show -d -g $ResourceGroupName -n $VmName --queery "publicIps" -o tsv ```
- ``` az vm delete ``` === it is not good because we created more than a VM
  - ``` az resource list -g $ResourceGroupName -o table ``` === disk+ virtualMachines + CustomScriptExtension + ExampleVmVMNix + ExampleVMNSG + networkInterfaces + networkSecurityGroups + publicIPAddressses + virtualNetworks
  - ** ``` az group delete --name $ResourceGroupName --yes ``` ** === delete every thing associated with VM === THERE ARE NO UNDO AFTER EXECUTE THE COMMAND

## Managing Storage Accounts
Create a storage account and get the connection string 
- ``` az account set -s "MySubscription" ```
- Create resource group 
```  
resourceGroup="CliStorageTest"
location="westeurope"
storageAccount="cliclobtest"
az group create -n $resourceGroup -l $location
```
- ``` az storege account create -h ```
- ``` az storege account create  -n $storageAccount  -g $resourceGroup  -l $location --sku Standard_LRS ``` //--sku===The pricing
- ``` connectionString=`az storage account show-connection-string -n $storageAccount  -g $resourceGroup --query connectionString -o tsv` ```
- ``` echo $connectionString ```
Create blob containers, upload files and generate shared access signatures
- ``` az storage -h ```
- ``` az storage containe create -h ```
- ``` az storage containe create -n "public" --public-access blob --connection-string $connectionString ```
- Create a private blob container
``` 
export AZURE_STORAGE_CONNNECTIO_STRING=$connectionString //bash
$env:AZURE_STORAGE_CONNNECTIO_STRING=$connectionString //PowerShell
SET AZURE_STORAGE_CONNNECTIO_STRING=$connectionString //Windows
az storage container create -n "private" --public-access off
```
- create a file 
``` 
echo "Hello World" > example.txt
cat example.txt
az storage blob upload -c "public" -f "example.txt" -n "test.txt" 
```
- file url: ``` az storage blob url -c "public" -n "test.txt" -o tsv ``` => https://cliblobtest.blob.core.windows.net/public/test.txt
- Upload to a private container and set in a sub-folder 
``` 
blobName="secret/provate.txt"
az storage blob upload -c "private" -f "example.txt" -n $blobName 
az storage blob url -c "private" -n $blobName -o tsv => https://cliblobtest.blob.core.windows.net/private/secret/private.txt HTTP 404
az storage blob generate-sas -c "private" -n $blobName \
  --permissions r -o tsv \
  --expiry 2017-10-15T13:24Z => => https://cliblobtest.blob.core.windows.net/private/secret/private.txt?query HTTP 200
```
- ``` az storage blob -h ```
Create a queue, Post a message to a queue, Receive a queue message and delete a queue message 
``` 
queueName="myqueue"
az storage queue create -n $queueName

az storage message put --content "Hello from CLI" -q $queueName
az storage message put --content "Hello from CLI 2" -q $queueName

az storage message get -q $queueName --visibility-timeout 120
or
az storage message update

az storage message delete ... id and popReceipt
az storage message delete --id "..." --pop-receipt "..." -q $queueName 

az storage message get -q $queueName --visibility-timeout 120 => "Hello from CLI 2"
az storage message get -q $queueName --visibility-timeout 120 => none===[] but after 2 minutes will be visible in the queue again "Hello from CLI 2" because message was not deleted 
```
Create a table, add a row to the tabøe, query the table (az storage table) and update table rows (az storage entity)
``` 
tableName="mytable 
az storage table create -n $tableName
az storage entity insert -t $tableName -e PartitionKey="Settings" RowKey="Timeout" Value=10 Description="Timeout in seconds"
az storage entity insert -t $tableName -e PartitionKey="Settings" RowKey="MaxRetries" Value=4 Description="Maximum Retries"

az storage entity query -t $tableName

- $filter ==== https://learn.microsoft.com/en-us/rest/api/storageservices/Querying-Tables-and-Entities
az storage entity query -t $tableName --filter "PartitionKey eq 'Settings'"
az storage entity query -t $tableName --filter 'Value eq 10'

az storage entity replace -t $tableName -e PartitionKey="Settings" RowKey="MaxRetries" Value=5 Description="Maximum Retries"  
or
az storage entity merge -t $tableName -e PartitionKey="Settings" RowKey="MaxRetries" Value=6   

az storage entity show -t $tableName -e PartitionKey="Settings" --row-key="MaxRetries"
```
Create a file share, upload a file and list file share contents
```
fileShare="myshare"
az storage share create -n $fileShare --quota 2 //2GB
az storage file upload -s $fileShare --source "example.txt"
az storage file list -s $fileShare
az storage file -h
az group delete -n $resourceGroup --yes === THERE ARE NO UNDO AFTER EXECUTE THE COMMAND
 ```

## Managing Web Apps and SQL
create an app service plan (az appservice plan create) and create a web app (az webapp create)
``` 
resourceGroup="cliWebAppDemo"
location="westeurope"
az group create -n $resourceGroup -l $location
az appservice plan create -h
  --zku : The pricing tiers, e.g F1(free), D1 (Shared), B1(Basic Small), ...
planName="CliWebAppDemo"
az appservice plan create -n $planName -g $resourceGroup --sku B1
appName="pluralsightclidemo"
az webapp create -n $appName -g $resourceGroup --plan $planName
az webapp show -n $appName -g $resourceGroup --query "defaultHostName" => pluralsightclidemo.azurewebsites.net
```
Deploy from GitHub (az webapp deployment source config), Sync changes (az webapp deployment source sync)
```
gitrepo="https://github.com/markheath/azure-cli-snippets"
az webapp deployment source config -n $appName -g $resourceGroup \
  --repo-url $gitrepo --branch master --manual-integration 

az webapp deployment source sync -n $appName -g $resourceGroup
```
Create a SQl Server (az sql server create) and Create a SQL database (az sql db create) === to steps
``` 
sqlServerName="pluralsightclidemo"
sqlServerUsername="mheath"
sqlServerPassword='<blabla>'
az sql server create -n $sqlServerName -g $resourceGroup \
  -l $location -u $sqlServerUsername -p $sqlServerPassword

databaseName="SnippetsDatabase"
az sql db list-editions -l $location -o table
az sql db create -g $resourceGroup -s $sqlServerName -n $databaseName \
  --service-objective Basic 
```
Configure SQl Server firewall (az sql server firewall-rule create) and Update Web App settings (az webapp config connection-string set) 
```
az webapp show -n $appName -g $resourceGroup --query "outboundIpAddressses" -o tsv
az sql server firewall-rule create -g $resourceGroup -s $sqlServerName \
  -n AllowWebApp1 --start-ip-address 0.0.0.0 --end-ip-address 0.0.0.0
connectionString=`az storage account show-connection-string -n $storageAccount  -g $resourceGroup --query connectionString -o tsv`
echo $connectionString
az webapp config connection-string set \
  -n $appName -g $resourceGroup \
  --settings "SnippetsContext=$connectionString" \
  --connection-string-type SQLAzure
  
https://pluralsightclidemo.azurewebsites.net/migrate === for populate database
```
backup database === Export SQL database as .bacpac (az sql db export) and Import .bacpac to a new database (az sql db import)
```
storageAccount="assetswe"
storageResourceGroup=2SharedAssests"
storageConnectionString=`az storage account show-connection-string -n $storageAccount  -g $storageResourceGroup --query connectionString -o tsv`
 
storageKey=`echo $storageConnectionString | grep -oP "Accountkey=+K.+"`
backupFileName="backup-$now.bacpac"
az sql db export -s $sqlServerName -n $databaseName -g $resourceGroup \
  -u $sqlServerUsername -p$sqlServerPassword \
  --storage-key-type StoraheAccessKey --storage-key $storageKey \
  --storage-uri "https://$storageAccount.blob.core.windowns.net/bacpacs/$backupFileName"
 
databaseName2="SnippetsDatabase2" 
az sql db create -g $resourceGroup -s $sqlServerName -n $databaseName2 \
  --service-objective Basic  
az sql db import -s $sqlServerName -n $databaseName2 -g $resourceGroup \
  -u $sqlServerUsername -p$sqlServerPassword \
  --storage-key-type StoraheAccessKey --storage-key $storageKey \
  --storage-uri "https://$storageAccount.blob.core.windowns.net/bacpacs/$backupFileName"
connectionString2=`az storage account show-connection-string -n $storageAccount  -g $resourceGroup --query connectionString -o tsv`
az webapp config connection-string set \
  -n $appName -g $resourceGroup \
  --settings "SnippetsContext=$connectionString2" \
  --connection-string-type SQLAzure 
```

## Deploying Resources with ARM, [Azure Quickstart Templates](https://github.com/azure/azure-quickstart-templates)
Create an ARM template (az group deployment create)
- [Docker Wordpress MySQL](https://github.com/Azure/azure-quickstart-templates/tree/master/application-workloads/wordpress/docker-wordpress-mysql)
```
resourceGroup="armtest"
location="westeurope"
az group create -l $location -n $resourceGroup 
templateuri=https://github.com/Azure/azure-quickstart-templates/tree/master/application-workloads/wordpress/docker-wordpress-/azuredeploy.json
az group deployment create \
  --name TestDeployment \
  --resource-group $resourceGroup \
  --template-uri $templateUri \
  -- parameters 'newStorageAccountName=<blabka>' \
                'newsqlPassword=<blabla>' \
                'adminUsername=<blabla>' \
                'adminPassword=<blabla>' \
                'dnsNameForPublicIP=<mypublicip72>' 
```
- ``` az resource list -g $resourceGroup -o table ```
- ``` az network public-ip list -g $resourceGroup  --query "[0].dnsSettings.fqdn" -o tsv ``` => mypublicip72.westeurope.cloudapp.azure.com
Generate an SRM template (az group export) and Creating templates (Azure portal and Visual Studio)
``` 
az group export -n CliWebAppDemo
or inside Azure portal in "Automation script"
or in Visual Studio from 2017 (old) via Azure Tool installed
```
deploy a local custom ARM template (az group dployment create), MySite.json - project from VS 
``` 
resourceGroup="templatedeploytest"
az group create -n $resourceGroup -l westeurope
deploymentName="MyDeployment"
sqlPassword=<password>
az group deployment create -g $resourceGroup -n $deploymentName \
  --template-file MySite.json \
  --parameters @MySite.parameters.json \
  -- parameters "administratorLoginPassword=$sqlPassword"
```
- ``` az webapp list -g $resourceGroup --query "[].defaultHostName" -o tsv"``` => websitep7imolzztzydq.azurewebsites.net 
Deploy an update template version (add an additional web app), MySiteV2.json - project from VS and incremental kan only create new resources === it is not allowed to delete for save reasons
```
az group deployment create -g $resourceGroup -n $deploymentName \
  --template-file MySiteV2.json \
  --parameters @MySite.parameters.json \
  -- parameters "administratorLoginPassword=$sqlPassword"
  --mode Incremental
```
- ``` az webapp list -g $resourceGroup --query "[].defaultHostName" -o tsv"``` => websitep7imolzztzydq.azurewebsites.net and website2p7imolzztzydq.azurewebsites.net
Revert to original template (delete the addicional web app), complete : do not allow deleted any resource when completed used by MySite.json project in VS but MySiteV2.json will be deleted
``` 
az group deployment create -g $resourceGroup -n $deploymentName \
  --template-file MySite.json \
  --parameters @MySite.parameters.json \
  -- parameters "administratorLoginPassword=$sqlPassword"
  --mode Complete
```
Creating ARM Templates
1. az group export
2. Create automation script in Azure Portal
3. Visual Studio tooling === Azure tool!
4. Azure Quickstart templates

## Automating with Service
Using a Service Principal
1. Application identity (az ad app create)
```
appName="ServicePrincipalDemo1"
az ad app create \
  --display-name $appName \
  --homepage "http://localhost/$appName" \
  --identifier-uris "http://localhost/$appName"
```
2. Service principal (az ad sp create-for-rbac)
```
appId=$(az ad app list --display-name $appName --query [].appId -o tsv) 
az ad sp create-for-rbac --name $appId --password $spPassword
```
3. Permissions (az role assignment)
```
servicePrincipalAppId=$(az ad sp list --display-name $appId --query "[].appId" -o tsv)
az role assignment list --assignee $servicePrincipalAppId

roleId=$(az role assigment list --assignee $servicePrincipalAppId --query "[].id" -o tsv)
az role assigmnet delete --ids $roleId

resourceGroup="MyVmDemo"
subscriptionId=$(az account show --query id -o tsv)
az role assigment create --assignee $servicePrincipalAppId \
  --role "contributor" \
  --scope "/subscriptions/$subscriptionId/resourceGroups/$resourceGroup
  
tenantId=$(az account show --query tenantId -o tsv)  
az logout

az login --service-principal -u $servicePrincipalAppId
  --password $spPassword --tenant $tenentId
  
az group list -o table
az group create -n NotAllowed -l westeurope => does not hva authorization to perform action
```
4. Log in (az login --service-principal)
```



```
- ``` ```
- ``` ```
- ``` ```