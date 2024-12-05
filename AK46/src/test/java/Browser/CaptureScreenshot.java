//package Browser;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.io.IOException;
//
//public class CaptureScreenshot {
//    @Test
//    void captureScreenshot() throws IOException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.selenium.dev/");
//
//        TakesScreenshot scrShot =((TakesScreenshot)driver);
//        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
//        File destFile=new File("target/selenium.png");
//        FileUtils.copyFile(srcFile, destFile);
//    }
//}
