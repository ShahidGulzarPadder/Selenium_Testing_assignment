import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.Reader;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


class ManAddressPage extends PageBase {

    private WebDriver driver;
    private WebDriverWait wait;
    //private By newsCardBy = By.xpath("/html/body/div[3]/div/section[4]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[2]/h3");
    private By profileDropDownBy = By.xpath("/html/body/div[3]/div/header/section/div/div/div[3]/div/div[3]/div/div/a");
    private By signoutButtonBy = By.xpath("/html/body/div[3]/div/header/section/div/div/div[3]/div/div[3]/div/div/div/ul/li[4]/a");

    public ManAddressPage(WebDriver driver) {
        super(driver);
    }    
    

    public ManAddressPage Logout() {
		//Filling or reading drop-down
        this.waitAndReturnElement(profileDropDownBy).click();
		    //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //WebElement element = this.driver.findElement(By.xpath("/html/body/div[3]/div/header/section/div/div/div[3]/div/div[3]/div/div/a"));
        //Actions action = new Actions(this.driver);
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //action.moveToElement(element).perform();
        this.waitAndReturnElement(signoutButtonBy).click();
        return new ManAddressPage(driver);
}
}
