import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainTest {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private final SoftAssertions softly = new SoftAssertions();

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void testPodruge() {
//          Переход на подружек
        driver.navigate().to("http://develop.podruge.d1.3dev.tech/login/index.php");
         webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
         webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Podruge Develop: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
//         Авторизация
        WebElement loginForm = driver.findElement(By.id("username"));
        loginForm.click();
        loginForm.sendKeys("admin");
        WebElement passwordForm = driver.findElement(By.id("password"));
        passwordForm.click();
        passwordForm.sendKeys("MMca01yx!");
        WebElement loginBtn = driver.findElement(By.id("loginbtn"));
        loginBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/my/"));
        webDriverWait.until(ExpectedConditions.titleIs("Личный кабинет"));
//         переход в Администрирование
        WebElement adminBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));
//         переход в хб Пользователи
        WebElement usersBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Пользователи')]]"));
        usersBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkusers"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));
//         переход в Список пользователей
        WebElement usersListBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Список пользователей')]]"));
        usersListBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/user.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Пользователи: Учетные записи: Список пользователей"));
//         работа по фильтру
        WebElement usersFilter = driver.findElement(By.xpath("//*[text()[contains(.,'Показать больше ...')]]"));
        usersFilter.click();
        WebElement usersFilterEmail = driver.findElement(By.id("id_email"));
        usersFilterEmail.click();
        usersFilterEmail.sendKeys("tool_generator_000543@example.com");
        WebElement usersFilterBtn = driver.findElement(By.id("id_addfilter"));
        usersFilterBtn.click();
//           вытаскиваем ФИО из списка
        WebElement userName = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/a"));
        String name = userName.getText();
        System.out.println("ФИО в списке: " + userName.getText() + ".");
//         заходим в Профиль пользователя
        userName.click();
        WebElement userProfileName = driver.findElement(By.xpath("//div[@class='col-md-4']//h3"));
        System.out.println("ФИО в профиле: " + userProfileName.getText() + ".");
//         сравниваем ФИО в списке и в профиле
        softly.assertThat(userProfileName.getText()).isEqualTo(name);
        System.out.println("Данные совпадают.");
        softly.assertAll();
    }


    @AfterMethod(alwaysRun = true)
    public void after() {
        driver.close();
    }


}

