package spencer.dean.jobsearch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class JobSearchTest {

    private WebDriver driver;
    private String baseUrl;

    @BeforeTest
    public void setup() {
        baseUrl = Environments.CWJOBS.url();
        driver = Drivers.FIREFOX.newInstance();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    @Test
    public void headerIsDisplayed()  throws Exception {
        Home home = new Home(driver, baseUrl);
        home.load();
        Assert.assertTrue(home.getPageHeader().isDisplayed());
    }

    @Test
    public void searchModuleIsDisplayed() throws Exception {
        Home home = new Home(driver, baseUrl);
        home.load();
        Assert.assertTrue(home.getSearchModule().isDisplayed());
    }

    @Test
    public void salarySelectHasDailyRateOption() throws Exception {
        Home home = new Home(driver, baseUrl);
        home.load();
        Assert.assertTrue(home.selectContainsOption(home.getSearchSalaryType(), "Daily rate"));
    }

    @Test
    public void jobsFromCompaniesIsNotZero() throws Exception {
        Home home = new Home(driver, baseUrl);
        home.load();
        int jobs = Integer.parseInt(home.getJobsFromCompanies().getText());
        Assert.assertTrue(jobs > 0);
        System.out.println("Jobs from companies = " + jobs);
    }

    @Test
    public void submitSearchForManagerManchesterWithAnnualSalaryAtLeastTwelveThousandPermanentDirectEmployers() throws Exception {
        Home home = new Home(driver, baseUrl);
        home.load();
        home.getSearchKeywords().sendKeys("manager");
        home.getSearchLocation().sendKeys("Manchester");
        home.getSearchSalaryType().selectByVisibleText("Annual salary");
        home.getSearchSalaryRate().selectByVisibleText("at least £12,000.00");
        home.getSearchJobType().selectByVisibleText("Permanent");
        home.getSearchDirectEmployer().click();
        Results results = home.submitSearch();
        Assert.assertTrue(results.getHeader().getText().equals("Job results"));
        Assert.assertTrue(results.getPagingTwoLink().getAttribute("href").equals("javascript:__doPostBack('srpPager','2')"));
        Assert.assertTrue(driver.getPageSource().contains("SITECATALYST CODE"));
    }
}