## Framework and Tools :

- Designed the framework using Selenium, TestNG and Page Object Model and Maven as bulld tool.
- Used RestAssured library to automate the Rest Weather API

##How to run the Project ?
- Extract the Project into your local machine (import as existing maven projects)
- In Base Class, please change the Chrome Driver path (set your local chrome driver path)
- Open POM.xml and save it (refresh)
- Open TestNG.xml and run as TestNG suite
- In Config.properties file (Inside Configuration folder), we can config multiple things like Variance for Weather entities and also the city name

##Approach/Steps :
- Created Maven project and given all the required dependencies
- TestNG.xml is there where the Test Suite details are written
- Created Page object classes to have all the webelements and actions for pages
- Implemented base class to have the starting setup which can be used in multiple test cases of the same suite
- Performed the actions step by step as per the requirement given
- Have written utility class to read the common strings from properties file
- Written utility class to get response from API, converting temperature etc.
- Created COMPARE class to validate the differences between different entities of Weather class on the basis of Variance given in config file

##Test Case :
- There is one Test Case in which the 3 entities of Weather (Wind, Humidity and Temperature) have been validated and the assertion is true only if all the 3 differences are falling under the configured variance.

