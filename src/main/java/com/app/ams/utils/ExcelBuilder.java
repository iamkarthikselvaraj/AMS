package com.app.ams.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.ams.model.Report;

/**
 * This class builds an Excel spreadsheet document using Apache POI library.
 * 
 * @author www.codejava.net
 *
 */
public class ExcelBuilder extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		List<Report> listReport = (List<Report>) model.get("listReport");

		// create a new Excel sheet
		HSSFSheet sheet = workbook.createSheet("Report");
		sheet.setDefaultColumnWidth(30);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		// style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		// create header row
		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("User Id");
		header.getCell(0).setCellStyle(style);

		header.createCell(1).setCellValue("Name");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("Email");
		header.getCell(2).setCellStyle(style);

		header.createCell(3).setCellValue("Date");
		header.getCell(3).setCellStyle(style);

		header.createCell(4).setCellValue("Day");
		header.getCell(4).setCellStyle(style);

		header.createCell(5).setCellValue("Time of Login");
		header.getCell(5).setCellStyle(style);

		header.createCell(6).setCellValue("Time of Logout");
		header.getCell(6).setCellStyle(style);

		header.createCell(7).setCellValue("Worked Hours");
		header.getCell(7).setCellStyle(style);

		header.createCell(8).setCellValue("Comments");
		header.getCell(8).setCellStyle(style);

		// create data rows
		int rowCount = 1;

		for (Report report : listReport) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(report.getUser().getUserId());
			aRow.createCell(1).setCellValue(report.getUser().getEmail());
			aRow.createCell(2).setCellValue(report.getUser().getUsername());
			aRow.createCell(3).setCellValue(report.getDate());
			aRow.createCell(4).setCellValue(report.getDay());
			aRow.createCell(5).setCellValue(report.getTimeOfLogin());
			aRow.createCell(6).setCellValue(report.getTimeOfLogout());
			aRow.createCell(7).setCellValue(report.getWorkedHours());
			aRow.createCell(8).setCellValue(report.getComments());
		}
	}

	private String ifNull(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj.toString();

	}
}