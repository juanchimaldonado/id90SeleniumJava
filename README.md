# Test Automation Framework

This project implements an automated testing framework using **Java**, **Gradle**, **Selenium WebDriver**, **TestNG**, **Cucumber**, and **Allure Reports**, following the **Page Object Model (POM)** pattern.

---

## ✅ Features

- Modular architecture with Page Objects
- BDD with Gherkin + Cucumber
- TestNG execution
- Environment configuration via `.properties`
- Automatic Allure report generation
- Screenshot capture on failure for debugging

---

## ⚙️ Requirements

Make sure you have the following installed:

- Java 17+
- Gradle 8+
- Chrome (or another WebDriver-compatible browser)
- Git

---

## 📦 Project Structure

```
src/
├── test/
│   ├── java/
│   │   ├── runner/                   # TestNG runner class
│   │   ├── steps/                    # Step definitions
│   │   │   └── Hooks.java            # Hooks for setup, teardown, screenshots
│   │   ├── pages/                    # Page Object classes
│   │   └── utils/                    # DriverManager, ConfigReader, etc.
│   │
│   └── resources/
│       ├── config/                   # Environment configs (qa.properties, prod.properties, etc.)
│       ├── features/                 # .feature files
│       └── testng.xml                # Suite for TestNG execution
```

---

## 📥 Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/your-user/your-repo.git
cd your-repo
```

### 2. Install dependencies

```bash
./gradlew clean build
```

### 3. Run the tests

We use a custom Gradle task called `runCucumberTest` to ensure TestNG and Cucumber run correctly.

```bash
./gradlew clean runCucumberTest
```

### 4. Generate and open the report

```bash
./gradlew allureReport
./gradlew allureServe
```

This will open the report in your default browser.

---

## 🎯 Run a Specific Scenario by Tag

To run a single scenario or a group of scenarios by tag, use the following command:

```bash
./gradlew runCucumberTest -Dcucumber.filter.tags="@TC01"
```

---

## 🖼️ Automatic Screenshots on Failure

If a scenario fails, a screenshot is captured and attached to the Allure report automatically:

```java
@After
public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
            .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Screenshot on failure");
    }
    DriverManager.quitDriver();
}
```

> You’ll find the screenshot inside the failed scenario’s details in the Allure report.

---

## 👨‍💻 Author

**Juan Ignacio Maldonado**  
Automation QA Engineer  
📧 juanchimaldonado93@gmail.com
🔗 [LinkedIn](https://linkedin.com/in/tu-perfil)