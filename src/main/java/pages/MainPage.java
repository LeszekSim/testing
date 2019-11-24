package pages;

import commons.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "login")
    private WebElement loginBtn;



    public WebDriverWait waitFor() {
        return new WebDriverWait(driver, 6);

    }

    public MainPage getMainPage() {
        driver.get(ReadProperties.getValue("URL"));

        return this;
    }

    public AuthenticationPage signIn() {

        waitFor().until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
        return new AuthenticationPage(driver);
    }










}
