package html;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    String password;

    public static void main(String[] args) throws InterruptedException {
        // declaration and instantiation of objects/variables
        //System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://gera.dhge.de/SelfService/start.php";
        String password = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        password = setLoginCredentials(driver, password);

        getNotenauskunftButton(driver).click();

        Thread.sleep(4000);

        driver.navigate().back();

        //new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Notenuebersicht (PDF)']")));

        Select drpSemester = new Select(driver.findElement(By.name("sem")));
        drpSemester.selectByValue("2");

        setPassword(driver, password);

        getNotenauskunftButton(driver).click();

        /*
        // gets the PDF with all grades of all semesters
        WebElement gradesPDF = driver.findElement(By.xpath("//input[@value='Notenuebersicht (PDF)']"));
        gradesPDF.click();
        */

        //closes Chrome
        //driver.close();

        System.exit(0);
    }


    public static WebElement getNotenauskunftButton(WebDriver driver) {
        WebElement grades = driver.findElement(By.xpath("//input[@value='Notenauskunft (Bildschirm)']"));
        return grades;
    }

    public static String setLoginCredentials(WebDriver driver, String password) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insert Matrikelnummer");

        WebElement matrnr = driver.findElement(By.name("matrnr"));
        matrnr.sendKeys(sc.nextLine());

        System.out.println("Insert password");

        password = sc.nextLine();

        WebElement pwd = driver.findElement(By.name("passw"));
        pwd.sendKeys(password);

        sc.close();

        return password;
    }

    public static void setPassword(WebDriver driver, String password) {
        WebElement pwd = driver.findElement(By.name("passw"));
        pwd.sendKeys(password);
    }


}
