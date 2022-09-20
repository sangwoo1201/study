package com.example.study.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.study.mapper.EmpMapper2;
import com.example.study.vo.EmpVO;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class Emp2Controller {
	
	//@Autowired : Spring이 클래스를 관리 해준다.
	@Autowired
	EmpMapper2 mapper;
	
	//조회 : Get
	@GetMapping("/emp")
	public List<EmpVO> callEmp(){
		return mapper.selectAllEmp();
	}
	
	//생성 : Post
	@PostMapping("/emp")
	public int callEmpInsert(@RequestBody EmpVO vo) {
		return mapper.insertEmp(vo);
	}
	
	//수정 : Patch
	@PatchMapping("/emp")
	public int callEmpUpdate(@RequestBody EmpVO vo) {
		return mapper.updateEmp(vo);
	}
	
	//삭제 : Delete
	@DeleteMapping("/emp/{empno}")
	public int callEmpDelete(@PathVariable int empno) {
		return mapper.deleteEmp(empno);
	}
	
	//조회 : Get (Join 포함)
	@GetMapping("/emp/dept")
	public List<Map<String, Object>> callEmpDept(){
		return mapper.selectEmpJoinDept();
	}
}
