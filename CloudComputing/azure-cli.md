# Azure CLI
- [Azure Command-Line Interface (CLI) documentation](https://learn.microsoft.com/en-us/cli/azure/)

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

## Cloud Shell
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- ``` ```
- 
- 
- 