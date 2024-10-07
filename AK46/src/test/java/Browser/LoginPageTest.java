package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest {
   private WebDriver driver = new ChromeDriver();

    @Test
    void openBrowserWithDefaultMode(){

        driver.get("https://the-internet.herokuapp.com/login");
        Assert.assertEquals(driver.getTitle(), "The Internet");

        // Nhập tên người dùng
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        // Nhập mật khẩu
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        // Nhấn nút Login
        driver.findElement(By.cssSelector("button.radius")).click();

        // Kiểm tra xem có chuyển đến trang bảo mật không
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

//    @Test
//    void loginWithValidCredentials() {
//        // Nhập tên người dùng
//        driver.findElement(By.name("username")).sendKeys("tomsmith");
//
//        // Nhập mật khẩu
//        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
//
//        // Nhấn nút Login
//        driver.findElement(By.cssSelector("button.radius")).click();
//
//        // Kiểm tra xem có chuyển đến trang bảo mật không
//        String expectedUrl = "https://the-internet.herokuapp.com/secure";
//        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
//    }
//

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}