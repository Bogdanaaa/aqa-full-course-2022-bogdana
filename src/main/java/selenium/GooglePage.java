package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GooglePage {

    private final WebDriver driver; //final - не можна перекинути WebDriver кудись ще


    public GooglePage(WebDriver driver){ //driver - показує що це обовʼязковий параметр
        this.driver = driver;
    }

    public void loadPage(){ //обʼєкт для завантаження сторінки
        driver.get("https://google.com/");
    }
    public void setSearchValue(String searchContent) {
        WebElement searchQueue = driver.findElement(By.name("q"));
        searchQueue.clear();
        searchQueue.sendKeys(searchContent);
    }

    public void pressSearchButton() {
        clickSuitable(driver.findElements(By.name("btnK"))); //clickSuitable - шуувє першу кнопку
    }

    public void pressFeelingLucky() {
        clickSuitable(driver.findElements(By.name("btnI")));
    }

    public void acceptCookies() {
        driver.findElements(By.tagName("button")).get(3).click();
    }

    public void declineCookies() {
        driver.findElements(By.tagName("button")).get(2).click();
    }

    private void clickSuitable(List<WebElement> buttons) { //шукаєм всі унопки btnI або btnK. List - елементів декілька
        for (WebElement button : buttons) { //обираэмо першу кнопку, яку знайдем в pressFeelingLucky
            try {
                button.click(); //клікаєм
                break; //якщо до цього не знайшлт її то не виконуєм цикл
            } catch (Exception e) { //якщо якась помилка (Exception) то наступний елемент

            }
        }
    }
}
