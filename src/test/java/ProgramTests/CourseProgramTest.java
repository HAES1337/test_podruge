package ProgramTests;
import mainTest.AbstractBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.assertj.core.api.SoftAssertions;


import java.time.Duration;

public class CourseProgramTest extends AbstractBaseTest {
    private final SoftAssertions softly = new SoftAssertions();

    @Test
    public void CourseAddDeleteProgramTest() throws InterruptedException {
        driver.navigate().to("http://develop.podruge.d1.3dev.tech/login/index.php");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Система дистанционного обучения сети клиник «Подружки»: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Система дистанционного обучения сети клиник «Подружки»: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
        loginPage.login("admin","MMca01yx!");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/my/courses.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Мои курсы"));
//        Переход в администрирование
        WebElement adminBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        WebElement coursesBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Курсы')]]"));
        coursesBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkcourses"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
//       переход в хб Траектории
        WebElement departments = driver.findElement(By.xpath("//*[text()[contains(.,'Траектории обучения')]]"));
        departments.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/program/programslist.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Траектории обучения"));
//       добавление траектории
        WebElement programAddBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root_app']/div/div/div/div/button")));
        programAddBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programInput = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/form[@class='py-2 w-100']/div/div/input")));
        programInput.click();
        programInput.sendKeys("Автотестовая траектория");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement progamSave = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div/button[contains(text(),'Сохранить')]")));
        progamSave.click();
        driver.navigate().refresh();
//        Заходим на траеткорию
        WebElement testProgram = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Автотестовая траектория']")));
        testProgram.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softly.assertThat(driver.getTitle()).isEqualTo("Траектории обучения:Автотестовая траектория:Курсы");
        WebElement courseAddBtn = driver.findElement(By.xpath("//button[text()='Добавить']"));
        courseAddBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement addForm = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
        addForm.click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseFirst = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li[1]")));
        courseFirst.click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        addForm.click();
//        Логика для двойного клика
//        Actions action = new Actions(driver);
//        WebElement formAdd = driver.findElement(By.xpath("//form[@id='addForm']/div/div/div/input"));
//        action.doubleClick(formAdd).perform();
        Thread.sleep(1000);
        WebElement courseSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li[2]")));
        courseSecond.click();
        Thread.sleep(1000);
        WebElement submitBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@form='addForm']")));
        submitBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteAllCourses = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[text()='Название курса'] /../th/span/input")));
        deleteAllCourses.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteBtn = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Удалить']")));
        deleteBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitDeleteBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/div/div/button")));
        submitDeleteBtn.click();
        Thread.sleep(2000);
//        Убеждаемся, что курсы удалены
        WebElement coursesDoNotExist = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Этой траектории еще не назначены курсы']")));
        coursesDoNotExist.getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        Переход  в список траекторий
        WebElement programsList = driver.findElement(By.xpath("//a[text()='Траектории обучения']"));
        programsList.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Траектории обучения");


//       удаление Траектории
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteCheckbox = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Автотестовая траектория']/../../td/span/input")));
        deleteCheckbox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteProgram = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header-group__buttons']/button[2]")));
        deleteProgram.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteProgramSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='dialog']/div[2]/div/button")));
        deleteProgramSubmit.click();


    }

}