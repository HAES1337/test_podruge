package DepartmentTests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.assertj.core.api.SoftAssertions;

import java.time.Duration;

public class ChildDepartCreateDeleteTest extends  AbstractBaseTest {
    private final SoftAssertions softly = new SoftAssertions();
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

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
//        Новое подразделение
        WebElement newDepart = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@ class='header-group__buttons']")));
        newDepart.click();
        Thread.sleep(1000);
        WebElement nameDepart = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fitem_id_name']/div/div/div/input")));
        nameDepart.isDisplayed();
        nameDepart.click();
        Thread.sleep(2000);
//         Название родительского подразделения
        nameDepart.sendKeys("Родительское подразделение");
//         Здесь можно сначала ввести руководителя, а потом уже подтверждать
        WebElement submit = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'css-8981b2')]/button[contains(text(),'Подтвердить')]")));
        submit.click();
        Thread.sleep(2000);
        WebElement selectDropdown = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='editForm']/div/div[4]/div[2]/div/div/div/div")));
        selectDropdown.click();
        Thread.sleep(2000);
        new Actions(driver).keyDown(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        submit.click();
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
//        WebElement deleteDepart = driver.findElement(By.xpath("//div[@id='topofscroll']/div[2]/div/section/div/div/div/ul/li[last()]/div/div[4]/div[2]/a"));
//        deleteDepart.click();
//        WebElement confirmBtn = driver.findElement(By.xpath("//div[contains(@class,'css-8981b2')]/button"));
//        confirmBtn.click();
//        Thread.sleep(3000);
        WebElement newDepartSecond = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@ class='header-group__buttons']")));
        newDepartSecond.isDisplayed();
        newDepartSecond.click();
        Thread.sleep(1000);
        WebElement nameDepartSecond = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fitem_id_name']/div/div/div/input")));
        nameDepartSecond.isDisplayed();
        nameDepartSecond.click();
        Thread.sleep(2000);
//         Название дочернего подразделения
        nameDepartSecond.sendKeys("Дочернее подразделение");
        Thread.sleep(2000);
        WebElement submitSecond = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'css-8981b2')]/button[contains(text(),'Подтвердить')]")));
        submitSecond.click();
        WebElement selectDropdownSecond = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='editForm']/div/div[4]/div[2]/div/div/div/div")));
        selectDropdownSecond.click();
        new Actions(driver).keyDown(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        submitSecond.click();
        Thread.sleep(3000);
        WebElement deleteDepart = driver.findElement(By.xpath("//div[@id='topofscroll']/div[2]/div/section/div/div/div/ul/li[last()]/div/div[4]/div[2]/a"));
                                                                    //div[@id='topofscroll']/div[2]/div/section/div/div/div/ul/li[last()]/div/div[4]/div[2]/a
        deleteDepart.click();
        WebElement confirmBtn = driver.findElement(By.xpath("//div[contains(@class,'css-8981b2')]/button"));
        confirmBtn.click();
        Thread.sleep(3000);
        WebElement deleteDepartSecond = driver.findElement(By.xpath("//div[@id='topofscroll']/div[2]/div/section/div/div/div/ul/li[last()]/div/div[4]/div[2]/a"));
        deleteDepartSecond.click();
        WebElement confirmBtnSecond = driver.findElement(By.xpath("//div[contains(@class,'css-8981b2')]/button"));
        confirmBtnSecond.click();
        Thread.sleep(3000);

    }
}

