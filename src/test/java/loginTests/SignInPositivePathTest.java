package loginTests;

import commons.BrowserFactory;
import commons.ReadProperties;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static org.junit.Assert.assertEquals;

public class SignInPositivePathTest {

    private WebDriver driver;
    private final String landingPage = "My account - My Store";

    @Before
    public void startPage() {
        driver = BrowserFactory.initialize();
    }

    @Test
    public void signInPositivePath() {
        MainPage mp = new MainPage(driver);
        assertEquals(landingPage, mp.getMainPage()
                .signIn()
                .loginIntoAcc(ReadProperties.getValue("loginEmail"), ReadProperties.getValue("loginPswd"))
                .confirmPage());

    }

    @After
    public void quit() {
        driver.quit();
    }

}
