
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;   //used to validate response status
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumBasic {
WebDriver driver;
    @Test
    public void test()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.google.com");
        String t=driver.getTitle();
        WebElement el= driver.findElement(By.name("q"));
        el.sendKeys("shapes");
        System.out.println(t);
        Assert.assertEquals(t,"Google");
        driver.close();
    }
}
