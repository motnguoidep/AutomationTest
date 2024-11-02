package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class SelectOptionTest {
    private WebDriver driver ;

    @BeforeClass
    void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    void openBrowserWithDefaultMode() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Assert.assertEquals(driver.getTitle(), "The Internet");
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = "openBrowserWithDefaultMode")
    void dropDown() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);

        // Chọn "Option 1" từ dropdown
        dropdown.selectByVisibleText("Option 1");
        Thread.sleep(3000); // Chậm 3 giây

        // Xác nhận rằng "Option 1" đã được chọn
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "Option 1", "Verify that Option 1 is selected");
        Thread.sleep(3000); // Chậm 3 giây
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit(); // Đóng trình duyệt sau khi các bài kiểm tra hoàn tất
//    }
}