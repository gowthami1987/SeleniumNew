
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;   //used to validate response status
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumBasic {
WebDriver driver;
   @BeforeTest
   public void test1()
   {
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

       String baseUrl = "http://demo.guru99.com/test/login.html";
       driver.get(baseUrl);
       driver.manage().window().maximize() ;
   }
    @Test
    public void test2()
    {
        WebElement email = driver.findElement(By.id("email"));
         WebElement password = driver.findElement(By.name("passwd"));
         email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");

        WebElement login = driver.findElement(By.id("SubmitLogin"));
        login.click();

    }
    @AfterTest
    public void test3()
    {
try {
    Thread.sleep(20000);
    driver.close();
}
    catch (InterruptedException e){}}
}
