import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) throws Exception{

        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        //This section will write the username and password into excel
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        File src = new File("D:\\MidTerm_Syeda_Mehreen_excel.xlsx");

        FileInputStream fls = new FileInputStream(src);

        XSSFWorkbook wb = new XSSFWorkbook(fls);

        XSSFSheet sheet1 = wb.getSheetAt(0);

        sheet1.createRow(0).createCell(0).setCellValue("User1");
        sheet1.getRow(0).createCell(1).setCellValue("Password1");
        FileOutputStream fout = new FileOutputStream(src);
        wb.write(fout);


        wb.close();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        //This section will read the username and password excel excel
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////


        String usr_1=sheet1.getRow(0).getCell(0).getStringCellValue();
        String psw_1=sheet1.getRow(0).getCell(1).getStringCellValue();

        System.out.println("Data from Excel is below:");
        System.out.println("Username 1 : "+usr_1 +" \t\t\tPassword 1 : "+psw_1);

        wb.close();


        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        //This section will do the log in
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://demo.guru99.com/test/login.html";
        driver.get(baseUrl);

        // Get the WebElement corresponding to the Email Address(TextField)
        WebElement email = driver.findElement(By.id("email"));

        // Get the WebElement corresponding to the Password Field
        WebElement password = driver.findElement(By.id("passwd"));

        // Find the submit button
        WebElement login = driver.findElement(By.id("SubmitLogin"));

        //using submit method to submit the form. Submit used on password field
        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys(usr_1);
        driver.findElement(By.id("passwd")).sendKeys(psw_1);
        driver.findElement(By.id("SubmitLogin")).submit();
        System.out.println("Login Screen should show Email address and password combination success");

        //driver.close()

    }

}
