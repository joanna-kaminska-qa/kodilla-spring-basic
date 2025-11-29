# kodilla-spring-basic

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.2.5-brightgreen)
![Gradle](https://img.shields.io/badge/Gradle-8-green)
![JUnit](https://img.shields.io/badge/JUnit-5.10-purple)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow)
![Status: Completed](https://img.shields.io/badge/Status-Completed-brightgreen)

This project contains exercises and homework tasks created as part of a module in the Kodilla "Automated Tester" Java course, focusing on **Spring Basics** in Java 21.

The module introduces foundations of the **Spring Framework** and **Spring Boot**, with a strong focus on:

- dependency injection
- bean creation and configuration
- bean scopes
- manual configuration with `@Bean`
- understanding how Spring manages object lifecycle

The project was developed in **IntelliJ IDEA** as part of the learning path for future **QA/Test Automation Engineers**.

---

## Description

This repository includes **Java 21 + Spring Boot 3.2.5** code demonstrating how Spring handles:

### Dependency Injection (DI)
Three DI methods implemented:
- constructor injection (recommended)
- field injection (`@Autowired`)
- setter injection

With exercises in:
- `dependency_injection/`
- `spring_dependency_injection/`

---

### Bean Management
Two ways of creating beans:

**Annotation-based beans**

Using:
- `@Component`
- `@Service`
- `@Repository`
- `@Controller`

Located in:
`spring_dependency_injection/`

**Manual configuration using @Bean**

Implemented in:
`spring_configuration/AnimalFactory.java`

---

### Bean Qualifiers
When multiple implementations exist:
- `@Primary`
- `@Qualifier`
- `@Resource(name = “…”)`

Examples found in:
`spring_dependency_injection/SimpleApplication.java`

---

### Bean Scopes
Implemented scopes:
- **singleton** (default)
- **prototype** (new instance each time)

Examples:
- `spring_scopes/Task.java`
- `spring_scopes/homework/Clock.java`

---

## Project Structure
```
kodilla-spring-basic/
├── build.gradle
├── gradlew / gradlew.bat
├── LICENSE
├── README.md
├── src/
│ ├── main/java/com/kodilla/spring/basic/
│ │ ├── Main.java
│ │ ├── SpringBasicRunner.java
│ │ ├── dependency_injection/
│ │ │ ├── MessageService.java
│ │ │ ├── EmailMessageService.java
│ │ │ ├── FacebookMessageService.java
│ │ │ ├── SkypeMessageService.java
│ │ │ ├── TextMessageService.java
│ │ │ └── homework/...
│ │ ├── spring_dependency_injection/
│ │ │ ├── SimpleApplication.java
│ │ │ ├── SkypeMessageService.java
│ │ │ ├── EmailMessageService.java
│ │ │ ├── FacebookMessageService.java
│ │ │ ├── TextMessageService.java
│ │ │ └── homework/...
│ │ ├── spring_configuration/
│ │ │ ├── Animal.java
│ │ │ ├── Dog.java
│ │ │ ├── Cat.java
│ │ │ ├── Duck.java
│ │ │ ├── AnimalFactory.java
│ │ │ └── homework/...
│ │ ├── spring_scopes/
│ │ │ ├── Task.java
│ │ │ └── homework/Clock.java
│ └── test/java/com/kodilla/spring/basic/
│ ├── dependency_injection/...
│ ├── spring_configuration/...
│ ├── spring_dependency_injection/...
│ ├── spring_scopes/...
│ └── homework tests
└── resources/application.properties
```
---

## Getting Started

### Requirements
- Java 21
- Gradle (wrapper included)
- IntelliJ IDEA
- Spring Boot 3.2.5  

### Run the Project

**Linux / macOS**

```bash
./gradlew clean build
```
**Windows**
```bash
gradlew clean build
```
---

## Build Configuration (Gradle)
```
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.2.5'
    id 'io.spring.dependency-management' version '1.1.4'
}

group = 'com.kodilla'
version = '0.0.1-SNAPSHOT'

java {
    sourceCompatibility = '21'
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

tasks.named('test') {
    useJUnitPlatform()
}
```
---

## Spring Basics Covered in This Module
### Dependency Injection
- constructor, field, setter injection 
- Message Services 
- SimpleApplication examples

### Bean Management
- annotation-based components 
- manual beans in AnimalFactory

### Bean Qualifiers
- handling multiple implementations

### Bean Scopes
- singleton 
- prototype 
- Clock homework exercise

---
## Test Suites Overview

### Dependency Injection Tests
- **SimpleApplicationTestSuite** – verifies correct injection of dependencies in `SimpleApplication`  
- **CalculatorTestSuite** – validates DI in homework calculator exercises  
- **ShippingCenterTestSuite** – tests DI for `ShippingCenter` and related services  

**Checks performed:**  
- Proper constructor, field, and setter injection  
- Correct wiring of beans  
- ApplicationContext loads without errors  

---

### Bean Configuration Tests
- **AnimalFactoryTestSuite** – validates manual bean creation using `@Bean` in `AnimalFactory`  
- **CarConfigurationTestSuite** (homework) – tests manual bean setup in car configuration exercises  

**Checks performed:**  
- Correct bean instantiation  
- Proper configuration of annotation-based and manual beans  

---

### Scope Tests
- **TaskTestSuite** – tests singleton behavior for `Task` class  
- **ClockTestSuite** – tests prototype behavior for `Clock` class  

**Checks performed:**  
- Singleton beans return the same instance each time  
- Prototype beans create a new instance per request  
- Scopes work as intended within the Spring context  

---

**All tests use:**  
- `@SpringBootTest`  
- `ApplicationContext` or `AnnotationConfigApplicationContext`  
- JUnit 5 (Jupiter) test runner  

**Purpose:**  
- Ensure correct dependency injection  
- Validate bean creation and scope behavior  
- Verify the application context loads without errors

---

### Optional Terminal Commands

- Build the project:

```bash
./gradlew build
```
- Run tests:
```bash
./gradlew test
```
- Clean the project:
```bash
./gradlew clean
```
## Authors

Created by:

**Joanna Kamińska**  
GitHub: [https://github.com/joanna-kaminska-qa](https://github.com/joanna-kaminska-qa)

---

## Version History

- **0.3** – Expanded test coverage & structural improvements (achieved >60% total test coverage)
- **0.2** – Minor improvements in structure (README added)
- **0.1** – Initial upload

---

## License

This project is licensed under the **MIT License**.  
See the LICENSE file for details.

---

## Acknowledgments
- Kodilla Automated Tester Java course  
- Spring Boot official documentation 
- Java 21 standard library 
- JUnit 5 documentation 
- Spring Framework reference guide



