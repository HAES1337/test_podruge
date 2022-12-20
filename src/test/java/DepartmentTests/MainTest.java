package DepartmentTests;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class MainTest extends AbstractBaseTest {


    private final SoftAssertions softly = new SoftAssertions();


    @Test
    public void testPodruge() {
//          Переход на подружек
        driver.navigate().to("http://develop.podruge.d1.3dev.tech/login/index.php");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Podruge Develop: Вход на сайт");
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
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/my/"));
        webDriverWait.until(ExpectedConditions.titleIs("Личный кабинет"));
//         переход в Администрирование
        WebElement adminBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));
//         переход в хб Пользователи
        WebElement usersBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Пользователи')]]"));
        usersBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkusers"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));
//         переход в Список пользователей
        WebElement usersListBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Список пользователей')]]"));
        usersListBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/user.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Пользователи: Учетные записи: Список пользователей"));
//         работа по фильтру
        WebElement usersFilter = driver.findElement(By.xpath("//*[text()[contains(.,'Показать больше ...')]]"));
        usersFilter.click();
        WebElement usersFilterEmail = driver.findElement(By.id("id_email"));
        usersFilterEmail.click();
        usersFilterEmail.sendKeys("tool_generator_000543@example.com");
        WebElement usersFilterBtn = driver.findElement(By.id("id_addfilter"));
        usersFilterBtn.click();
//           вытаскиваем ФИО из списка
        WebElement userName = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/a"));
        String name = userName.getText();
        System.out.println("ФИО в списке: " + userName.getText() + ".");
//         заходим в Профиль пользователя
        userName.click();
        WebElement userProfileName = driver.findElement(By.xpath("//div[@class='col-md-4']//h3"));
        System.out.println("ФИО в профиле: " + userProfileName.getText() + ".");
//         сравниваем ФИО в списке и в профиле
        softly.assertThat(userProfileName.getText()).isEqualTo(name);
        System.out.println("Данные совпадают.");
        softly.assertAll();
    }


}

