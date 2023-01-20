package mainTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainTest.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class AbstractBaseTest {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected LoginPage loginPage;


    @BeforeMethod(alwaysRun = true)
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
//        driver.close();
    }
}
