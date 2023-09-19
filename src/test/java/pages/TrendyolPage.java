package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilits.Driver;

public class TrendyolPage {
    public TrendyolPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement cookieAccept;


    @FindBy(xpath = "//p[@class='link-text']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='login-button']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@class='q-input']")
    public WebElement emailLabel;

    @FindBy(xpath = "//input[@id='login-email']")
    public WebElement emailLabelSign;

    @FindBy(xpath = "//input[@class='inputtext _55r1 inputtext _1kbt inputtext _1kbt']")
    public WebElement emailLabelFacebook;

    @FindBy(xpath = "(//input[@class='inputtext _55r1 inputtext _1kbt inputtext _1kbt'])[2]")
    public WebElement passwordLabelFacebook;

    @FindBy(xpath = "//li[@class='tab-link active']")
    public WebElement categoryMan;

    @FindBy(xpath = "//a[@href='/erkek-ceket-x-g2-c1030']")
    public WebElement jacket;

    @FindBy(xpath = "//div[@class='fltrs-wrppr hide-fltrs']")
    public WebElement brandLabel;

}

