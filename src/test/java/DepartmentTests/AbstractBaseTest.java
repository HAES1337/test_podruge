package DepartmentTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class AbstractBaseTest {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @BeforeMethod(alwaysRun = true)
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
//        driver.close();
    }
}
