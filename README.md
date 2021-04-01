# Introduction #
A demo showing how to access DynamoDB using spring-data-dynamodb.  
It contains CRUD for a simple data structure consisting of User and Company.
It also configures DynamoDB parameters for different environments - dev and prod.

# Getting Started #
## Step 1: Setting Up DynamoDB Locally ##
1. Download DynamoDB:  
https://s3.ap-southeast-1.amazonaws.com/dynamodb-local-singapore/dynamodb_local_latest.zip

2. Unzip the file to a directory of your choice.

3. Open a command terminal, navigate to the directory where you extracted DynamoDBLocal.jar, and enter the following command:
	```
	java -jar DynamoDBLocal.jar -sharedDb
	```
	The screen should print:
	```
	Port:   8000
	InMemory:       false
	DbPath: null
	SharedDb:       true
	shouldDelayTransientStatuses:   false
	CorsParams:     *
	```
	Now a DynamoDB server is running locally on port 8000. You can browse http://localhost:8000/shell/ to see a build-in DynamoDB Web Shell.

4. We are using -sharedDb option. Use -help to see other options, such as run db on another port:
	```
	java -jar DynamoDBLocal.jar -help
	```
	See https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html for details.
## Step 2: Launching Spring Boot Application ##
Open this project in IDE. Wait for initialisation. Then bootRun. The application runs locally on localhost:8080.

## Step 3: Managing DynamoDB with NoSQL Workbench ##
You can use AWS NoSQL Workbench to manage DynamoDB. 
1. Download here: https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/workbench.settingup.html
2. Install and run. In 'Operation builder', click on 'Add connection'.
3. Select 'DynamoDB local' tag. Click on 'Connect'.
4. A local database is added to the 'Active connections' list. Open it, then you can do some operations.
