package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebEmailTest {

    public void loadEmail() {
        ChromeDriver chromeDriver = null; //створюємо змінну
        try {
            WebDriverManager.chromedriver().setup();

            chromeDriver = new ChromeDriver();
            chromeDriver.get("https://www.ukr.net/");

//            WebElement loginInput = chromeDriver.findElement(By.name("email"));
            WebElement loginInput = chromeDriver.findElement(By.id("id-input-login"));
            loginInput.click();
            loginInput.sendKeys("test.email@ukr.net");
//            WebElement passwordInput = chromeDriver.findElement(By.name("password"));
            WebElement passwordInput = chromeDriver.findElement(By.id("id-input-password"));
            passwordInput.click();
            passwordInput.sendKeys("123password");
            WebElement continueButton = chromeDriver.findElement(By.className("Form_submit"));
//            List<WebElement> buttonsEmail = chromeDriver.findElements(By.tagName(""))
            continueButton.click();
       } finally { //після того як все відпрацює ми обовʼязково виконаємо дію
            if (chromeDriver != null) { //якщо chromeDriver не закритий
                chromeDriver.quit(); //то закриваємо chromeDriver
            }
        }
    }


}
