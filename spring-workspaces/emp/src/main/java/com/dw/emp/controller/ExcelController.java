package com.dw.emp.controller;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dw.emp.service.ExcelService;
//RestController는 JSON을 리턴할 때 사용!
//Excel 파일은 JSON이 아니기 때문에 Controller라고 선언!
@Controller
public class ExcelController {
	
	@Autowired
	ExcelService excelService;
	
	//Excel, PDF, PPT 등 파일을 다운로드 받을 때는 리턴타입 void
	//HttpServletResponse 라는 자바 객체가 대신 리턴 해주겠다.
	@GetMapping("/excel/download")
	public void downloadExcelFile(HttpServletResponse response) throws Exception{
		
		String today = new SimpleDateFormat("yyMMdd").format(new Date()); //자바 오늘날짜 가져오기
		String title = "사원_게시판"; //Excel 파일 이름
		
		response.setContentType("ms-vnd/excel");//엑셀 파일을 보내겠다.
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(today+"_"+title,"UTF-8")+".xls");//엑셀 파일이름 수정
        Workbook workBook = excelService.makeExcelForm(); //엑셀 파일생성
        workBook.write(response.getOutputStream());
        workBook.close();
        
        response.getOutputStream().flush();
        response.getOutputStream().close();
	}
}