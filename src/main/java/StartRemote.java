import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class StartRemote {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        StartApp sa = new StartApp();
        StartRemote sr =new StartRemote();

        // Android
        System.out.println("ANDROID TEST IS OK=" +  sa.loginTestAndroid(sr.getAndroidDriver()));
    }

    public AndroidDriver getAndroidDriver() throws MalformedURLException {

        AndroidDriver<MobileElement> driver;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "520021dcb250b4f7");
        caps.setCapability("platformName", "ANDROID");
        caps.setCapability("platformVersion", "8.1.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("app", "C:\\Users\\USER\\Desktop\\kerem\\mobile\\appium-project\\app\\eribank.apk");
        caps.setCapability("noReset","false");

        driver = new AndroidDriver<MobileElement>(new URL("https://192.168.1.17:4444/wd/hub"),caps);

        return driver;
    }
}
