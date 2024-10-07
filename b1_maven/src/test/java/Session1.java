import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Session1 {

    WebDriver driver;

    @BeforeMethod
    public void init() {
        // Khởi tạo các tài nguyên cần thiết cho các phương pháp kiểm thử
    }

    @Test
    public void TC_001() {
        // Thực hiện các bước kiểm thử ở đây
    }

    @AfterMethod
    public void tearDown() {
        // Dọn dẹp các tài nguyên sau khi phương pháp kiểm thử hoàn tất
    }
}
