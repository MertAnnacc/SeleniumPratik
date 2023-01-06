package First;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c2 {
    public static void main(String[] args) throws InterruptedException {


        //1. Yeni bir Class olusturalim.C05_NavigationMethods
        System.setProperty("webdriver.chrome.driver" , "src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.navigate().to("https://www.youtube.com/");
        Thread.sleep(3000);
        //3. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000);
        //4. Tekrar YouTube’sayfasina donelim
        driver.navigate().back();
        Thread.sleep(3000);
//5. Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
        Thread.sleep(3000);
//6. Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        Thread.sleep(3000);
//7. Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();
    }
}
