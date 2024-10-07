package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperLink {
    private WebDriver driver = new ChromeDriver();

    @Test
    void openBrowserWithDefaultMode() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/status_codes");
        Assert.assertEquals(driver.getTitle(), "The Internet");
        Thread.sleep(3000); // Chậm 3 giây
    }

    @Test(dependsOnMethods = "openBrowserWithDefaultMode")
    void StatusCodes() throws InterruptedException {
//      Status 200
        WebElement code200 = driver.findElement(By.linkText("200"));
        code200.click();
        Assert.assertTrue(driver.getPageSource().contains("200 status code"), "Verify 200 status code");
        Thread.sleep(3000); // Chậm 3 giây

        // Nhấp vào "go here"
        WebElement goHere = driver.findElement(By.linkText("here")); // Sửa để nhấp vào liên kết "here"
        goHere.click();
        Assert.assertEquals(driver.getTitle(), "The Internet");
        Thread.sleep(3000); // Chậm 3 giây

//        Status 301
        WebElement code301 = driver.findElement(By.linkText("301"));
        code301.click();
        Assert.assertTrue(driver.getPageSource().contains("301 status code"), "Verify 301 status code ");

//        // Nhấp vào "go here"
        goHere = driver.findElement(By.linkText("here"));
        goHere.click();
        Assert.assertEquals(driver.getTitle(), "The Internet");
        Thread.sleep(3000); // Chậm 3 giây


//        // Nhấp vào "404"
        WebElement code404 = driver.findElement(By.linkText("404"));
        code404.click();
        Assert.assertTrue(driver.getPageSource().contains("404 status code"), "Verify 404 status code page appears");

        goHere = driver.findElement(By.linkText("here"));
        goHere.click();
        Assert.assertEquals(driver.getTitle(), "The Internet");
        Thread.sleep(3000);

//        // Nhấp vào "500"
        WebElement code500 = driver.findElement(By.linkText("500"));
        code500.click();
        Assert.assertTrue(driver.getPageSource().contains("500 status code"), "Verify 500 status code page appears");

        goHere = driver.findElement(By.linkText("here"));
        goHere.click();
        Assert.assertEquals(driver.getTitle(), "The Internet");
        Thread.sleep(3000);

    }

}

