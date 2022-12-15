package DepartmentTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.assertj.core.api.SoftAssertions;

import java.security.Key;
import java.time.Duration;

public class EmployeeDepartTest extends AbstractBaseTest {
    private final SoftAssertions softly = new SoftAssertions();

    @Test
    public void EmployeeDepartmentTest () throws InterruptedException {
//        Переход на подружек
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://develop.podruge.d1.3dev.tech/login/index.php");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Podruge Develop: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
//        Авторизация
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement nameDepart = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fitem_id_name']/div/div/div/input")));
        nameDepart.isDisplayed();
        nameDepart.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//         Название родительского подразделения
        nameDepart.sendKeys("Тестовое подразделение");
//         Здесь можно сначала ввести руководителя, а потом уже подтверждать
        WebElement submit = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'css-8981b2')]/button[contains(text(),'Подтвердить')]")));
        submit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement selectDropdown = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='editForm']/div/div[4]/div[2]/div/div/div/div")));
        selectDropdown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        new Actions(driver).keyDown(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        submit.click();
        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement departName = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Тестовое подразделение']")));
                //div[@id='region-main-box']/section/div/div/div/ul/li[last()]/div/div
        departName.click();
        webDriverWait.until(ExpectedConditions.titleIs("Тестовое подразделение:Сотрудники"));
        softly.assertThat(driver.getTitle()).isEqualTo("Тестовое подразделение:Сотрудники");
//        Добавление нового сотрудника
        WebElement employeeAddBtn = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='root_app']/div/div/div/div/button")));
        employeeAddBtn.click();
        Thread.sleep(600);
        WebElement employeeList = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
        employeeList.click();
        Thread.sleep(4000);
        Actions employee =  new Actions(driver);
        Action seriesOfActions = employee
                .keyDown(Keys.ARROW_DOWN).pause(2000).sendKeys(Keys.ENTER).build();
        seriesOfActions.perform();
        WebElement submitAdd = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@type='submit']")));
        submitAdd.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        WebElement employeeDelete = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Удалить']")));
        employeeDelete.click();
        Thread.sleep(1000);
        WebElement submitDelete = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/div/button")));
        submitDelete.click();
        Thread.sleep(1000);
        employeeAddBtn.click();
        Thread.sleep(1000);
        WebElement employeeListSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
        employeeListSecond.click();
        Thread.sleep(4000);
        Actions employeeSecond =  new Actions(driver);
        Action seriesOfActionsSecond = employeeSecond
                .keyDown(Keys.ARROW_DOWN).pause(2000).sendKeys(Keys.ENTER).build();
        seriesOfActionsSecond.perform();
        WebElement submitAddSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@type='submit']")));
        submitAddSecond.click();
        WebElement checkBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/table/thead/tr/th/span")));
        checkBox.click();
        WebElement checkBoxDelete = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root_app']/div/div/div/div[2]/button[3]")));
        checkBoxDelete.click();
        WebElement checkBoxDeleteSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='dialog']/div[2]/button[1]")));
        checkBoxDeleteSubmit.click();
        Thread.sleep(4000);
        WebElement departList = driver.findElement(By.xpath("//a[text()='Подразделения']"));
        departList.click();
        WebElement deleteDepart = driver.findElement(By.xpath("//div[@id='topofscroll']/div[2]/div/section/div/div/div/ul/li[last()]/div/div[4]/div[2]/a"));
        deleteDepart.click();
        WebElement confirmBtn = driver.findElement(By.xpath("//div[contains(@class,'css-8981b2')]/button"));
        confirmBtn.click();



    }
}
