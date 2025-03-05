package Admin.BookingDetail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import java.time.Duration;

public class Address {
    WebDriver driver;
    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/food1/");

    }
    @Test
    void clickButton(){
        driver.findElement(By.xpath("//a[text(text='contact']")).click();

        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/food1/contact.php", currentUrl, "URL không khớp sau khi click.");
    }

    @Test
    void happyCase(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Mot nguoi dep");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("0987654543");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ht@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Hello, Help me!");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div/span[text(text()='sent message successfully!']"))
        );
        String actualMessage = messageElement.getText();
        assertEquals("sent message successfully!", actualMessage, "Thông báo không khớp!");
    }

    @Test
    void maxLength(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Công cụ đếm ký tự onl");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("0987654543");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ht@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Hello, Help me!");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "Thông báo lỗi không được hiển thị khi vượt maxlength!");

        String expectedMessage = "Name cannot exceed 20 characters";
        String actualMessage = errorMessage.getText();
        assertEquals(expectedMessage, actualMessage, "Nội dung thông báo lỗi không đúng!");
    }

    @Test
    void minLength(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Công cụ đếm ký tự onl");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("0987654543");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ht@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Hello, Help me!");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "Thông báo lỗi không được hiển thị khi vượt min length!");

        String expectedMessage = "Name cannot less than 2 characters";
        String actualMessage = errorMessage.getText();
        assertEquals(expectedMessage, actualMessage, "Nội dung thông báo lỗi không đúng!");
    }

    @Test
    void nameContainNumberAndSpecialCharacters(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("&!@@#123");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("0987654543");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ht@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Hello, Help me!");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "ten khong hop le!");

        String expectedMessage = "Name cannot contain numbers and special characters";
        String actualMessage = errorMessage.getText();
        assertEquals(expectedMessage, actualMessage, "Nội dung thông báo lỗi không đúng!");
    }

    @Test
    void nameBlank(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("0987654543");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ht@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Hello, Help me!");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "Vui long nhap ten !");

        String expectedMessage = "Can not leave name field blank";
        String actualMessage = errorMessage.getText();
        assertEquals(expectedMessage, actualMessage, "Nội dung thông báo lỗi không đúng!");
    }

    @Test
    void numberMaxLength(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ANPHAN");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("09876545438");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ht@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Hello, Help me!");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "Thông báo lỗi không được hiển thị khi vượt max length!");

        String expectedMessage = "Can not more than 10 number characters";
        String actualMessage = errorMessage.getText();
        assertEquals(expectedMessage, actualMessage, "Nội dung thông báo lỗi không đúng!");
    }

    @Test
    void numberMinLength(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ANPHAN");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ht@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Hello, Help me!");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "Thông báo lỗi không được hiển thị khi vượt min length!");

        String expectedMessage = "Can not less than 1 number characters";
        String actualMessage = errorMessage.getText();
        assertEquals(expectedMessage, actualMessage, "Nội dung thông báo lỗi không đúng!");
    }
    @Test
    void numberEqual4(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ANPHAN");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("0243");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ht@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Hello, Help me!");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "Invalid phone number format!");

        String expectedMessage = "Can not equal 4 numbers characters";
        String actualMessage = errorMessage.getText();
        assertEquals(expectedMessage, actualMessage, "Nội dung thông báo lỗi không đúng!");
    }

    @Test
    void formatEmail(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ANPHAN");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("0243");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("-#%@768.com");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Hello, Help me!");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "Invalid email format!");

        String expectedMessage = "Format email incorrect";
        String actualMessage = errorMessage.getText();
        assertEquals(expectedMessage, actualMessage, "Nội dung thông báo lỗi không đúng!");
    }

    @Test
    void maxLengthEmail(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ANPHAN");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("0243");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("a1234567890bcdefghijklyyyyyyyyyyyyyyyyyyyydddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmno.pqrstuvwxyz1234567890abcdefghi_jklmnopqrstuvwxyz-1234567890abcdefghi");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Hello, Help me!");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "Email invalid!");

        String expectedMessage = "Format email incorrect";
        String actualMessage = errorMessage.getText();
        assertEquals(expectedMessage, actualMessage, "Nội dung thông báo lỗi không đúng!");
    }

    @Test
    void minLengthEmail(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ANPHAN");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("0243");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("aa@b.com.vn");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Hello, Help me!");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "Email invalid!");

        String expectedMessage = "Format email incorrect";
        String actualMessage = errorMessage.getText();
        assertEquals(expectedMessage, actualMessage, "Nội dung thông báo lỗi không đúng!");
    }

    @Test
    void emailNotExist(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ANPHAN");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("0243");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("%^@b.com.vn");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Hello, Help me!");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "Email invalid!");

        String expectedMessage = "Email incorrect";
        String actualMessage = errorMessage.getText();
        assertEquals(expectedMessage, actualMessage, "Nội dung thông báo lỗi không đúng!");
    }

    @Test
    void MsgBlank(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ANPHAN");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("0243");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("th@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "Please enter your message!");

        String expectedMessage = "Please enter your message";
        String actualMessage = errorMessage.getText();
        assertEquals(expectedMessage, actualMessage, "Nội dung thông báo lỗi không đúng!");
    }

    @Test
    void maxLengthMsg(){
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ANPHAN");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("0243");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("th@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Trận này thật sự khó khăn, đúng như chúng tôi đã trù liệu\", HLV Kim nói sau trận đấu trên sân Rizal Memorial tối 18/12. \"Đội tuyển không thể ghi bàn hay tạo ra nhiều cơ hội đủ tốt trong hiệp một, nhưng nỗ lực hơn trong hiệp hai, nhất là w\n" +
                "Hiện, Việt Nam vững vàng trên đỉnh bảng B với bảy điểm, nhiều hơn ba điểm so với Indonesia và Myanmar. Philippines đứng thứ tư được ba điểm. Ở lượt cuối ngày 21/12, thầy trò Kim chỉ cần hòa Myanmar trên sân nhà Việt Trì để chắc chắn đi tiếp với vị trí dẫn đầu.");

        driver.findElement(By.xpath("///input[@name='send']")).click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "Message khoong vuot qua 500 ky tu");

        String expectedMessage = "Message not more than 500 characters";
        String actualMessage = errorMessage.getText();
        assertEquals(expectedMessage, actualMessage, "Nội dung thông báo lỗi không đúng!");
    }








}
