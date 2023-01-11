package JUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ReadExcel2  {
    @Test
    public void test01() throws IOException {

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        String dosyaYolu = "src/test/java/JUnit/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
       String heyyyy= workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();

        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String baskent = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedKelime= "Kabil";
        Assert.assertEquals(expectedKelime,baskent);
        //- Satir sayisini bulalim
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()+1);

        //- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());
        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String> ulkelerMap = new TreeMap<>();

        int sonSatirIndexi= workbook.getSheet("Sayfa1").getLastRowNum();
        String key="";
        String value="";

        for (int i = 0; i <=sonSatirIndexi ; i++) {

            key= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            value= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() +", " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() +", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);
        }

        System.out.println(ulkelerMap);

    }
}
