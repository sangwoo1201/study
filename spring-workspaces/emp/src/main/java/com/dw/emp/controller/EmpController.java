package com.dw.emp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dw.emp.service.EmpService;
import com.dw.emp.vo.EmpVO;
import com.github.pagehelper.PageInfo;

//@CroosOrigin : 누구나 자원(소스)을(를) 요청할 수 있게 권한 해제
@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class EmpController {
	
	/*
	 * M(Model == Mapper&Service) V(View) C(Controller)는
	 * 규모가 큰 프로젝트에서 업무분담을 하기위해 사용하는 적절한 디자인 패턴(코드 아키텍쳐) 중 하나.
	 * 장점 : 유지보수 쉽다, 직관적이다, 인력 채용 쉽다(기업 입장에서).
	 * 단점 : 프로젝트 규모가 작다면 시간낭비, 가독성 떨어짐
	 * 
	 * Point : MVC는 Spring뿐만 아니라 여러 프레임워크에서 사용하는 디자인 패턴이다!
	 *         MVC는 Spring 기술이 절~대 아님!!!
	 */
	

	//@Autowired = new 자동 생성 (Spring이 클래스를 관리해준다. == )
	//프레임워크(Spring boot)가 클래스를 관리해주는 기술을 Dependency Injection(DI)라고 표현한다.
	@Autowired
	private EmpService service;
	
	//특정 부서원 조회
	@GetMapping("/emp/deptno/{deptno}")
	public List<EmpVO> callEmp(@PathVariable int deptno){
		/*
		 * 조회하는 과정(Get 요청이 왔을 때)
		 * 에서 수정, 삭제, 추가가 이루어 질 수 도 있다.
		 */
		return service.getEmpList(deptno); //rows가 0이면 null리턴!
	}
	
	//전체 사원 조회
	//PageInfo: 페이징 처리 도와주는 라이브러리!
	//쿼리스트링으로 수정 ?page=3
	@GetMapping("/emp")
	public PageInfo<Map<String, Object>> callEmpPage(@RequestParam int page){
		
		List<Map<String, Object>> list = service.getEmpPageList(page);
		int navigatePages = 5; //한블록에 보여줄 페이지 수(ex 네이버 웹툰은 1블록에 10페이지)
		
		return new PageInfo<Map<String, Object>>(list, navigatePages);
	}
	
	//사원정보 통계 조회
	@GetMapping("/emp/statistics")
	public Map<String, Object> callStatistics(){
		return service.getEmpStatistics();
	}
	
	//사원 등록
	@PostMapping("/emp")
	public int callEmpInsert(@RequestBody EmpVO vo) {
		return service.setEmp(vo);
	}
	
	//특정 사원 조회
	@GetMapping("/emp/empno/{empno}")
	public EmpVO callEmpByEmpno(@PathVariable int empno) {
		return service.getEmpByEmpno(empno);
	}
	
	//사원 정보 수정
	@PatchMapping("/emp")
	public int callEmpUpdate(@RequestBody EmpVO vo) {
		return service.getEmpUpdate(vo);
	}
	
	//사원 삭제 여부 수정 (body가 아니라 path로 데이터를 받자)
	@PatchMapping("/emp/empno/{empno}")
	public int callEmpUseUpdate(@PathVariable int empno) {
		return service.getFireEmp(empno);
	}
	
}