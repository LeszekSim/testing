package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver initialize() {
        String browserName = System.getProperty("browser.name");
        WebDriver driver = null;

        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        String url = System.getProperty("initial.url");
        if (url != null && !url.isEmpty()) {
            driver.get(url);
        }

        return driver;
    }

}
