package JUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c1 {
    // 3 ayri test method'u olusturun
    // 1.method'da amazon'a gidip, amazona gittigimizi test edin
    // 2.method'da amazon'da nutella aratip, sonuclarin nutella icerdigini test edin
    // 3.method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin


    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver" , "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        String expectedKelime = "Amazon";
        String actualTitle =driver.getTitle();

        if (actualTitle.contains(expectedKelime)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test PASSED");
        }
    }

    @Test
    public void test02(){
        WebElement aramaKutusu =driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        String expectedKelime = "nutella";
        WebElement actualKelimeler = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String sonucYazisi=actualKelimeler.getText();

        System.out.println(actualKelimeler.getText());

        if (sonucYazisi.contains(expectedKelime)){
            System.out.println("Test PASSED");

        }else {
            System.out.println("Test FAILED");
        }
    }

    @Test
    public void test03(){
        WebElement actualKelimeler = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisi=actualKelimeler.getText();

        String[] sonucSayisiArr = sonucYazisi.split(" ");
        String sonucAdediStr = sonucSayisiArr[2];
        int actualSonucAdedi = Integer.parseInt(sonucAdediStr);

        System.out.println(sonucAdediStr);

        int expectedAramaSonucuSayisi = 50;

        if (actualSonucAdedi>expectedAramaSonucuSayisi){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

    }







}
