package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {

    private WebDriver driver;
    private static WebDriverSingleton webDriverSingleton;
    private WebDriverParameter parameter;

    private WebDriverSingleton() {
        parameter = new WebDriverParameter("Chrome");
        setLocalDriver();
    }

    private void setLocalDriver() {
        switch (parameter.getBrowserName()) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        setDriverConfig();
    }

    public static WebDriverSingleton getInstance() {
        if (webDriverSingleton == null) {
            webDriverSingleton = new WebDriverSingleton();
        }
        return webDriverSingleton;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriverConfig() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void setDownDriver() {
        if (webDriverSingleton != null) {
            driver.close();
            webDriverSingleton = null;
        }
    }
}