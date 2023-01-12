package JUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class JSExecutor extends TestBase {

    @Test
    public void test01(){
        // Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // Shop with Points sekmesine JSexecutor kullanarak click yapın

        WebElement swpoints = driver.findElement(By.xpath("//*[text()='Shop with Points']"));

        JavascriptExecutor jss = (JavascriptExecutor) driver;

        jss.executeScript("arguments[0].click();", swpoints);

        jss.executeScript("alert('bu is bu kadar')");

        ReusableMethods.bekle(3);
    }
}
