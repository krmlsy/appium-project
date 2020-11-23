import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class StartApp {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        StartApp sa = new StartApp();


        // Android
        System.out.println("ANDROID TEST IS OK=" +  sa.loginTestAndroid(sa.getAndroidDriver()));

        // IOS
        System.out.println("IOS TEST IS OK=" +  sa.loginTestIOS(sa.getIOSDriver()));


    }

    public AndroidDriver getAndroidDriver() throws MalformedURLException {

        AndroidDriver<MobileElement> driver;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Samsung.*");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("app", "sauce-storage:eriBankApk");
        caps.setCapability("noReset","false");

        driver = new AndroidDriver<MobileElement>(new URL("https://otomasyon:dc1ba806-9368-4b38-9db9-f8bcc0c3506a@ondemand.us-west-1.saucelabs.com:443/wd/hub"),caps);

        return driver;
    }

    public boolean loginTestAndroid(AndroidDriver driver) throws InterruptedException {

        TimeUnit.SECONDS.sleep(7);

        driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();

        TimeUnit.SECONDS.sleep(3);

        WebElement balance = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View"));

        boolean check = driver.findElement(By.id("com.experitest.ExperiBank:id/logoutButton")).isDisplayed();

        driver.quit();

        //return  ;
        return check;

    }

    public IOSDriver getIOSDriver() throws MalformedURLException {

        IOSDriver<MobileElement> driver;

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "iPhone .*");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "14.1");
        caps.setCapability("deviceOrientation","portrait");
        caps.setCapability("app", "sauce-storage:eriBankIpa");


        driver = new IOSDriver<MobileElement>(new URL("https://otomasyon:dc1ba806-9368-4b38-9db9-f8bcc0c3506a@ondemand.us-west-1.saucelabs.com:443/wd/hub"),caps);

        return driver;
    }

    public boolean loginTestIOS(IOSDriver driver) throws InterruptedException {

        TimeUnit.SECONDS.sleep(7);



        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("usernameTextField");
        el4.sendKeys("company");


        MobileElement el5 = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"passwordTextField\"]"));
        el5.sendKeys("company");

        MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("loginButton");
        el6.click();

        TimeUnit.SECONDS.sleep(3);

        boolean check  = driver.findElementByAccessibilityId("logoutButton").isDisplayed();


        driver.quit();

        //return  driver.findElement(By.id("com.experitest.ExperiBank:id/logoutButton")).isDisplayed();
        return check;

    }

}
