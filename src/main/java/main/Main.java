package main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.*;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String... args) {

        //autotest for - BaseWebTest
        /*BaseWebTest baseWebTest = new BaseWebTest();
        baseWebTest.loadGooglePage();*/

        //autotest for - WebEmailTest
       /* WebEmailTest webEmailTest = new WebEmailTest();
        webEmailTest.loadEmail();*/

        //autotest for GogglePage
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        try{
            GooglePage googlePage = new GooglePage(driver);
            //testGoogleOne(googlePage);
            //testGoogleTwo(googlePage);
            // cloudFlareCookiesTest(new CloudFlarePage(driver));
            CloudFlareSignUpTest(new CloudFlareSignUpPage(driver));
        }
        finally {
            driver.quit();
        }


    }

    public static void cloudFlareCookiesTest(CloudFlarePage cloudFlarePage) {
        cloudFlarePage.loadPage();
        cloudFlarePage.waitForAcceptCookiesBtn().click();
    }

    public static void CloudFlareSignUpTest(CloudFlareSignUpPage cloudFlareSignUpPage){
        cloudFlareSignUpPage.loadPage();
        cloudFlareSignUpPage.waitForSignUpForm();
        cloudFlareSignUpPage.EmailField("testmail@mail.com");
        cloudFlareSignUpPage.PasswordField("password.green123");
        cloudFlareSignUpPage.waitForPasswRule1();
    }

    public static void testGoogleOne(GooglePage googlePage) {
        googlePage.loadPage();
//        googlePage.acceptCookies(); //у мене немає кук
        googlePage.setSearchValue("news Ukraine");
        googlePage.pressSearchButton();
    }

    //1.43;


    public static void testGoogleTwo(GooglePage googlePage) {
        googlePage.loadPage();
        googlePage.setSearchValue("news World");
        googlePage.pressFeelingLucky();
    }


}