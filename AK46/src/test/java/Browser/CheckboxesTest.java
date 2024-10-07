package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {
    private WebDriver driver = new ChromeDriver();


    @Test
    void openBrowserWithDefaultMode() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Assert.assertEquals(driver.getTitle(), "The Internet");
    }


    @Test(dependsOnMethods = "openBrowserWithDefaultMode")
    void checkbox1() {
        // Lấy checkbox 1 (checkbox đầu tiên)
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        Assert.assertTrue(checkbox1.isSelected(), "Verify checkbox1 is checked initially");

        // Đánh dấu checkbox 1
//        checkbox1.click();
//        Assert.assertTrue(checkbox1.isSelected(), "Verify checkbox1 is checked after clicking");
    }

    @Test(dependsOnMethods = "openBrowserWithDefaultMode")
    void checkbox2() {
        // Lấy checkbox 2 (checkbox thứ hai)
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertTrue(checkbox2.isSelected(), "Verify checkbox2 is checked initially");


    }

}
