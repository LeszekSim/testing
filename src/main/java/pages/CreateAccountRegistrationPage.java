package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountRegistrationPage {

    private WebDriver driver;

    public CreateAccountRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement createAnAccountHeader;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private WebElement nameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id="passwd")
    private WebElement passwordInput;

    @FindBy(id="days")
    private WebElement dayOfBirthList;

    @FindBy(id="months")
    private WebElement monthOfBirthList;

    @FindBy(id="years")
    private WebElement yearOfBirthList;

    @FindBy(id="address1")
    private WebElement addressInput;

    @FindBy(id="city")
    private WebElement cityInput;

    @FindBy(id="id_state")
    private WebElement stateList;

    @FindBy(id="postcode")
    private WebElement zipCodeInput;

    @FindBy(id="phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(id="alias")
    private WebElement addressAliasInput;

    @FindBy(id="company")
    private WebElement companyInput;

    @FindBy(id="address2")
    private WebElement secondAddressLineInput;

    @FindBy(id="other")
    private WebElement additionalInformationInput;

    @FindBy(id="phone")
    private WebElement homePhoneInput;

    @FindBy(id = "id_country")
    private WebElement countryList;

    @FindBy(id="submitAccount")
    private WebElement registerBtn;



    public WebDriverWait waitFor() {
        return new WebDriverWait(driver, 6);

    }

    public CreateAccountRegistrationPage selectGender(GenderSelect genderSelect) {
        waitFor().until(ExpectedConditions.visibilityOf(createAnAccountHeader));
        By filterLocator = By.cssSelector(String.format("#uniform-id_gender%s", genderSelect.toString()));
        WebElement selectingGenderButton = driver.findElement(filterLocator);
        selectingGenderButton.click();
        return this;
    }

    public CreateAccountRegistrationPage fillNameData(String name, String surname) {
        nameInput.clear();
        nameInput.sendKeys(name);
        lastNameInput.clear();
        lastNameInput.sendKeys(surname);
        return this;
    }

    public CreateAccountRegistrationPage setPassword(String pswd) {
        passwordInput.sendKeys(pswd);
        return this;
    }

    public CreateAccountRegistrationPage selectDateOfBirth(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        Select selectDay = new Select(dayOfBirthList);
        selectDay.selectByValue(dayOfBirth);
        Select selectMonth = new Select(monthOfBirthList);
        selectMonth.selectByValue(monthOfBirth);
        Select selectYear = new Select(yearOfBirthList);
        selectYear.selectByValue(yearOfBirth);
        return this;
    }

    public CreateAccountRegistrationPage selectAddress(String address, String city, String state, String postalCode) {
        addressInput.clear();
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        Select selectState = new Select(stateList);
        selectState.selectByValue(state);
        zipCodeInput.clear();
        zipCodeInput.sendKeys(postalCode);
        return this;
    }

    public CreateAccountRegistrationPage selectCountry(String country) {
        Select selectCountry  = new Select(countryList);
        selectCountry.selectByValue(country);
        return this;
    }

    public CreateAccountRegistrationPage selectMobilePhone(String mobilePhoneNumber) {
        mobilePhoneInput.clear();
        mobilePhoneInput.sendKeys(mobilePhoneNumber);
        return this;
    }

    public CreateAccountRegistrationPage selectAlias(String addressAlias) {
        addressAliasInput.clear();
        addressAliasInput.sendKeys(addressAlias);
        return this;
    }

    public MyAccountPage clickRegister() {
        registerBtn.click();
        return new MyAccountPage(driver);
    }


}
