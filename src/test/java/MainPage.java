import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

class MainPage extends PageBase {

    private By loginMenuButtonBy = By.xpath("/html/body/div[3]/div/header/section/div/div/div[3]/div/div[3]/div/div/a/span");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.animicausa.com/");
    }    
    
    public LoginPage openLogin() {
        this.waitAndReturnElement(loginMenuButtonBy).click();
        return new LoginPage(this.driver);
    }
     /*   public void openSearchToggler(){
        WebElement searchTogglerElement = waitVisibiiltyAndFindElement(searchTogglerLocator);
        searchTogglerElement.click();
    }*/

    /*public SearchResultPage search(String searchQuery){
        WebElement searchBarElement = waitVisibiiltyAndFindElement(searchLocator);
        searchBarElement.sendKeys(searchQuery + "\n");
        return new SearchResultPage(this.driver);
    }*/

}