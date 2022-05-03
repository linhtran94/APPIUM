package BaiTapVeNha3.src;

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

public class Wordpress {

    AndroidDriver driver;

    @BeforeClass
    public void Setup() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\LynhTran\\Desktop\\org.wordpress.android.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Test_Input_Email_Wordpress() {

        String email = "test123@gmail.com";

        WebElement login_btn = driver.findElementById("org.wordpress.android:id/continue_with_wpcom_button");
        login_btn.click();
        WebElement emailadd_tb = driver.findElementById("org.wordpress.android:id/input");
        emailadd_tb.click();
        emailadd_tb.sendKeys(email);
        WebElement continue_btn = driver.findElementById("org.wordpress.android:id/login_continue_button");
        continue_btn.click();


    }
}
