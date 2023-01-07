package JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class FileUploadTesti extends TestBase {

    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.


        WebElement chooseFileButonu= driver.findElement(By.xpath("//*[@id='file-upload']"));

        String dosyaYolu= System.getProperty("user.home")+"/Desktop/Hello World.docx";

        //chooseFileButonu.sendKeys(dosyaYolu);


        //Upload butonuna basalim.

        driver.findElement(By.xpath("//*[@id='file-submit']")).click();


        //“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploadedElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());

        ReusableMethods.bekle(3);
    }
}
