package Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WebTable {
    /*
    * Open browser
    * Navigate to https://the-internet.herokuapp.com/tables
    * Focus on table 1
    * The person who has largest due is "Doe Jacson"
    *  */

/* 1. get value of due column
  2. find max due value
  3. find index of max due value = row
  4. get firstName of max due + get lastName of maxDue
  5. Verify
* */

    @Test
    void tc05(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        double[] dueValue = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(webElement -> Double.parseDouble(webElement.getText().replace("$","")))
                .toArray();

        double maxDueValue = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(webElement -> Double.parseDouble(webElement.getText().replace("$","")))
                .max()
                .getAsDouble();

        int indexOfMaxDue = 0;
        for(int i =0;i<dueValue.length;i++){
            if(dueValue[i]==maxDueValue){
                indexOfMaxDue = i+1;
            }
        }
        System.out.println(indexOfMaxDue);
        String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
        String firsName = driver.findElement(By.xpath(String.format(cellLocator,indexOfMaxDue,2))).getText(); // 2 -> cot firstName
        String lastName = driver.findElement(By.xpath(String.format(cellLocator,indexOfMaxDue,1))).getText(); // 1 -> cot lastName
        Assert.assertEquals(String.format("%s %s",firsName,lastName),"Jason Doe");
    }

    @Test
    void tc05Cach2(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Person> table1Person = new ArrayList<>();
        String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        for (int i = 1; i <=totalRows ; i++) {
            String firstName = driver.findElement(By.xpath(String.format(cellLocator,i,2))).getText();
            String lastName = driver.findElement(By.xpath(String.format(cellLocator,i,1))).getText();
            String due = driver.findElement(By.xpath(String.format(cellLocator,i,4))).getText();
            table1Person.add(new Person(firstName,lastName,due));
        }

        Person maxDuePerson = table1Person
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .get();
        Assert.assertEquals(maxDuePerson.getFullName(),"Jason Doe");
    }

}

