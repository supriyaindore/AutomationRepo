package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestUtil;

import java.util.ArrayList;
import java.util.List;

public class HomePage{

    @FindBy(xpath = "//a[text()='Welcome to Lead Management System']")
    WebElement homeTitle;

    @FindBy(tagName = "a")
    List<WebElement> listWebElement;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String homeTitles(){
         return homeTitle.getText();
    }

    public void urlListExample(){
        System.out.println(listWebElement.size());
        List<String> urlLink = new ArrayList<>();
        for (WebElement e : listWebElement){
            String url = e.getAttribute("href");
            urlLink.add(url);
//            TestUtil.checkBrokenLink(url);
        }
        urlLink.parallelStream().forEach(e->TestUtil.checkBrokenLink(e));
    }
}
