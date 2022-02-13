package config;

public class WebDriverParameter {

    private String browserName;

    public WebDriverParameter (String browserName){
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }
}
