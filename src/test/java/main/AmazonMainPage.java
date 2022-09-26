package main;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import selenium.driver.WebDriverContainer;
import selenium.pages.AmazonPage;

public class AmazonMainPage {
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
        Assertions.assertTrue(pageAmz.getSearchResultAmazon().size()>10 );
    }

    @Test
    public void TestAmazonCategories(){
        pageAmz.loadPage();
        pageAmz.switchToCategoryAmazon("Headsets");
        //Assertions.assertEquals ("https://www.amazon.com/s?k=gaming+headsets&pd_rd_r=ab146d34-ecfb-4d9d-8301-bd3bd8d7c321&pd_rd_w=V7k9P&pd_rd_wg=FWe91&pf_rd_p=12129333-2117-4490-9c17-6d31baf0582a&pf_rd_r=HS23TJ62TCC467EPQK9Q&ref=pd_gw_unk",
                //driver.getCurrentUrl());
        Assertions.assertTrue(pageAmz.getSearchResultAmazon().size() > 15 );
    }

    @AfterEach //проміжок між кожним тестом 2 сек
    public void afterTestAmz() throws InterruptedException{
        Thread.sleep(2000);
    }


}
