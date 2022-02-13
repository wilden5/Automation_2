package pages;

import config.Config;
import config.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage {

    private final WebDriver driver;

    private final String AUTH_PAGE_URL = Config.getProperty("db.init.url");
    private static final By EMAIL_INPUT = By.xpath("//input[@id='email_create']");
    private static final By CREATE_ACCOUNT_BUTTON = By.xpath("//button[@id='SubmitCreate']");

    public AuthenticationPage() {
        this.driver = WebDriverSingleton.getInstance().getDriver();
        driver.get(AUTH_PAGE_URL);
    }

    public RegistrationPage startRegistration(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        return new RegistrationPage();
    }
}