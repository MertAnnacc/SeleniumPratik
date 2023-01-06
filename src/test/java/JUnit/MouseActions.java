package JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class MouseActions extends TestBase {



    @Test
    public void test01() {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get(" https://the-internet.herokuapp.com/context_menu");

        // 3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan = driver.findElement(By.xpath("//div[@id='hot-spot']"));

        Actions action = new Actions(driver);
        action.contextClick(ciziliAlan).perform();
        ReusableMethods.bekle(3);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedKelime = "You selected a context menu";
        String actualKelime = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedKelime,actualKelime);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(2);

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWhd = driver.getWindowHandle();

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> ikiSayfaWHdSet = driver.getWindowHandles();
        String ikinciSayfaWHD= "";

        for (String each :ikiSayfaWHdSet
             ) {
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWHD = each;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);

        String expectedYenisayfaYazi="Elemental Selenium";
        String actualYeniSayfaYazi= driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedYenisayfaYazi,actualYeniSayfaYazi);

        ReusableMethods.bekle(5);

    }
}
