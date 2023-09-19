package utilits;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver(){

    }

    // daha fazla kontrol imkani ve extends kullanmadan driver a ulasmak icin
    //webDriver objesini Driver class'inda ki static bir method ile olusturacagiz
    // Ancak getDriver () her kullanildiginda yeni bir driver olusturur
    //bunu engellemek ve kodumuzun duzgun calisamasini saglamak icin ilk kullanimda
    //driver= new ChromeDriver(); kodu calissin sonraki kullanimlarda calismasin diye bir yontem gelistirmeliyiz

    public static WebDriver driver;

    public static WebDriver getDriver() {

        String istenenBrowser=ConfigReader.getProperty("browser");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        if (driver == null) {
            switch (istenenBrowser){

                case "firefox" :

                    driver= new FirefoxDriver();
                    break;
                case "safari" :

                    driver= new SafariDriver();
                    break;
                default:

                    driver = new ChromeDriver(ops);

            }
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;

    }
        public static void closeDriver () {
           if (driver!=null){
               driver.close();
               driver=null;
           }

        }

    public static void quitDriver () {
        if (driver!=null){
            driver.quit();
            driver=null;
        }

    }
    public static WebDriver getDriver(String istenenBrowsers) {


        if (driver == null) {

            switch (istenenBrowsers) {
                case "firefox":

                    driver = new FirefoxDriver();
                    break;
                case "edge":

                    driver = new EdgeDriver();
                    break;
                case "chrome":

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        }


        return  driver;
    }


}