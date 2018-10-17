# New Age, API testing project, readme

Project requirements
--------------------
[Java](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) could be downloaded here 

[Lombok](https://projectlombok.org/) is used for boilercode generation, corresponding IDE plugin required ( [plugin](https://plugins.jetbrains.com/plugin/6317) for Intellij IDEA)

[Maven](https://maven.apache.org/download.cgi) of the latest version required for frontend assets generation 

[Hamcrest](http://hamcrest.org/JavaHamcrest/) Matcher, to create more readeble assertion in the tests

[Allure](https://docs.qameta.io/allure/#_installing_a_commandline) Allure is used to generate HTML report for test build


Library validation
-------------
Validate is java, maven, allure is setup by command `--version`, example: 
```
mvn --version
java -- version
```

Project setup/Running the tests
-------------
Project run test by maven command, like:

```
mvn clean test
```

Report generating
-------------
Allure Report Automatically generate at {$projectPath}/target/allure-results

Report viewing
-------------

To view report run command:
```
allure serve {$projectPath}/target/allure-results
```

To install allure use this [link](https://docs.qameta.io/allure/#_installing_a_commandline)
