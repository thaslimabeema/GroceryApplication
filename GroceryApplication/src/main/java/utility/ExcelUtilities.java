package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

 

public class ExcelUtilities {
	static FileInputStream f;//built in class to input file. data is stored in f
	static XSSFWorkbook w;//inbuilt class. in order to fetch workbook where data is
	static XSSFSheet s;//multiple sheets can be present. inbuilt class to fetch sheet
	public static String getStringData(int a,int b, String sheet) throws IOException 
	{
		//f=new FileInputStream("C:\\Users\\thaslima\\eclipse-workspace\\AutomationCourse\\src\\test\\resources\\TestData.xlsx");
		f=new FileInputStream(Constant.TESTDATA);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		return c.getStringCellValue();
	}
	
	public static int getIntegerData(int a, int b, String sheet) throws IOException
	{
		//f=new FileInputStream("C:\\Users\\thaslima\\eclipse-workspace\\AutomationCourse\\src\\test\\resources\\TestData.xlsx");
		f=new FileInputStream(Constant.TESTDATA);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);//getsheet- inbuild method used to get sheet
		XSSFRow r=s.getRow(a);//XSSFRow - inbuilt class to input a row, getRow- inbuilt method to get row
		XSSFCell c=r.getCell(b);//XSSFCell- inbuilt class to input a cell,getCell- inbuilt method to get cell
		int z = (int) c.getNumericCellValue();
		return z;
	}
	
 public static void main(String[] args) throws IOException {
		
		System.out.println(ExcelUtilities.getStringData(1, 0,"LoginPage"));
		System.out.println(ExcelUtilities.getIntegerData(1, 1,"LoginPage"));
		
		System.out.println(ExcelUtilities.getStringData(2, 0,"LoginPage"));
		System.out.println(ExcelUtilities.getIntegerData(2, 1,"LoginPage"));
		
	}

}
