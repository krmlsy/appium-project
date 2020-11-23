import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class StartApp {
    public static AndroidDriver<MobileElement> driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Samsung.*");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("app", "sauce-storage:sahibinden");
        caps.setCapability("noReset","false");

        driver = new AndroidDriver<MobileElement>(new URL("https://otomasyon:dc1ba806-9368-4b38-9db9-f8bcc0c3506a@ondemand.us-west-1.saucelabs.com:443/wd/hub"),caps);


        TimeUnit.SECONDS.sleep(5);

        driver.findElement(By.id("com.sahibinden:id/browsing_activity_featured_classifieds_text_view_search")).click();

        driver.findElement(By.id("com.sahibinden:id/search_src_text")).sendKeys("araba");

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView[1]")).click();

        TimeUnit.SECONDS.sleep(2);

        driver.quit();

    }
}
