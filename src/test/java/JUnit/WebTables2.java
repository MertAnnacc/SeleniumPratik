package JUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebTables2 extends TestBase {

    @Test
    public void test01() {
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan basliklari yazdirin
        WebElement headersBaslik = driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println(headersBaslik.getText());

        //3. 3.sutunun basligini yazdirin
        List<WebElement> basliklarElementi = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println("3.sütunun baslıgi :" + basliklarElementi.get(2).getText());

        //4. Tablodaki tum datalari yazdirin
        WebElement tumDatalar = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println("Tüm datalar :" + tumDatalar.getText());

        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> datalarListesi = driver.findElements(By.xpath("//div[@class='rt-td']"));

        int sirano=1;
        for (WebElement eachData: datalarListesi
             ) {

            if (!(eachData.getText().equals("") || eachData.getText().equals(" "))){
                System.out.println(sirano + "-" + eachData.getText());
                sirano++;
            }

        }
        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Satır sayısı :" +satirSayisi.size());

        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("Sütun sayısı :" +basliklarElementi.size());

        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunDatalarListesi= driver.findElements(By.xpath("((//div[@class='rt-tr-group']))//div[1]/div[3]"));

        for (WebElement eachElement: ucuncuSutunDatalarListesi
        ) {
            if (!(eachElement.getText().equals("") || eachElement.getText().equals(" "))){
                System.out.println( eachElement.getText() );

            }
        }

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        for (int i = 0; i < datalarListesi.size()  ; i++) {

            if (datalarListesi.get(i).getText().equals("Alden")){

                System.out.println("Istenen kisinin maasi : " + datalarListesi.get(i+4).getText());
            }
        }



    }

}
