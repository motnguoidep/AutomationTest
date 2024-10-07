package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ChromeTest {
    @Test
    void openBrowserWithDefaultMode(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

//    khong the record video, but can chup man hinh
    @Test
    void openBrowserWithHeadlessMode(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();;

    }

//    @Test
//    void openBrowserWithMobileViewMode(){
//        Map<String, Object> deviceMetrics = new HashMap<>();
//        deviceMetrics.put("width", 412);
//        deviceMetrics.put("height", 915);
//        Map<String, Object> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceMetrics", deviceMetrics);
//
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
//
//        WebDriver driver = new ChromeDriver(chromeOptions);
//
//        driver.get("https://www.selenium.dev/");
//
//        Assert.assertEquals(driver.getTitle(),"Selenium");
//
//        driver.quit();
//
//    }

    // muốn test xem cai version co phu hop voi san pham cua minh không
//    dự đoán được lỗi có thể xảy ra
    @Test
    void openBrowserWithBetaVersion(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("131");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
//        driver.quit();
    }

//    @Test
//    void openBrowserWithFakeGeoLocation(){
//
//        WebDriver driver = new ChromeDriver();
//
//        DevTools devTools = ((HasDevTools) driver).getDevTools();
//
//        devTools.createSession();
//
//        // Mountain view
//
//        devTools.send(Emulation.setGeolocationOverride(
//
//                Optional.of(37.386052),
//
//                Optional.of(-122.083851),
//
//                Optional.of(1)
//
//        ));
//
//        driver.get("https://the-internet.herokuapp.com/geolocation");
//
//        driver.findElement(By.xpath("//button[.='Where am I?']")).click();
//
//        Assert.assertEquals(driver.findElement(By.cssSelector("#lat-value")).getText(),"37.386052");
//
//        Assert.assertEquals(driver.findElement(By.cssSelector("#long-value")).getText(),"-122.083851");
//
//    }

//    @Test
//    void simulate3GNetworkCondition(){
//
//        ChromeDriver driver = new ChromeDriver();
//
//        DevTools devTools = driver.getDevTools();
//
//        devTools.createSession();
//
//        // Enable Network emulation
//
//        devTools.send(Network.enable(Optional.of(100000000), Optional.empty(), Optional.empty()));
//
//
//
//        // Set network conditions to emulate 3G or 4G
//
//        devTools.send(Network.emulateNetworkConditions(
//
//                false,
//
//                100,
//
//                75000,
//
//                25000,
//
//                Optional.of(ConnectionType.CELLULAR3G),
//
//                Optional.of(0),
//
//                Optional.of(0),
//
//                Optional.of(false)
//
//        ));
//
//        driver.get("https://selenium.dev");
//
//
//
//    }


}
