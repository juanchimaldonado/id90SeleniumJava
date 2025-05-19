package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:build/reports/html-report.html",
                "json:build/reports/cucumber-report.json"
        },
        monochrome = true
)
@Test
public class TestRunner extends AbstractTestNGCucumberTests {
}


