Description of Date Substractor for calculating days between 2 dates taken into account Leap year.

Plain POJO Date.java file holds complete implementation for calculating days between 2 dates.

Simple project in Spring to show how plain POJOs easily can be utilized in full RESTfull Webservice applications.
Project uses Spring Boot library to start the application that launches an embedded Tomcat servlet.
A RestController is initialized that exposes a REST endpoint resource: Date Substractor with a single GET resource:
	{HOST}/dates/substractions/{d1_year}/{d1_month}/{d1_day}/{d2_year}/{d2_month}/{d2_day}

For documenting and trying the REST API the Swagger-UI has been used.
This is for documenting REST API's.

The complete project has a footprint of 19MB. This includes all necessary dependent libraries and the static html files for the frontend part.

The Date Substractor can be tested here (Deployed on a Raspberry PI running Java 8):
http://83.94.246.179:8080/


Project Structure for Date Substractor:

Structured as a Maven project developed in IntelliJ (Commercial license)
Technologies/toolstack involved (only opensource):
Java 8 						http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html
	Java Time API (Only used in JUnit Test for correct Assertions)
	JSR-330					https://jcp.org/en/jsr/detail?id=330
JUnit 						http://junit.org/
Spring Framework 			http://projects.spring.io/spring-framework/
	Spring Boot
	Spring Boot Maven plugn
	Tomcat Webserver		http://tomcat.apache.org/
Maven 						https://maven.apache.org/
Swagger UI 					http://swagger.io/
	SpringFox				http://springfox.github.io/springfox/

Folder main:
java:
dk.mhr.
	config
		SwaggerConfig.java 				- Setting up Swagger Documentation
	controller
		DateSubstractorController.java  - REST Controller exposing the API
		ExeptionControllerAdvice.java   - Exceptionhandling for bad request
	entity
		Date.java                       - POJO that holds calculation logic
	exception
		DateException.java              - Exception for invalid dates
	service
		DateSubstractorService.java     - Business logic for Date Substractor
	ApplicationMain.java                - Main Application entrance
resources:
application.properties                  - Properties for application

Folder test.java:
dk.mhr.test
	DateSubstractorTest                 - UnitTest for Date POJO