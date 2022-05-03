package BaiTapVeNha4.src;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class SauceLab {

    AndroidDriver driver;

    public void Setup() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\LynhTran\\Desktop\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
//        dc.setCapability("appPackage", "");
//        dc.setCapability("appActivity", "");

        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Test_Input_Username_Password() {

        String username = "standard_user";
        String password = "secret_sauce";

        MobileElement username_tb = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@text=\"Username\"]");
        username_tb.click();
        username_tb.sendKeys(username);
        MobileElement password_tb = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@text=\"Password\"]");
        password_tb.click();
        password_tb.sendKeys(password);
        MobileElement login_btn = (MobileElement) driver.findElementByAccessibilityId("test-LOGIN");
        login_btn.click();
//        MobileElement btnAddToCart = (MobileElement) driver.findElementByAccessibilityId("test-ADD TO CART");
//        login_btn.click();
//        TouchAction touchAction = new AndroidTouchAction(driver);
//        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(btnAddToCart)))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).perform();
//        touchAction.tap(PointOption.point(553, 899)).perform();
//        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
//                        ".scrollIntoView(new UiSelector().text(\"test-ADD TO CART\"))"));
//        element.click();
//        verticalScrolling(0.6, 0.3, 0.5); //như này là vuốt từ dưới lên : 60% màn hình -> 30% màn hình
//        Thread.sleep(3000);
//        verticalScrolling(0.3, 0.6, 0.5); // như này là từ trên xuống
//
//
//        public void verticalScrolling(double startPercentage, double endPercentage, double anchorPercentage) {
//            Dimension size = driver.manage().window().getSize();
//            System.out.println("size.getWidth() = " + size.getWidth());
//            System.out.println("size.getHeight() = " + size.getHeight());
//
//            int anchor = (int) (size.width /2); // -> có thể fix cứng /2 như này
//
////            int anchor = (int) (size.width * anchorPercentage);
//            int startPoint = (int) (size.height * startPercentage);
//            int endPoint = (int) (size.height * endPercentage);
//            new TouchAction(driver)
//                    .press(point(anchor, startPoint))
//                    .waitAction(waitOptions(ofMillis(1000)))
//                    .moveTo(point(anchor, endPoint))
//                    .release()
//                    .perform();
        }
//
    }
