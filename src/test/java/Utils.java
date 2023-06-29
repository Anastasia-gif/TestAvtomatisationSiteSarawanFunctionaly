import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Utils  {
    final WebDriver driver;
    private WebElement butSendTel;
    private WebElement fieldNumber;
    private WebElement formSendCode;
    private WebElement wrapFieldsSendCode;
    private WebElement butSend;
    private WebElement butPersonalArea;
    private String popupPersonalAreaElem;
    public TestData testData = new TestData();

    public Utils(WebDriver driver) {
        this.driver = driver;
        fieldNumber = driver.findElement(By.cssSelector("input"));

    }
    public void login() {
        WebElement butEnter = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id ='group-btn']/div[3]/button")));
        butEnter.click();
        enterTel(testData.validUserTel);
        butSendTel = driver.findElement(By.xpath("//form[@class='auth-modal']/button"));
        butSendTel.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        enterCode(testData.validUserCode);
    }
    public void logOutOfPersonalAccount(){
        WebElement butPersonalArea= new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id ='group-btn']/div[3]/button")));
        butPersonalArea.click();
        WebElement butExit= new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='popup__list']/button[@class='popup__item']")));
        butExit.click();
        WebElement butYes = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal__content2 active logout']/div[2]/div/button[1]")));
        butYes.click();
    }
    public void enterTel(String tel) {
        fieldNumber = driver.findElement(By.xpath("//form[@class='auth-modal']/label/input"));
        fieldNumber.sendKeys(tel);
    }

    public void enterCode(String code) {
        formSendCode = driver.findElement(By.xpath("//form[@class=\"auth-modal-send-code\"]"));
        wrapFieldsSendCode = formSendCode.findElement(By.xpath("//div[@class=\"auth-modal__code\"]"));
        ArrayList<WebElement> fieldsSendCode = (ArrayList<WebElement>) wrapFieldsSendCode.findElements(By.cssSelector("input"));
        String[] userCode = code.split("");
        for (int i = 0; i < fieldsSendCode.size(); i++) {
            for (int j = 0; j < userCode.length; j++) {
                if (i == j) {
                    fieldsSendCode.get(i).sendKeys(userCode[j]);
                }
            }
        }
        butSend = formSendCode.findElement(By.cssSelector("button"));
        butSend.click();
    }

    public void checkingTheLoginPersonalAccount() {
        butPersonalArea = driver.findElement(By.xpath("//div[@class=\"user\"]/button[@class=\"header__group-item link-hover-svg\"]"));
        butPersonalArea.click();
        popupPersonalAreaElem = driver.findElement(By.xpath("//div[@class=\"popup\"]/div[2]/a[1]")).getText();
        Assertions.assertEquals("Мои данные", popupPersonalAreaElem);
        WebElement butClosePopup = driver.findElement(By.xpath("//div[@class=\"popup\"]/div[1]/span"));
        butClosePopup.click();
    }


}
