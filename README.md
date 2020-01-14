# bpdtsTechnicalTest
# AUTOMATION-PRACTICE-WEBSITE
* This is a sample implementation of functional test using Cucumber and Selenium framework.
* POM has been used along with BDD gherkin style.
* This practice project is dynamic and a good blueprint to build on for tests based on BDD as well as UI testing.
* Framework is ready to be commited in GitLab and Jenkins for continues integration and to run against a pipline
* This POM framework structure can be easly enhanced and applied to small or large project includingn API and performace testing.

## Framework used
* Cucumber
* POM

## Current capability
* Browser based tests
  * Selenium
  * headless mode - optional
  * Cucumber Reporting dependencies have been added and failed, passed aswell as test screenshots will be taken onced linked with Jenkins cucumber reporting

## Utilities classes: There are some reusable utility classes, listed below added to help quick delivery.
  * WebDriverHandler
  * EnvironmentHandler
  * Backgroud added to scenarios to reduce steps and making it more clear to business when reading BDD
 
## Running tests
#### Prerequisites
As there are no login username/password or linked to a database, there are currently no prerequisites for this framework.

* Run individual tests such as RunAllCucumberTests.java or RunWipTestOnly.java.
* By default it will run against `dev` environment. 
* Local environment is added under env file if needed.

#### running from maven
* `mvn clean test -Denvironment=dev` runs all cucumber scenarios against Dev environment.

#### running for a particular set of scenarios
1. Tag the scenario by an unique annotation such as `@test. Tagging can be applied at feature level or at scenario level.
2. To run scenarios with tag `@test` use `mvn clean test -Dcucumber.options="--tags @test"`
3. To run scenarios with tag `@wip` use `mvn clean test -Dcucumber.options="--tags @wip"`

### Do's
* Keep one to one mapping of Page Object
* Implement all steps for multiple pages in a single file.
* Do remove the redundant code /configuration ASAP.
* Use Background on BDD scenarios to make it dynamic
* When possible create a new BDD step but use existing steps to reduce duplication

### Files
A PDF copy of BPDTS technical test instruction has been added to files 
* /Users/enis.kraja/Desktop/techAutomation/src/test/resources/files/

### Don'ts
*Don't separate the step definitions into relevant files.

### To Doo
* Link project with Jenkins to generate cucumber style report
* Link with Jenkins to run automation in a pipeline
* Create a GitLab repo for continues integration
