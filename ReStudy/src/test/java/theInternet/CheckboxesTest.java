package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTest {
    /*
    * 1. Open browser
    * 2. Navigate to https://the-internet.herokuapp.com/checkboxes
    * 3. Check on checkbox1
    * 4. Verify that checkbox1 is checked
    * 5. Check on checkbox2
    * 6. Verify that checkbox2 is checked
    * */
    WebDriver driver;
    @BeforeMethod
    void setup(){
        driver = new ChromeDriver();
    }

    @Test
    void selectCheckbox1(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElement(By.xpath("//form[@id='checkboxes' ]/input[1]"));
        if(!checkbox.isSelected()){
            checkbox.click();
        }
        Assert.assertTrue(checkbox.isSelected());
    }
    @Test
    void selectCheckbox2(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElement(By.xpath("//form[@id='checkboxes' ]/input[2]"));
        if(checkbox.isSelected()){
            checkbox.click();
        }
        Assert.assertFalse(checkbox.isSelected());
    }
}
