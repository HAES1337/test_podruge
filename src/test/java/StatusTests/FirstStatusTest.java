package StatusTests;
import mainTest.AbstractBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.assertj.core.api.SoftAssertions;
import java.time.Duration;


public class FirstStatusTest extends AbstractBaseTest {
    private final SoftAssertions softly = new SoftAssertions();

    @Test
    public void CreateDeleteDepartmentTest() throws InterruptedException {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.navigate().to("http://develop.podruge.d1.3dev.tech/login/index.php");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Система дистанционного обучения сети клиник «Подружки»: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Система дистанционного обучения сети клиник «Подружки»: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
        loginPage.login("admin", "MMca01yx!");
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
//        Создаем подразделения
        WebElement newDepart = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@ class='header-group__buttons']")));
        newDepart.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement nameDepart = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fitem_id_name']/div/div/div/input")));
        nameDepart.isDisplayed();
        nameDepart.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//         Название родительского подразделения
        nameDepart.sendKeys("Родительское подразделение для 1 кейса");
//        WebElement adminName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='fitem_id_depmanagerid']/div[2]/div/div/div/input")));
//        adminName.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement usersList = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li")));
//        usersList.click();
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
        nameDepartSecond.sendKeys("Дочернее подразделение для 1 кейса");
//        WebElement adminNameSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='fitem_id_depmanagerid']/div[2]/div/div/div/input")));
//        adminNameSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement childDepart = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Выбрать']/../div/input")));
        childDepart.click();
        WebElement childList = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li[text()='Родительское подразделение для 1 кейса']")));
        childList.click();
//        WebElement usersListSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li")));
//        usersListSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitSecond = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'css-8981b2')]/button[contains(text(),'Подтвердить')]")));
        submitSecond.click();

//        Создаем траекторию
        adminBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        WebElement coursesBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Курсы')]]"));
        coursesBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkcourses"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
//       переход в хб Траектории
        WebElement programs = driver.findElement(By.xpath("//*[text()[contains(.,'Траектории обучения')]]"));
        programs.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/program/programslist.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Траектории обучения"));
//       Траектория
        WebElement programAddBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root_app']/div/div/div/div/button")));
        programAddBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programInput = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/form[@class='py-2 w-100']/div/div/input")));
        programInput.click();
        programInput.sendKeys("Траектория для 1 кейса");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programSave = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div/button[contains(text(),'Сохранить')]")));
        programSave.click();
        driver.navigate().refresh();
//        Переход в курсы
        adminBtn= driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        coursesBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Курсы')]]"));
        coursesBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkcourses"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        WebElement CoursesManage = driver.findElement(By.xpath("//*[text()[contains(.,'Управление курсами и категориями')]]"));
        CoursesManage.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/course/management.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Управление курсами и категориями"));
//         Создаем первый курс
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement newCourse = driver.findElement(By.xpath("//a[text()='Создать новый курс']"));
        newCourse.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_fullname']")));
        courseName.click();
        courseName.sendKeys("Курс для 1 кейса");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseShortName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_shortname']")));
        courseShortName.click();
        courseShortName.sendKeys("1 кейс");
        WebElement courseSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Сохранить и показать']")));
        courseSubmit.click();
        webDriverWait.until(ExpectedConditions.titleIs("Курс: Курс для 1 кейса"));
//        Переходим в родительское подразделение
        adminBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        usersBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Пользователи')]]"));
        usersBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkusers"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        departments = driver.findElement(By.xpath("//*[text()[contains(.,'Подразделения')]]"));
        departments.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/department/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Подразделения"));
        WebElement departName = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/a[text()='Родительское подразделение для 1 кейса']")));
        departName.click();
        webDriverWait.until(ExpectedConditions.titleIs("Родительское подразделение для 1 кейса:Сотрудники"));
        softly.assertThat(driver.getTitle()).isEqualTo("Родительское подразделение для 1 кейса:Сотрудники");
//        Добавляем сотрудника
        WebElement employeeAddBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root_app']/div/div/div/div/button")));
        employeeAddBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement employeeList = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
        employeeList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement employeeFirst = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li[text()='Вячеслав Москальчук (Не назначено) (13)']")));
        employeeFirst.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitAdd = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@type='submit']")));
        submitAdd.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
//        Переход в дочернее подразделение
        departments = driver.findElement(By.xpath("//a[text()='Подразделения']"));
        departments.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/department/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Подразделения"));
        WebElement iconDepart = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='mb-3 position-relative'][last()]/div/div/i")));
        iconDepart.click();
        departName = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/a[text()='Дочернее подразделение для 1 кейса']")));
        departName.click();
        webDriverWait.until(ExpectedConditions.titleIs("Дочернее подразделение для 1 кейса:Сотрудники"));
        softly.assertThat(driver.getTitle()).isEqualTo("Дочернее подразделение для 1 кейса:Сотрудники");
//        Добавляем второго сотрдуника
        employeeAddBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root_app']/div/div/div/div/button")));
        employeeAddBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        employeeList = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
        employeeList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        employeeFirst = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li[text()='Максим Дулепов (Не назначено) (18)']")));
        employeeFirst.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        submitAdd = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@type='submit']")));
        submitAdd.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
//        Обратно в родительское
        departments = driver.findElement(By.xpath("//a[text()='Подразделения']"));
        departments.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/department/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Подразделения"));
        departName = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/a[text()='Родительское подразделение для 1 кейса']")));
        departName.click();
        webDriverWait.until(ExpectedConditions.titleIs("Родительское подразделение для 1 кейса:Сотрудники"));
        softly.assertThat(driver.getTitle()).isEqualTo("Родительское подразделение для 1 кейса:Сотрудники");
//        Переход в траектории подразделения
        Select courses = new Select(driver.findElement(By.xpath("//select")));
        courses.selectByVisibleText("Траектории");
        softly.assertThat(driver.getTitle()).isEqualTo("Родительское подразделение для 1 кейса:Траектории");
        WebElement programAddDepartBtn = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='root_app']/div/div/div/div/button")));
        programAddDepartBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programList = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
        programList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programFirst = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li[text()='Траектория для 1 кейса']")));
        programFirst.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@form='addForm']")));
        submitBtn.click();
        Thread.sleep(3000);
        WebElement programInherit = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Назначить дочерним подразделениям']/i")));
        programInherit.click();
        WebElement inheritAdmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-8981b2']/div/button")));
        inheritAdmit.click();
        Thread.sleep(3000);
//        Переходим в траекторию, добавить курс
        adminBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        coursesBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Курсы')]]"));
        coursesBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkcourses"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        programs = driver.findElement(By.xpath("//*[text()[contains(.,'Траектории обучения')]]"));
        programs.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/program/programslist.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Траектории обучения"));
        WebElement testProgram = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Траектория для 1 кейса']")));
        testProgram.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softly.assertThat(driver.getTitle()).isEqualTo("Траектории обучения:Траектория для 1 кейса:Курсы");
        WebElement courseAddBtn = driver.findElement(By.xpath("//button[text()='Добавить']"));
        courseAddBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement addForm = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
        addForm.click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseFirst = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li[text()[contains(.,'Курс для 1 кейса')]]")));
        courseFirst.click();
        Thread.sleep(1000);
        submitBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@form='addForm']")));
        submitBtn.click();
        WebElement addedCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Курс для 1 кейса']")));

//        Переходим в курс
        adminBtn= driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        coursesBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Курсы')]]"));
        coursesBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkcourses"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        CoursesManage = driver.findElement(By.xpath("//*[text()[contains(.,'Управление курсами и категориями')]]"));
        CoursesManage.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/course/management.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Управление курсами и категориями"));
        WebElement testCourse = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Курс для 1 кейса']")));
        testCourse.click();
        WebElement courseInfo = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Зачисленные на курс пользователи']")));
        courseInfo.click();
        webDriverWait.until(ExpectedConditions.titleIs("1 кейс: Участники"));
//        Проверяем статусы
        WebElement childEmployee = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Максим Дулепов']/../../../tr[2]/td[6]/div/span[text()='Активно']")));
        WebElement parentEmployee = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Вячеслав Москальчук']/../../../tr[2]/td[6]/div/span[text()='Активно']")));
//        Переходим обратно в родительское подразделение
        adminBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        usersBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Пользователи')]]"));
        usersBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkusers"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        departments = driver.findElement(By.xpath("//*[text()[contains(.,'Подразделения')]]"));
        departments.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/department/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Подразделения"));
        departName = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/a[text()='Родительское подразделение для 1 кейса']")));
        departName.click();
        webDriverWait.until(ExpectedConditions.titleIs("Родительское подразделение для 1 кейса:Сотрудники"));
        softly.assertThat(driver.getTitle()).isEqualTo("Родительское подразделение для 1 кейса:Сотрудники");
        courses = new Select(driver.findElement(By.xpath("//select")));
        courses.selectByVisibleText("Траектории");
        softly.assertThat(driver.getTitle()).isEqualTo("Родительское подразделение для 1 кейса:Траектории");
        programInherit = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Снять назначение для дочерних подразделений']/i")));
        programInherit.click();
        inheritAdmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-8981b2']/div/button")));
        inheritAdmit.click();
        Thread.sleep(3000);
//        Переходим обратно в курс
        adminBtn= driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        coursesBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Курсы')]]"));
        coursesBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkcourses"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        CoursesManage = driver.findElement(By.xpath("//*[text()[contains(.,'Управление курсами и категориями')]]"));
        CoursesManage.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/course/management.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Управление курсами и категориями"));
        testCourse = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Курс для 1 кейса']")));
        testCourse.click();
        courseInfo = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Зачисленные на курс пользователи']")));
        courseInfo.click();
        webDriverWait.until(ExpectedConditions.titleIs("1 кейс: Участники"));
//        Проверяем статусы
        childEmployee = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-fullname='Максим Дулепов']/span[text()='Заблокировано']")));
        parentEmployee = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Вячеслав Москальчук']/../../../tr[2]/td[6]/div/span[text()='Активно']")));
//        Удаляем все
//        Курс
        adminBtn= driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        coursesBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Курсы')]]"));
        coursesBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkcourses"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        CoursesManage = driver.findElement(By.xpath("//*[text()[contains(.,'Управление курсами и категориями')]]"));
        CoursesManage.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/course/management.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Управление курсами и категориями"));
        testCourse = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Курс для 1 кейса']")));
        testCourse.click();
        WebElement deleteCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Удалить']")));
        deleteCourse.click();
        WebElement deleteCourseAdmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Удалить']")));
        deleteCourseAdmit.click();
        WebElement proverka = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Удаление 1 кейс']")));
//        Траектория
        adminBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        coursesBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Курсы')]]"));
        coursesBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkcourses"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        programs = driver.findElement(By.xpath("//*[text()[contains(.,'Траектории обучения')]]"));
        programs.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/program/programslist.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Траектории обучения"));
        WebElement deleteProgram = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Траектория для 1 кейса']/../../td[last()]/div/a[last()]")));
        deleteProgram.click();
        WebElement deleteProgramSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='dialog']/div[2]/div/button")));
        deleteProgramSubmit.click();
        Thread.sleep(3000);
//        Подразделения
        adminBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        usersBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Пользователи')]]"));
        usersBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkusers"));
        webDriverWait.until(ExpectedConditions.titleIs("СДО сети клиник «Подружки»: Управление: Поиск"));
        departments = driver.findElement(By.xpath("//*[text()[contains(.,'Подразделения')]]"));
        departments.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/department/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Подразделения"));
        WebElement deleteParent = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Родительское подразделение для 1 кейса']/../../div[last()]/div[last()]/a")));
        deleteParent.click();
        WebElement deleteAdmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'css-8981b2')]/button")));
        deleteAdmit.click();
        Thread.sleep(3000);
        WebElement deleteChild = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Дочернее подразделение для 1 кейса']/../../div[last()]/div[last()]/a")));
        deleteChild.click();
        deleteAdmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'css-8981b2')]/button")));
        deleteAdmit.click();
        Thread.sleep(3000);




    }
}