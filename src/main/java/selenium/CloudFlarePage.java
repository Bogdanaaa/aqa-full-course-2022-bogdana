package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudFlarePage {

    private final WebDriver driver;

    public CloudFlarePage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://www.cloudflare.com/hp/");
    }

    public WebElement waitForAcceptCookiesBtn() {
        return new WebDriverWait(driver, Duration.ofSeconds(10)) //ми будемо чекати 30 сек, доки..
                .until(ExpectedConditions.presenceOfElementLocated(By.id("onetrust-accept-btn-handler"))); //доки не зʼявится елемент з ід кнопки "onetrust-accept-btn-handler"
    }

}

