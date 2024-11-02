package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Open browser
//
//Navigate to https://the-internet.herokuapp.com/nested_frames
//
//Verify Text present:

public class FrameTest {

    WebDriver driver;
    @BeforeMethod
    void Setup(){
        driver = new ChromeDriver();
    }

    @Test
    void verifyTextPresentSuccess(){
        // Điều hướng đến URL
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Xác minh URL hiện tại
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/nested_frames");
    }
}
