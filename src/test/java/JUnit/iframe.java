package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class iframe {

    //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
            //2 ) Bir metod olusturun: iframeTest
 //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
            //- Text Box’a “Merhaba Dunya!” yazin.
//TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
// gorunur oldugunu dogrulayin ve konsolda yazdirin

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement yazi1 = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(yazi1.isEnabled());
        Thread.sleep(3000);

        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(textBox);

        WebElement yaziYaz = driver.findElement(By.xpath("//body[@id='tinymce']"));
        yaziYaz.clear();
        yaziYaz.sendKeys("Merhaba Dunya!");
        Thread.sleep(3000);

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin

        driver.switchTo().defaultContent();

        WebElement link = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));

        Assert.assertTrue(link.isDisplayed());

        System.out.println(link.getText());















    }

}
