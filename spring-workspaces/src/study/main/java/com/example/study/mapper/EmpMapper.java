package com.example.study.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.study.vo.DeptVO;
import com.example.study.vo.EmpVO;

//@Mapper라고 선언해야 Spring이 run할 때 해당 interface를 작동 시킨다.
//Mapper 역할은 SQL문과 자바를 연결해주는 다리다.
@Mapper
public interface EmpMapper {
	/*
	 * 인터페이스에서는 메소드 정의만! 구현하지 않는다!
	 */
	public List<EmpVO> selectEmp();
	public EmpVO selectEmpOne(int empno);
	public DeptVO selectDeptOne(int deptno);
}
