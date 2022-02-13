package pages;

import config.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private WebDriver driver;

    public MyAccountPage() {
        this.driver = WebDriverSingleton.getInstance().getDriver();
    }
}
