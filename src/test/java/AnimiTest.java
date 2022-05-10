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



public class AnimiTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }
        //complex xpath (eg. //div//a[@href='asd'])
      private By hvrlink = By.xpath("/html/body/div[3]/div/header/div/div/div/div/div/ul/li[4]/div/div/div/div[2]/ul/li/ul/li[2]/a");
      private By hvrlogout = By.xpath("/html/body/div[3]/div/header/section/div/div/div[3]/div/div[3]/div/div/div/ul/li[4]/a");
      private By mysearch = By.xpath("/html/body/div[3]/div/header/section/div/div/div[1]/div/div[1]/div/form/div/input");
      private By mysearchres = By.xpath("/html/body/div[3]/div/header/section/div/div/div[1]/div/div[1]/div/form/div/input");
      private final By bodyLocator = By.tagName("body");
      private WebElement waitVisibiiltyAndFindElement(By locator) 
      {
      this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
      return this.driver.findElement(locator);
      }
    @Test
    public void testLoginLogout() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.openLogin();
        DashboardPage dashboardPage = loginPage.login("dibigok233@azteen.com","Shahid@123");

        System.out.println(dashboardPage.getNewsCardTitle());
        Assert.assertTrue(dashboardPage.getNewsCardTitle().contains("WORLDWIDE SHIPPING"));
        //mainPage = dashboardPage.Logout();
        //Logout
		//Filling or reading drop-down
        WebElement element = this.driver.findElement(By.xpath("/html/body/div[3]/div/header/section/div/div/div[3]/div/div[3]/div/div/a"));
        Actions action = new Actions(this.driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action.moveToElement(element).perform();
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(hvrlogout)).click();
    }

    @Test
    public void FormSendUser() {
		
		//Fill input (text,radio,check...)
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.openLogin();
        //Fill simple form and send (eg. Login)
        DashboardPage dashboardPage = loginPage.login("dibigok233@azteen.com", "Shahid@123");
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mysearch));//.click();
		WebElement searchBarElement = waitVisibiiltyAndFindElement(mysearch);
		//Form sending with user
		searchBarElement.sendKeys("Mini Serving Trays \n");
		WebElement bodyElement = waitVisibiiltyAndFindElement(bodyLocator);
		Assert.assertTrue(bodyElement.getText().contains("FILTER BY PRICE"));
        

	}
    @Test
    public void MultiplePageLinks() {

    //WebDriver driver = new HtmlUnitDriver();
    MainPage mainPage = new MainPage(this.driver);
    List<WebElement> allinks = driver.findElements(By.tagName("a")); // use tagname according to the need

    System.out.println("Total number of links present " + allinks.size());
		for(int i = 0;i<allinks.size();i++)
		{
			WebElement Animi = allinks.get(i);
			String url = Animi.getAttribute("href");
		}
	}
   /* for (WebElement link : allLinks) {
    if (link.getAttribute("href") != null && link.getText().isEmpty()==false) { //again modify the condition here accordingly
        driver.get(link.getAttribute("href"));
        driver.getTitle().then(function(title){
             assert.equal(title, site_name);
        });         
    }
    }*/
    @Test
    public void ReadingTitle(){
         //Reading of page title
        //Static Page test
        MainPage mainPage = new MainPage(this.driver);	
		System.out.println("Page title is : " + this.driver.getTitle());
		System.out.println("Task completed : Reading the page title");
		Assert.assertTrue(this.driver.getTitle().contains("Animi Causa: Gift Shop, Gift Ideas, Unique Gifts For Everyone"));
    }
    @Test
    public void Hovering() {
        MainPage mainPage = new MainPage(this.driver);
        WebElement element = this.driver.findElement(By.xpath("/html/body/div[3]/div/header/div/div/div/div/div/ul/li[4]/a"));
        Actions action = new Actions(this.driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action.moveToElement(element).perform();
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(hvrlink)).click();
        //Form sending
        System.out.println("HoverTest completed");
        // Here I am trying browser back button
        this.driver.navigate().back();
    }


    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}