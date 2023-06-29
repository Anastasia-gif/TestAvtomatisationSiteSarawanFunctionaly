import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExitFromPersonalArea extends Abstract {
    Utils utils = new Utils(driver);

    @Test
    public void TestLogOutOfPersonalAccount(){
       utils.login();
       utils.logOutOfPersonalAccount();
    }

}
