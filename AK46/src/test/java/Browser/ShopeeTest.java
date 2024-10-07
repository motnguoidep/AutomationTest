package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopeeTest {

    private WebDriver driver = new ChromeDriver();


    @Test
    void openBrowserWithDefaultMode() {
        driver.get("https://shopee.vn/");
        Assert.assertEquals(driver.getTitle(), "Đăng nhập tài khoản - Mua sắm Online | Shopee Việt Nam");

        // Nhập thông tin đăng nhập
        driver.findElement(By.name("loginKey")).sendKeys("thuongngo09072003@gmail.com"); // Thay thế bằng email hoặc số điện thoại
        driver.findElement(By.name("password")).sendKeys(""); // Thay thế bằng mật khẩu

        // Nhấn nút Đăng Nhập
        driver.findElement(By.cssSelector("button.vvOL40.iesrPs.AsFRg8.qCI4rz.ZKayWA.AnY7KS")).click();


    }
}
