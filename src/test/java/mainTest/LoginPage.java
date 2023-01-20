package mainTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class LoginPage {

    WebDriver webDriver;

    @FindBy(id = "username")
    private WebElement loginForm;

    @FindBy(id = "password")
    private WebElement passwordForm;

    @FindBy(id = "loginbtn")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(webDriver,this);
    }

    public void login (String login,String password) {
        loginForm.clear();
        loginForm.sendKeys(login);
        passwordForm.clear();
        passwordForm.sendKeys(password);
        loginBtn.click();
    }

}

