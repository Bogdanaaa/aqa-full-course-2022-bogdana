package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AmazonPage {
    private final WebDriver driver;
    private final static String URL = "https://www.amazon.com/";

    public AmazonPage(WebDriver driver){ //тсворили конструктор для драйвера
        this.driver = driver;
    }

    public void loadPage(){
        driver.get(URL);
    }

    public void setSearchValueAmazon(String searchValueAmazon){
        WebElement searchContainerAmazon = driver.findElement(By.xpath("//input [@id='twotabsearchtextbox']")); //знаходимо поле пошуку
        searchContainerAmazon.clear();
        searchContainerAmazon.sendKeys(searchValueAmazon); //передаємо текст який хочемо шукати
    }

    public void performSearchAmazon(){ //шукаємо в пошуковій строці натисканням Enter
        WebElement searchContainerAmazon = driver.findElement(By.xpath("//input [@id='twotabsearchtextbox']"));
        searchContainerAmazon.sendKeys(Keys.RETURN );
    }

    public void openCategoryAmazon(){ //блок катерогії
        WebElement hamburgerMenu = driver.findElement(By.id("nav-hamburger-menu")); //знаходимо кнопку, яка відериває катерогії
        hamburgerMenu.click();
    }

    public void switchToCategoryAmazon(String categoryNameAmazon){
        WebElement catElementAmazon = driver.findElement(By.linkText(categoryNameAmazon)); //обираємо потрібну нам категорію за текстом в ссилці
        catElementAmazon.click();
    }

    public List<WebElement> getSearchResultAmazon() { //після того як через пошук виконали "setSearchValueAmazon"
        return new WebDriverWait(driver, Duration.ofSeconds(15)) //чекаємо максимум 15 сек
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy( //доки не знайдемо список (тобто декілька елементів)
                        By.xpath("//* [@class='s-main-slot s-result-list s-search-results sg-row']/child::div")));
    }

    public void waitUntilUrlAmz(String expectedUrlAmz){ //чекаємо поки
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectedUrlAmz));
    }
}
