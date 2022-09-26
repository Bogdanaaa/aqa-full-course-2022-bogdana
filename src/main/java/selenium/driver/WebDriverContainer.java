package selenium.driver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//цей класс відповіє за те, щоб у нас був тільки 1 драйвер на всі тести
//жоден інший обʼєкт за межами цього класу  не може створити ще один драйвер
public class WebDriverContainer {

    private final static WebDriverContainer instance = new WebDriverContainer();
    private final WebDriver driver;

    private WebDriverContainer() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static WebDriverContainer getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
