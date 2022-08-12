package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.TestUtil;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    //    public static WebDriver driver;
    ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config/config.properties");
            prop.load(fp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/ganesh.jadhav/Repo/MorningTehnoStudy/src/main/resources/browser/chromedriver.exe");
            driver.set(new ChromeDriver());
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/ganesh.jadhav/Repo/MorningTehnoStudy/src/main/resources/browser/geckodriver.exe");
            driver.set(new FirefoxDriver());
        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "/Users/ganesh.jadhav/Repo/MorningTehnoStudy/src/main/resources/browser/msedgedriver.exe");
            driver.set(new EdgeDriver());
        } else {
            System.out.println("please select the correct browser");
        }

        getDriver().navigate().to(prop.getProperty("url"));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICITE_WAIT));
    }

}
