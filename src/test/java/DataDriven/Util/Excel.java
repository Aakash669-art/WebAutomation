package DataDriven.Util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excel {


    static Workbook book;
    static Sheet sheet;
 public  static  String SheetPath = System.getProperty("user.dir")+"/src/test/resources/Book1.xlsx";


 public  static  Object[][] getDataFromExcel(String sheetname){

     FileInputStream file = null;
     try {
        file = new FileInputStream(SheetPath);
         book = WorkbookFactory.create(file);
         sheet = book.getSheet(sheetname);
     } catch (IOException e) {
         System.out.println("Either file not wfound or workbook not created ");;
     }
    Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
     for (int i=0; i<sheet.getLastRowNum(); i++){
         for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
             data[i][j] = sheet.getRow(i + 1).getCell(j).toString();

         }
     }
     return  data;
 }

}
