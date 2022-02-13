import config.WebDriverSingleton;
import org.junit.AfterClass;
import pages.AuthenticationPage;

public class BaseTest {

    AuthenticationPage authenticationPage = new AuthenticationPage();

    @AfterClass
    public static void setDownDriver() {
        WebDriverSingleton.getInstance().setDownDriver();
    }
}
