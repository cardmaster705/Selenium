package qualityStreamTutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public void writeExcel(String filePath, String sheetName, String[] dataToWrite) throws IOException {
		File file = new File(filePath);
		FileInputStream newFileInputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(newFileInputStream);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
		XSSFRow row = newSheet.getRow(0);
		XSSFRow newRow = newSheet.createRow(rowCount+1);
		
		for (int i = 0; i < row.getLastCellNum(); i++) {
			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellValue(dataToWrite[i]);
		}
		newFileInputStream.close();
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		newWorkbook.write(fileOutputStream);
		fileOutputStream.close();
	}
	
	public void writeCellValue(String filepath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException {
		
		File file = new File(filepath);
		FileInputStream newFileInputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(newFileInputStream);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		XSSFRow row = newSheet.getRow(rowNumber);
		XSSFCell firstCell = row.getCell(cellNumber -1);
		System.out.println("first cell: "+firstCell.getStringCellValue());
		XSSFCell nextCell = row.createCell(cellNumber);
		nextCell.setCellValue(resultText);
		System.out.println("next cell value: "+nextCell.getStringCellValue());
		newFileInputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkbook.write(outputStream);
		outputStream.close();
		}
}
