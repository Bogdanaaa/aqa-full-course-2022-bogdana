package main;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import selenium.driver.WebDriverContainer;
import selenium.driver.WebDriverFactory;
import selenium.pages.AmazonPage;

public class BaseAmazon {
    protected final AmazonPage pageAmz;

    public BaseAmazon(){ this.pageAmz = new AmazonPage(WebDriverFactory.getInstance().getActiveDriver());
    } //им звертаємось до WebDriverFactory і відериваємо драйвер, кожен раз коли створюємо новий клас

    @AfterAll //після всх тестів закриваємо браузер
    public static void tearDownAmz(){ WebDriverFactory.getInstance().quitDriver();
    }

}
