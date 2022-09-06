import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupEx {
    WebDriver driver;

    @Test(groups="Regression")
    public void testCaseOne()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://demo.guru99.com/test/login.html");
        System.out.println("Im in testCaseOne - And in Regression Group");
        driver.close();
    }
    @Test(groups="Regression")
    public void testCaseTwo(){
        String s= driver.getTitle();
        System.out.println(s);
    }
    @Test(groups="Smoke Test")
    public void testCaseThree(){
        System.out.println("Im in testCaseThree - And in Smoke Test Group");
    }
    @Test(groups="Regression")
    public void testCaseFour(){
        System.out.println("Im in testCaseFour - And in Regression Group");
    }
}
