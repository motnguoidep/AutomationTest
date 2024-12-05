package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {
/*
* TC02: Checkboxes : Check to a box
* Open Browser
* Navigate to https://the-internet.herokuapp.com/checkboxes
* Check on checkbox 1
* Verify  that checkbox1 is checked
* Check on checkbox 2
* Verify that checkbox 2 is checked*/
//cach 1: //*[@checked]
//cach 2:    #checkboxes input:nth-child(3)
//cach 3: //input[1]/../input[2]

    @Test
    void ableSelectChecbox(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElement(By.cssSelector("#checkboxes input:nth-child(1)"));
        if(!checkbox.isSelected()){
            checkbox.click();
        }
        Assert.assertTrue(checkbox.isSelected());
    }

    @Test
    void ableToSelectAChecbox(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElement(By.cssSelector("#checkboxes input:nth-child(3)"));
        if(!checkbox.isSelected()){
            checkbox.click();
        }
        Assert.assertTrue(checkbox.isSelected());

    }

}
