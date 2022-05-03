package BaiTapVeNha2.src;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Eribank {
    AndroidDriver driver;

    @BeforeClass
    public void Setup() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\LynhTran\\Desktop\\EriBank.apk");

        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Test_Input_Username_Password() {

        String username = "linhtran";
        String password = "Linh123";

        WebElement ok_btn = driver.findElementById("android:id/button1");
        ok_btn.click();
        WebElement username_tb = driver.findElementById("com.experitest.ExperiBank:id/usernameTextField");
        username_tb.click();
        username_tb.sendKeys(username);
        WebElement password_tb = driver.findElementById("com.experitest.ExperiBank:id/passwordTextField");
        password_tb.click();
        password_tb.sendKeys(password);
        WebElement login_btn = driver.findElementById("com.experitest.ExperiBank:id/loginButton");
        login_btn.click();
    }
}
