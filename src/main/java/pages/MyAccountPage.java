package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "page-heading")
    private WebElement pageHeader;


    public WebDriverWait waitFor() {
        return  new WebDriverWait(driver, 6);

    }


    public String confirmPage() {
        return driver.getTitle();
    }


}
