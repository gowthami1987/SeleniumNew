import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

public class ParameterByDataprovider {
    WebDriver driver;
    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");}

    @Test(dataProvider = "userData")
    public void fillUserForm(String userName, String password)
    {try {System.out.println("test=" + userName);
            driver.findElement(By.name("q")).sendKeys(userName+password);

        }
        catch (Exception e) {System.out.println(e);}}
    @AfterTest
    public void test1() {
        driver.close();
         }
    String xlFilePath = "/Volumes/Love/SeleniumProject/SeleniumNew/Sample.xlsx";
    String sheetName = "Sheet1";
    @DataProvider(name="userData")
    public Object[][] userFormData() throws Exception {Object[][] data = testData(xlFilePath, sheetName);
        System.out.println("provider="+data[0][0]);
        return data;}
    public Object[][] testData(String xlFilePath, String sheetName) throws Exception {Object[][] data = null;
        File file = new File(xlFilePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        XSSFRow row = sheet.getRow(0);
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfCols = row.getLastCellNum();
        Cell cell;
        data = new Object[noOfRows][noOfCols];
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                row = sheet.getRow(i);
                cell = row.getCell(j);
                data[i ][j] = cell.getStringCellValue();
                System.out.println("method="+data[i][j]);
            }}
        return data;
    }}
