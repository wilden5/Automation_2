package pages;

import config.UserBuilder;
import config.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private final WebDriver driver;

    private static final By FIRSTNAME_INPUT = By.xpath("//input[@id='customer_firstname']");
    private static final By LASTNAME_INPUT = By.xpath("//input[@id='customer_lastname']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@id='passwd']");
    private static final By ADDRESS_INPUT = By.xpath("//input[@id='address1']");
    private static final By CITY_INPUT = By.xpath("//input[@id='city']");
    private static final By ZIPCODE_INPUT = By.xpath("//input[@id='postcode']");
    private static final By MOBILE_PHONE = By.xpath("//input[@id='phone_mobile']");
    private static final By STATE_DROPDOWN = By.xpath("//select[@id='id_state']");
    private static final By REGISTER_BUTTON = By.xpath("//button[@id='submitAccount']");

    public RegistrationPage() {
        this.driver = WebDriverSingleton.getInstance().getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(REGISTER_BUTTON));
    }

    public MyAccountPage continueRegistration(UserBuilder user) {
        driver.findElement(FIRSTNAME_INPUT).sendKeys(user.getFirstName());
        driver.findElement(LASTNAME_INPUT).sendKeys(user.getLastName());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(ADDRESS_INPUT).sendKeys(user.getAddress());
        driver.findElement(CITY_INPUT).sendKeys(user.getCity());
        driver.findElement(ZIPCODE_INPUT).sendKeys(user.getZipcode());
        driver.findElement(MOBILE_PHONE).sendKeys(user.getMobile());

        driver.findElement(STATE_DROPDOWN).click();
        new Select(driver.findElement(STATE_DROPDOWN)).selectByVisibleText(user.getState());
        driver.findElement(REGISTER_BUTTON).click();
        return new MyAccountPage();
    }
}
