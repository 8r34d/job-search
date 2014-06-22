package spencer.dean.jobsearch;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Home {

    private WebDriver driver;
    private String baseUrl;
    private String pageUrl = Pages.HOME.url();

    @FindBy(css = "div.page.page-home")
    private WebElement pageHeader;

    @FindBy(css = "span.highlight:nth-child(2)")
    private WebElement jobsFromCompanies;

    @FindBy(className = "mod-search")
    private WebElement searchModule;

    @FindBy(id = "ucJobSearchForm_txtKeywords")
    private WebElement searchKeywords;

    @FindBy(id = "ucJobSearchForm_txtLocation")
    private WebElement searchLocation;

    @FindBy(id = "ucJobSearchForm_ddlSalary_RateType")
    private WebElement searchSalaryType;

    @FindBy(id = "ucJobSearchForm_ddlSalary_Rate")
    private WebElement searchSalaryRate;

    @FindBy(id = "ucJobSearchForm_ddlContractType")
    private WebElement searchJobType;

    @FindBy(id = "ucJobSearchForm_rblCompanyType_1")
    private WebElement searchDirectEmployer;

    @FindBy(id = "ucJobSearchForm_btnSearch")
    private WebElement searchSubmit;

    Home(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(baseUrl + pageUrl);
    }

    public WebElement getPageHeader() {
        return pageHeader;
    }

    public WebElement getSearchModule() {
        return searchModule;
    }

    public WebElement getSearchKeywords() {
        return searchKeywords;
    }

    public WebElement getSearchLocation() {
        return searchLocation;
    }

    public Select getSearchSalaryType() {
        return new Select(searchSalaryType);
    }

    public Select getSearchSalaryRate() {
        return new Select(searchSalaryRate);
    }

    public Select getSearchJobType() {
        return new Select(searchJobType);
    }

    public WebElement getSearchDirectEmployer() {
        return searchDirectEmployer;
    }

    public WebElement getSearchSubmit() {
        return searchSubmit;
    }

    public Results submitSearch() {
        getSearchSubmit().click();
        return new Results(driver, baseUrl);
    }

    public Boolean selectContainsOption(Select select, String option) {
        Boolean result = false;
        List<WebElement> options = select.getOptions();
        for (WebElement e : options) {
            if (e.getText().equals(option)) {
                result = true;
            }
        }        
        return result;
    }

    public WebElement getJobsFromCompanies() {
        return jobsFromCompanies;
    }
}