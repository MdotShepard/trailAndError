package html;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        // declaration and instantiation of objects/variables
        //System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://gera.dhge.de/SelfService/start.php";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        WebElement matrnr = driver.findElement(By.name("matrnr"));
        matrnr.sendKeys("G180054WI");

        WebElement pwd = driver.findElement(By.name("passw"));
        pwd.sendKeys("Arnz3tr6");

        getNotenauskunftButton(driver).click();

        Thread.sleep(4000);

        driver.navigate().back();

        //new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Notenuebersicht (PDF)']")));

        Select drpSemester = new Select(driver.findElement(By.name("sem")));
        drpSemester.selectByValue("2");

        WebElement pwd2 = driver.findElement(By.name("passw"));
        pwd2.sendKeys("Arnz3tr6");

        getNotenauskunftButton(driver).click();

        /*
        // gets the PDF with all grades of all semesters
        WebElement gradesPDF = driver.findElement(By.xpath("//input[@value='Notenuebersicht (PDF)']"));
        gradesPDF.click();
        */

        //close Chrome
        //driver.close();

        System.exit(0);
    }


    public static WebElement getNotenauskunftButton(WebDriver driver) {
        WebElement grades = driver.findElement(By.xpath("//input[@value='Notenauskunft (Bildschirm)']"));
        return grades;
    }
}
