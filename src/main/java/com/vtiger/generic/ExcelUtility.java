package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	
	
	/**
	 * @author usha
	 * To fetch the data from excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return data from excel sheet
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	
      public String readDatafromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
      {
    	  FileInputStream fis= new FileInputStream(IConstants.excelpath);
    	  Workbook wb= WorkbookFactory.create(fis);
    	  Sheet sh=wb.getSheet(sheetname);
    	  Row r=sh.getRow(rownum);
    	  Cell c=r.getCell(cellnum);
    	  String data=c.getStringCellValue();
    	  return data;
    	  
      }
      
      
      
      
      /**
       * @author usha
       * Read Data from Excel
       * @param path
       * @param sheetname
       * @param rownum
       * @param cellnum
       * @return data
       * @throws EncryptedDocumentException
       * @throws IOException
       */
      
      public String  readDatafromExcel(String path,String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
    	  
    	  FileInputStream fis=new FileInputStream(path);
    	  Workbook wb= WorkbookFactory.create(fis);
    	  Sheet sh=wb.getSheet(sheetname);
    	  Row r=sh.getRow(rownum);
    	  Cell c= r.getCell(cellnum);
    	  String data=c.getStringCellValue();
    	  return data;
    	  
      }
      
      
      /**
       * @author usha
       * Get the last row
       * @param path
       * @param sheetname
       * @param rownum
       * @return
       * @throws EncryptedDocumentException
       * @throws IOException
       */
      
      
      public int getrowcount(String path,String sheetname,int rownum) throws EncryptedDocumentException, IOException
      {
    	  
    	  FileInputStream fis= new FileInputStream(path);
    	  Workbook wb=  WorkbookFactory.create(fis);
    	  Sheet sh= wb.getSheet(sheetname);
    	  return sh.getLastRowNum();
    	  	  
      }
      
      
      
      /**
       * @author usha
       * Write Data in Excel Sheet
       * @param path
       * @param sheetname
       * @param rownum
       * @param column
       * @param value
       * @throws EncryptedDocumentException
       * @throws IOException
       */
      
      
      public void writedatainexcel(String path,String sheetname,int rownum,int column,String value) throws EncryptedDocumentException, IOException
      {
    	  FileInputStream fis=new FileInputStream(path);
    	  Workbook wb= WorkbookFactory.create(fis);
    	  Sheet sh=wb.getSheet(sheetname);
    	  Row r= sh.getRow(rownum);
    	 Cell c=r.createCell(column);
    	 c.setCellValue(value);
    	 FileOutputStream fout=new FileOutputStream(path);
    	 
    	 
    	 }
      
      
      
      
}
