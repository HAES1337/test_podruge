package DepartmentTests;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateDeleteDepartTest extends AbstractBaseTest {
    private final SoftAssertions softly = new SoftAssertions();


    @Test
    public void CreateDeleteDepartTest() {
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
        WebElement usersBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Пользователи')]]"));
        usersBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkusers"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));
        WebElement departments = driver.findElement(By.xpath("//*[text()[contains(.,'Подразделения')]]"));
        departments.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/department/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Подразделения"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        WebElement newDepart = driver.findElement(By.xpath("//button[@ type='button']"));
        WebElement newDepart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ type='button']")));
        newDepart.click();
//        WebElement nameDepart = driver.findElement(By.id(":r7:"));
        WebElement nameDepart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ type='text']")));
        nameDepart.click();
//        Название подразделения
        nameDepart.sendKeys("Тестовое Название");
    }
}