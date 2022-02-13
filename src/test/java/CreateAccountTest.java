import com.github.javafaker.Faker;
import config.Config;
import config.UserBuilder;
import config.WebDriverSingleton;
import org.junit.Assert;
import org.junit.Test;

public class CreateAccountTest extends BaseTest {

    private UserBuilder user = new UserBuilder(
            new Faker().internet().emailAddress(),
            Config.getProperty("user.firstName"),
            Config.getProperty("user.lastName"),
            Config.getProperty("user.password"),
            Config.getProperty("user.address"),
            Config.getProperty("user.city"),
            Config.getProperty("user.zipcode"),
            Config.getProperty("user.state"),
            Config.getProperty("user.mobile"));

    @Test
    public void new_account_registration() {
        authenticationPage.startRegistration(user.getEmail()).continueRegistration(user);

        Assert.assertEquals("Url is not correct",
                Config.getProperty("db.expected.url.account"), WebDriverSingleton.getInstance().getDriver().getCurrentUrl());
    }
}