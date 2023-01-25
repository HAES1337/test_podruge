package PurposeTests;
import mainTest.AbstractBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.assertj.core.api.SoftAssertions;
import java.time.Duration;


public class CoursePurposeTest extends AbstractBaseTest {
    private final SoftAssertions softly = new SoftAssertions();

    @Test
    public void CoursesPurposeTest() throws InterruptedException {
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
        driver.navigate().refresh();
//        Переход в назначение
        WebElement testPupose = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Автотест-назначение']")));
        testPupose.click();
        webDriverWait.until(ExpectedConditions.titleIs("Смешанные назначения:Автотест-назначение:Настройки"));
//        Переход в курсы и добавление курсов
        Select coursePurpose = new Select(driver.findElement(By.xpath("//select[@name='jump']")));
        coursePurpose.selectByVisibleText("Курсы");
        webDriverWait.until(ExpectedConditions.titleIs("Смешанные назначения:Автотест-назначение:Курсы"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement addCourseBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Назначить']")));
        addCourseBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@role='combobox']")));
        courseName.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement firstCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li[1]")));
        firstCourse.click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        courseName.click();
        Thread.sleep(1000);
        WebElement secondCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li[2]")));
        secondCourse.click();
        Thread.sleep(1000);
        WebElement submitBtnCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='dialog']/div[2]/div/button")));
        submitBtnCourse.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Удаление курсов
        WebElement deleteBox = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/thead/tr/th/span/input")));
        deleteBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteBtn = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Удалить']")));
        deleteBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitDeleteBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/div/div/button")));
        submitDeleteBtn.click();
        Thread.sleep(2000);
//        После фикса убрать Ф5
        driver.navigate().refresh();
        Thread.sleep(2000);
//        После фикса убрать Ф5
//        Убеждаемся, что курсы удалены после фикса поменять текст!!!
        WebElement coursesDoNotExist = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root_app']/div/div")));
        String noCourses = coursesDoNotExist.getText();
//        System.out.println(noCourses);
        Assert.assertTrue(noCourses.contains("Для данного смешанного назначения курсы ещё не заданы"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Переход в список назначений
        WebElement programsList = driver.findElement(By.xpath("//a[text()='Смешанные назначения']"));
        programsList.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Смешанные назначения");


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