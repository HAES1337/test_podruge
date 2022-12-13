package DepartmentTests;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.time.Duration;

public class CreateDeleteDepartTest extends AbstractBaseTest {
    private final SoftAssertions softly = new SoftAssertions();


    @Test
    public void CreateDeleteDepartmentTest() throws InterruptedException {
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
        WebElement newDepart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@ class='header-group__buttons']")));
        newDepart.click();
        Thread.sleep(1000);
        WebElement nameDepart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fitem_id_name']/div/div/div/input")));
        nameDepart.isDisplayed();
        nameDepart.click();
        Thread.sleep(2000);
//        JavascriptExecutor js1 = (JavascriptExecutor)driver;
//        js1.executeScript("arguments[0].click();", nameDepart);
//////        Название подразделения
        nameDepart.sendKeys("НАЗВАНИЕ");
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'css-8981b2')]/button[contains(text(),'Подтвердить')]")));
        submit.click();
        Thread.sleep(2000);
        WebElement selectDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='editForm']/div/div[4]/div[2]/div/div/div/div")));
        selectDropdown.click();
//        Select select = new Select(driver.findElement(By.xpath("//div[@role='presentation']")));
//        select.selectByIndex(0);
        Thread.sleep(2000);
        new Actions(driver).keyDown(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        submit.click();
        Thread.sleep(3000);
        WebElement deleteDepart = driver.findElement(By.xpath("//div[@id='topofscroll']/div[2]/div/section/div/div/div/ul/li[last()]/div/div[4]/div[2]/a"));
        deleteDepart.click();
        WebElement confirmBtn = driver.findElement(By.xpath("//div[contains(@class,'css-8981b2')]/button"));
        confirmBtn.click();
//        WebElement select = driver.findElement(By.xpath("//div[@role='presentation'][3]/div/ul/li[1]"));
//        select.click();

        //form[@id='editForm']/div/div[4]/div[2]/div/div/div/div
    }
}