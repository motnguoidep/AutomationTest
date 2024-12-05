package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFb {
    private WebDriver driver = new ChromeDriver();


    @Test
    void openBrowserWithDefaultMode() {
        driver.get("https://www.facebook.com/");
        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");

        // Nhập tên người dùng
        driver.findElement(By.name("email")).sendKeys("");
        // Nhập mật khẩu
        driver.findElement(By.name("pass")).sendKeys(""); // Thay thế bằng mật khẩu của bạn

        // Nhấn nút Login
        driver.findElement(By.name("login")).click(); // Sử dụng name="login" để tìm nút đăng nhập

        // Kiểm tra xem có chuyển đến trang cá nhân không (cần điều chỉnh URL theo tài khoản)
        String expectedUrl = "https://www.facebook.com/"; // Thay thế bằng URL mong muốn
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

    }
}
