package spencer.dean.jobsearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public enum Drivers {

    FIREFOX(FirefoxDriver.class),
    HTML_UNIT(HtmlUnitDriver.class);

    private Class<? extends WebDriver> d;

    private Drivers (Class<? extends WebDriver> d) { this.d = d; }

    public WebDriver newInstance() { 
        WebDriver driver = null;
        try {
            driver = d.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return driver;
    }
}