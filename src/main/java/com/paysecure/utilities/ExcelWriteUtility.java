package com.paysecure.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteUtility {

    private static String getExcelPath(String fileName) {
        String projectDir = System.getProperty("user.dir");
        String excelFolder = "src/main/resources/ExcelResultsFolder";

        File folder = new File(projectDir, excelFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return Paths.get(folder.getAbsolutePath(), fileName).toString();
    }
    


    public static void writeResultForErrorMessage(String sheetName,String MerchantName, String TransactionID, String Error,String TimeStamp) {
        String filePath = getExcelPath("ErrorMsg.xlsx");
        writeExcel(sheetName, TransactionID, MerchantName,TimeStamp, Error,filePath);
    }

    public static void writeExcel(String sheetName, String TimeStamp, String TransactionID,String merchantname, String Error,String filePath) {
        File file = new File(filePath);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        XSSFWorkbook workbook = null;

        try {
            // Create workbook if not exists
            if (!file.exists()) {
                workbook = new XSSFWorkbook();
                fos = new FileOutputStream(file);
                workbook.write(fos);
                fos.close();
            }

            fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                sheet = workbook.createSheet(sheetName);

                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Transaction ID");
                header.createCell(1).setCellValue("Error");
                header.createCell(2).setCellValue("Merchant Name");
                header.createCell(3).setCellValue("TimeStamp");
      
            }

            int lastRow = sheet.getLastRowNum() + 1;
            Row row = sheet.createRow(lastRow);

            row.createCell(0).setCellValue(TransactionID);
            row.createCell(1).setCellValue(Error);
            row.createCell(2).setCellValue(merchantname);
            row.createCell(3).setCellValue(TimeStamp);


            fis.close(); // Very important
            fos = new FileOutputStream(file);
            workbook.write(fos);

        } catch (Exception e) {
            System.out.println("Error writing result to Excel: " + e.getMessage());
        } finally {
            try { if (fis != null) fis.close(); } catch (Exception ignore) {}
            try { if (fos != null) fos.close(); } catch (Exception ignore) {}
            try { if (workbook != null) workbook.close(); } catch (Exception ignore) {}
        }
    }
    
   

}

