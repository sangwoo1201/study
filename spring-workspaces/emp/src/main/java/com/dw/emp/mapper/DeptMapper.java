package com.dw.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dw.emp.vo.DeptVO;
import com.dw.emp.vo.EmpVO;

@Mapper
public interface DeptMapper {
	
	// 전체 부서 조회
	public List<Map<String, Object>> selectDept();
	
	//부서 등록
	public int insertDept(DeptVO vo);
	
	//이미 있는 부서인지 아닌지 체크
	public int selectCountByDeptNo(int deptno);
	
	// 특정 부서 조회
	public DeptVO selectDeptByDeptno(int deptno);
	
	// 특정 부서 정보 수정
	public int updateDept(DeptVO vo);
	
	// 특정 부서 삭제(is_use)
	public int fireDept(int deptno);

}