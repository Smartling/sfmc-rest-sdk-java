# Salesforce Marketing Cloud (ExactTarget) Java SDK
We already use [forked version](https://github.com/Smartling/FuelSDK-Java) of the official FuelSDK-Java, but it doesn't have endpoints for the new Content Builder. That was the reason to create a new SDK.

For intergation tests
gradlew.bat clean integrationTest -Dsfmc.username=<username> -Dsfmc.password=<password>