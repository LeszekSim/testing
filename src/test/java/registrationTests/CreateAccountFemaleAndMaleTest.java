package registrationTests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import commons.BrowserFactory;
import commons.EmailGenerator;
import commons.ReadProperties;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.GenderSelect;
import pages.MainPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

@RunWith(DataProviderRunner.class)
public class CreateAccountFemaleAndMaleTest {

    private WebDriver driver;
    private String copiedEmail;
    private final String landingPage = "My account - My Store";

    @Before
    public void startPage () {
        driver = BrowserFactory.initialize();
        EmailGenerator eg= new EmailGenerator(driver);
        try {
            copiedEmail = eg.getNewEmail();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        }
        driver.get(ReadProperties.getValue("URL"));
    }

    @Test
    @UseDataProvider("createAccountData")
    public void createAnAccountFemaleAndMale(GenderSelect genderSelect, String name, String surname, String pswd, String address, String city, String state,
                                String postalCode, String mobilePhone, String addressAllias) {

        MainPage mp = new MainPage(driver);
        Assert.assertEquals(landingPage, mp.getMainPage()
                .signIn().inputEmail(copiedEmail)
                .selectGender(GenderSelect.Male)
                .fillNameData(name, surname)
                .setPassword(pswd)
                .selectAddress(address, city, state,postalCode)
                .selectMobilePhone(mobilePhone)
                .selectAlias(addressAllias)
                .clickRegister()
                .confirmPage());

    }

    @After
    public void quit() {
        driver.quit();
    }

    @DataProvider
    public static Object[][] createAccountData() {
        return new Object[][]{
                {GenderSelect.Female, ReadProperties.getValue("Name"), ReadProperties.getValue("Surname"),
                        ReadProperties.getValue("Password"), ReadProperties.getValue("Address"),
                        ReadProperties.getValue("City"), "4", ReadProperties.getValue("PostalCode"),
                        ReadProperties.getValue("MobilePhone"), ReadProperties.getValue("AddressAlias")},
                {GenderSelect.Male, "john", "johnson", "test2", "1st street", "NewSomething", "4",
                        "11111", "001001001", "def"}
        };
    }
}
