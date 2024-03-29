package DepartmentTests;

import mainTest.AbstractBaseTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class CourseDepartTest extends AbstractBaseTest {
    private final SoftAssertions softly = new SoftAssertions();


    @Test
    public void CourseDepartmentTest ()  {
//        Переход на подружек
        driver.navigate().to("http://develop.podruge.d1.3dev.tech/login/index.php");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Система дистанционного обучения сети клиник «Подружки»: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Система дистанционного обучения сети клиник «Подружки»: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
//        Авторизация
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
//         Название подразделения
        nameDepart.sendKeys("Курс-Тест");
        WebElement adminName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='fitem_id_depmanagerid']/div[2]/div/div/div/input")));
        adminName.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement usersList= webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li")));
        usersList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submit = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'css-8981b2')]/button[contains(text(),'Подтвердить')]")));
        submit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Переход в подразделение
        WebElement departName = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='mb-3 position-relative'][last()]/div/div/a")));
        //a[text()='Курс-Тест']
        departName.click();
        webDriverWait.until(ExpectedConditions.titleIs("Курс-Тест:Сотрудники"));
        softly.assertThat(driver.getTitle()).isEqualTo("Курс-Тест:Сотрудники");
//        Переход в вкладку курсы
        Select courses = new Select(driver.findElement(By.xpath("//select")));
        courses.selectByVisibleText("Курсы");
        webDriverWait.until(ExpectedConditions.titleIs("Курс-Тест:Курсы"));
        softly.assertThat(driver.getTitle()).isEqualTo("Курс-Тест:Курсы");
//        Добавление первого курса
        WebElement courseAddBtn = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='root_app']/div/div/div/div/button")));
        courseAddBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseList = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
        courseList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseFirst = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li")));
        courseFirst.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@form='addForm']")));
        submitBtn.click();
//      Удаление первого курса
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label='Удалить']")));
        deleteBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='dialog']/div/div/button[1]")));
        deleteSubmit.click();
//        НАДО УБРАТЬ ПОСЛЕ ФИКСА
        driver.navigate().refresh();
//        Добавляем второй курс
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseAddBtnSecond = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='root_app']/div/div/div/div/button")));
        courseAddBtnSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseListSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
        courseListSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li")));
        courseSecond.click();
//        Thread.sleep(2000);
//        seriesOfActions.perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitBtnSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@form='addForm']")));
        submitBtnSecond.click();
//        Удаляем второй курс
        WebElement checkBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/table/thead/tr/th/span")));
        checkBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement checkBoxDelete = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root_app']/div/div/div/div[2]/button[3]")));
        checkBoxDelete.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement checkBoxDeleteSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='dialog']/div/div/button[1]")));
        checkBoxDeleteSubmit.click();
//        Удаление подразделения
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement departList = driver.findElement(By.xpath("//a[text()='Подразделения']"));
        departList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteDepart = driver.findElement(By.xpath("//div[@id='topofscroll']/div[2]/div/section/div/div/div/ul/li[last()]/div/div[4]/div[2]/a"));
        deleteDepart.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement confirmBtn = driver.findElement(By.xpath("//div[contains(@class,'css-8981b2')]/button"));
        confirmBtn.click();





    }
}
