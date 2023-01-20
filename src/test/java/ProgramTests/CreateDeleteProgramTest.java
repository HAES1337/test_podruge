package ProgramTests;
import mainTest.AbstractBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.assertj.core.api.SoftAssertions;
import java.time.Duration;

public class CreateDeleteProgramTest extends AbstractBaseTest {
    private final SoftAssertions softly = new SoftAssertions();

   @Test
    public void CreateDeleteProgramTest() {
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
