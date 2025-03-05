package theInternet;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FormAuthenticationTest {
    /*
    * 1. Open browser
    * 2. Navigate to https://the-internet.herokuapp.com/login
    * 3. Fill in username with tomsmith
    * 4. Fill in the password with SuperSecretPassword!
    * 5. Click on Login button
    * 6  And the home page appear
    * */
    WebDriver driver;

    @BeforeMethod
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        driver = new ChromeDriver(chromeOptions);

    }

    @Test
    void shouldBeSuccessfullyWithValidCredential() {
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure" );
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='flash']")).getText().contains("You logged into a secure area!"));
    }

    @Test
    void loginWithInvalidUsername(){
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmithh");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(driver.findElement(By.xpath("///div[@id='flash']")).getText().contains("Your username is invalid!"));
    }

    @Test
    void loginWithInvalidPassword(){
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(driver.findElement(By.xpath("///div[@id='flash']")).getText().contains("Your password is invalid!"));
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
