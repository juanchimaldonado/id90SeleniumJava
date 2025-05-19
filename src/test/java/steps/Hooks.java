package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.initializeDriver();
        String env = System.getProperty("env", "qa");
        ConfigReader.load(env);
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot on failure");
        }
        DriverManager.quitDriver();
    }
}

