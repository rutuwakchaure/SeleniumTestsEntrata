# SeleniumTestsEntrata

UI Automation Testing project for [Entrata](https://www.entrata.com/) using **Selenium WebDriver**, **TestNG**, and **ExtentReports**.

---

## Project Overview

This project automates key UI flows of the Entrata website, including:
- Navigating and verifying different pages (e.g., Sign In, Affordable)
- Playing the homepage video
- Filling out the "Watch Demo" form
- Capturing screenshots on every test
- Generating interactive HTML test reports using ExtentReports

---

## Project Structure

```
SeleniumTestsEntrata/
│
├── base/                  # BaseTest class to manage WebDriver
├── pages/                 # Page Object Model (POM) classes like Home.java
├── tests/                 # TestNG test classes
├── utils/                 # Utilities (ConfigReader, ScreenshotUtil, WaitUtils, ExtentManager)
│
├── screenshots/           # Captured screenshots during test runs
├── test-output/           # Extent report output
├── config.properties      # Test configuration values
├── pom.xml                # Maven project descriptor
└── README.md              # Project documentation
```

---

## Prerequisites

- Java 11 or later
- Maven
- TestNG
- Git
- Chrome browser
- ChromeDriver (compatible with your Chrome version)

---

## How to Run the Tests

1. **Clone the project**:
   ```bash
   git clone https://github.com/rutuwakchaure/SeleniumTestsEntrata.git
   cd SeleniumTestsEntrata
   ```

2. **Update `config.properties`** file if needed (inside `resources/`):
   - Base URL
   - Form data (first name, email, etc.)

3. **Run the tests via Maven**:
   ```bash
   mvn clean test
   ```

4. **View the test report**:
   Open the file:
   ```
   test-output/ExtentReport.html
   ```

---

## Technologies Used

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **ExtentReports**
- **Apache Log4j**
- **Maven**

---

## Screenshots & Reports

- Screenshots are saved to `/screenshots` folder for each test.
- ExtentReports generate a rich HTML test report at `/test-output/ExtentReport.html`.

---

## Author

**Rutuja Wakchaure**  
[rutu.w.2000@gmail.com](mailto:rutu.w.2000@gmail.com)

---

## License

This project is for learning and demonstration purposes.