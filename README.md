<h1 align="center"> Selenium Java Automation Framework</h1>

<p align="center">
A robust & scalable test automation framework built using <b>Selenium WebDriver, Java, TestNG & Maven</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Programing Language-Java-blue" />
  <img src="https://img.shields.io/badge/Build Tool-Maven-orange" />
  <img src="https://img.shields.io/badge/Test Framework-TestNG-brightgreen" />
  <img src="https://img.shields.io/badge/Testing Report-ExtentReport-red" />
  <img src="https://img.shields.io/badge/Browser-Chrome-success" />
</p>

---

## Table of Contents
- [ Project Overview](#project-overview)
- [ Tech Stack / Tools](#tech-stack--tools)
- [ Project Structure](#project-structure)
- [ Prerequisites](#prerequisites)
- [ Installation & Setup](#installation--setup)
- [ Configuration Details](#configuration-details)
- [ Test Execution](#test-execution)
- [ Key Features](#key-features)
- [ Contributing](#contributing)
- [ Contact](#contact)

---

## Project Overview
This is a **Selenium Java Test Automation Framework** designed to automate UI testing effectively.  
It follows the **Page Object Model (POM)** architecture enabling better code reusability and maintenance.  
The framework integrates advanced reporting (Extent Reports), detailed logs, and configurable test execution.

---

## Tech Stack / Tools
| Category | Technology |
|---------|------------|
| Language | Java 17 |
| Automation | Selenium WebDriver |
| Test Framework | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model (POM) |
| Reporting | Extent Reports |
| Browser Supported | Chrome |
| Version Control | Git & GitHub |

---

## Project Structure
```text
AutomationExerciseFramework
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── autoExercise.PageObjects     # Page Object Model classes
│   │   │   └── autoExercise.Utilities       # Base setup, Config Reader, Extent Reports setup
│   │   └── resources
│   │       └── log4j2.xml                   # Logging configuration
│
├── src
│   └── test
│       └── java
│           └── autoExercise.TestCases       # Test Scripts (TestNG)
│
├── Reports                                  # Extent HTML Reports
├── ScreenShots                              # Captured screenshots on failures
├── logs                                     # Application/Test logs
├── testng.xml                               # Test Suite configuration
├── pom.xml                                  # Maven Dependencies
└── README.md                                # Project Documentation
```
---
## Prerequisites
Before running the framework, ensure the following are installed:

- Java 17
- Maven 3.8+
- Chrome browser (latest version recommended)
- ChromeDriver matching the Chrome version
- Git (optional, for cloning the repo)

---

## Installation & Setup

1. Clone the repository
   ```bash
   git clone https://github.com/rushikeshbhivate43/Selenium-Java-Automation-Framework.git
   
2. Navigate to the project directory:
cd Selenium-Java-Automation-Framework

3. Install dependencies using Maven
mvn clean install

4. Configure config.properties in:
   src/main/resources/config.properties
   
  Example Values:
- baseUrl=https://automationexercise.com/
- browser=chrome
- implicitWait=10

---

## Configuration Details
| Property          | Description                  | Example                         |
| ----------------- | ---------------------------- | ------------------------------- |
|   baseUrl         | Base URL of the application  | https://automationexercise.com/ |
|   browser         | Browser to run tests on      | chrome                          |
|   implicitWait    | Implicit wait in seconds     | 10                              |

---

## Test Execution
Run all tests via Maven:
- mvn test

Run specific TestNG suite:
- mvn test -DsuiteXmlFile=testng.xml

Run tests from IDE:
- Right-click on testng.xml > Run as > TestNG Suite

---

## Key Features

- Selenium automation with Java
- TestNG for structured testing & assertions
- Page Object Model for clean and reusable code
- Captures screenshots on test failure (ScreenShots/)
- Detailed logging with Log4j2 (logs/ folder)
- Extent Reports for test execution results (Reports/ folder)
- Centralized WebDriver & Config management in Utilities
- Scalable folder structure for future enhancement

---

## Contributing

Contributions are welcome! Follow these steps:
- Create a new branch (git checkout -b feature/your-feature)
- Make your changes & commit (git commit -m "Add new feature")
- Push to branch (git push origin feature/your-feature)
- Open a Pull Request

---

## Contact
- GitHub: rushikeshbhivate43
- Email: rushikeshbhivate111@gmail.com
