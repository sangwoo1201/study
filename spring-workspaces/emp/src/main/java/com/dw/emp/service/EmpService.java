package com.dw.emp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.emp.mapper.EmpMapper;
import com.dw.emp.vo.EmpVO;
import com.github.pagehelper.PageHelper;

// @Service : 비즈니스 계층 (비즈니스(= 고객 요구사항)를(을) 여기서 구현하겠다.)
// 서비스 == 비즈니스
@Service
public class EmpService {
	
	@Autowired
	private EmpMapper mapper;
	
	public List<EmpVO> getEmpList(int deptno){
		/*
		 * 1. 사원들 comm 10% 인상(급여 기준으로) 후 사원 조회
		 * 2. 가장 보너스를 많이 받은사람 delete 하기
		 */
		int rows = mapper.updateEmpComm(deptno); //update
		if(rows > 0) { // 업데이트가 완료됨
			List<EmpVO> list = mapper.selectEmpByDeptno(deptno); // select
			// 가장 급여가 높은사람 empno 찾아내기
			int sal = 0;   // 급여
			List<Integer> empNoList = new ArrayList<Integer>();
			for(EmpVO vo : list) {
				if(sal < vo.getSal()) {
					sal = vo.getSal();
					empNoList.add(vo.getEmpno()); // 급여 많이 받는 사원 list에 추가
				}
			}
			for(int empno : empNoList) {
				System.out.println("가장 급여를 많이 받는 사원 번호 => "+empno);
				// mapper.deleteEmp(empno); // 사원삭제
			}
			list = mapper.selectEmpByDeptno(deptno); // 삭제된 데이터 재조회
			return list;
		}
		return null; // rows가 0이면 null리턴!
	}
	
	// 사원 전체 조회
	public List<Map<String, Object>> getEmpPageList(int page){
		// 필요에 따라 고객 요구사항이 들어오면 여기서 로직을 구현하면 됩니다.
		int pageSize = 10;
		PageHelper.startPage(page, pageSize);
		return mapper.selectEmp();
	}
	// 사원 통계 조회
	public Map<String, Object> getEmpStatistics(){
		return mapper.selectEmpStatistics();
	}
	// 사원 저장
	public int setEmp(EmpVO vo){
		// 이미 가입된 사원번호인지 체크하기
		int empno = vo.getEmpno(); // 사원번호를 불러온다.
		int count = mapper.selectCountByEmpno(empno); // 이미 가입된 회원 체크 쿼리 호출!
		if(count > 0) { // 만약에 count가 1이면 이미 가입된 사원
			return 0;
		}
		return mapper.insertEmp(vo);
	}
	// 특정 사원 조회
	public EmpVO getEmpByEmpno(int empno) {
		return mapper.selectEmpByEmpno(empno);
	}
	// 특정 사원 정보 수정
	public int getEmpUpdate(EmpVO vo){
		return mapper.updateEmp(vo);
	}
	// 특정 회원 탈퇴(삭제) : 컬럼(is_use)만 수정
	public int getFireEmp(int empno){
		return mapper.fireEmp(empno);
	}
	
}