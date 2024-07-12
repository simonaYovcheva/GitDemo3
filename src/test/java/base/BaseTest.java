package base;

import core.App;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public App app;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        return driver;
    }

    @Before
    public void setup() {
        app = new App(getDriver());
    }

    @After
    public void tearDown(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
