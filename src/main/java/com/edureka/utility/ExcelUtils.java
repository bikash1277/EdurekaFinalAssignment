package com.edureka.utility;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtils {
    public String scenario = null;
    XSSFSheet ExcelWSheet;
    XSSFWorkbook ExcelWBook;
    XSSFCell Cell;
    XSSFRow row;
    XSSFSheet sheet;
    int cellNo, rowNo;
    public ExcelUtils() {

    }

    public void readExcel() {
        try {
            File f = new File(PropertyFileReader.getProperty("testData.path"));
            FileInputStream fis = new FileInputStream(f);
            ExcelWBook = new XSSFWorkbook(fis);
            sheet = ExcelWBook.getSheet(PropertyFileReader.getProperty("sheetName"));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setRow() {
        try {
            readExcel();
            scenario = PropertyFileReader.getProperty("TestcaseName");
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                String testCase = row.getCell(0).getStringCellValue();
                if (testCase.equalsIgnoreCase(scenario)) {
                    rowNo = i;
                    break;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String getData(String colName) {
        try {
            //readExcel();
            setRow();
            row = sheet.getRow(0);
            for (int i = 1; i <= row.getLastCellNum(); i++) {
                String col = row.getCell(i).getStringCellValue();
                if (colName.equalsIgnoreCase(col)) {
                    cellNo = i;
                    break;
                }
            }
            String value = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
            return value;
        } catch (Exception e) {
            e.getMessage();

        }
        return null;
    }


    public void setCellData(String Result, int RowNum, int ColNum) throws Exception {
        try {
            row = ExcelWSheet.getRow(RowNum);
            Cell = row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
            if (Cell == null) {
                Cell = row.createCell(ColNum);
                Cell.setCellValue(Result);
            } else {
                Cell.setCellValue(Result);
            }
            FileOutputStream fileOut = new FileOutputStream(PropertyFileReader.getProperty("testData.path"));
            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }


    }

}
