package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {
    /*
    * 1. Open browser
    * 2. Navigate to https://the-internet.herokuapp.com/dropdown
    * 3. select option1
    * 4. Verify that option1 is selected
    * */
    WebDriver driver;
    @BeforeMethod
    void setup(){
        driver = new ChromeDriver();
    }

    @Test
    void dropDown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.xpath("//select[@id='dropdown']")).click();
        driver.findElement(By.xpath("//option[@value='1']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//option[@selected='selected']")).isSelected());
    }
}
