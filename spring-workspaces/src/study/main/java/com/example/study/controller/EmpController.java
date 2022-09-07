package com.example.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.study.vo.EmpVO;

// @RestController는 결과값을 json으로 보여준다.
@RestController
@CrossOrigin
public class EmpController {
	
	/*
	 * @ : 어노테이션
	 * Get : 조회하다
	 * Mapping : URL을 매핑(==연결)하다.
	 * /emp : URL 주소
	 */
	@GetMapping("/emp")
	public List<EmpVO> callAllEmp(){
		List<EmpVO> list = new ArrayList<EmpVO>();
		
		EmpVO smith = new EmpVO(); //VO 클래스 생성
		smith.setEmpno(7369);
		smith.setEname("SMITH");
		smith.setJob("CLERK");
		smith.setHiredate("1980-12-17");
		smith.setSal(800);
		list.add(smith); //list에 smith 추가
		
		//list에 ALLEN 추가하기
		EmpVO allen = new EmpVO();
		allen.setEmpno(7499);
		allen.setEname("ALLEN");
		allen.setJob("SALESMAN");
		allen.setHiredate("1981-02-20");
		allen.setSal(1600);
		list.add(allen);
		
		return list;
	}
}
