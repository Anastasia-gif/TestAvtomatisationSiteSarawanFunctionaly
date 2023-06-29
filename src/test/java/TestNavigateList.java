import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestNavigateList extends Abstract {

    private WebElement elemNavList;
    private List<WebElement> elementsListNav;
    private String uri;
    private TestAuthorization testAuthorization = new TestAuthorization();
    Utils utils = new Utils(driver);
    @Test
    public void testOpenSectionАuthorizedUser(){
        utils.login();
        checkOpenSections();
        utils.logOutOfPersonalAccount();
    }
    @Test
    public void testOpenSectionUnauthorizedUser(){
        checkOpenSections();
    }
    public void  checkOpenSections() {
        elemNavList = driver.findElement(By.xpath("//header/div[1]/nav[@class=\"nav\"]/div[1]"));
        elementsListNav = elemNavList.findElements(By.cssSelector("li"));
        for (int i = 0; i < elementsListNav.size(); i++) {
            WebElement element = elementsListNav.get(i);
            String textElement = element.getText();
            switch (textElement) {
                case "Главная":
                    element.click();
                    uri = driver.getCurrentUrl();
                    Assertions.assertEquals("https://Sarawan:Sarawan@sarawan.salfa.ru/", uri);
                    break;
                case "Акции":
                    element.click();
                    uri = driver.getCurrentUrl();
                    Assertions.assertEquals("https://Sarawan:Sarawan@sarawan.salfa.ru/discount", uri);
                    break;
                case "Новости":
                    element.click();
                    uri = driver.getCurrentUrl();
                    Assertions.assertEquals("https://Sarawan:Sarawan@sarawan.salfa.ru/news", uri);
                    break;
                case "Контакты":
                    element.click();
                    uri = driver.getCurrentUrl();
                    Assertions.assertEquals("https://Sarawan:Sarawan@sarawan.salfa.ru/contacts", uri);
                    break;
                case "Доставка и оплата":
                    element.click();
                    uri = driver.getCurrentUrl();
                    Assertions.assertEquals("https://Sarawan:Sarawan@sarawan.salfa.ru/delivery", uri);
                    break;
                case "Обратная связь":
                    element.click();
                    WebElement modalWindow = driver.findElement(By.className("modal__content2"));
                    Boolean classActive = new WebDriverWait(driver, Duration.ofSeconds(10))
                            .until(ExpectedConditions.attributeToBe(modalWindow,"class","modal__content2 active feedback"));
                    WebElement modalWindowFeedback= new WebDriverWait(driver, Duration.ofSeconds(20
                     ))
                            .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"feedback_feedback__iQEmv\"]/div[@class=\"feedback_feedbackHeader__rdlH1\"]/button")));
                    //WebElement modalWindowFeedback = driver.findElement(By.xpath("//div[@class=\"modal active\"]/div/div/div/button"));
                    modalWindowFeedback.click();
                    break;
            }
        }
    }
}
