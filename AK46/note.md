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