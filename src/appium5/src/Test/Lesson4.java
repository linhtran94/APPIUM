package Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
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
import static java.time.Duration.ofSeconds;

public class Lesson4 {

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

    public void testScrollDownUpLeftRight() throws InterruptedException {


        driver.findElementByAccessibilityId("Views").

                click();
        Thread.sleep(3000);
//        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"WebView5\"))"));
//        element.click();

//        verticalScrolling(0.8, 0.3);
//        Thread.sleep(3000);
//        verticalScrolling(0.3, 0.8);

        horizontalSwipeByPercentage(0.8, 0.3, 0.5);
        Thread.sleep(3000);

        horizontalSwipeByPercentage(0.3, 0.8, 0.5);
//        driver.findElementByAccessibilityId("Hover Events").click();

    }

    public void verticalScrolling(double startPercentage, double endPercentage) {
        Dimension size = driver.manage().window().getSize();
        System.out.println("size.getWidth() = " + size.getWidth());
        System.out.println("size.getHeight() = " + size.getHeight());


        //-> có thể fix cứng /2 như này
        int anchor = (int) (size.width / 3);

//        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release()
                .perform();
    }

    public void horizontalSwipeByPercentage(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
        new TouchAction(driver)
                .press(point(startPoint, anchor))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endPoint, anchor))
                .release().perform();
    }


    @Test
    public void testPressKeys() {
        driver.findElementByAccessibilityId("OS").click();
        driver.findElementByAccessibilityId("SMS Messaging").click();

//        driver.findElementById("io.appium.android.apis:id/sms_recipient").sendKeys("nguyen van hai");
        driver.findElementById("io.appium.android.apis:id/sms_recipient").click();
        waitFor(3);
        driver.pressKey(new KeyEvent(AndroidKey.H));
        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.I));


    }

    public void waitFor(long seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testDropdown() {

        driver.findElementByAccessibilityId("Views").click();
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Spinner\"))"));
        element.click();

        driver.findElementById("io.appium.android.apis:id/spinner1").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text=\"violet\"]").click();
        Assert.assertEquals(driver.findElementByXPath("//android.widget.Spinner[@resource-id=\"io.appium.android.apis:id/spinner1\"]/android.widget.TextView").getText(), "violet");

    }

    @Test
    public void testDropdownAdvance() {
        String expected = "yellow";


        driver.findElementByAccessibilityId("Views").click();
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Spinner\"))"));
        element.click();

        driver.findElementById("io.appium.android.apis:id/spinner1").click();

        List<WebElement> webElements = driver.findElements(By.className("android.widget.CheckedTextView"));

//        for (int i = 0; i < webElements.size(); i++) {
//            String value = webElements.get(i).getText();
//            System.out.println("value = " + value);
//            if (value.contains(expected)) {
//                webElements.get(i).click();
//                break;
//            }
//        }
        System.out.println("--------------");
        for (WebElement e : webElements) {
            System.out.println(e.getText());
            if (e.getText().contains(expected)) {
                e.click();
                break;
            }
        }

        Assert.assertEquals(driver.findElementByXPath("//android.widget.Spinner[@resource-id=\"io.appium.android.apis:id/spinner1\"]/android.widget.TextView").getText(), expected);

        driver.findElementById("io.appium.android.apis:id/spinner1").click();
        List<WebElement> webElements2 = driver.findElements(By.className("android.widget.CheckedTextView"));
        webElements2.forEach(element1 -> {
            System.out.println("element1.getText() = " + element1.getText());
        });

//        driver.findElementByXPath("//android.widget.CheckedTextView[@text=\"violet\"]").click();


    }


    @Test
    public void testCheckbox() {

        driver.findElementByAccessibilityId("Preference").click();
        driver.findElementByAccessibilityId("9. Switch").click();
//        WebElement checkbox = driver.findElementById("android:id/checkbox");
//        Assert.assertEquals(checkbox.getAttribute("checked"), "false");
//        checkbox.click();
//        Assert.assertEquals(checkbox.getAttribute("checked"), "true");
//        WebElement switcher = driver.findElementByXPath("(//android.widget.Switch)[1]");
//        switcher.click();
//        Assert.assertEquals(switcher.getAttribute("checked"), "true");

        List<WebElement> webElementList = driver.findElementsByXPath("//android.widget.Switch");

        webElementList.forEach(e -> {
            e.click();
        });
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
}
