package com.dw.emp.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.emp.mapper.EmpMapper;


@Service
public class ExcelService {

	@Autowired
	private EmpMapper empMapper;
	
	//엑셀 만드는 함수 
	//Workbook == Excel
	public Workbook makeExcelForm() throws Exception{
		
		Workbook workbook = new HSSFWorkbook();//excel 생성
		Sheet sheet = workbook.createSheet("사원 자료"); //시트 생성
		Row row = null; //엑셀 행
		Cell cell = null;//엑셀 열
		int rowNumber = 0; //행 번호
		
		CellStyle headStyle = makeExcelHeadStyle(workbook);
		CellStyle bodyStyle = makeExcelBodyStyle(workbook);
		
		row = sheet.createRow(rowNumber++);//첫번째 행
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("사원 번호");
		
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("사원 이름");
		
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("사원 직책");
		
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("사원 급여");
		
		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("사원 입사날짜");
		
		cell = row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("사원 부서이름");
		
		List<Map<String, Object>> list = empMapper.selectEmp();
		
		for(Map<String, Object> data : list) { //쿼리에서 조회한 값을 excel에다가 넣는 작업.
			row = sheet.createRow(rowNumber++);//행을 계속 추가 해준다. for문 조건식이 만족할 때 까지.
			cell = row.createCell(0);//사원 번호
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("empno").toString());
			
			cell = row.createCell(1);//사원 이름 
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("ename").toString());
			
			cell = row.createCell(2);//직책
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("job").toString());
			
			cell = row.createCell(3);//급여
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("sal").toString());
			
			cell = row.createCell(4);//입사 날짜
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("hiredate").toString());
			
			cell = row.createCell(5);//부서 이름
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("dname").toString());
		}
		
		return workbook;
	}
	
	// 엑셀 head style 수정
	public CellStyle makeExcelHeadStyle(Workbook workbook) {
		CellStyle cellStyle = null;
		cellStyle = workbook.createCellStyle();
		// 가는 경계선 생성
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		// 배경색 생성
		cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// 가운데 정렬
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		return cellStyle;
	}
		
	// 엑셀 body style 수정
	public CellStyle makeExcelBodyStyle(Workbook workbook) {
		CellStyle cellStyle = null;
		cellStyle = workbook.createCellStyle();
		cellStyle.setBorderTop(BorderStyle.THIN); //가는 경계선 생성
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		return cellStyle;
	}
	
}
