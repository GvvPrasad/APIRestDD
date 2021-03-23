# APIRestDD

#### Description
This Project is made for testing Rest API
Made with Maven, Selenium, Java, TestNG, RestAssured

#### Project Structure
```
  Root
    ├── src/main/java
    │	├── init
    │	│	└── ObjectRepository
    │	└── Utilities
    │	│	└── Excel  	
    ├── src/test/java    
    │	├── Methods
    │	├── Payloads
    ├── src/test/resources
    │	└── Test Data Files
    └── testNG.xml
```

#### Package's Details
|Package Names|Description           							                                                                                   |
|:------------|:-----------------------------------------------------------------------------------------------------------------------------------|
|Base		  | It consists of Base class file where we initiate Browser and its Desired Capabilities, initiate of Reports and closing Browser     |
|Common		  |	It consists of several common methods which can be used across entire application like wait, screenshot, scroll, Mouse Events etc  |
|Config		  |	It consists of ObjectRepository, here we define all the variable and properties file to access ".properties" file		           |
|Listeners	  |	It consists of TestNG Listeners and RetryAnalyzer		                                                                           |
|Utilities	  |	It consists of Utilities of Excel files, Reports and Email 		                                                                   |
|Links		  |	It consists of class file for checking the all the links and for 404Errors and other domain		                                   |
|Locators     |	It consists of locators for each web page in separate class file 		                                                           |
|TestScripts  |	It consists of test scripts files as class files                		                                                           |
