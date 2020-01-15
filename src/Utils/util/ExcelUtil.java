package Utils.util;

import javafx.concurrent.Worker;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class ExcelUtil {
	private static XSSFSheet read2007Value(InputStream in) throws IOException {
		try (XSSFWorkbook workbook = new XSSFWorkbook(in)) {
			return workbook.getSheetAt(0);
		}
	}
	private static XSSFSheet read2007Value(InputStream in,Integer page) throws IOException {
		try (XSSFWorkbook workbook = new XSSFWorkbook(in)) {
			return workbook.getSheetAt(page);
		}
	}

	public static List<Worker> readWorkersExcel(InputStream inputStream) throws IOException{
		List<Worker> result = new ArrayList<>();
		XSSFSheet sheet = read2007Value(inputStream);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
		}
		return result;
	}

	public static String exportIssueTemplate(Map<String,Object> params){
		//List<Map<String,Object>> business = (List<Map<String, Object>>) params.get("business");
		List<String> languages = (List<String>) params.get("languages");
		Integer[] width = new Integer[]{20,30,30,30};
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);
            //cs.setFillBackgroundColor(new XSSFColor( new Color(155,193,230)));
			//XSSFColor color = new XSSFColor(new java.awt.Color(155, 193, 230));
			cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cs.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
			cs.setAlignment(HorizontalAlignment.CENTER);
			cs.setVerticalAlignment(VerticalAlignment.CENTER);
			cs.setBorderBottom(BorderStyle.THIN);
			cs.setBorderLeft(BorderStyle.THIN);
			cs.setBorderTop(BorderStyle.THIN);
			cs.setBorderRight(BorderStyle.THIN);
            XSSFSheet sheet = workbook.createSheet();
			XSSFRow headerRow = sheet.createRow(0);
			headerRow.setHeightInPoints((2*sheet.getDefaultRowHeightInPoints()));
			int col = 0;
			headerRow.createCell(col++, CellType.STRING).setCellValue("Category");
			headerRow.createCell(col++, CellType.STRING).setCellValue(new XSSFRichTextString("Attached Knowledge \r\nTitle (e.gXXX;XXX)"));
			/*StringBuilder sb = new StringBuilder();
			for(int i=0;i<business.size();i++){
				Map<String,Object> map = business.get(i);
				sb.append(map.get("business")+"="+i+",");
			}*/
			//headerRow.createCell(col++, CellType.STRING).setCellValue("Business (e.g 0;1;2)       \r\n(Jollychic=0,MarkaVIP=1)");
			//headerRow.createCell(col++, CellType.STRING).setCellValue("Business (e.g 0;1;2)       \r\n("+sb.substring(0,sb.length()-1)+")");
			headerRow.createCell(col++, CellType.STRING).setCellValue("Feedback (YES=0,NO=1)");
			headerRow.createCell(col++, CellType.STRING).setCellValue("Title(EN)  ");
			headerRow.createCell(col++, CellType.STRING).setCellValue("Similar Title(EN)  \r\n(e.gXXX;XXX)");
			headerRow.createCell(col++, CellType.STRING).setCellValue("Content(EN)  ");
			headerRow.createCell(col++, CellType.STRING).setCellValue("KeyWords(EN)(separate with  \r\nEnglish in comma)");

			for(String language : languages){
				if("EN".equals(language)){
					continue;
				}
				headerRow.createCell(col++, CellType.STRING).setCellValue("Title("+language+")  ");
				headerRow.createCell(col++, CellType.STRING).setCellValue("Similar Title("+language+")  \r\n(e.gXXX;XXX)");
				headerRow.createCell(col++, CellType.STRING).setCellValue("Content("+language+")  ");
				headerRow.createCell(col++, CellType.STRING).setCellValue("KeyWords("+language+")(separate with  \r\nEnglish in comma)");
			}
            for(int i=0;i<headerRow.getPhysicalNumberOfCells();i++) {
                XSSFCell cell = headerRow.getCell(i);
                cell.setCellStyle(cs);
				sheet.setColumnWidth(i, width[i%4] * 256);
				//sheet.autoSizeColumn(i);
				//sheet.setColumnWidth(i, 20 * 256);
			}
			String filename = System.currentTimeMillis() + ".xlsx";
			String path = "/tmp/" + filename;
			FileOutputStream fos = new FileOutputStream(path);
			workbook.write(fos);
			return path;
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
