import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Actions;


import java.sql.Driver;
import java.sql.DriverManager;

public class Abstract  {
   public static WebDriver driver;
    public static Actions actions;


    @BeforeAll
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*",
                "--ignore-ssl-errors=yes",
                "--ignore-certificate-errors"
        );
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.get("https://Sarawan:Sarawan@sarawan.salfa.ru/");
        driver.manage().window().maximize();
        actions=new Actions(driver);
//
    }

    @AfterAll
    public static void destroy() {
        driver.close();
    }

}
