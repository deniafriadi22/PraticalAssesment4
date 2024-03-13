package TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    //declare driver (untuk buka browser)
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //Declare wait
    public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<>();

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        //Add setter and getter
        driver.set(new EdgeDriver(options));
        driver.get().manage().window().maximize();//maximize window
        driver.get().get("https://demoblaze.com/");
        explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(120)));

    }

    @AfterMethod
    public void closeBrowser(){
        driver.get().quit();

    }

}
