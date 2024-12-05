package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDrown {


    @Test
    void tc03(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");

        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='1']")).isSelected());
        driver.quit();
    }

    /*
    * <select multiple="" id="fruits">
            <option value="banana">Banana</option>
            <option value="apple">Apple</option>
            <option value="orange">Orange</option>
            <option value="grape">Grape</option>
        </select>
        * */
    @Test
    void selectMultiple(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));

        Assert.assertTrue(select.isMultiple());

//        verify able select banana and apple
        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");

//        verify able select banana and apple
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='fruits']/option[@value='apple']")).isSelected());
    }

    @Test
    void deSelect(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));
        Assert.assertTrue(select.isMultiple());

//        verify able select banana and apple
        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");

//        verify able select banana and apple
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='fruits']/option[@value='apple']")).isSelected());

//        Deselect banana
        select.deselectByVisibleText("Banana");
//        verify able select banana and apple
        Assert.assertFalse(driver.findElement(By.xpath("//select[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='fruits']/option[@value='apple']")).isSelected());
    }

    @Test
    void deSelectAll(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));
        Assert.assertTrue(select.isMultiple());

//        verify able select banana and apple
        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");

//        verify able select banana and apple
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='fruits']/option[@value='apple']")).isSelected());

//        deselect all
        select.deselectAll();
        Assert.assertFalse(driver.findElement(By.xpath("//select[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//select[@id='fruits']/option[@value='apple']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//select[@id='fruits']/option[@value='orange']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//select[@id='fruits']/option[@value='prape']")).isSelected());

    }

    @Test
    void ableSelectDateForFlight() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.vietnamairlines.com/vn/vi/Home?utm_source=CLEADS-BTT&utm_medium=GGL-PerforMax&utm_campaign=Vandamnangniu&utm_content=SG.Affi.3554.KV2TG&gad_source=1");
        Thread.sleep(5000);
        driver.findElement(By.id("cookie-agree")).click();
        Thread.sleep(5000);

//        select to city
        driver.findElement(By.id("city-to-roundtrip")).click();
        driver.findElement(By.xpath("//div[text()='Đà Nẵng (DAD), Việt Nam']")).click();

//        click on Depart date
        driver.findElement(By.id("roundtrip-date-depart")).click();

//        Select 27/11/2024 => //td[@data-month='11' and @data-year='2024']/a[.='27']
        driver.findElement(By.xpath("//td[@data-month='11' and @data-year='2024']/a[.='27']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[@data-month='11' and @data-year='2024']/a[.='29']")).click();
        Thread.sleep(1000);

        driver.findElement(By.className("confirm-dates")).click();
    }
//2h13
}
