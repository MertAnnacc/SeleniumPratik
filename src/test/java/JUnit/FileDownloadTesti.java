package JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTesti extends TestBase {

    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get(" https://the-internet.herokuapp.com/download");

        //3. mani.png dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='mani.jpeg']")).click();
        ReusableMethods.bekle(3);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu = System.getProperty("user.home" + "\\Downloads\\mani.jpeg");

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
