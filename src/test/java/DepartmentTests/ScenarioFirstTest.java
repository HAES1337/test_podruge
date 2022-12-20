package DepartmentTests;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScenarioFirstTest extends AbstractBaseTest {
    private final SoftAssertions softly = new SoftAssertions();

    @Test
    public void CourseDepartmentTest () throws InterruptedException {
//        Переход на подружек
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://develop.podruge.d1.3dev.tech/login/index.php");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Podruge Develop: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
////        Авторизация
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
//         Название подразделения
        nameDepart.sendKeys("Сценарий-Тест");
        WebElement adminName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='fitem_id_depmanagerid']/div[2]/div/div/div/input")));
        adminName.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement usersList = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li")));
        usersList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submit = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'css-8981b2')]/button[contains(text(),'Подтвердить')]")));
        submit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Переход в подразделение
        WebElement departName = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='mb-3 position-relative'][last()]/div/div/a")));
        departName.click();
        webDriverWait.until(ExpectedConditions.titleIs("Сценарий-Тест:Сотрудники"));
        softly.assertThat(driver.getTitle()).isEqualTo("Сценарий-Тест:Сотрудники");
        Thread.sleep(2000);
//        Добавляем сотрудника
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement employeeAddBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root_app']/div/div/div/div/button")));
//        employeeAddBtn.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement employeeList = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
//        employeeList.click();
//        employeeList.sendKeys("Hanna Александр Schulz");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement employeeFirst = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li")));
//        employeeFirst.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement submitAdd = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@type='submit']")));
//        submitAdd.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Переходим на управляющего
        WebElement dropDownProfile = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Меню пользователя']")));
        dropDownProfile.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement logoutBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='carousel-item-main']/a[last()]")));
        logoutBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Podruge Develop: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
//        WebElement loginFormSecond = driver.findElement(By.id("username"));
//        loginFormSecond.click();
//        loginFormSecond.clear();
//        loginFormSecond.sendKeys("lelal25862");
//        WebElement passwordFormSecond = driver.findElement(By.id("password"));
//        passwordFormSecond.click();
//        passwordFormSecond.clear();
//        passwordFormSecond.sendKeys("MMca01yx!");
//        WebElement loginBtnSecond = driver.findElement(By.id("loginbtn"));
//        loginBtnSecond.click();
        loginPage.login("lelal25862","MMca01yx!");
        driver.navigate().to("http://develop.podruge.d1.3dev.tech/my/");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/my/"));
        webDriverWait.until(ExpectedConditions.titleIs("Личный кабинет"));
//        Переход в управление курсами
        WebElement adminBtnSecond = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtnSecond.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));
        WebElement coursesBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Курсы')]]"));
        coursesBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkcourses"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));
        WebElement CoursesManage = driver.findElement(By.xpath("//*[text()[contains(.,'Управление курсами и категориями')]]"));
        CoursesManage.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/course/management.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Управление курсами и категориями"));
//        Создаем первый курс
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement newCourse = driver.findElement(By.xpath("//a[text()='Создать новый курс']"));
        newCourse.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_fullname']")));
        courseName.click();
        courseName.sendKeys("Сценарий Первый Курс");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseShortName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_shortname']")));
        courseShortName.click();
        courseShortName.sendKeys("СТ-1");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseDescription = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='id_summary_editoreditable']")));
        courseDescription.click();
        courseDescription.sendKeys("Курс для проверки Автотеста");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Сохранить и показать']")));
        courseSubmit.click();
        webDriverWait.until(ExpectedConditions.titleIs("Курс: Сценарий Первый Курс"));


//        Добавляем участников курса
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement members = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Участники')]")));
        members.click();
        webDriverWait.until(ExpectedConditions.titleIs("СТ-1: Участники"));


        //        Студент
//        WebElement usersEnrollment = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Зачисление пользователей на курс'][1]")));
//        usersEnrollment.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement usersSearch = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/div[@data-region='wrapper']/div/form/div/input[@type='submit'")));
//        usersSearch.click();
//        usersSearch.sendKeys("Hanna Schulz");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement userStudent = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role='listbox']/li[@data-value='215']")));
//        userStudent.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement userSpan = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-value='215']")));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement userStudentSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-region='footer']/button[2]")));
//        userStudentSubmit.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


//        Учитель
        WebElement usersEnrollmentSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div[@data-region='wrapper']/div/form/div/input[@type='submit']")));
        usersEnrollmentSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement usersSearchSecond = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Найти']")));
        usersSearchSecond.click();
        usersSearchSecond.sendKeys("Michael Smith");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement userTeacher = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@role='listbox']/li[@data-value='1069']")));
        userTeacher.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement userSpan2 = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-value='1069']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select courseRole = new Select(driver.findElement(By.xpath("//select[@name='roletoassign']")));
        courseRole.selectByVisibleText("Учитель");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement userTeacherSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-region='footer']/button[2]")));
        userTeacherSubmit.click();
        driver.navigate().refresh();


//       Создаем второй курс
        driver.navigate().to("http://develop.podruge.d1.3dev.tech/course/management.php");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/course/management.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Управление курсами и категориями"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement newCourseSecond = driver.findElement(By.xpath("//a[text()='Создать новый курс']"));
        newCourseSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseNameSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_fullname']")));
        courseNameSecond.click();
        courseNameSecond.sendKeys("Сценарий Второй Курс");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseShortNameSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_shortname']")));
        courseShortNameSecond.click();
        courseShortNameSecond.sendKeys("СТ-2");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseDescriptionSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='id_summary_editoreditable']")));
        courseDescriptionSecond.click();
        courseDescriptionSecond.sendKeys("Второй курс для проверки Автотеста");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseSubmitSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Сохранить и показать']")));
        courseSubmitSecond.click();
        webDriverWait.until(ExpectedConditions.titleIs("Курс: Сценарий Второй Курс"));

//        Учитель 2
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement membersSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Участники')]")));
        membersSecond.click();
        webDriverWait.until(ExpectedConditions.titleIs("СТ-2: Участники"));
        WebElement usersEnrollmentThird = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div[@data-region='wrapper']/div/form/div/input[@type='submit']")));
        usersEnrollmentThird.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement usersSearchThird = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Найти']")));
        usersSearchThird.click();
        usersSearchThird.sendKeys("Michael Smith");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement userTeacherSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@role='listbox']/li[@data-value='1069']")));
        userTeacherSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement userSpan3 = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-value='1069']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select courseRoleSecond = new Select(driver.findElement(By.xpath("//select[@name='roletoassign']")));
        courseRoleSecond.selectByVisibleText("Учитель");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement userTeacherSubmitSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-region='footer']/button[2]")));
        userTeacherSubmitSecond.click();
        driver.navigate().refresh();
//        Переход в управление курсами
        driver.navigate().to("http://develop.podruge.d1.3dev.tech/course/management.php");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/course/management.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Управление курсами и категориями"));


//      Выходим обратно на админа создать траекторию
        WebElement dropDownProfileSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Меню пользователя']")));
        dropDownProfileSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement logoutBtnSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='carousel-item-main']/a[last()]")));
        logoutBtnSecond.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Podruge Develop: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
//        WebElement loginFormThird = driver.findElement(By.id("username"));
//        loginFormThird.click();
//        loginFormThird.clear();
//        loginFormThird.sendKeys("admin");
//        WebElement passwordFormThird = driver.findElement(By.id("password"));
//        passwordFormThird.click();
//        passwordFormThird.clear();
//        passwordFormThird.sendKeys("MMca01yx!");
//        WebElement loginBtnThird = driver.findElement(By.id("loginbtn"));
//        loginBtnThird.click();
        loginPage.login("admin","MMca01yx!");
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/my/"));
        webDriverWait.until(ExpectedConditions.titleIs("Личный кабинет"));

//        Переход в траектории
        WebElement adminBtnThird = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtnThird.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));
        WebElement coursesBtnSecond = driver.findElement(By.xpath("//*[text()[contains(.,'Курсы')]]"));
        coursesBtnSecond.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkcourses"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));
        WebElement programsManage = driver.findElement(By.xpath("//*[text()[contains(.,'Траектории обучения')]]"));
        programsManage.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/program/programslist.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Траектории обучения"));

//        Добавляем траекторию
        WebElement programAddBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root_app']/div/div/div/div/button")));
        programAddBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programInput = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div[@class='py-2 w-100']/div/div/input")));
        programInput.click();
        programInput.sendKeys("Траектория для сценария");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement progamSave = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div/button[contains(text(),'Сохранить')]")));
        progamSave.click();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement program = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Траектория для сценария'][last()]")));
        program.click();
        webDriverWait.until(ExpectedConditions.titleIs("Траектории обучения:Траектория для сценария:Курсы"));

//        Добавляем курсы траекторию
//        Первый
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programCourseAddBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header-group']/div/button[1]")));
        programCourseAddBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programCourseInput = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
        programCourseInput.click();
//        programCourseInput.sendKeys("Сценарий Первый Тест");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseList = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li[contains(text(),'Сценарий Первый Курс')]")));
        courseList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programCourseSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@form='addForm']")));
        programCourseSubmit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Сценарий Первый Курс']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        Второй
        WebElement programCourseAddBtnSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header-group']/div/button[1]")));
        programCourseAddBtnSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programCourseInputSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
        programCourseInputSecond.click();
//        programCourseInput.sendKeys("Сценарий Второй Тест");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseListSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li[contains(text(),'Сценарий Второй Курс')]")));
        courseListSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programCourseSubmitSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@form='addForm']")));
        programCourseSubmitSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Сценарий Второй Курс']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        Последовательное обучение
        WebElement sequentialLearning = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span/span/input")));
        sequentialLearning.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement sequentialLearningSave = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header-group']/div/button[3]")));
        sequentialLearningSave.click();

//        Переход в подразделения
        WebElement adminBtnFourth = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtnFourth.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));
        WebElement usersBtnSecond = driver.findElement(By.xpath("//*[text()[contains(.,'Пользователи')]]"));
        usersBtnSecond.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkusers"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));
        WebElement departmentsSecond = driver.findElement(By.xpath("//*[text()[contains(.,'Подразделения')]]"));
        departmentsSecond.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/department/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Подразделения"));
        WebElement departNameSecond = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='mb-3 position-relative'][last()]/div/div/a")));
        departNameSecond.click();
//        Добавление сотрудника
        WebElement employeeAddBtnSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root_app']/div/div/div/div/button")));
        employeeAddBtnSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement employeeListSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
        employeeListSecond.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement employee = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li[contains(text(),'Hanna Александр Schulz')]")));
        employee.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitAddEmp = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@type='submit']")));
        submitAddEmp.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Hanna Александр Schulz']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        Переход в вкладку траектории
        Select courseRoleThird = new Select(driver.findElement(By.xpath("//select")));
        courseRoleThird.selectByVisibleText("Траектории");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softly.assertThat(driver.getTitle()).isEqualTo("Сценарий-Тест:Траектории");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programDepartAddBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root_app']/div/div/div/div/button")));
        programDepartAddBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programList = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='addForm']/div/div/div/input")));
        programList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement programDepartFirst = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='presentation']/div/ul/li[contains(text(),'Траектория для сценария')]")));
        programDepartFirst.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/button[@form='addForm']")));
        submitBtn.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Траектория для сценария']")));


//        Переходим на учителя
        WebElement dropDownProfileThird = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Меню пользователя']")));
        dropDownProfileThird.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement logoutBtnThird = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='carousel-item-main']/a[last()]")));
        logoutBtnThird.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Podruge Develop: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
//        WebElement loginFormFourth = driver.findElement(By.id("username"));
//        loginFormFourth.click();
//        loginFormFourth.sendKeys("username63");
//        WebElement passwordFormFourth = driver.findElement(By.id("password"));
//        passwordFormFourth.click();
//        passwordFormFourth.sendKeys("MMca01yx!");
//        WebElement loginBtnFourth = driver.findElement(By.id("loginbtn"));
//        loginBtnFourth.click();
        loginPage.login("username63","MMca01yx!");
        softly.assertThat(driver.getTitle()).isEqualTo("Личный кабинет");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/");

//        Переходим в первый курс
        WebElement myCourses = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li/a[contains(text(),'Мои курсы')]")));
        myCourses.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Мои курсы");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/courses.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement FirstCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Сценарий Первый Курс')]/..")));
        FirstCourse.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Курс: Сценарий Первый Курс");
//        Включаем режим редактирования, добавляем элемент
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement adminMode = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form/div/div/input")));
        adminMode.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Элемент первого курса
        WebElement firstElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='section-1']/div/button")));
        firstElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement testElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/div[text()='Тест']")));
        testElement.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Редактирование Тест");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement testName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='name']")));
        testName.sendKeys("Сценарный Тест");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement collapseBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='collapseElement-12']")));
        collapseBtn.click();
        Select controlCourse = new Select(driver.findElement(By.xpath("//select[@name='completion']")));
        controlCourse.selectByVisibleText("Отображать элемент курса как выполненный при выполнении условий");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement saveElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Сохранить и показать']")));
        saveElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softly.assertThat(driver.getTitle()).isEqualTo("СТ-1: Сценарный Тест");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement elementManage = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Добавить вопрос']")));
        elementManage.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Редактирование теста: Сценарный Тест");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement addDropDown = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Добавить']")));
        addDropDown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement questionAdd = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dropdown show']/div/a[1]")));
        questionAdd.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement trueFalse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Верно/Неверно']/../input")));
        trueFalse.click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submitElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Добавить']")));
        submitElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement questionName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='name']")));
        questionName.sendKeys("Первый вопрос по сценарию");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement questionText = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='textbox'][1]")));
        questionText.sendKeys("Автотест упадет и ничего не проверит");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement questionSave = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Сохранить']")));
        questionSave.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Редактирование теста: Сценарный Тест");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Редактирование завершения первого курса
        WebElement backToFirstCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='СТ-1']")));
        backToFirstCourse.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Курс: Сценарий Первый Курс");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement navBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='secondary-navigation d-print-none moove']/div/nav/ul/li[last()]/a")));
        navBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseFirstEnd = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Завершение курса')]")));
        courseFirstEnd.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement dropDown = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='collapseElement-1']")));
        dropDown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement testCheckBox = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Тест - Сценарный Тест')]")));
        testCheckBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement saveChanges = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Сохранить']")));
        saveChanges.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Курс: Сценарий Первый Курс");





//        Переход во второй курс
        myCourses = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li/a[contains(text(),'Мои курсы')]")));
        myCourses.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Мои курсы");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/courses.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement SecondCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Сценарий Второй Курс')]/..")));
        SecondCourse.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Курс: Сценарий Второй Курс");
//              Включаем режим редактирования, добавляем элементы
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        adminMode = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form/div/div/input")));
//        adminMode.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Элемент второго курса
        firstElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='section-1']/div/button")));
        firstElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        testElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/div[text()='Тест']")));
        testElement.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Редактирование Тест");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        testName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='name']")));
        testName.sendKeys("Сценарный Тест");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        collapseBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='collapseElement-12']")));
        collapseBtn.click();
        controlCourse = new Select(driver.findElement(By.xpath("//select[@name='completion']")));
        controlCourse.selectByVisibleText("Отображать элемент курса как выполненный при выполнении условий");
        saveElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Сохранить и показать']")));
        saveElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softly.assertThat(driver.getTitle()).isEqualTo("СТ-2: Сценарный Тест");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        elementManage = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Добавить вопрос']")));
        elementManage.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Редактирование теста: Сценарный Тест");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        addDropDown = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Добавить']")));
        addDropDown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        questionAdd = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dropdown show']/div/a[1]")));
        questionAdd.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement shortAnswer = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Короткий ответ']/../input")));
        shortAnswer.click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        submitElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Добавить']")));
        submitElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        questionName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='name']")));
        questionName.sendKeys("Второй вопрос по сценарию");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        questionText = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='textbox'][1]")));
        questionText.sendKeys("Автотест упадет и ничего не проверит?");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement answerOption = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='answer[0]']")));
        answerOption.sendKeys("Все будет хорошо!");
        Select perScore = new Select(driver.findElement(By.xpath("//select[@name='fraction[0]']")));
        perScore.selectByVisibleText("100%");
        questionSave = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Сохранить']")));
        questionSave.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Редактирование теста: Сценарный Тест");

        //        Редактирование завершения первого курса
        backToFirstCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='СТ-2']")));
        backToFirstCourse.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Курс: Сценарий Первый Курс");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='secondary-navigation d-print-none moove']/div/nav/ul/li[last()]/a")));
        navBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        courseFirstEnd = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Завершение курса')]")));
        courseFirstEnd.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        dropDown = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='collapseElement-1']")));
        dropDown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        testCheckBox = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Тест - Сценарный Тест')]")));
        testCheckBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        saveChanges = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Сохранить']")));
        saveChanges.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Курс: Сценарий Второй Курс");

//        Заходим на студента
        WebElement dropDownProfileFourth = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Меню пользователя']")));
        dropDownProfileFourth.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement logoutBtnFourth = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='carousel-item-main']/a[last()]")));
        logoutBtnFourth.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Podruge Develop: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
        loginPage.login("tool_generator_000209","MMca01yx!");
        softly.assertThat(driver.getTitle()).isEqualTo("Личный кабинет");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/");
        WebElement studentCourses = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li/a[contains(text(),'Мои курсы')]")));
        studentCourses.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Мои курсы");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/courses.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement groupMenuDropDown = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='groupingdropdown']")));
        groupMenuDropDown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement allCourses = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Все курсы, кроме скрытых']")));
        allCourses.click();
        Thread.sleep(3000);



//        Проверка отображения второго курса
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement studentSecondCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Сценарий Второй Курс')]/..")));
//        WebElement studentSecondCourse = webDriverWait.until(ExpectedConditions.attributeContains(By.xpath("//span[contains(text(),'Сценарий Второй Курс')]/.."))
//        if (studentSecondCourse.isDisplayed()){
//            throw new IllegalArgumentException("Отображается второй курс");
//        }

//        public boolean isElementPresent (By.xpath("//span[contains(text(),'Сценарий Второй Курс')]/..")){
//            try {
//                driver.findElements(By.xpath("//span[contains(text(),'Сценарий Второй Курс')]/.."));
//                return true;
//            } catch (NoSuchElementException e){
//                return false;
//            }
//        }

        int t = driver.findElements(By.xpath("//span[contains(text(),'Сценарий Второй Курс')]/..")).size();
        if (t>0) {
            throw new IllegalArgumentException("Отображается второй курс");
        } else {
            System.out.println("Курсы отображаются правильно");
        }



//          Прохождение первого теста
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement studentFirstCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Сценарий Первый Курс')]/..")));
        studentFirstCourse.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Курс: Сценарий Первый Курс");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement firstCourseElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Сценарный Тест')]/..")));
        firstCourseElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement testTry = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Попытка теста']")));
        testTry.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement firstAnswer = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ablock']/div/div[2]/input")));
        firstAnswer.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement endTry = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Закончить попытку...']")));
        endTry.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement testEnd = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Отправить всё и завершить тест']")));
        testEnd.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement testEndSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Отправить всё и завершить тест']")));
        testEndSubmit.click();
//         Переход обратно в мои курсы
        studentCourses = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li/a[contains(text(),'Мои курсы')]")));
        studentCourses.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Мои курсы");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/courses.php");

//        Включение таски за админа и возвращение обратно
        dropDownProfileFourth = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Меню пользователя']")));
        dropDownProfileFourth.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logoutBtnFourth = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='carousel-item-main']/a[last()]")));
        logoutBtnFourth.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Podruge Develop: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
        loginPage.login("admin","MMca01yx!");
        softly.assertThat(driver.getTitle()).isEqualTo("Личный кабинет");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/");
        driver.navigate().to("http://develop.podruge.d1.3dev.tech/admin/tool/task/scheduledtasks.php");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/admin/tool/task/scheduledtasks.php");
        softly.assertThat(driver.getTitle()).isEqualTo("Podruge Develop: Управление: Сервер: Задачи: Планировщик задач");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement taskRun = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[27]/td[4]/div/a")));
        taskRun.click();
        WebElement taskRunSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
        taskRunSubmit.click();
        Thread.sleep(10000);
        dropDownProfileFourth = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Меню пользователя']")));
        dropDownProfileFourth.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logoutBtnFourth = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='carousel-item-main']/a[last()]")));
        logoutBtnFourth.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Podruge Develop: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
        loginPage.login("tool_generator_000209","MMca01yx!");
        softly.assertThat(driver.getTitle()).isEqualTo("Личный кабинет");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/");
        studentCourses = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li/a[contains(text(),'Мои курсы')]")));
        studentCourses.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Мои курсы");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/courses.php");
        driver.navigate().refresh();


//         Переход во второй курс
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement studentSecondCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Сценарий Второй Курс')]/..")));
        studentSecondCourse.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Курс: Сценарий Второй Курс");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        firstCourseElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Сценарный Тест')]/..")));
        firstCourseElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        testTry = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Попытка теста']")));
        testTry.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement testAnswer = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='answer']/input")));
        testAnswer.sendKeys("Все будет хорошо!");
        endTry = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Закончить попытку...']")));
        endTry.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        testEnd = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Отправить всё и завершить тест']")));
        testEnd.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        testEndSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Отправить всё и завершить тест']")));
        testEndSubmit.click();
        studentCourses = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li/a[contains(text(),'Мои курсы')]")));
        studentCourses.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Мои курсы");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/courses.php");

//        Заходим на учителя проверить отчеты
        dropDownProfileFourth = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Меню пользователя']")));
        dropDownProfileFourth.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logoutBtnFourth = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='carousel-item-main']/a[last()]")));
        logoutBtnFourth.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Podruge Develop: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
        loginPage.login("username63","MMca01yx!");
        softly.assertThat(driver.getTitle()).isEqualTo("Личный кабинет");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/");
        studentCourses = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li/a[contains(text(),'Мои курсы')]")));
        studentCourses.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Мои курсы");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/courses.php");

//        Первый курс
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        studentFirstCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Сценарий Первый Курс')]/..")));
        studentFirstCourse.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Курс: Сценарий Первый Курс");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement reports = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-key='coursereports']/a")));
        reports.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Отчеты");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement reportsCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Завершение курса']")));
        reportsCourse.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement reportStudent = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr/th/a")));
        System.out.println(reportStudent.getText()+" "+"завершила первый курс");

//        Второй курс
        studentCourses = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li/a[contains(text(),'Мои курсы')]")));
        studentCourses.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Мои курсы");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/courses.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        studentFirstCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Сценарий Второй Курс')]/..")));
        studentFirstCourse.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Курс: Сценарий Второй Курс");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        reports = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-key='coursereports']/a")));
        reports.click();
        softly.assertThat(driver.getTitle()).isEqualTo("Отчеты");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        reportsCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Завершение курса']")));
        reportsCourse.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        reportStudent = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr/th/a")));
        System.out.println(reportStudent.getText()+" "+"завершила второй курс");

//        Заходим на админа + Удаляем все созданное
//        Подразделение
        dropDownProfileFourth = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Меню пользователя']")));
        dropDownProfileFourth.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logoutBtnFourth = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='carousel-item-main']/a[last()]")));
        logoutBtnFourth.click();
        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/login/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Вход на сайт"));
        softly.assertThat(driver.getTitle()).isEqualTo("Podruge Develop: Вход на сайт");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/login/index.php");
        loginPage.login("admin","MMca01yx!");
        softly.assertThat(driver.getTitle()).isEqualTo("Личный кабинет");
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://develop.podruge.d1.3dev.tech/my/");

        adminBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtn.click();

        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));

        usersBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Пользователи')]]"));
        usersBtn.click();

        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkusers"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));

        departments = driver.findElement(By.xpath("//*[text()[contains(.,'Подразделения')]]"));
        departments.click();

        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/department/index.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Подразделения"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteDepart = driver.findElement(By.xpath("//li[@class='mb-3 position-relative'][last()]/div/div/div/a[@aria-label='Удалить']"));
        deleteDepart.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement confirmBtn = driver.findElement(By.xpath("//div[contains(@class,'css-8981b2')]/button"));
        confirmBtn.click();
        Thread.sleep(2000);
//        Траекторию
        adminBtnThird = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtnThird.click();

        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));
        coursesBtnSecond = driver.findElement(By.xpath("//*[text()[contains(.,'Курсы')]]"));
        coursesBtnSecond.click();

        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkcourses"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));

        programsManage = driver.findElement(By.xpath("//*[text()[contains(.,'Траектории обучения')]]"));
        programsManage.click();

        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/local/program/programslist.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Траектории обучения"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteCheckbox = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Траектория для сценария']/../../td/span/input")));
        deleteCheckbox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteProgram = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header-group__buttons']/button[2]")));
        deleteProgram.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteProgramSubmit = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='dialog']/div[2]/div/button")));
        deleteProgramSubmit.click();
        Thread.sleep(2000);

//        Курсы
        adminBtnSecond = driver.findElement(By.xpath("//*[text()[contains(.,'Администрирование')]]"));
        adminBtnSecond.click();

        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));

        coursesBtn = driver.findElement(By.xpath("//*[text()[contains(.,'Курсы')]]"));
        coursesBtn.click();

        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/admin/search.php#linkcourses"));
        webDriverWait.until(ExpectedConditions.titleIs("Podruge Develop: Управление: Поиск"));

        CoursesManage = driver.findElement(By.xpath("//*[text()[contains(.,'Управление курсами и категориями')]]"));
        CoursesManage.click();

        webDriverWait.until(ExpectedConditions.urlToBe("http://develop.podruge.d1.3dev.tech/course/management.php"));
        webDriverWait.until(ExpectedConditions.titleIs("Управление курсами и категориями"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement choiceCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Сценарий Первый Курс')]")));
        choiceCourse.click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='listing-actions course-detail-listing-actions']/a[4]")));
        deleteCourse.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteCourseConfirm = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-footer']/div/div/form/button")));
        deleteCourseConfirm.click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement continueBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Продолжить']")));
        continueBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        choiceCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Сценарий Второй Курс')]")));
        choiceCourse.click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        deleteCourse = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='listing-actions course-detail-listing-actions']/a[4]")));
        deleteCourse.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        deleteCourseConfirm = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-footer']/div/div/form/button")));
        deleteCourseConfirm.click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        continueBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Продолжить']")));
        continueBtn.click();


































    }


}
