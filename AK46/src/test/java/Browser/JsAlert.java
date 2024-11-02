package Browser;

//Open browser
//
//Navigate to https://the-internet.herokuapp.com/javascript_alerts
//
//When click on "Click For JS Alert" button
//
//Then the Popup is displayed.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsAlert {
    WebDriver driver;

    @BeforeMethod
    void Setup(){
        driver = new ChromeDriver();
    }

    @Test
    void VerifyPopupAlertIsDisplayed() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "I am a JS Alert");

        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }

    @Test
    void VerifyPopupConfirmIsDisplay() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "I am a JS Confirm");

        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
    @Test
    void VerifyPopupConfirmIsDisplay2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "I am a JS Confirm");

        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
    }
    @Test
    void VerifyPopupPromptIsDisplay() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "I am a JS prompt");

        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }

    
}
