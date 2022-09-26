package com.dw.emp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dw.emp.mapper.EmpMapper;
import com.dw.emp.service.EmpService;
import com.dw.emp.vo.EmpVO;

//@CroosOrigin : 누구나 자원(소스)을(를) 요청할 수 있게 권한 해제
@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class EmpController {

	//@Autowired = new 자동 생성 (Spring이 클래스를 관리해준다. == )
	//프레임워크(Spring boot)가 클래스를 관리해주는 기술을 Dependency Injection(DI)라고 표현한다.
	@Autowired
	private EmpService service;
	
	//특정 부서원 조회
	@GetMapping("/emp/deptno/{deptno}")
	public List<EmpVO> callEmp(@PathVariable int deptno){
		return service.getEmpList(deptno); //rows가 0이면 null리턴!
	}
	
	//전체 사원 조회
	@GetMapping("/emp")
	public List<EmpVO> callEmp(){
		return service.getEmpList();
	}
}