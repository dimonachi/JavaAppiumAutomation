package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CoreTestCase extends TestCase {
    protected RemoteWebDriver driver;
    private static String AppiumUrl = "http://127.0.0.1:4723/wd/hub";
    @Override
    protected void setUp() throws Exception {

        super.setUp();

        driver = new ChromeDriver(this.getMyChromeOptions());
        this.openWikiWebPageForMobileWeb();

    }

    protected ChromeOptions getMyChromeOptions(){
        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width",360);
        deviceMetrics.put("height",740);
        deviceMetrics.put("pixelRatio",3.0);

        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
        mobileEmulation.put("deviceMetrics",deviceMetrics);
        mobileEmulation.put("userAgent","Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D)");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=360,740");

        return chromeOptions;
    }

    protected void openWikiWebPageForMobileWeb(){
        driver.get("https://en.m.wikipedia.org/");
    }
    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenPortrait()
    {
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else{
            System.out.println("Method rotateScreenPortrait() does nothing for platforms");
        }

    }

    protected void rotateScreenLandscape()
    {
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else{
            System.out.println("Method rotateScreenLandscape() does nothing for platforms");
        }
    }

    protected void backgroundApp(int seconds)
    {
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(Duration.ofDays(seconds));;
        } else{
            System.out.println("Method backgroundApp does nothing for platforms");
        }
    }


}
