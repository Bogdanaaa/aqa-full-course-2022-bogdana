package selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    //Factory патерн - це такий класс, який вміє створювати однотипні обʼєкти для Page object. Кожен елемент (пошук, котегоря, меню сбоку, блок реклами, херед, футер) це Page object

    private WebDriver driver;

    private final static WebDriverFactory instance = new WebDriverFactory();

    private WebDriverFactory() {
        WebDriverManager.chromedriver().setup();
    }

    public static WebDriverFactory getInstance() {
        return instance;
    }

    public WebDriver getActiveDriver() { //тут можемо передавати наприклад назву браузера в ()  . Наприклад (String browserName)
        if (driver != null) { //драйвер якщо не порожній
            return driver; //ми його вертаємо
        } else {
            return getDriver(); //якщо драйвера порожній повертаємо новий драйвер
        }
    }

    public void quitDriver() {
        driver.quit();
        driver = null;
    }

    private WebDriver getDriver() {
        this.driver = new ChromeDriver();
        return driver;
    }
}
