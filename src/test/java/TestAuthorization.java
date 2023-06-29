import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestAuthorization extends Abstract {
    private WebElement butEnter;
    private WebElement butSendTel;
    public TestData testData = new TestData();
    Utils utils = new Utils(driver);
    // private String elemPersonalAria;

    @Test
    public void loginValidateDate() {
        utils.login();
        utils.checkingTheLoginPersonalAccount();
        utils.logOutOfPersonalAccount();
    }

    @Test
    public void loginInvalidDate() {
        WebElement butEnter = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id ='group-btn']/div[3]/button")));
        butEnter.click();

        for (var k : testData.invalidDateForEnterPersonArea.keySet()) {
            utils.enterTel(k);
            butSendTel = driver.findElement(By.xpath("//form[@class='auth-modal']/button"));
            butSendTel.click();
            String messageError = driver.findElement(By.xpath("//form[@class=\"auth-modal\"]/label/span")).getText();
            Assertions.assertEquals(testData.invalidDateForEnterPersonArea.get(k), messageError);

        }

    }

}
