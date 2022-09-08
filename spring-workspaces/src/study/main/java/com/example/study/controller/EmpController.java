package com.example.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.study.vo.DeptVO;
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
	@GetMapping("/emp/{empno}")
	public EmpVO callEmpNo(@PathVariable int empno){
		List<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO smith = new EmpVO();
		smith.setEmpno(7369);
		smith.setEname("SMITH");
		smith.setJob("CLERK");
		smith.setHiredate("1980-12-17");
		smith.setSal(800);
		list.add(smith);
		
		EmpVO allen = new EmpVO();
		allen.setEmpno(7499);
		allen.setEname("ALLEN");
		allen.setJob("SALESMAN");
		allen.setHiredate("1981-02-20");
		allen.setSal(1600);
		list.add(allen);
		
		System.out.println("사원번호는 => "+empno);
		
		for(int i=0; i<list.size(); i++) {
			int x = list.get(i).getEmpno();
			if(x == empno) {
				return list.get(i);
			}
		}
		
		return null;
	}
	
	@GetMapping("/dept")
	public List<DeptVO> callDeptAll(){
		List<DeptVO> list = new ArrayList<DeptVO>();
		DeptVO dept1 = new DeptVO();
		dept1.setDeptno(10);
		dept1.setDname("ACCOUNTING");
		dept1.setLoc("NEW YORK");
		list.add(dept1);
		
		DeptVO dept2 = new DeptVO();
		dept2.setDeptno(20);
		dept2.setDname("RESEARCH");
		dept2.setLoc("DALLAS");
		list.add(dept2);
		
		return list;
	}
	
	//@PathVariable을 이용해서 url에 있는 데이터를 받아올 수 있다.
	// ex) localhost:8080/dept/300 => 300이라는 데이터를 파라미터로 받는다.
	@GetMapping("/dept/{deptno}")
	public DeptVO callDeptNo(@PathVariable int deptno){
		List<DeptVO> list = new ArrayList<DeptVO>();
		DeptVO dept1 = new DeptVO();
		dept1.setDeptno(10);
		dept1.setDname("ACCOUNTING");
		dept1.setLoc("NEW YORK");
		list.add(dept1);
		
		DeptVO dept2 = new DeptVO();
		dept2.setDeptno(20);
		dept2.setDname("RESEARCH");
		dept2.setLoc("DALLAS");
		list.add(dept2);
		
		System.out.println("부서번호는 => "+deptno);
		
		for(int i=0; i<list.size(); i++) {
			int x = list.get(i).getDeptno(); //list add한 deptno를 불러온다.
			if(x == deptno) { //x가 url로 받아온 deptno랑 같다면!
				return list.get(i); //부서번호 일치 deptno 객체 return
			}
		}
		//Arraylist, HashMap 공부
		return null;
	}
	
}
