package Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {
    @Test
    void webTable(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");


    }

}

