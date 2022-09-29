package com.dw.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dw.emp.vo.EmpVO;

@Mapper
public interface EmpMapper {

	//부서번호 사원 조회
	public List<EmpVO> selectEmpByDeptno(int deptno);
	
	//사원급여 별로 comm 10% 지급
	public int updateEmpComm(int deptno);
	
	//사원 삭제
	public int deleteEmp(int empno);
	
	//전체 사원 조회
	public List<Map<String, Object>> selectEmp();
	
	//통계 쿼리 조회
	public Map<String, Object> selectEmpStatistics();
	
	//사원 등록
	public int insertEmp(EmpVO vo);
	
	//특정 사원 조회
	public EmpVO selectEmpByEmpno(int empno);
	
	//사원 정보 수정
	public int updateEmp(EmpVO vo);
	
	//사원 삭제
	public int fireEmp(int empno);
}
