package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class EmailGenerator {

    private WebDriver driver;

    public EmailGenerator(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="button[class='btn-rds icon-btn bg-theme click-to-copy copyIconGreenBtn']")
    private WebElement copyEmailBtn;
    @FindBy(id = "click-to-refresh")
    private WebElement refreshBtn;
    @FindBy(css = "input[id='mail']")
    private WebElement emailInput;

    public WebDriverWait waitFor() {
        return  new WebDriverWait(driver, 15);
    }

    public String getNewEmail() throws IOException, UnsupportedFlavorException {

        driver.get("https://temp-mail.org/");
        waitFor().until(ExpectedConditions.elementToBeClickable(refreshBtn)).click();
        waitFor().until(ExpectedConditions.attributeContains(emailInput, "value","@"));
        copyEmailBtn.click();
        String copiedEmail=(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        System.out.println(copiedEmail);

        return copiedEmail;
    }




}
