package PurposeTests;
import mainTest.AbstractBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.assertj.core.api.SoftAssertions;
import java.time.Duration;


public class CreateDeletePurposeTest extends AbstractBaseTest {
    private final SoftAssertions softly = new SoftAssertions();

    @Test
    public void CreatePurposeTest() throws InterruptedException {
        driver.navigate().to("http://develop.podruge.d1.3dev.tech/login/index.php");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Система дистанционного обучения сети клиник «Подружки»: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Система дистанционного обучения сети клиник «Подружки»: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
        loginPage.login("admin","MMca01yx!");
//        переход в Администрирование
        WebElement adminBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        WebElement usersBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Пользователи')]]"));
        usersBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkusers"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
//        Переход в смешанные назначения
        WebElement purposes = driver.findElement(By.xpath("//*[text()[contains(.,'Смешанные назначения')]]"));
        purposes.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/purpose/purposeslist.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Смешанные назначения"));
//        Новое назначение
        WebElement newPurpose = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@ class='header-group__buttons']/button/a")));
        newPurpose.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softly.assertThat(driver.getTitle()).isEqualTo("Смешанные назначения:Создание");
        WebElement namePurpose = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fitem_id_name']/div[2]/input")));
        namePurpose.click();
        namePurpose.sendKeys("Автотест-назначение");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement newUser = driver.findElement(By.xpath("//div[@id='fitem_id_userid']/div[2]/div[3]/span"));
        newUser.click();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement userList = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fitem_id_userid']/div[2]/ul/li[4]")));
        userList.isDisplayed();
        userList.click();
        Thread.sleep(2000 );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement focusField = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='d-md-inline-block mr-md-2 position-relative']/input")));
        focusField.click();
        Thread.sleep(2000);

//        Actions action = new Actions(driver);
//        action.keyTAB(Keys.TAB).perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitBtn = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit'][1]")));
        submitBtn.click();
//        Удаление назначения
        WebElement checkbox = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Автотест-назначение']/../../td/span/input")));
        checkbox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitDelete = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@ class='header-group__buttons']/button[2]")));
        submitDelete.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitDeleteOneMore = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@form='addForm']")));
        submitDeleteOneMore.click();





    }
}
