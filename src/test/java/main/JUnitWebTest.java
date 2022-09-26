package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;
import selenium.driver.WebDriverContainer;
import selenium.pages.AmazonPage;

public class JUnitWebTest {
    private WebDriver driver;
    private final AmazonPage pageAmz = new AmazonPage(WebDriverContainer.getInstance().getDriver());



    @BeforeAll
    public static void setup(){

    }

    @BeforeEach
    public void preTest(){
        this.driver = WebDriverContainer.getInstance().getDriver();
        driver.get("about:blank"); //вкладка в браузері, коли більше нема чого показати
    }

    @Test //тестуємо пошук
    public void testAmazonSearch(){
        pageAmz.loadPage(); //завантажуємо сторінку Amazon
        pageAmz.setSearchValueAmazon("chairs"); //шукаємо через пошук
        pageAmz.performSearchAmazon(); //натискаємо ентр
        Assertions.assertTrue(pageAmz.getSearchResultAmazon().size()>10);
    }

}
