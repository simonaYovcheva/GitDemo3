package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report"},
        features = "src/test/resources/userLogin.feature",
        tags = "@loginTest"
)
public class RunCukesTest extends AbstractTestNGCucumberTests {
}
