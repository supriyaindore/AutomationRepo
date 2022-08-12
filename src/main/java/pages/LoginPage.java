package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    @FindBy(id = "txtUsername")
    WebElement username;

    @FindBy(id = "txtPassword")
    WebElement pasword;

    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement loginBtn;

    @FindBy(className = "form-control")
    List<WebElement> list;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass){
        username.sendKeys(user);
        pasword.sendKeys(pass);
        loginBtn.click();
    }

}
