package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudFlareSignUpPage {

    private final WebDriver driver;

    public CloudFlareSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://dash.cloudflare.com/sign-up");
    }

    public WebElement waitForSignUpForm() {
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[ @data-testid='signup-form']")));
    }

    public void EmailField(String enterEmail) {
        WebElement inputEmail = driver.findElement(By.name("email"));
        inputEmail.click();
        inputEmail.sendKeys(enterEmail);
    }

    public void PasswordField(String enterPassword) {
        WebElement inputEmail = driver.findElement(By.name("password"));
        inputEmail.click();
        inputEmail.sendKeys(enterPassword);
    }

    public void FindPasswRule1() {
        WebElement pswRule1 = driver.findElement(By.xpath("//*[ @data-testid='new_sign_up.pw_validation.rule_1']"));
    }

    public WebElement waitForPasswRule1() {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("c_hw")));
    }


}
