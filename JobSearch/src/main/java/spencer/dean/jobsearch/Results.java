package spencer.dean.jobsearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Results {

    private WebDriver driver;
    private String baseUrl;
    private String pageUrl = Pages.HOME.url();

    @FindBy(css=".row .twelve.columns h1")
    private WebElement header;

    Results(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(baseUrl + pageUrl);
    }

    public WebElement getHeader() {
        return header;
    }
}