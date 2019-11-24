package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage {

    private WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
    }


    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(id ="SubmitCreate")
    private WebElement AccountCreate;

    @FindBy(id = "email")
    private WebElement emailLoginInput;

    @FindBy(id = "passwd")
    private WebElement pswdInput;

    @FindBy(id = "SubmitLogin")
    private WebElement signInBtn;


    public WebDriverWait waitFor() {
        return  new WebDriverWait(driver, 6);
    }


    public CreateAccountRegistrationPage inputEmail(String email) {
        waitFor().until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
        waitFor().until(ExpectedConditions.elementToBeClickable(AccountCreate));
        AccountCreate.click();
        return new CreateAccountRegistrationPage(driver);
    }

    public MyAccountPage loginIntoAcc(String loginEmail, String loginPswd) {
        waitFor().until(ExpectedConditions.visibilityOf(emailLoginInput));
        emailLoginInput.clear();
        emailLoginInput.sendKeys(loginEmail);
        pswdInput.clear();
        pswdInput.sendKeys(loginPswd);
        signInBtn.click();

        return new MyAccountPage(driver);
    }

}
