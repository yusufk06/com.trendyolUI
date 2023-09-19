package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilits.ConfigReader;
import utilits.Driver;
import utilits.ReusableMethods;
import utilits.TestBaseRapor;

public class BrowserTest extends TestBaseRapor {

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                {"chrome"},
                {"firefox"},
                {"edge"}
        };
    }

    public WebDriver driver;

    @Test(dataProvider = "testData",groups = "demo")

    public void accessWithAllofBrowsersTest(String browser) {

        extentTest = extentReports.createTest("Access test to Trendyol Home Page from different browsers",
                "Trendyol Home Page should be accessible via firefox, chrome, edge.");

        //Open the browser with Chrome , Firefox and Edge
        //"https://trendyol.com/" is written to the URL and clicked.
        Driver.getDriver(browser).get(ConfigReader.getProperty("trendyolpage"));
        extentTest.info("Trendyol Home Page has been logged in");

        ReusableMethods.bekle(2);
        //Verify that the title of the page is "Contains Trendyol"
        String expectedTitle="Trendyol";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        extentTest.pass(" Trendyol Home Page title verified");


        //Close the page
        Driver.closeDriver();

    }
}
