package DepartmentTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.assertj.core.api.SoftAssertions;

import java.time.Duration;

public class ChildDepartCreateDeleteTest extends  AbstractBaseTest {
    private final SoftAssertions softly = new SoftAssertions();


    @Test
    public void CreateDeleteDepartmentTest() throws InterruptedException {
        driver.navigate().to("http://develop.podruge.d1.3dev.tech/login/index.php");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Система дистанционного обучения сети клиник «Подружки»: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Система дистанционного обучения сети клиник «Подружки»: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
//         Авторизация
//        WebElement loginForm = driver.findElement(By.id("username"));
//        loginForm.click();
//        loginForm.sendKeys("admin");
//        WebElement passwordForm = driver.findElement(By.id("password"));
//        passwordForm.click();
//        passwordForm.sendKeys("MMca01yx!");
//        WebElement loginBtn = driver.findElement(By.id("loginbtn"));
//        loginBtn.click();
        loginPage.login("admin","MMca01yx!");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/my/courses.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Мои курсы"));
//         переход в Администрирование
        WebElement adminBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        WebElement usersBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Пользователи')]]"));
        usersBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkusers"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
//        переход в хб Подразделения
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
        nameDepart.sendKeys("Родительское подразделение");
        WebElement adminName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='fitem_id_depmanagerid']/div[2]/div/div/div/input")));
        adminName.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement usersList= webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li")));
        usersList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submit = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'css-8981b2')]/button[contains(text(),'Подтвердить')]")));
        submit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement newDepartSecond = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@ class='header-group__buttons']")));
        newDepartSecond.isDisplayed();
        newDepartSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement nameDepartSecond = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fitem_id_name']/div/div/div/input")));
        nameDepartSecond.isDisplayed();
        nameDepartSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//         Название дочернего подразделения
        nameDepartSecond.sendKeys("Дочернее подразделение");
        WebElement adminNameSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='fitem_id_depmanagerid']/div[2]/div/div/div/input")));
        adminNameSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement usersListSecond= webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li")));
        usersListSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitSecond = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'css-8981b2')]/button[contains(text(),'Подтвердить')]")));
        submitSecond.click();
//        Удаляем первое подразделение
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteDepart = driver.findElement(By.xpath("//div[@id='topofscroll']/div[2]/div/section/div/div/div/ul/li[last()]/div/div[4]/div[2]/a"));
        deleteDepart.click();
        WebElement confirmBtn = driver.findElement(By.xpath("//div[contains(@class,'css-8981b2')]/button"));
        confirmBtn.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
//        Удаляем второе подразделение
        WebElement deleteDepartSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='topofscroll']/div[2]/div/section/div/div/div/ul/li[last()]/div/div[4]/div[2]/a")));
        deleteDepartSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement confirmBtnSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'css-8981b2')]/button")));
        confirmBtnSecond.click();


    }
}

