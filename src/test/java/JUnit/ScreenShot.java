package JUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {
        // amazon'a gidip
        driver.get("https://www.amazon.com");
        // Nutella aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // arama sonuclarinin Nutella icerdigini test edin

        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";
        String actualAramaSonucu= aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));


        // Tum sayfanin screenshot'ini alin
        TakesScreenshot tss = (TakesScreenshot) driver;
        File tumsayfaScreenShot = new File("target/ekranGoruntusu/Nutella.jpg");

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,tumsayfaScreenShot);

        ReusableMethods.bekle(3);
    }

}
