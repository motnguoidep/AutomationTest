# Java Selenium

1. [WebTable](src/test/java/Browser/WebTable.java)
```java
int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        int totalColumns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();

        String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
        for (int i = 1; i <= totalRows; i++){
            for(int j = 1; j <= totalColumns; j++){
                WebElement cell = driver.findElement(By.xpath(String.format(cellLocator,i,j)));
                System.out.println(cell.getText());
            }
        }
        driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"))
                .stream()
                .forEach(webElement -> System.out.println(webElement.getText()));

```
thuật toán của bài lấy gia tri tu table

2. [FormAuthenticationTest](src/test/java/Browser/FormAuthenticationTest.java)
```Java
@BeforeMethod
    void setup() {
        driver = new ChromeDriver();
    }
```
default của class mở 1 ần rồi chạy 3 testcase 
- trạng thái của testcase1 anh huong testcase2 -> lam cho testcase failed vi re-condition khong dung
3. [Webtable](src/test/java/Browser/WebTable.java)
```Java
int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        int totalColumns = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();

        String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
        for(int i = 1; i<= totalRows; i++){
            for(int j=1; j<= totalColumns; j++){
                WebElement cell = driver.findElement(By.xpath(String.format(cellLocator, i, j)));
                System.out.println(cell.getText());
            }
        }
        driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td"))
                .stream()
                .forEach(webElement -> System.out.println(webElement.getText()));
```
Tu duy cua bai toan

4. [DynamicLoadingPage](src/test/java/Browser/DynamicLoadingPage.java)

```Java
Thread.sleep(10000);

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
```

Thread.sleep(10000) (Chờ tĩnh):
Chờ cố định 10 giây, không quan tâm điều kiện.
Không tối ưu, làm chậm chương trình.

Explicit Wait (Chờ tường minh):
Chờ có điều kiện cụ thể cho từng phần tử.
Linh hoạt, hiệu quả nhất.