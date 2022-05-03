package lesson2.src;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver driver;

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "9.0");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("app", "C:\\Users\\LynhTran\\Desktop\\Calculator.apk");
        URL url = new URL("http://localhost:4724/wd/hub");
        driver = new AndroidDriver(url, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement btn7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        btn7.click();
        driver.findElementById("com.google.android.calculator:id/op_add").click();
        driver.findElementById("com.google.android.calculator:id/digit_9").click();
        String result = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        System.out.println("result = " + result);
    }
}


