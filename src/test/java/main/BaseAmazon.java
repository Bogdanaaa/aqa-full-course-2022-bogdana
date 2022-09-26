package main;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import selenium.driver.WebDriverContainer;
import selenium.pages.AmazonPage;

public class BaseAmazon {
    protected final AmazonPage pageAmz;

    public BaseAmazon(){
        this.pageAmz = new AmazonPage(WebDriverContainer.getInstance().getDriver());
    }

    @AfterAll //після всх тестів закриваємо браузер
    public void ternDownAmz(){
        WebDriverContainer.getInstance().getDriver().quit();
    }

}
