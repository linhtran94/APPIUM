package Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class Lesson5 {

    AndroidDriver driver;

    @BeforeMethod
    public void initialize() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName", "ANDROID");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("platformVersion", "9.0");
        cap.setCapability("app", "C:\\Users\\LynhTran\\Desktop\\File APK\\ApiDemos.apk");
//        cap.setCapability("fullReset", true);
//        cap.setCapability("appPackage", "io.appium.android.apis");
//        cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        driver = new AndroidDriver(new URL(
                "http://localhost:4724/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void testRatingBar() {
        driver.findElementByAccessibilityId("Views").click();
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Rating Bar\"))"));
        element.click();
//        driver.findElementByAccessibilityId("Rating Bar").click();
        //   io.appium.android.apis:id/ratingbar1
        //io.appium.android.apis:id/ratingbar2
        //io.appium.android.apis:id/small_ratingbar
        //io.appium.android.apis:id/indicator_ratingbar
        waitFor(3);
        chooseRatingBar(1);
        waitFor(3);
        chooseRatingBar(2);
        waitFor(3);
        chooseRatingBar(3);
    }

    public void chooseRatingBar(double index) {
        WebElement rating = driver.findElement(By.id("io.appium.android.apis:id/ratingbar1"));
        Rectangle rectangle = rating.getRect();
        System.out.println("rectangle.getHeight() = " + rectangle.getHeight());
        System.out.println("rectangle.getWidth() = " + rectangle.getWidth());
        System.out.println("rectangle.getX() = " + rectangle.getX());
        System.out.println("rectangle.getY() = " + rectangle.getY());
        double x = (double) rectangle.getWidth() * (index / 3);
        System.out.println("x = " + x);
        int y = rectangle.getY();
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point((int) x, y)).perform();
    }

    @Test
    public void testRadio() {
        driver.findElementByAccessibilityId("Views").click();
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Radio Group\"))"));
        element.click();
//check vao 1 elements
//        WebElement checkAll = driver.findElementById("io.appium.android.apis:id/all");
//        checkAll.click();
//        Assert.assertEquals(checkAll.getAttribute("checked"), "true");


        // check all
        List<WebElement> listRadio = driver.findElements(By.xpath("//android.widget.RadioButton"));
        listRadio.forEach(radion -> {
            radion.click();
            Assert.assertEquals(radion.getAttribute("checked"), "true");
        });

        //check button clear

        System.out.println("start click to button clear");
        driver.findElementById("io.appium.android.apis:id/clear").click();
        listRadio.forEach(radion -> Assert.assertEquals(radion.getAttribute("checked"), "false")

        );

        Assert.assertEquals(driver.findElementById("io.appium.android.apis:id/choice").getText(), "You have selected: (none)");

    }

    @Test
    public void testFilter() {
        driver.findElementByAccessibilityId("Views").click();
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Search View\"))"));
        element.click();
        driver.findElementByAccessibilityId("Filter").click();
        searchWith("hi", 2);
        searchWith("ha", 7);


    }

    private void searchWith(String text, int resultCount) {
        //search with text
        driver.findElementById("android:id/search_src_text").clear();
        driver.findElementById("android:id/search_src_text").sendKeys(text);
        driver.hideKeyboard();
        //lay ket qua

        List<WebElement> results = driver.findElements(By.xpath("//android.widget.ListView/android.widget.TextView"));
        List<String> strings = new ArrayList<>();
        results.forEach(result -> {
            String value = result.getText();
            System.out.println("value = " + value);
            strings.add(value);
        });
        Assert.assertEquals(strings.size(), resultCount);
    }

    @Test
    public void testTabs() {
        driver.findElementByAccessibilityId("Views").click();
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Tabs\"))"));
        element.click();
        driver.findElementByAccessibilityId("1. Content By Id").click();

        List<WebElement> webElements = driver.findElementsByXPath("//android.widget.TabWidget//android.widget.LinearLayout");
        for (int i = 0; i < webElements.size(); i++) {


//            driver.findElementByXPath("//android.widget.TextView[@text=\"TAB3\"]").click();
            webElements.get(i).click();
            WebElement result = driver.findElementByXPath("//android.widget.TabHost//android.widget.FrameLayout/android.widget.TextView");
            System.out.println("result = " + result.getText());
            Assert.assertEquals(result.getText(), "tab" + (i + 1));
        }


    }


    @Test
    public void testDropdown1() {
        driver.findElementByAccessibilityId("Views").click();
        driver.findElementByAccessibilityId("Controls").click();
        driver.findElementByAccessibilityId("2. Dark Theme").click();
        driver.findElementById("io.appium.android.apis:id/spinner1").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text=\"Neptune\"]").click();
        Assert.assertEquals(driver.findElementByXPath(" //android.widget.Spinner/android.widget.TextView").getText(), "Neptune");
//        Controls
//        2. Dark Theme
//        io.appium.android.apis:id / spinner1

        //android.widget.CheckedTextView[@text="Neptune"]
        //android.widget.Spinner/android.widget.TextView
    }

    @Test
    public void testCalendarBasic() {
        driver.findElementByAccessibilityId("Views").click();
        driver.findElementByAccessibilityId("Date Widgets").click();
        driver.findElementByAccessibilityId("1. Dialog").click();
        driver.findElementById("io.appium.android.apis:id/pickDate").click();
        Assert.assertTrue(driver.findElementByXPath("//android.view.View[@text=\"2\"]").isDisplayed());


        chooseDate("15", "8");

    }

    private void chooseDate(String expectedDate, String expectedMonth) {
        WebElement btnNext = driver.findElementById("android:id/next");
        WebElement btnPrev = driver.findElementById("android:id/prev");
        WebElement btnOK = driver.findElementById("android:id/button1");

        int currentMonth = 9;
        int expectedMonth1 = Integer.parseInt(expectedMonth);
//        driver.findElementByXPath("//android.view.View[@text='" + expectedDate + "']").click();
        String xpath = "//android.view.View[@text='%s']";
        System.out.println("xpath after = " + String.format(xpath, expectedDate));

        //chon thang
        if (expectedMonth1 > currentMonth) {
            btnNext.click();
        } else {
            btnPrev.click();
        }

        //chon ngay
        driver.findElementByXPath(String.format(xpath, expectedDate)).click();
        btnOK.click();
        String result = driver.findElementById("io.appium.android.apis:id/dateDisplay").getText();
        Assert.assertTrue(result.contains(expectedMonth + "-" + expectedDate + "-2021"));
    }

    public void waitFor(long seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
