package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * TC01: Form Authentication : Login successful with valid credentials
 * Open browser
 *
 * Navigate to https://the-internet.herokuapp.com/login
 *
 * Fill in username with tomsmith
 *
 * Fill in the password with SuperSecretPassword!
 *
 * Click on Login button
 *
 * And the home page is appear
 */

public class FormAuthenticationTest {
    WebDriver driver;

    @BeforeMethod
    void setup() {
        // Thiết lập trình điều khiển Chrome
        driver = new ChromeDriver();
    }

    @Test
    void shouldBeSuccessfullyWithValidCredential() {
        // Điều hướng đến trang đăng nhập
        driver.get("https://the-internet.herokuapp.com/login");

        // Nhập thông tin đăng nhập hợp lệ
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        // Xác minh rằng người dùng đã đăng nhập thành công
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));
    }

    @Test
    void loginFailWithWrongUserName() {
        // Nhập thông tin đăng nhập không hợp lệ
        driver.findElement(By.id("username")).sendKeys("tomsmith1111");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        // Xác minh rằng đăng nhập thất bại do tên người dùng không hợp lệ
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your username is invalid!"));
    }

    @Test
    void loginFailWithWrongPassword() {
        // Nhập thông tin đăng nhập không hợp lệ
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword1234");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid!"));
    }

    @AfterMethod
    void tearDown() {
        // Đóng trình duyệt
        driver.quit();
    }
}