# SampleTestingFramework

Selenium WebDriver framework containing tests for Login & Products page for
https://www.saucedemo.com/

## Pre requisites for running tests in command line:

- Java 8
- Maven 3.6.3
- Chrome driver. Download from https://chromedriver.chromium.org/downloads. Save chromedriver.exe in c:\webdrivers\ or
  change this path which is hard coded
  in https://github.com/OneComQAAssignment/SampleTestingFramework/blob/main/src/main/java/com/one/framework/WebDriverFactory.java

Run 'mvn clean install -DskipTests' to build the project

## Run tests

In target folder run (for Windows):

java -cp PocForOneCom-1.0-SNAPSHOT-tests.jar;PocForOneCom-1.0-SNAPSHOT.jar;libs\*
-Dwebdriver.baseUrl=https://www.saucedemo.com/ -Dwebdriver.remote=false -Dwebdriver.capabilities.browserName=chrome
org.testng.TestNG ../TestNG-XML-Suites/Login/LoginTestSuite.xml

java -cp PocForOneCom-1.0-SNAPSHOT-tests.jar;PocForOneCom-1.0-SNAPSHOT.jar;libs\*
-Dwebdriver.baseUrl=https://www.saucedemo.com/ -Dwebdriver.remote=false -Dwebdriver.capabilities.browserName=chrome
org.testng.TestNG ../TestNG-XML-Suites/Smoke/SmokeTestSuite.xml


----------------------------------------------------------------------------------------------------------------------------------------------------------------

## Postman Collection
Postman collection is available here : (/PostmanCollection)

Import the collection in Postman and use the collection runner to run the entire collection.

Scope :
All PET API endpoints
![img.png](document/img.png)

## Updated on the current project
- Fixed login tests and added more negative scenarios to LoginTestSuite.xml all are passing.
![image](https://user-images.githubusercontent.com/95953783/181794469-5ff2b8c2-d291-4a23-a87c-3a8864385679.png)

- Added sorting tests for main page.
![image](https://user-images.githubusercontent.com/95953783/181794674-c49b7089-ba53-41a1-a23e-7370c2dedf01.png)

- Added new class file and test for product to cart and checkout
![image](https://user-images.githubusercontent.com/95953783/181794759-2270ec6e-4069-453a-887c-0f2d08a360bc.png)

