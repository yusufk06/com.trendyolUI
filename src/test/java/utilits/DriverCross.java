package utilits;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
public class DriverCross {
    private DriverCross(){
    }
    public static WebDriver driver;
    public static WebDriver getDriver(String browser){

        browser = browser==null ? ConfigReader.getProperty("browser") :browser;
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        if (driver==null) {
            switch (browser){
                case "firefox" :

                    driver= new FirefoxDriver();
                    break;
                case "edge":

                    driver= new EdgeDriver();
                    break;
                case "safari" :

                    driver= new SafariDriver();
                    break;
                default:


                    driver = new ChromeDriver(ops);
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
    public static void closeDriver(){
        if (driver != null){
            driver.close();
            driver=null;
        }
    }
    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }
}













